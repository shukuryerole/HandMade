package com.example.demo.services;

import com.example.demo.entities.OtpRequest1;
import com.example.demo.entities.User1;

public interface Userser1 {

	User1 findUser(String username);

	void saveUs(User1 user);

	void verifyOtp(OtpRequest1 request);

	String getToken1(User1 u);

	String verify(User1 u);


}
