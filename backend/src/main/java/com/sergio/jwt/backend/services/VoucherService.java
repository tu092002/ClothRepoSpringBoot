package com.sergio.jwt.backend.services;

import com.sergio.jwt.backend.entites.Voucher;
import com.sergio.jwt.backend.repositories.VoucherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VoucherService {
    @Autowired
    private VoucherRepo voucherRepo ;
    // trường hợp danh sách      có keyword , ko phân trang
    public List<Voucher> searchByName(String kw){
        return this.voucherRepo.searchVoucherByCode(kw);
    }
    // trường hợp danh sách    theo keyword,     có phân trang
    public Page<Voucher> search_Then_Pagination(String kw, Integer pageNo){
        List list = this.searchByName(kw); // timf kiem trc rui phan trang ds tim duoc
        Pageable pageable = PageRequest.of(pageNo-1, 2);
        Integer start = (int) pageable.getOffset();
        Integer end = (pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size() : (int) (pageable.getOffset() + pageable.getPageSize());
        list = list.subList(start,end);
        return new PageImpl<Voucher>(list,pageable, this.searchByName(kw).size() );
    }
    // trường hợp danh sách   ko keyword ,   có phân trang
    public Page<Voucher> findAll(Integer pageNo){
        Pageable pageable = PageRequest.of(pageNo-1,2);
        return this.voucherRepo.findAll(pageable);
    }
    public Voucher findById(int id) {
        return voucherRepo.findById(id).get();
    }

    public List<Voucher> findAll() {
        return voucherRepo.findAll();
    }

    public Boolean create(Voucher c) {
        try {
            voucherRepo.save(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Transactional
    public Boolean update(Voucher c) {
        try {
            voucherRepo.save(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Transactional
    public Boolean delete(int id) {
        try {
            voucherRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
