package com.sergio.jwt.backend.controllers;

import com.sergio.jwt.backend.entites.*;
import com.sergio.jwt.backend.entites.Tag;
import com.sergio.jwt.backend.repositories.CategoryRepo;
import com.sergio.jwt.backend.repositories.ImageFileRepo;
import com.sergio.jwt.backend.repositories.ImageRepository;
import com.sergio.jwt.backend.services.*;

import com.sergio.jwt.backend.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminTagController {
    @Autowired
    public TagService tagService;
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


    @GetMapping("/tag")
    public String index(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword,
                        @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
        Page<Tag> list = tagService.findAll(pageNo);
        if (keyword != null) {
            list = this.tagService.search_Then_Pagination(keyword, pageNo);
        }



        model.addAttribute("list", list);
        model.addAttribute("keyword", keyword);
        model.addAttribute("totalPage", list.getTotalPages());
        model.addAttribute("currentPage", pageNo);

        return "admin/tag/index";
    }

    @GetMapping("/add-tag")
    public String add(Model model) {
        Tag tag = new Tag();
        model.addAttribute("tag", tag);
        return "admin/tag/add";
    }

    @PostMapping("/add-tag")
    public String createTag( @ModelAttribute("tag") Tag tag, RedirectAttributes redirectAttributes) throws IOException {
        try {

                Tag prod = this.tagService.create(tag);

                redirectAttributes.addFlashAttribute("message", "Thêm thành công!");
                redirectAttributes.addFlashAttribute("alertClass", "alert-success");





            return "redirect:/admin/tag";
        } catch (Exception e) {

            e.printStackTrace();

        }
        redirectAttributes.addFlashAttribute("message", "ADD FAIL !!!");
        redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        return "admin/tag/add";

    }


    @GetMapping("/edit-tag/{id}")
    public String edit(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        Tag tag = this.tagService.findById(id);

        model.addAttribute("tag", tag);
        return "admin/tag/edit";
    }

    @PostMapping("/edit-tag/{id}")
    public String edit(@PathVariable("id") Integer id, @ModelAttribute("tag") Tag p
            , Model model, RedirectAttributes redirectAttributes,BindingResult bindingResult) {
        try {


            Tag prod = this.tagService.create(p);




            redirectAttributes.addFlashAttribute("message", "Edit thành công!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-warning");
            return "redirect:/admin/tag";
        } catch (Exception e) {

            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("message", "Edit FAIL!");
        redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        redirectAttributes.addFlashAttribute("validFile", "Chọn tối thiểu 1 hình!");
        redirectAttributes.addFlashAttribute("alertClass", "alert-warning");

        return "/admin/tag/edit";


    }

    // lưu ý ở đây phải là @Getmapping mới xoá đc
    @GetMapping("/delete-tag/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        if (this.tagService.delete(id)) {
            redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-info");
            return "redirect:/admin/tag";
        } else {
            redirectAttributes.addFlashAttribute("message", "XÓA FAIL!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/admin/tag";
        }
    }
}
