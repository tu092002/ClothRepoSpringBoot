package com.sergio.jwt.backend.controllers;

import com.sergio.jwt.backend.entites.Category;
import com.sergio.jwt.backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminCateController {
    @Autowired
    public CategoryService categoryService;
    @GetMapping("/category")
    public String index(Model model,@RequestParam(name = "keyword", defaultValue = "") String keyword,
                        @RequestParam(name="pageNo",defaultValue = "1") Integer pageNo) {

        Page<Category> list = categoryService.findAll(pageNo);

        if(keyword != null){
            list = this.categoryService.search_Then_Pagination(keyword,pageNo);
        }
        model.addAttribute("list", list);
        model.addAttribute("keyword", keyword);
        model.addAttribute("totalPage", list.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        return "admin/category/index";
    }

    @GetMapping("/add-category")
    public String add(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/category/add";
    }
    @PostMapping("/add-category")
    public String save(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        if(this.categoryService.create(category)) {
            redirectAttributes.addFlashAttribute("message", "add thành công!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
            return "redirect:/admin/category";
        } else {
            redirectAttributes.addFlashAttribute("message", "add Thất bại!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "admin/category/add";
        }
    }

    @GetMapping("/edit-category/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        Category category = this.categoryService.findById(id);
        model.addAttribute("category",category);
        return "admin/category/edit";
    }
    @PostMapping("/edit-category/{id}")
    public String edit(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes){
        if(this.categoryService.create(category)) {
            redirectAttributes.addFlashAttribute("message", "Edit thành công!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-warning");
            return "redirect:/admin/category";
        } else {
            redirectAttributes.addFlashAttribute("message", "Edit thất bại!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "admin/category/add";
        }
    }
    // lưu ý ở đây phải là @Getmapping mới xoá đc
    @GetMapping("/delete-category/{id}")
    public String  delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        if(this.categoryService.delete(id)){
            redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-info");
            return "redirect:/admin/category";
        }
        else {
            redirectAttributes.addFlashAttribute("message", "Xóa thất bại ");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/admin/category";
        }
    }
}
