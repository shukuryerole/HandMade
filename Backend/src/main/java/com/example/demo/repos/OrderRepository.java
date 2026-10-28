package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

	@Query(value = "SELECT SUM(total) FROM orders", nativeQuery = true)
	Double getTotalRevenue();
}
