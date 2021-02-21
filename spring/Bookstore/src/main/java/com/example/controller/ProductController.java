package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.ProductsRepository;
import com.example.demo.service.ProductService;
import com.example.model.ProductModel;

@RestController
public class ProductController {
	
	@Autowired
	public ProductService productService;
	
	@GetMapping("/products")
	public List<ProductModel> getAllProducts() {
		return productService.getAllproducts();
	}
	
	@PostMapping("/admin/addproduct")
	public boolean addProduct(ProductModel product) {
		return productService.saveproduct(product);
	}
	
	@PutMapping("/admin/updateproduct")
	public boolean updateProduct(ProductModel product) {
		return productService.updateproduct(product);
	}
	
	@DeleteMapping("/admin/deleteProduct")
	public boolean deleteProduct(String productId) {
		return productService.deleteproductById(productId);
	}
	
}
