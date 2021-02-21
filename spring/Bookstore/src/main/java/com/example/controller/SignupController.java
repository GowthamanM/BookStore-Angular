package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.model.UserModel;
import com.example.tempmodel.UserTempModel;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SignupController {

	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	public boolean saveUser(@RequestBody UserTempModel user) {
		return userService.saveUser(user).equals("success") ? true : false;
	}
	
	
}
