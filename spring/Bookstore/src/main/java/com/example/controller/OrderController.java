package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.OrderTempRepo;
import com.example.model.OrderTemp;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class OrderController {

	@Autowired
	OrderTempRepo orderRepo;
	
	@GetMapping("/admin/orders")
	public List<OrderTemp> getProducts() {
		return (List<OrderTemp>)orderRepo.findAll();
	}
}
