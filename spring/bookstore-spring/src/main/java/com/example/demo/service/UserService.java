package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;
import com.example.model.UserModel;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepo;
	
	public String saveUser(UserModel user) {
		
		try {
			userRepo.save(user);
			return "success";
		} catch(Exception e) {
			System.out.println("Error\n" + e.getMessage());
		}
		
		return "failure";
	}
	
}
