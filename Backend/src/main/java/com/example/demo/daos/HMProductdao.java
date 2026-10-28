package com.example.demo.daos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Cart1;
import com.example.demo.entities.HMProduct;
import com.example.demo.entities.Orders;
import com.example.demo.entities.User1;
import com.example.demo.repos.Cartrepo1;
import com.example.demo.repos.HMProductrepo;
import com.example.demo.repos.OrderRepo;
import com.example.demo.repos.Userrepo1;
import com.example.demo.services.HMProductser;

import jakarta.transaction.Transactional;

@Service
public class HMProductdao implements HMProductser{
	
	@Autowired
	private Userrepo1 urepo;
	
	@Autowired
	private Cartrepo1 crepo;
	
	
	@Autowired
	private HMProductrepo prepo;
	
	@Autowired
	private OrderRepo orderRepo;

	@Override
	public String saveProduct(HMProduct p) {
		// TODO Auto-generated method stub
		prepo.save(p);
		return "Product inserted";
	}

	@Override
	public List<HMProduct> findAllPA() {
		// TODO Auto-generated method stub
		return prepo.findByAvilTrue();
	}

	@Override
	public HMProduct getByid(Integer id) {
		// TODO Auto-generated method stub
		return prepo.findById(id).orElse(null);
	}

	@Override
	public List<HMProduct> findByCatAvil(String category) {
		// TODO Auto-generated method stub
		return prepo.findByCategoryAndAvilTrue(category);
	}

	@Override
	public List<HMProduct> findByCaCo(String category, String color) {
		// TODO Auto-generated method stub
		return prepo.findByCategoryAndColorAndAvilTrue(category, color);
	}

	@Override
	public List<HMProduct> findInRange(Double min, Double max) {
		// TODO Auto-generated method stub
		return prepo.findByPriceBetweenAndAvilTrue(min, max);
	}

	@Override
	public List<HMProduct> searchByTitle(String keyword) {
		// TODO Auto-generated method stub
		return prepo.findByTitleContainingIgnoreCaseAndAvilTrue(keyword);
	}

	@Override
	public List<HMProduct> findLowStock(Integer quantity) {
		// TODO Auto-generated method stub
		return prepo.findByQuantityLessThan(quantity);
	}

	@Override
	public List<HMProduct> findByCatPriceBet(String category, Double min, Double max) {
		// TODO Auto-generated method stub
		return prepo.findByCategoryAndPriceBetweenAndAvilTrue(category, min, max);
	}

	@Override
	public void deleteByid(Integer id) {
		// TODO Auto-generated method stub
		prepo.deleteById(id);
		
	}

	@Override
	public void updateP(Integer id, HMProduct p) {
		// TODO Auto-generated method stub
		HMProduct p1 = prepo.findById(id).get();
		p1.setId(id);
		p1.setTitle(p.getTitle());
		p1.setCategory(p.getCategory());
		p1.setPrice(p.getPrice());
		p1.setColor(p.getColor());
		p1.setAvil(p.isAvil());
		p1.setImageUrl(p.getImageUrl());
		prepo.save(p1);
		
	}

	@Override
	public List<HMProduct> findAll() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}

	@Override
	public HMProduct findBySku(String sku) {
		// TODO Auto-generated method stub
		return prepo.findBySku(sku);
	}

	@Override
	public List<HMProduct> findEcoFriendly() {
		// TODO Auto-generated method stub
		return prepo.findByIsEcoFriendlyTrue();
	}

	@Override
	public List<HMProduct> findHandmade() {
		// TODO Auto-generated method stub
		return prepo.findByIsHandmadeTrue();
	}

	@Override
	public List<HMProduct> sortByPrice(String dir) {
	    if(dir.equalsIgnoreCase("asc")) {
	        return prepo.findAllByOrderByPriceAsc();
	    } else {
	        return prepo.findAllByOrderByPriceDesc();
	    }
	}

	@Override
	public void updateStock(Integer id, Integer quantity) {
	    HMProduct p = prepo.findById(id).orElse(null);
	    if(p != null) {
	        p.setQuantity(quantity);
	     
	        prepo.save(p);
	    }
	}

	@Override
	public List<HMProduct> highStock(Integer quantity) {
		// TODO Auto-generated method stub
		return prepo.findByQuantityGreaterThan(quantity);
	}

	@Override
	public List<HMProduct> findByDistrict(String district) {
		// TODO Auto-generated method stub
		return prepo.findByOriginDistrict(district);
	}

	@Override
	public List<HMProduct> findByState(String state) {
		// TODO Auto-generated method stub
		return prepo.findByOriginState(state);
	
	}

	@Override
	public List<HMProduct> findByArtisan(String artisan) {
		// TODO Auto-generated method stub
		return prepo.findByArtisanName(artisan);
	}

	@Override
	public List<HMProduct> createdBefore(LocalDateTime date) {
		// TODO Auto-generated method stub
		return prepo.findByCreatedAtBefore(date);
	}

	@Override
	public List<HMProduct> createdAfter(LocalDateTime date) {
		// TODO Auto-generated method stub
		return prepo.findByCreatedAtAfter(date);
	}

	@Override
	public List<HMProduct> findByGiTagNumber(String giTagNumber) {
		// TODO Auto-generated method stub
		return prepo.findByGiTagNumber(giTagNumber);
	}

	@Override
	public List<HMProduct> catPriceAvail(String category, Double min, Double max, boolean available) {
		// TODO Auto-generated method stub
		 return prepo.findByCategoryAndPriceBetweenAndAvil(category, min, max, available);
	}

	@Override
	public List<HMProduct> latestProducts() {
		// TODO Auto-generated method stub
		return prepo.findTop10ByOrderByCreatedAtDesc();
	}

	@Override
	public List<HMProduct> expensiveProducts() {
		// TODO Auto-generated method stub
		return prepo.findTop10ByOrderByPriceDesc();
	}

	@Override
	public String addCart(int uid, int pid) {

	    User1 user = urepo.findById(uid)
	        .orElseThrow(() -> new RuntimeException("User not found"));

	    HMProduct product = prepo.findById(pid)
	        .orElseThrow(() -> new RuntimeException("Product not found"));

	    Cart1 existingCart = crepo.findByUserIdAndProductId(uid, pid);

	    if(existingCart != null){
	        existingCart.setQuantity(existingCart.getQuantity() + 1);
	        crepo.save(existingCart);
	        return "Product already in cart, quantity increased";
	    }

	    Cart1 cartItem = new Cart1();
	    cartItem.setUser(user);
	    cartItem.setProduct(product);
	    cartItem.setQuantity(1);

	    crepo.save(cartItem);

	    return "Product added to cart";
	}

	@Override
	public List<Cart1> getAllc(int id) {
		// TODO Auto-generated method stub
		List<Cart1> li = crepo.findAllByUserId(id);
		return li;
	}

	@Override
	public void deleteItemId(Integer id) {
		crepo.deleteById(id);
		
	}

	@Transactional
	@Override
	public void deleteCart(Integer userId) {

	    crepo.deleteCartByUserId(userId);
	}

	@Override
	public void saveOrder(int userId, Double total) {

	    User1 user = urepo.findById(userId)
	        .orElseThrow(() -> new RuntimeException("User not found"));

	    Orders order = new Orders();
	    order.setUser(user);
	    order.setTotal(total);
	    order.setOrderDate(LocalDateTime.now());

	    orderRepo.save(order);
	}

	@Override
	public List<Orders> getOrders(int userId) {
	    return orderRepo.findByUser_Id(userId); // ✅ FIX
	}

	@Override
	public List<HMProduct> getAllGIProducts() {
	    return prepo.findByGiproductTrue();
	}
	

}
