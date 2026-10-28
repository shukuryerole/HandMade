package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Shipping;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
}