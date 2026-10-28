package com.example.demo.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User1;
import com.example.demo.repos.Userrepo1;

@Service
public class MyUserDetailsService1 implements UserDetailsService{

	
	 @Autowired
	    private Userrepo1 repo;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	        User1 user = repo.findByUsername(username);

	        if (user == null) {
	            throw new UsernameNotFoundException("User not found");
	        }

	        return new org.springframework.security.core.userdetails.User(
	                user.getUsername(),
	                user.getPassword(),
	                List.of(new SimpleGrantedAuthority(user.getRole().name()))        
	        );
	    }
	

}
