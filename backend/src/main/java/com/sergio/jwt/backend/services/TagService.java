package com.sergio.jwt.backend.services;

import com.sergio.jwt.backend.entites.Tag;
import com.sergio.jwt.backend.entites.Tag;
import com.sergio.jwt.backend.repositories.TagRepo;
import com.sergio.jwt.backend.repositories.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private TagRepo TagRepo;
    // trường hợp danh sách      có keyword , ko phân trang
    public List<Tag> searchByName(String kw){
        return this.TagRepo.searchTagByName(kw);
    }
    // trường hợp danh sách    theo keyword,     có phân trang
    public Page<Tag> search_Then_Pagination(String kw, Integer pageNo){
        List list = this.searchByName(kw); // timf kiem trc rui phan trang ds tim duoc
        Pageable pageable = PageRequest.of(pageNo-1, 2);
        Integer start = (int) pageable.getOffset();
        Integer end = (pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size() : (int) (pageable.getOffset() + pageable.getPageSize());
        list = list.subList(start,end);
        return new PageImpl<Tag>(list,pageable, this.searchByName(kw).size() );
    }
    // trường hợp danh sách   ko keyword ,   có phân trang
    public Page<Tag> findAll(Integer pageNo){
        Pageable pageable = PageRequest.of(pageNo-1, 2, Sort.by(Sort.Direction.DESC, "createdDate"));
        return this.TagRepo.findAll(pageable);
    }
    public Tag findById(int id) {
        return TagRepo.findById(id).get();
    }

    public List<Tag> findAll() {
        return TagRepo.findAll();
    }

    public Tag create(Tag c) {
        try {
            return TagRepo.save(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    public Boolean update(Tag c) {
        try {
            TagRepo.save(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Transactional
    public Boolean delete(int id) {
        try {
            TagRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
