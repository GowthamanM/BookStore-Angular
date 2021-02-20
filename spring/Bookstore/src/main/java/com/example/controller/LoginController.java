package com.example.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;
import com.example.model.LoginModel;
import com.example.model.UserModel;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/login")
	public boolean checkUser(@RequestBody LoginModel data) {
		System.out.println(data);
		Optional<UserModel> user = userRepo.findById(data.getEmail());
		if(user.isEmpty()) {
			System.out.println("false");
			return false;
		}else {
			if(user.get().getPassword().equals(data.getPassword())) {
				System.out.println("true");
				return true;				
			}else {
				System.out.println("false");
				return false;
			}
		}
	}
}
