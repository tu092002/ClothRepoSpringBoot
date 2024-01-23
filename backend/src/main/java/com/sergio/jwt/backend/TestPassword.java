package com.sergio.jwt.backend;

import com.sergio.jwt.backend.entites.Product;
import com.sergio.jwt.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPassword {
    public static ProductService productService  = new ProductService();
    public static void main(String[] args){
        System.out.println(  new BCryptPasswordEncoder().encode("123456")); // tạo tạm pass khi chưa có register cho Admin
        Product p = productService.findById(602);
        System.out.println(p.getImages());

    }
}
