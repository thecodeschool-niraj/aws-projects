package com.thecodeschool.aws.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thecodeschool.aws.entity.User;
import com.thecodeschool.aws.repository.UserRepository;

@RestController
public class UserResource {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping("/users")
	public void registerUser(@RequestBody User user) {
		userRepository.save(user);
	}
	
	@PutMapping("/users/{userId}")
	public void updateUserProfile(@PathVariable Long userId, @RequestBody User user) throws Exception {
		User dbUser = userRepository.findById(userId)
			.orElseThrow(() -> new Exception("User not found for this id :: " + userId));
		dbUser.setFirstName(user.getFirstName());
		dbUser.setLastName(user.getLastName());
		userRepository.save(dbUser);
	}
}
