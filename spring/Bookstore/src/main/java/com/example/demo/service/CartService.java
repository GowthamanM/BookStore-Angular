package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CartRepository;
import com.example.demo.repository.UserRepository;
import com.example.model.CartModel;
import com.example.model.UserModel;
import com.example.model.CartItemModel;

@Service
public class CartService {
	
	@Autowired
	public CartRepository cartRepo;
	
	@Autowired
	public UserRepository userRepo;
	
		
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
		Optional<UserModel> user = userRepo.findById(userId);
		if(user.isPresent()) {
			return user.get().getCart();
		}
		return null;
	}
	
	
	public List<CartItemModel> getCartItemsFromCart(String userId) {
		CartModel cart = this.getCartByUserID(userId);
		return cart.getCartItems();
	}
//	
	public String addCartItem(String userId, CartItemModel cartItem) {
		CartModel cart = this.getCartByUserID(userId);
		cart.getCartItems().add(cartItem);
		return this.saveCart(cart);
	}
	
	public String deleteCartItem(String userId, CartItemModel cartItem) {
		CartModel cart = this.getCartByUserID(userId);
		List<CartItemModel> items = cart.getCartItems();
		items.remove(cartItem);
		cart.setCartItems(items);
		return this.saveCart(cart);
	}
	
	public String deleteAllCartItems(String userId) {
		CartModel cart = this.getCartByUserID(userId);
		cart.getCartItems().clear();
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
