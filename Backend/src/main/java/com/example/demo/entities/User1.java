package com.example.demo.entities;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


@Entity
@Table(name = "HMUSER_info")
public class User1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String password;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role1 role;
    
    private String otp;

    private LocalDateTime otpExpiry;

    private boolean verified = false;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Cart1> cartItems = new ArrayList<>();

	public User1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User1(Integer id, String username, String password, Role1 role, String otp, LocalDateTime otpExpiry,
			boolean verified, List<Cart1> cartItems) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.otp = otp;
		this.otpExpiry = otpExpiry;
		this.verified = verified;
		this.cartItems = cartItems;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role1 getRole() {
		return role;
	}

	public void setRole(Role1 role) {
		this.role = role;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public LocalDateTime getOtpExpiry() {
		return otpExpiry;
	}

	public void setOtpExpiry(LocalDateTime otpExpiry) {
		this.otpExpiry = otpExpiry;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public List<Cart1> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<Cart1> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "User1 [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", otp="
				+ otp + ", otpExpiry=" + otpExpiry + ", verified=" + verified + ", cartItems=" + cartItems + "]";
	}

    
	


  
}