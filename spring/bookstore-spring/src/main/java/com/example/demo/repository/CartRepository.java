package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.CartModel;
import com.example.model.CartItemModel;

@Repository
public interface CartRepository extends JpaRepository<CartModel, String> {
	
	List<CartModel> findByUserID(String userID);
	List<CartModel> findByCartItems(List<CartItemModel> cartItems);
	
}
