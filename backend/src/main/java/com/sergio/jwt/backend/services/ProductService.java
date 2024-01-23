package com.sergio.jwt.backend.services;

import com.sergio.jwt.backend.entites.Privilege;
import com.sergio.jwt.backend.entites.Product;
import com.sergio.jwt.backend.exceptions.ResourceNotFoundException;
import com.sergio.jwt.backend.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    public List<Product> searchByName(String kw) {
        return this.productRepo.searchProductByName(kw);
    }
    // danh sach có keyword,có phân trang
    public Page<Product> search_Then_Pagination(String kw, Integer pageNo){
        List<Product>  list = this.searchByName(kw); // tìm danh sách kw trước
        Pageable pageable = PageRequest.of(pageNo - 1, 2); // số lượng page, số sản phẩm có thể hiện/1 page
        Integer start = (int) pageable.getOffset();
        Integer end = (pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size() : (int) (pageable.getOffset() + pageable.getPageSize());
        list = list.subList(start,end);
        return  new PageImpl<Product>(list, pageable,this.searchByName(kw).size());
    }
    // danh sách lấy tất cả ko keyword, có phân trang
    public Page<Product> findAll(Integer pageNo){
        Pageable pageable = PageRequest.of(pageNo-1, 2, Sort.by(Sort.Direction.DESC, "createdDate"));
        return this.productRepo.findAll(pageable);

    }
    public Product findById(int id) {
        return productRepo.findById(id).get(); // dùng get() để lấy ra Product thay vì mặc định của nó Optional<Product>
    }

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public Product create(Product c) {
        try {
            return productRepo.save(c);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Transactional
    public Product update(int id, Product updatedProduct) {
        return productRepo.findById(id).map(product -> {
            product.setProductName(updatedProduct.getProductName());
            product.setPrice(updatedProduct.getPrice());
            product.setDescription(updatedProduct.getDescription());
            product.setCate(updatedProduct.getCate());
            // Cập nhật các thuộc tính khác nếu cần
            return productRepo.save(product);
        }).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
    }

    @Transactional
    public Boolean delete(int id) {
        try {
            productRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
