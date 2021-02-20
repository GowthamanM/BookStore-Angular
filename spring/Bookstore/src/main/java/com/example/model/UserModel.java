package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class UserModel {
	
	@Id
	String email;
	String password;
	String username;
	String mobileNumber;
	String address;
	boolean active;
	String role;
	
	@OneToOne(cascade = {CascadeType.PERSIST ,CascadeType.REMOVE, CascadeType.REFRESH})
	@JoinColumn
	CartModel cart;
	
	@OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST ,CascadeType.REMOVE, CascadeType.REFRESH})
	List<OrderModel> ordersList;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public CartModel getCart() {
		return cart;
	}

	public void setCart(CartModel cart) {
		this.cart = cart;
	}

	public List<OrderModel> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<OrderModel> ordersList) {
		this.ordersList = ordersList;
	}

	@Override
	public String toString() {
		return "UserModel [email=" + email + ", password=" + password + ", username=" + username + ", mobileNumber="
				+ mobileNumber + ", address=" + address + ", active=" + active + ", role=" + role
				+ ", cart=" + cart + ", ordersList=" + ordersList + "]";
	}

	
}
