package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CartRepository;
import com.example.model.Cart;
import com.example.model.CartItem;

@Service
public class CartService {
	
	@Autowired
	public CartRepository cartRepo;
	
	public String saveCart(Cart cart) {
		try {
			cartRepo.save(cart);
			return "success";
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "failure";
	}
	
	public Cart getCartByUserID(String userId) {
		Optional<Cart> cart = null;
		
		try {
			cart = cartRepo.findById(userId);
			if(cart.isEmpty()) {
				System.out.println("Cart doesn't exist for the user");
				return null;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return cart.get();
	}
	
	public List<CartItem> getCartItemsFromCart(Cart cart) {
		return cart.getCartItems();
	}
	
	public String addCartItem(String userId, CartItem cartItem) {
		Cart cart = this.getCartByUserID(userId);
		cart.getCartItems().add(cartItem);
		return this.saveCart(cart);
	}
		
	public String deleteCartByIdorCartObject(Object obj) {
		if(obj instanceof String) {
			try {
				cartRepo.deleteById((String) obj);
				return "success";
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		} else if(obj instanceof Cart) {
			try {
				cartRepo.delete((Cart) obj);
				return "success";
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return "failure";	
	}
	
}
