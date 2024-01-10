package com.sergio.jwt.backend.services;

import com.sergio.jwt.backend.entites.Address;
import com.sergio.jwt.backend.exceptions.ResourceNotFoundException;
import com.sergio.jwt.backend.repositories.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepo  addressRepo;

    public List<Address> getAllAddress() {return addressRepo.findAll();}

    public Address getAddressById(int id){
        return addressRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address", "id", id));

    }
}
