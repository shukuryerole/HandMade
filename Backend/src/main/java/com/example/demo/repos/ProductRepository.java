package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.HMProduct;

public interface ProductRepository extends JpaRepository<HMProduct, Integer> {
}
