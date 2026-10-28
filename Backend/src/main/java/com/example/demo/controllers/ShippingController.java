package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.daos.ShippingService;
import com.example.demo.entities.Shipping;

@RestController
@RequestMapping("/api/shipping")
@CrossOrigin(origins = "http://localhost:3000")
public class ShippingController {

    @Autowired
    private ShippingService service;

    @PostMapping("/saves")
    public Shipping saveShipping(@RequestBody Shipping shipping) {
        return service.saveShipping(shipping);
    }
}