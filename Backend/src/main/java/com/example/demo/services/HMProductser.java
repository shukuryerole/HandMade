package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.entities.Cart1;
import com.example.demo.entities.HMProduct;
import com.example.demo.entities.Orders;

public interface HMProductser {

	String saveProduct(HMProduct p);

	List<HMProduct> findAllPA();

	HMProduct getByid(Integer id);

	List<HMProduct> findByCatAvil(String category);

	List<HMProduct> findByCaCo(String category, String color);

	List<HMProduct> findInRange(Double min, Double max);

	List<HMProduct> searchByTitle(String keyword);

	List<HMProduct> findLowStock(Integer quantity);

	List<HMProduct> findByCatPriceBet(String category, Double min, Double max);

	void deleteByid(Integer id);

	void updateP(Integer id, HMProduct p);

	List<HMProduct> findAll();

	HMProduct findBySku(String sku);

	List<HMProduct> findEcoFriendly();

	List<HMProduct> findHandmade();

	List<HMProduct> sortByPrice(String dir);

	void updateStock(Integer id, Integer quantity);

	List<HMProduct> highStock(Integer quantity);

	List<HMProduct> findByDistrict(String district);

	List<HMProduct> findByState(String state);

	List<HMProduct> findByArtisan(String artisan);

	List<HMProduct> createdBefore(LocalDateTime date);

	List<HMProduct> createdAfter(LocalDateTime date);

	List<HMProduct> findByGiTagNumber(String giTagNumber);

	List<HMProduct> catPriceAvail(String category, Double min, Double max, boolean available);

	List<HMProduct> latestProducts();

	List<HMProduct> expensiveProducts();

	String addCart(int uid, int pid);

	List<Cart1> getAllc(int id);

	void deleteItemId(Integer id);

	void deleteCart(Integer userId);

	void saveOrder(int userId, Double total);

	List<Orders> getOrders(int userId);

	List<HMProduct> getAllGIProducts();

}
