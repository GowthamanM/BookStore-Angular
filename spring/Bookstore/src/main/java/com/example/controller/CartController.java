package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.service.CartService;
import com.example.model.CartItemModel;
import com.example.model.CartModel;

public class CartController {
	
	@Autowired
	public CartService cartService;
	
	@GetMapping("/users/cart/{userId}")
	public CartModel getCart(@PathVariable String userId) {
		return cartService.getCartByUserID(userId);
	}
	
	@GetMapping("/users/cart/{userId}/items")
	public List<CartItemModel> getAllCartItems(@PathVariable String userId) {
		return cartService.getCartItemsFromCart(userId);
	}
	
	@PostMapping("/users/cart/{userId}/items/add")
	public String addCartItemToCart(@PathVariable String userId, @RequestBody CartItemModel cartItem) {
		return cartService.addCartItem(userId, cartItem);
	}
	
	
}
