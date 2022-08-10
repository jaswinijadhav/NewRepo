package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.Constants;

@RestController
@RequestMapping("/user")
public class DemoController {

	Logger logger = LoggerFactory.getLogger(DemoController.class);

	@Autowired
	private UserService userService;

	@GetMapping(value = Constants.GETBYID)
	public User getUserById(@PathVariable("id") int id) {

		return userService.getUserById(id);

	}

	@GetMapping(value = Constants.HEALTHCHECK)
	public ResponseEntity<String> healthCheck(@PathVariable int id) {
		boolean isUserExist = userService.isUserExist(id);
		if (isUserExist) {
			return new ResponseEntity<String>("Health Check Successful", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Health Check Failed", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = Constants.POST)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User adduser = userService.createUser(user);
		return new ResponseEntity<User>(adduser, HttpStatus.CREATED);

	}

}
