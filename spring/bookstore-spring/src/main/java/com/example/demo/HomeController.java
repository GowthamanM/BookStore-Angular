package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@GetMapping("/")
	public List<TestDao> home() {
		List<TestDao> arr = new ArrayList<>();
		TestDao t1 = new TestDao("Hello");
		TestDao t2 = new TestDao("Hi");
		TestDao t3 = new TestDao("Hawll");
		arr.add(t1);
		arr.add(t2);
		arr.add(t3);
		
		return arr;
	}
}
