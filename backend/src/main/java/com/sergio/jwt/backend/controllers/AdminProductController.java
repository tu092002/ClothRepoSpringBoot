package com.sergio.jwt.backend.controllers;

import com.sergio.jwt.backend.entites.*;
import com.sergio.jwt.backend.entites.Product;
import com.sergio.jwt.backend.repositories.CategoryRepo;
import com.sergio.jwt.backend.repositories.ImageFileRepo;
import com.sergio.jwt.backend.repositories.ImageRepository;
import com.sergio.jwt.backend.repositories.ProdTagRepo;
import com.sergio.jwt.backend.services.*;

import com.sergio.jwt.backend.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLOutput;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminProductController {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    public ProductService productService;
    @Autowired
    public ImageService imageService;
    @Autowired
    public CategoryService categoryService;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private FilesStorageService filesStorageService;
    @Autowired
    private ImageFileRepo imageFileRepo;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private TagService tagService;
    @Autowired
    private ProdTagService prodTagService;
    @Autowired
    private ProdTagRepo prodTagRepo;


    @GetMapping("/product")
    public String index(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword,
                        @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
        Page<Product> list = productService.findAll(pageNo);
        if (keyword != null) {
            list = this.productService.search_Then_Pagination(keyword, pageNo);
        }

        List<Image> listImg = imageService.findImagesByProductId(1);
//        byte[] encoded0 = p.getImages().get(0).getData();
//        byte[] encoded1 = p.getImages().get(1).getData();
//        String encodedString0 = Base64.getEncoder().encodeToString(encoded0);
//        String encodedString1 = Base64.getEncoder().encodeToString(encoded1);
        List<Tag> listTag = this.tagService.findAll();

        model.addAttribute("list", list);
        model.addAttribute("listTag", listTag);
        model.addAttribute("keyword", keyword);
        model.addAttribute("totalPage", list.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("listImg", listImg);
//        model.addAttribute("encoded0", encodedString0);
//        model.addAttribute("encoded1", encodedString1);
        return "admin/product/index";
    }

    @PostMapping("/{id}/images")
    public ResponseEntity<?> uploadImages(@PathVariable("id") int id, @RequestParam("images") MultipartFile[] images) {
        try {
            List<String> imageNames = new ArrayList<>();
            for (MultipartFile image : images) {
                filesStorageService.store(image);
                imageNames.add(image.getOriginalFilename());
            }
            return ResponseEntity.status(HttpStatus.OK).body("Uploaded images: " + imageNames);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload images");
        }
    }

    @GetMapping("/add-product")
    public String add(Model model) {
        Product product = new Product();
        List<Category> listCate = categoryService.findAll();
        model.addAttribute("listCate", listCate);

        List<Tag> allTags = tagService.findAll();
        model.addAttribute("product", product);
        model.addAttribute("allTags", allTags);
        return "admin/product/add";
    }

    @PostMapping("/add-product")
    public String createProduct(Model model,@ModelAttribute("product") Product product,
                                @Valid @RequestParam("files") MultipartFile[] files
            , BindingResult result, RedirectAttributes redirectAttributes,  @RequestParam("tags") List<Integer> tagIds) throws IOException {
        if (result.hasErrors()) {
//            String errorMessage = messageSource.getMessage("NotEmpty.files", null, LocaleContextHolder.getLocale());
            return "admin/product/add";
        }
        try {


            if (files.length >= 1) {
                Product prod = this.productService.create(product); // sinh id tự tăng
                // thẻm thẻ
                Set<ProdTag> prodTagSet = new HashSet<>();
                for (int id : tagIds) {
                    Tag tag = tagService.findById(id);
                    ProdTag prodTag = new ProdTag();
                    prodTag.setProduct(prod);
                    prodTag.setTag(tag);
                    prodTagSet.add(prodTag);


                }

                product.setProdTags(prodTagSet);
                this.productService.update(prod.getId(), prod);
                // kết thúc thêm thẻ

                for (int i = 0; i < files.length; i++) {
                    MultipartFile file =files[i];
                    this.imageService.uploadImage(file, prod, i);
                    System.out.println("Index: " + i + ", File: " + file.getOriginalFilename());
                }
                redirectAttributes.addFlashAttribute("message", "Thêm thành công!");
                redirectAttributes.addFlashAttribute("alertClass", "alert-success");


            }


            return "redirect:/admin/product";
        } catch (Exception e) {

            e.printStackTrace();

        }
        redirectAttributes.addFlashAttribute("message", "ADD FAIL !!!");
        redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        return "admin/product/add";

    }


    @GetMapping("/edit-product/{id}")
    public String edit(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        Product product = this.productService.findById(id);
        List<Category> listCate = this.categoryService.findAll();
        model.addAttribute("listCate", listCate);
//        redirectAttributes.addFlashAttribute("validFile", "Chọn tối thiểu 1 hình!");
//        redirectAttributes.addFlashAttribute("alertClass", "alert-warning");
        List<Tag> allTags = tagService.findAll();
        model.addAttribute("product", product);
        model.addAttribute("allTags", allTags);
        return "admin/product/edit";
    }

    @PostMapping("/edit-product/{id}")
    public String edit(@PathVariable("id") Integer id, @ModelAttribute("product") Product p,
                       @Valid @RequestParam("files") MultipartFile[] files, Model model,
                       RedirectAttributes redirectAttributes, BindingResult bindingResult,
                       @RequestParam("tags") Set<Integer> tagIds) {
        try {

            List<Category> listCate = this.categoryService.findAll();
            model.addAttribute("listCate", listCate);
            if (!tagIds.isEmpty()) {
                // thẻm thẻ
                Set<ProdTag> prodTagSet = new HashSet<>();
                for (Integer tagId : tagIds) {
                    Tag tag = tagService.findById(tagId);
                    ProdTag prodTag = new ProdTag();
                    prodTag.setProduct(p);
                    prodTag.setTag(tag);
                    prodTagSet.add(prodTag);


                }
                prodTagService.deleteByProdId(id);
                Set<ProdTag> setProdTagCreated = prodTagService.create(prodTagSet);
                p.setProdTags(setProdTagCreated);


                // kết thúc thêm thẻ
            }
            // dù cho có thêm thẻ hay chưa vẫn update lại product
            this.productService.update(id, p);

            imageRepository.deleteAll(imageService.findImagesByProductId(p.getId()));

            if (files.length == 2 || files.length == 1) {

                for (int i = 0; i < files.length; i++) {
                    MultipartFile file = files[i];
                    this.imageService.uploadImage(file, p, i);
                    System.out.println("Index: " + i + ", File: " + file.getOriginalFilename());
                }

            } else if (files.length > 2) {
                for (int i = 0; i < 2; i++) {
                    MultipartFile file = files[i];
                    this.imageService.uploadImage(file, p, i);
                    System.out.println("Index: " + i + ", File: " + file.getOriginalFilename());
                }
            }


            redirectAttributes.addFlashAttribute("message", "Edit thành công!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-warning");
            return "redirect:/admin/product";
        } catch (Exception e) {

            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("message", "Edit FAIL!");
        redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        redirectAttributes.addFlashAttribute("validFile", "Chọn tối thiểu 1 hình!");
        redirectAttributes.addFlashAttribute("alertClass", "alert-warning");

        return "/admin/product/edit";


    }

    // lưu ý ở đây phải là @Getmapping mới xoá đc
    @GetMapping("/delete-product/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        if (this.productService.delete(id)) {
            redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-info");
            return "redirect:/admin/product";
        } else {
            redirectAttributes.addFlashAttribute("message", "XÓA FAIL!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/admin/product";
        }
    }
}
