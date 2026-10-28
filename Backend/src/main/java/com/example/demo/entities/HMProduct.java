package com.example.demo.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "HMProduct_info")
public class HMProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	
	private String title;

	
	private String category;

	
	private String description;

	
	private String imageUrl;

	
	private double price;

	
	private double discountPrice;

	
	private Integer quantity;

	private boolean avil;

	
	private String color;

	
	private String material;

	private boolean isHandmade;

	private boolean giproduct;

	
	private String originState;

	
	private String originDistrict;

	
	private String giTagNumber;

	
	private String artisanName;

	private boolean isEcoFriendly;

	
	private String sku;

	
	private LocalDate createdAt;

	
	private LocalDate updatedAt;


	// Cart relation 
	@JsonIgnore
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private List<Cart1> cartItems = new ArrayList<>();


	public HMProduct() {
		super();
		// TODO Auto-generated constructor stub
	}


	public HMProduct(Integer id,
			@NotBlank(message = "Title is required") @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters") String title,
			@NotBlank(message = "Category is required") String category,
			@NotBlank(message = "Description is required") @Size(min = 10, message = "Description must be at least 10 characters") String description,
			@NotBlank(message = "Image URL is required") String imageUrl,
			@Positive(message = "Price must be greater than 0") double price,
			@PositiveOrZero(message = "Discount price cannot be negative") double discountPrice,
			@NotNull(message = "Quantity is required") @Min(value = 0, message = "Quantity cannot be negative") Integer quantity,
			boolean avil, @NotBlank(message = "Color is required") String color,
			@NotBlank(message = "Material is required") String material, boolean isHandmade, boolean giproduct,
			@Size(min = 2, max = 50, message = "Origin state must be between 2 and 50 characters") String originState,
			@Size(min = 2, max = 50, message = "Origin district must be between 2 and 50 characters") String originDistrict,
			@Size(min = 4, max = 30, message = "GI Tag must be between 4 and 30 characters") String giTagNumber,
			@Size(min = 3, max = 60, message = "Artisan name must be between 3 and 60 characters") String artisanName,
			boolean isEcoFriendly,
			@NotBlank(message = "SKU is required") @Size(min = 4, max = 20, message = "SKU must be between 4 and 20 characters") String sku,
			@PastOrPresent(message = "Created date cannot be in the future") LocalDate createdAt,
			@PastOrPresent(message = "Updated date cannot be in the future") LocalDate updatedAt,
			List<Cart1> cartItems) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.description = description;
		this.imageUrl = imageUrl;
		this.price = price;
		this.discountPrice = discountPrice;
		this.quantity = quantity;
		this.avil = avil;
		this.color = color;
		this.material = material;
		this.isHandmade = isHandmade;
		this.giproduct = giproduct;
		this.originState = originState;
		this.originDistrict = originDistrict;
		this.giTagNumber = giTagNumber;
		this.artisanName = artisanName;
		this.isEcoFriendly = isEcoFriendly;
		this.sku = sku;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.cartItems = cartItems;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public double getDiscountPrice() {
		return discountPrice;
	}


	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public boolean isAvil() {
		return avil;
	}


	public void setAvil(boolean avil) {
		this.avil = avil;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}


	public boolean isHandmade() {
		return isHandmade;
	}


	public void setHandmade(boolean isHandmade) {
		this.isHandmade = isHandmade;
	}


	public boolean isGiproduct() {
		return giproduct;
	}


	public void setGiproduct(boolean giproduct) {
		this.giproduct = giproduct;
	}


	public String getOriginState() {
		return originState;
	}


	public void setOriginState(String originState) {
		this.originState = originState;
	}


	public String getOriginDistrict() {
		return originDistrict;
	}


	public void setOriginDistrict(String originDistrict) {
		this.originDistrict = originDistrict;
	}


	public String getGiTagNumber() {
		return giTagNumber;
	}


	public void setGiTagNumber(String giTagNumber) {
		this.giTagNumber = giTagNumber;
	}


	public String getArtisanName() {
		return artisanName;
	}


	public void setArtisanName(String artisanName) {
		this.artisanName = artisanName;
	}


	public boolean isEcoFriendly() {
		return isEcoFriendly;
	}


	public void setEcoFriendly(boolean isEcoFriendly) {
		this.isEcoFriendly = isEcoFriendly;
	}


	public String getSku() {
		return sku;
	}


	public void setSku(String sku) {
		this.sku = sku;
	}


	public LocalDate getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDate getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}


	public List<Cart1> getCartItems() {
		return cartItems;
	}


	public void setCartItems(List<Cart1> cartItems) {
		this.cartItems = cartItems;
	}


	@Override
	public String toString() {
		return "HMProduct [id=" + id + ", title=" + title + ", category=" + category + ", description=" + description
				+ ", imageUrl=" + imageUrl + ", price=" + price + ", discountPrice=" + discountPrice + ", quantity="
				+ quantity + ", avil=" + avil + ", color=" + color + ", material=" + material + ", isHandmade="
				+ isHandmade + ", giproduct=" + giproduct + ", originState=" + originState + ", originDistrict="
				+ originDistrict + ", giTagNumber=" + giTagNumber + ", artisanName=" + artisanName + ", isEcoFriendly="
				+ isEcoFriendly + ", sku=" + sku + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", cartItems=" + cartItems + "]";
	}
	
	


	

}