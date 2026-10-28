package com.example.demo.daos;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.demo.entities.OtpRequest1;

import com.example.demo.entities.User1;
import com.example.demo.repos.Userrepo1;
import com.example.demo.services.Userser1;

@Service
public class User1dao implements Userser1{
	
	@Autowired
	private Userrepo1 urepo;
	
	@Autowired
	AuthenticationManager authman;
	
	@Autowired
	JwtService1 jwtservice;

	@Override
	public User1 findUser(String username) {
		// TODO Auto-generated method stub
		User1 u = urepo.findByUsername(username);
		return u;
	}

	@Override
	public void saveUs(User1 user) {
		// TODO Auto-generated method stub
		urepo.save(user);
		
	}

	@Override
	public void verifyOtp(OtpRequest1 request) {
		// TODO Auto-generated method stub
		
		User1 user = urepo.findByUsername(request.getUsername());
		System.out.println(user);
		
		if(!user.getOtp().equals(request.getOtp())) {
			throw new RuntimeException("Invalid otp");
			
		}
		if(user.getOtpExpiry().isBefore(LocalDateTime.now())) {
			throw new RuntimeException("OTP experied");
		}
		user.setVerified(true);
		user.setOtp(null);
		urepo.save(user);
		
	}
		
	

	@Override
	public String getToken1(User1 u) {
		// TODO Auto-generated method stub
		Authentication authenticate = authman.authenticate(new UsernamePasswordAuthenticationToken(
				u.getUsername(),u.getPassword()));
				if(authenticate.isAuthenticated()) {
					return jwtservice.generateToken(u.getUsername(), u.getRole());
				}
				else {
					return "Fail";
				}
				
	}

	@Override
	public String verify(User1 u) {

	    Authentication authenticate = authman.authenticate(
	            new UsernamePasswordAuthenticationToken(
	                    u.getUsername(), u.getPassword()
	            )
	    );

	    if(authenticate.isAuthenticated()) {

	        User1 user = urepo.findByUsername(u.getUsername());

	        if(!user.isVerified()) {
	            throw new RuntimeException("Account not verified");
	        }

	        return jwtservice.generateToken(user.getUsername(), user.getRole());
	    }

	    return null;
	}

}
