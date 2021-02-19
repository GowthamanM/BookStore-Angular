package com.example.model;

import java.util.List;

public class Cart {
	
	String cartID;
	String userID;
	List<CartItem> cartItems;
	public String getCartID() {
		return cartID;
	}
	public void setCartID(String cartID) {
		this.cartID = cartID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	@Override
	public String toString() {
		return "Cart [cartID=" + cartID + ", userID=" + userID + ", cartItems=" + cartItems + "]";
	}
	
	
	
	
}
