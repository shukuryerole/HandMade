package com.example.demo.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Shipping;
import com.example.demo.repos.ShippingRepository;

@Service
public class ShippingService {

    @Autowired
    private ShippingRepository repo;

    public Shipping saveShipping(Shipping shipping) {
        return repo.save(shipping);
    }
}