package com.example.demo.entities;

public class DashboardDTO {

    private long totalProducts;
    private long totalOrders;
    private double totalRevenue;

    // Constructor
    public DashboardDTO(long totalProducts, long totalOrders, double totalRevenue) {
        this.totalProducts = totalProducts;
        this.totalOrders = totalOrders;
        this.totalRevenue = totalRevenue;
    }

    // Getters
    public long getTotalProducts() { return totalProducts; }
    public long getTotalOrders() { return totalOrders; }
    public double getTotalRevenue() { return totalRevenue; }
}