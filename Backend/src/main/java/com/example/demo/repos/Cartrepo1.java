package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Cart1;

import jakarta.transaction.Transactional;

@Repository
public interface Cartrepo1 extends JpaRepository<Cart1, Integer> {

    List<Cart1> findAllByUserId(int id);

    //   DELETE METHOD 
    @Modifying
    @Transactional
    @Query("DELETE FROM Cart1 c WHERE c.user.id = :userId")
    void deleteCartByUserId(int userId);

	Cart1 findByUserIdAndProductId(int uid, int pid);
}