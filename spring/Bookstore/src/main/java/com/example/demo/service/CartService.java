package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CartRepository;
import com.example.model.CartModel;
import com.example.model.CartItemModel;

@Service
public class CartService {
	
	@Autowired
	public CartRepository cartRepo;
	
	public String saveCart(CartModel cart) {
		try {
			cartRepo.save(cart);
			return "success";
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "failure";
	}
	
	public CartModel getCartByUserID(String userId) {
		Optional<CartModel> cart = null;
		
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
	
//	public List<CartItemModel> getCartItemsFromCart(CartModel cart) {
//		return cart.getCartItems();
//	}
//	
//	public String addCartItem(String userId, CartItemModel cartItem) {
//		CartModel cart = this.getCartByUserID(userId);
//		cart.getCartItems().add(cartItem);
//		return this.saveCart(cart);
//	}
//		
	public String deleteCartByIdorCartObject(Object obj) {
		if(obj instanceof String) {
			try {
				cartRepo.deleteById((String) obj);
				return "success";
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		} else if(obj instanceof CartModel) {
			try {
				cartRepo.delete((CartModel) obj);
				return "success";
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return "failure";	
	}
	
}
