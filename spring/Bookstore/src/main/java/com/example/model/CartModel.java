	package com.example.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class CartModel {
	
	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
    strategy = "org.hibernate.id.UUIDGenerator"
    )
	String cartID;
	
	@OneToOne(mappedBy = "cart", cascade = {CascadeType.PERSIST ,CascadeType.REMOVE, CascadeType.REFRESH})
	UserModel user;
	
	@OneToMany(mappedBy = "cart", cascade = {CascadeType.PERSIST ,CascadeType.REMOVE, CascadeType.REFRESH})
	List<CartItemModel> cartItems;

	public String getCartID() {
		return cartID;
	}

	public void setCartID(String cartID) {
		this.cartID = cartID;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public List<CartItemModel> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemModel> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "CartModel [cartID=" + cartID + ", user=" + user + ", cartItems=" + cartItems + "]";
	}
	
	
	
}
