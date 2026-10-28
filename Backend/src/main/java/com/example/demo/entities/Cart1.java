package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Cart1 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer quantity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hmuser_id")
	private User1 user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hmproduct_id")
	private HMProduct product;

	public Cart1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart1(Integer id, Integer quantity, User1 user, HMProduct product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.user = user;
		this.product = product;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public User1 getUser() {
		return user;
	}

	public void setUser(User1 user) {
		this.user = user;
	}

	public HMProduct getProduct() {
		return product;
	}

	public void setProduct(HMProduct product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", quantity=" + quantity + ", user=" + user + ", product=" + product + "]";
	}
	
	

}
