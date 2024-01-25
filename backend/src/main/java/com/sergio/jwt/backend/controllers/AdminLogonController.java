package com.sergio.jwt.backend.controllers;

import com.sergio.jwt.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminLogonController {
    @Autowired
    public UserService userService;
    @RequestMapping("/logon")
    public String logon() {
//        userService.assignRoleToUser(1,"ADMIN");
//        userService.assignRoleToUser(2,"USER");
        return "admin/logon";
    }


}
