package com.example.model;

public class CartItem extends ProductModel {
	
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
