package com.sergio.jwt.backend.services;

import com.sergio.jwt.backend.entites.Category;
import com.sergio.jwt.backend.entites.Product;
import com.sergio.jwt.backend.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public List<Product>  findAllProduct(){
        return productRepo.findAll();
    }

    public Optional<Product> findById(int id){
        return productRepo.findById(id);
    }

    public Product addProduct(Product c) {
        return productRepo.save(c);
    }

    public void delete(int id) {
        productRepo.deleteById(id);
    }


}
