package com.example.demo.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.Cart1;
import com.example.demo.entities.HMProduct;
import com.example.demo.entities.Orders;
import com.example.demo.entities.Total1;
import com.example.demo.helper.HelperHM;
import com.example.demo.services.HMProductser;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@RestController
@RequestMapping("/hmproduct")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class HandMadeProductController {
	
	@Autowired
	private HMProductser pser;
	

    // Save new product
    @PostMapping("/savep")
    public ResponseEntity<?> saveProduct(@RequestBody HMProduct p){
        pser.saveProduct(p);

        HelperHM h = new HelperHM();
        h.setMessage("Product Saved");
        h.setData(p);

        return new ResponseEntity<>(h, HttpStatus.ACCEPTED);
    }

    // Get all available products
    @GetMapping("/availp")
    public ResponseEntity<?> findAvailP(){
        List<HMProduct> li = pser.findAllPA();

        HelperHM h = new HelperHM();
        h.setMessage("Available Product");
        h.setData(li);

        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    // Get product by ID
    @GetMapping("/getById/{id}")
    public HMProduct getProductById(@PathVariable Integer id) {
        return pser.getByid(id);
    }

    // Get products by category
    @GetMapping("/avilBCat")
    public ResponseEntity<?> findByCategoryA(@RequestParam String category){
        List<HMProduct> li = pser.findByCatAvil(category);

        HelperHM h = new HelperHM();
        h.setMessage("Available Product By Category");
        h.setData(li);

        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    // Get products by category and color
    @GetMapping("/catandColor")
    public ResponseEntity<?> findByCatandColor(
            @RequestParam String category,
            @RequestParam String color){

        List<HMProduct> li = pser.findByCaCo(category, color);

        HelperHM h = new HelperHM();
        h.setMessage("Available Product By Category and Color");
        h.setData(li);

        return new ResponseEntity<>(h, HttpStatus.ACCEPTED);
    }

    // Get products in price range
    @GetMapping("/findpricerange")
    public ResponseEntity<?> findPInRange(
            @RequestParam Double min,
            @RequestParam Double max){

        List<HMProduct> li = pser.findInRange(min, max);

        HelperHM h = new HelperHM();
        h.setMessage("Available Product Range");
        h.setData(li);

        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    // Search product by title
    @GetMapping("/searchBTitle")
    public ResponseEntity<?> findByTitle(@RequestParam String keyword){
        List<HMProduct> li = pser.searchByTitle(keyword);

        HelperHM h = new HelperHM();
        h.setMessage("Available Product By Title");
        h.setData(li);

        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    // Get low stock products
    @GetMapping("/lowstock")
    public ResponseEntity<?> findlowStockP(@RequestParam Integer quantity){
        List<HMProduct> li = pser.findLowStock(quantity);

        HelperHM h = new HelperHM();
        h.setMessage("Low Stock Products");
        h.setData(li);

        return new ResponseEntity<>(h, HttpStatus.ACCEPTED);
    }
    
 // High Stock
    @GetMapping("/highStock")
    public ResponseEntity<?> highStock(@RequestParam Integer quantity){
        List<HMProduct> li = pser.highStock(quantity);

        HelperHM h = new HelperHM();
        h.setMessage("High Stock GI Products");
        h.setData(li);

        return new ResponseEntity<>(h,HttpStatus.OK);
    }

    // Get products by category and price range
    @GetMapping("/catpriceavil")
    public ResponseEntity<?> findcategoryavil(
            @RequestParam String category,
            @RequestParam Double min,
            @RequestParam Double max){

        List<HMProduct> li = pser.findByCatPriceBet(category, min, max);

        HelperHM h = new HelperHM();
        h.setMessage("Available Product By Category and Price");
        h.setData(li);

        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    // Delete product by ID
    @DeleteMapping("/delete/{pid}")
    public ResponseEntity<?> deleteProduct(@PathVariable("pid") Integer id) {
        pser.deleteByid(id);

        HelperHM h = new HelperHM();
        h.setMessage("Product Deleted");
        h.setData(null);

        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    // Update product details
    @PutMapping("/updateP/{id}")
    public ResponseEntity<?> editProduct(
            @PathVariable Integer id,
            @RequestBody HMProduct p) {

        pser.updateP(id, p);

        HelperHM h = new HelperHM();
        h.setMessage("Product Updated");
        h.setData(null);

        return new ResponseEntity<>(h, HttpStatus.ACCEPTED);
    }

    // Get all products
    @GetMapping("/all")
    public ResponseEntity<?> findAllProducts(){
        List<HMProduct> li = pser.findAll();

        HelperHM h = new HelperHM();
        h.setMessage("All Products");
        h.setData(li);

        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    // Find product by SKU
    @GetMapping("/findBySku")
    public ResponseEntity<?> findBySku(@RequestParam String sku){
        HMProduct p = pser.findBySku(sku);

        HelperHM h = new HelperHM();
        h.setMessage("Product By SKU");
        h.setData(p);

        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    // Get eco-friendly products
    @GetMapping("/eco")
    public ResponseEntity<?> findEcoProducts(){
        List<HMProduct> li = pser.findEcoFriendly();

        HelperHM h = new HelperHM();
        h.setMessage("Eco Friendly Products");
        h.setData(li);

        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    // Get handmade products
    @GetMapping("/handmade")
    public ResponseEntity<?> findHandmade(){
        List<HMProduct> li = pser.findHandmade();

        HelperHM h = new HelperHM();
        h.setMessage("Handmade Products");
        h.setData(li);

        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    // Sort products by price
    @GetMapping("/sortByPrice")
    public ResponseEntity<?> sortByPrice(@RequestParam String dir){
        List<HMProduct> li = pser.sortByPrice(dir);

        HelperHM h = new HelperHM();
        h.setMessage("Sorted Products By Price");
        h.setData(li);

        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    // Update stock quantity
    @PutMapping("/updateStock/{id}")
    public ResponseEntity<?> updateStock(
            @PathVariable Integer id,
            @RequestParam Integer quantity){

        pser.updateStock(id, quantity);

        HelperHM h = new HelperHM();
        h.setMessage("Stock Updated");
        h.setData(null);

        return new ResponseEntity<>(h, HttpStatus.OK);
    }
    
    @GetMapping("/district")
    public ResponseEntity<?> findByDistrict(@RequestParam String district){
        List<HMProduct> li = pser.findByDistrict(district);

        HelperHM h = new HelperHM();
        h.setMessage("GI Products by District");
        h.setData(li);

        return new ResponseEntity<>(h,HttpStatus.OK);
    }
    
    @GetMapping("/state")
    public ResponseEntity<?> findByState(@RequestParam String state){
        List<HMProduct> li = pser.findByState(state);

        HelperHM h = new HelperHM();
        h.setMessage("GI Products by State");
        h.setData(li);

        return new ResponseEntity<>(h,HttpStatus.OK);
    }
    
    @GetMapping("/artisan")
    public ResponseEntity<?> findByArtisan(@RequestParam String artisan){
        List<HMProduct> li = pser.findByArtisan(artisan);

        HelperHM h = new HelperHM();
        h.setMessage("GI Products by Artisan");
        h.setData(li);

        return new ResponseEntity<>(h,HttpStatus.OK);
    }
    
    @GetMapping("/createdAfter")
    public ResponseEntity<?> createdAfter(@RequestParam LocalDateTime date){
        List<HMProduct> li = pser.createdAfter(date);

        HelperHM h = new HelperHM();
        h.setMessage("Products Created After Date");
        h.setData(li);

        return new ResponseEntity<>(h,HttpStatus.OK);
    }
    
    @GetMapping("/createdBefore")
    public ResponseEntity<?> createdBefore(@RequestParam LocalDateTime date){
        List<HMProduct> li = pser.createdBefore(date);

        HelperHM h = new HelperHM();
        h.setMessage("Products Created Before Date");
        h.setData(li);

        return new ResponseEntity<>(h,HttpStatus.OK);
    }
    
    @GetMapping("/giTag")
    public ResponseEntity<?> findByGiTag(@RequestParam String giTagNumber){

        List<HMProduct> li = pser.findByGiTagNumber(giTagNumber);

        HelperHM h = new HelperHM();
        h.setMessage("Product Found By GI Tag Number");
        h.setData(li);

        return new ResponseEntity<>(h, HttpStatus.OK);
    }
    
    @GetMapping("/catpriceavail")
    public ResponseEntity<?> catPriceAvail(
            @RequestParam String category,
            @RequestParam Double min,
            @RequestParam Double max,
            @RequestParam boolean available){

        List<HMProduct> li = pser.catPriceAvail(category, min, max, available);

        HelperHM h = new HelperHM();
        h.setMessage("Products by Category Price and Availability");
        h.setData(li);

        return new ResponseEntity<>(h,HttpStatus.OK);
    }
    
    @GetMapping("/latest")
    public ResponseEntity<?> latestProducts(){

        List<HMProduct> li = pser.latestProducts();

        HelperHM h = new HelperHM();
        h.setMessage("Latest Products");
        h.setData(li);

        return new ResponseEntity<>(h,HttpStatus.OK);
    }
    
    @GetMapping("/expensive")
    public ResponseEntity<?> expensiveProducts(){

        List<HMProduct> li = pser.expensiveProducts();

        HelperHM h = new HelperHM();
        h.setMessage("Top Expensive Products");
        h.setData(li);

        return new ResponseEntity<>(h,HttpStatus.OK);
    }
    
    @PostMapping("/addtocart")
    public ResponseEntity<String> addToCart(@RequestParam int uid, @RequestParam int pid){
        String msg = pser.addCart(uid, pid);
        return ResponseEntity.ok(msg);
    }
	
	@GetMapping("/showCart")
	public List<Cart1> getData(@RequestParam int id){
		List<Cart1> li = pser.getAllc(id);
		return li;
	}
	
	//--------Order Creation
		@PostMapping("/create-order")
		public ResponseEntity<Map<String, Object>> createOrder(@RequestBody Total1 total) { 
		    System.out.println(total.getTotal());

		    try {
		        // Initialize Razorpay client
		        RazorpayClient razorpayClient = new RazorpayClient(
		                "rzp_test_SNui633mxwSkn4",
		                "Tz0q27T0FWwVmmIgXR1sF4VS"
		        );

		        // Prepare order request
		        JSONObject orderRequest = new JSONObject();
		        int amount = (int) (total.getTotal() * 100); // Convert to smallest currency unit
		        orderRequest.put("amount", amount);
		        orderRequest.put("currency", "INR");
		        orderRequest.put("receipt", "txn_123456");
		        orderRequest.put("payment_capture", 1);

		        // Create order
		        Order order = razorpayClient.orders.create(orderRequest);

		        // Prepare response
		        Map<String, Object> response = new HashMap<>();
		        response.put("id", order.get("id"));
		        response.put("amount", order.get("amount"));
		        response.put("currency", order.get("currency"));

		        return ResponseEntity.ok(response);

		    } catch (Exception e) {
		        e.printStackTrace();
		        return ResponseEntity.status(500).body(Map.of("error", "Order creation failed"));
		    }
		}
		
		@DeleteMapping("/deleteItem/{id}")
		public Map<String, String> deleteItem(@PathVariable("id") Integer id){
			pser.deleteItemId(id);
			return Map.of("Message ","Item Removed");
		}
		
		@DeleteMapping("/deleteCart/{userId}")
		public String deleteCart(@PathVariable("userId") Integer userId) {
		    pser.deleteCart(userId);
		    return "Cart Cleared";
		}
		
		@PostMapping("/saveOrder")
		public String saveOrder(@RequestParam int userId, @RequestParam Double total){
		    pser.saveOrder(userId, total);
		    return "Order Saved";
		}

		@GetMapping("/getOrders")
		public List<Orders> getOrders(@RequestParam int userId){
		    return pser.getOrders(userId);
		}
		
		@GetMapping("/gi")
		public ResponseEntity<?> getAllGIProducts() {

		    List<HMProduct> li = pser.getAllGIProducts();

		    HelperHM h = new HelperHM();
		    h.setMessage("All GI Products");
		    h.setData(li);

		    return new ResponseEntity<>(h, HttpStatus.OK);
		}

}
