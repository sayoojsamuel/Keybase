package com.onedark.springbootstarter.user;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable String id) {
		return userService.getUser(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable String id) {
		userService.updateUser(user, id);	
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}

	@RequestMapping("/users/{id}/encrypt") 
	public String encryptHome() {
		return "Usage is /users/id/encrypt/data-to-encrypt";
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/{id}/generatekeys")
	public String generateKeys(@RequestBody User user, @PathVariable String id) throws NoSuchAlgorithmException, NoSuchProviderException, IOException {
		return userService.generateKeys(user, id);
	}
	
	
	
	
}
