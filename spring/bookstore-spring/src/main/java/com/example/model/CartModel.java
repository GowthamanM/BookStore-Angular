package com.example.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CartModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	String cartID;
	String userID;
	List<CartItemModel> cartItems;
	
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
	public List<CartItemModel> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItemModel> cartItems) {
		this.cartItems = cartItems;
	}
	
	@Override
	public String toString() {
		return "Cart [cartID=" + cartID + ", userID=" + userID + ", cartItems=" + cartItems + "]";
	}
	
	
	
	
}