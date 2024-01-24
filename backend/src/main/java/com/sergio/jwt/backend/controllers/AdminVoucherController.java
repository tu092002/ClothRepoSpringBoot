package com.sergio.jwt.backend.controllers;

import com.sergio.jwt.backend.entites.Voucher;
import com.sergio.jwt.backend.services.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminVoucherController {

    @Autowired
    public VoucherService voucherService;
    @GetMapping("/voucher")
    public String index(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword,
                        @RequestParam(name="pageNo",defaultValue = "1") Integer pageNo) {

        Page<Voucher> list = voucherService.findAll(pageNo);

        if(keyword != null){
            list = this.voucherService.search_Then_Pagination(keyword,pageNo);
        }
        model.addAttribute("list", list);
        model.addAttribute("keyword", keyword);
        model.addAttribute("totalPage", list.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        return "admin/voucher/index";
    }

    @GetMapping("/add-voucher")
    public String add(Model model) {
        Voucher voucher = new Voucher();
        model.addAttribute("voucher", voucher);
        return "admin/voucher/add";
    }
    @PostMapping("/add-voucher")
    public String save(@ModelAttribute("voucher") Voucher voucher, RedirectAttributes redirectAttributes, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/voucher/add";
        }
        if(this.voucherService.create(voucher)) {
            redirectAttributes.addFlashAttribute("message", "add thành công!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        } else {
            redirectAttributes.addFlashAttribute("message", "add Thất bại!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "admin/voucher/add";
        }
        return "redirect:/admin/voucher";

    }

    @GetMapping("/edit-voucher/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        Voucher voucher = this.voucherService.findById(id);
        model.addAttribute("voucher",voucher);
        return "admin/voucher/edit";
    }
    @PostMapping("/edit-voucher/{id}")
    public String edit(@ModelAttribute("voucher") Voucher voucher, RedirectAttributes redirectAttributes){
        if(this.voucherService.create(voucher)) {
            redirectAttributes.addFlashAttribute("message", "Edit thành công!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-warning");
            return "redirect:/admin/voucher";
        } else {
            redirectAttributes.addFlashAttribute("message", "Edit thất bại!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "admin/voucher/add";
        }
    }
    // lưu ý ở đây phải là @Getmapping mới xoá đc
    @GetMapping("/delete-voucher/{id}")
    public String  delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        if(this.voucherService.delete(id)){
            redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-info");
            return "redirect:/admin/voucher";
        }
        else {
            redirectAttributes.addFlashAttribute("message", "Xóa thất bại ");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/admin/voucher";
        }
    }
}
