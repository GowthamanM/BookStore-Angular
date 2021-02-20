package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CartItemRepository;
import com.example.model.CartItemModel;

@Service
public class CartItemService {
	
	@Autowired
	public CartItemRepository cartItemRepo;
	
//	Get all the cartItems
	public List<CartItemModel> getAllcartItems() {	
		List<CartItemModel> cartItems = null;
		try {
			cartItems = cartItemRepo.findAll();
			if(cartItems.isEmpty()) {
				System.out.println("cartItem not found in cartItem repo");
				return new ArrayList<>();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return cartItems;
	}
	
//	Get the cartItem by id
	public CartItemModel getcartItem(String cartItemId) {	
		Optional<CartItemModel> cartItem = null;
		try {
			cartItem = cartItemRepo.findById(cartItemId);
			if(cartItem.isEmpty()) {
				System.out.println("cartItem not found in cartItem repo");
			}	
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return cartItem.get();
	}
	
//	Save the cartItem
	public String savecartItem(CartItemModel cartItem) {
		try {
			cartItemRepo.save(cartItem);
			return "success";
		} catch(Exception e) {
			System.out.println("Error\n" + e.getMessage());
		}
		return "failure";
	}
	
	public String updatecartItem(CartItemModel cartItem) {
		try {
			cartItemRepo.save(cartItem);
			return "success";
		} catch(Exception e) {
			System.out.println("Error\n" + e.getMessage());
		}
		return "failure";
	}
	
//	delete the cartItem
	public String deletecartItem(CartItemModel cartItem) {
		try {
			cartItemRepo.delete(cartItem);
			return "success";
		} catch(Exception e) {
			System.out.println("Error\n" + e.getMessage());
		}
		return "failure";
	}
	
	
//	Delete the cartItem by id
	public String deletecartItemById(String cartItemId) {
		try {
			cartItemRepo.deleteById(cartItemId);
			return "success";
		} catch(Exception e) {
			System.out.println("Error\n" + e.getMessage());
		}
		return "failure";
	}	
	
}
