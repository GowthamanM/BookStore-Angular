package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CartItem extends ProductModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	String cartItemId;
	int quantity;
	
	public CartItem() {
		// TODO Auto-generated constructor stub
		super();
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
