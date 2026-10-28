package com.example.demo.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer> {

    // ✅ FIXED METHOD
    List<Orders> findByUser_Id(int userId);
}