package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;
import com.example.model.UserModel;
import com.example.tempmodel.UserTempModel;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SignupController {

	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/signup")
	public boolean saveUser(@RequestBody UserTempModel user) {
		System.out.println(user);
		UserModel data = new UserModel();
		data.setEmail(user.getEmail());
		data.setUsername(user.getUsername());
		data.setMobileNumber(user.getMobileNumber());
		data.setRole(user.getRole());
		data.setActive(true);
		data.setPassword(user.getPassword());
		userRepo.save(data);
		return true;
	}
}
