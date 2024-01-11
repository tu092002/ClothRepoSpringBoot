package com.sergio.jwt.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class AdminCateController {
    @RequestMapping("/admin/category")
    public String index() {
        return "admin/category/index";
    }

    @RequestMapping("/admin/add-category")
    public String add() {
        return "admin/category/add";
    }
}
