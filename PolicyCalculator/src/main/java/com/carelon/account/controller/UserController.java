package com.carelon.account.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carelon.account.pojo.User;
import com.carelon.account.services.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;

//	@RequestMapping(value = "signup", method = RequestMethod.POST)
//	public String signup(@RequestBody User user) {
//		return userService.registerUser(user);
//	}

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public ResponseEntity<Map<String, String>> signup(@RequestBody User user) {
		String message = userService.registerUser(user);
		Map<String, String> response = new HashMap<>();
		response.put("message", message);
		return ResponseEntity.ok(response);
	}

//	@RequestMapping(value = "users/{username}/{password}", method = RequestMethod.GET)
//	public String login(@PathVariable("username") String username, @PathVariable("password") String password) {
//		String flag = userService.loginUser(username, password);
//		
//		return flag;
//	}

	@RequestMapping(value = "users/{username}/{password}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, String>> login(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		String flag = userService.loginUser(username, password);
		Map<String, String> response = new HashMap<>();
		response.put("role", flag);
		return ResponseEntity.ok(response);
	}

//	@RequestMapping(value = "users/{username}", method = RequestMethod.GET)
//	public boolean userExist(@PathVariable("username") String username) {
//		return userService.userExist(username);
//	}

}
