package com.example.demo.entities;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double total;

    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User1 user;
    
    @OneToOne
    private Shipping shipping;

    // getters setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

    public User1 getUser() { return user; }
    public void setUser(User1 user) { this.user = user; }
}