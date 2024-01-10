package com.sergio.jwt.backend.services;

import com.sergio.jwt.backend.entites.Address;
import com.sergio.jwt.backend.entites.AddressUser;
import com.sergio.jwt.backend.repositories.AddressUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressUserService {
    @Autowired
    private AddressUserRepo addressUserRepo;
    public List<Address> findByUserId(int id){
        return addressUserRepo.findByUserId(id);
    }
}
