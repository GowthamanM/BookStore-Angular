package com.example.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CartItem extends ProductModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	String cartItemId;
	int quantity;
	
	@SuppressWarnings("deprecation")
	public CartItem() {
		// TODO Auto-generated constructor stub
		super();
		this.cartItemId = new String((Math.floor(Math.random() * 100)) +  new Date().toLocaleString());
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(quantity >= 0) {
			this.quantity = quantity;
		}	
	}

	@Override
	public String toString() {
		return "CartItem [quantity=" + quantity + "]";
	}
	
	
	
}
