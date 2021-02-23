package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;
import com.example.model.CartItemModel;
import com.example.model.CartModel;
import com.example.model.CartTempModel;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
	
	@Autowired
	ProductService productRepo;
	
	@PostMapping("/home/{id}")
	public void addToCart(@RequestBody String Quantity,@PathVariable String id) {
		CartTempModel cart = new CartTempModel();
		System.out.println(productRepo.getproduct(id));
		System.out.println(id+"-->"+Quantity);
	}
	
	
}
