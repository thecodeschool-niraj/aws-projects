package com.thecodeschool.aws.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thecodeschool.aws.model.User;

@RestController
public class SampleUsers {
	
	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		List<User> userList = new ArrayList<User>();
		
		// User data stub
		userList.add(new User(100, "Niraj", "Kumar"));
		userList.add(new User(101, "Amit", "Arora"));
		userList.add(new User(102, "Balesh", "Chintan"));
		userList.add(new User(103, "Rajesh", "Drohi"));
		userList.add(new User(104, "Ashish", "Ranjan"));
		userList.add(new User(105, "Tejas", "Kewat"));
		userList.add(new User(106, "Ramesh", "Makanwala"));
		userList.add(new User(107, "Pratyush", "Banarjee"));
		userList.add(new User(108, "Kamalesh", "Pandey"));
		userList.add(new User(109, "Ajit", "Dhruval"));
		
		return userList;
	}
}
