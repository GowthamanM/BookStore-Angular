package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;
import com.example.model.UserModel;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepo;
	
	public List<UserModel> getAllUsers() {	
		List<UserModel> users = null;
		try {
			users = userRepo.findAll();
			if(users.isEmpty()) {
				System.out.println("User not found in user repo");
				return new ArrayList<>();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return users;
	}
	
	public UserModel getUser(String userId) {	
		Optional<UserModel> user = null;
		try {
			user = userRepo.findById(userId);
			if(user.isEmpty()) {
				System.out.println("User not found in user repo");
			}	
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return user.get();
	}
	
	public String saveUser(UserModel user) {
		try {
			userRepo.save(user);
			return "success";
		} catch(Exception e) {
			System.out.println("Error\n" + e.getMessage());
		}
		return "failure";
	}
	
	public String updateUser(UserModel user) {
		try {
			userRepo.save(user);
			return "success";
		} catch(Exception e) {
			System.out.println("Error\n" + e.getMessage());
		}
		return "failure";
	}
	
	public String deleteUser(UserModel user) {
		try {
			userRepo.delete(user);
			return "success";
		} catch(Exception e) {
			System.out.println("Error\n" + e.getMessage());
		}
		return "failure";
	}
	
	public String deleteUserById(String userId) {
		try {
			userRepo.deleteById(userId);
			return "success";
		} catch(Exception e) {
			System.out.println("Error\n" + e.getMessage());
		}
		return "failure";
	}	
}
