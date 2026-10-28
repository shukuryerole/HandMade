package com.example.demo.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.DashboardDTO;
import com.example.demo.repos.OrderRepository;
import com.example.demo.repos.ProductRepository;

@Service
public class DashboardService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderRepository orderRepo;

    public DashboardDTO getDashboardData() {

        long totalProducts = productRepo.count();
        long totalOrders = orderRepo.count();

        Double revenue = orderRepo.getTotalRevenue();
        double totalRevenue = (revenue != null) ? revenue : 0.0;

        return new DashboardDTO(totalProducts, totalOrders, totalRevenue);
    }
}