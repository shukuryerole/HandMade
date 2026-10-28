package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User1;

@Repository
public interface Userrepo1 extends JpaRepository<User1, Integer>{

	User1 findByUsername(String username);

}
