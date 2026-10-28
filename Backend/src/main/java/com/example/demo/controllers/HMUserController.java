package com.example.demo.controllers;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.OtpRequest1;

import com.example.demo.entities.OtpUtil1;

import com.example.demo.entities.Role1;

import com.example.demo.entities.User1;

import com.example.demo.helper.HelperHM;

import com.example.demo.services.Emailser1;

import com.example.demo.services.Userser1;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/hmuser")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class HMUserController {

	
BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Autowired
	private Userser1 seru;
	
	@Autowired
	private Emailser1 ser;
	
	@PostMapping("/saveu")
	public ResponseEntity<?> saveUser(@RequestBody User1 u){
		User1 user = seru.findUser(u.getUsername());
		System.out.println(user);
		
		String otp = OtpUtil1.generateOtp();
	    u.setOtp(otp);
	    u.setOtpExpiry(LocalDateTime.now().plusMinutes(5));
	    u.setVerified(false);
	
	    if(user!=null) {
		if(user.isVerified()) {
		return 
				ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("message", "Email already exists"));
		}
		 user.setOtp(otp);
	        user.setOtpExpiry(LocalDateTime.now().plusMinutes(20));
	        seru.saveUs(user);
	        u = user;
	}
	else {
		u.setPassword(encoder.encode(u.getPassword()));
	   if (u.getRole() == null) {
            u.setRole(Role1.ROLE_USER);
        }
	   seru.saveUs(u);
	}
	String s= "Email Verification";
	ser.sendEmail(u.getUsername(),s,u.getOtp());
	
	HelperHM h = new HelperHM();
	h.setMessage("User register successfully");
	h.setData(u);
	return new ResponseEntity<>(h,HttpStatus.OK);
		
	}
	
	@PostMapping("/verify-otp")
	public ResponseEntity<?> verifyOtp(@RequestBody OtpRequest1 request) {
		System.out.println(request.getOtp());
		System.out.println(request.getUsername());
		seru.verifyOtp(request);
		return ResponseEntity.ok("Account verified successfully");
		
	}
	@PostMapping("/login")
	public ResponseEntity<?> userlogin(@RequestBody User1 u) {

	    String result = seru.verify(u); // JWT token
	    User1 us = seru.findUser(u.getUsername());

	    if(result == null) {
	        return ResponseEntity
	                .status(HttpStatus.UNAUTHORIZED)
	                .body("Invalid Username or Password");
	    }

	    return ResponseEntity.ok(
	            Map.of(
	                    "jwt", result,
	                    "message", "Login successful",
	                    "user", us
	            )
	    );
	}
	
	@GetMapping("/gettoken")
	public String getTok(@RequestBody User1 u) {
		String t = seru.getToken1(u);
		return t;
	}
	
	@GetMapping("/logout")
	public ResponseEntity<String> logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return ResponseEntity.ok("Logged out.");
		
	}
	
	
	
	
}
