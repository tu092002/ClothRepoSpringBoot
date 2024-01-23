package com.sergio.jwt.backend.services;

import com.sergio.jwt.backend.entites.Category;
import com.sergio.jwt.backend.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    // trường hợp danh sách      có keyword , ko phân trang
    public List<Category> searchByName(String kw){
        return this.categoryRepo.searchCategoryByName(kw);
    }
    // trường hợp danh sách    theo keyword,     có phân trang
    public Page<Category> search_Then_Pagination(String kw, Integer pageNo){
        List list = this.searchByName(kw); // timf kiem trc rui phan trang ds tim duoc
        Pageable pageable = PageRequest.of(pageNo-1, 2);
        Integer start = (int) pageable.getOffset();
        Integer end = (pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size() : (int) (pageable.getOffset() + pageable.getPageSize());
        list = list.subList(start,end);
        return new PageImpl<Category>(list,pageable, this.searchByName(kw).size() );
    }
    // trường hợp danh sách   ko keyword ,   có phân trang
    public Page<Category> findAll(Integer pageNo){
        Pageable pageable = PageRequest.of(pageNo-1,2);
        return this.categoryRepo.findAll(pageable);
    }
    public Category findById(int id) {
        return categoryRepo.findById(id).get();
    }

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public Boolean create(Category c) {
        try {
            categoryRepo.save(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Transactional
    public Boolean update(Category c) {
        try {
            categoryRepo.save(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Transactional
    public Boolean delete(int id) {
        try {
            categoryRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
