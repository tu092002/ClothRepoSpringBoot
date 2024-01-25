package com.sergio.jwt.backend.services;

import com.sergio.jwt.backend.entites.ProdTag;
import com.sergio.jwt.backend.repositories.ProdTagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProdTagService {
    @Autowired
    private ProdTagRepo prodTagRepo;
    public Set<ProdTag> create(Set<ProdTag> p){

        List<ProdTag> arrayList = this.prodTagRepo.saveAll(p);
// Thêm các phần tử vào List sang set
        Set<ProdTag> set = new HashSet<>(arrayList);
        return set;

    }
    public void deleteByProdId(int id){
        this.prodTagRepo.deleteByProdId(id);
    }
}
