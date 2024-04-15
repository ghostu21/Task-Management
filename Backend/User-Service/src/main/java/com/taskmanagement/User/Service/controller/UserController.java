package com.taskmanagement.User.Service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.User.Service.dto.GetUserResponseTO;
import com.taskmanagement.User.Service.dto.UpdateUserRequestTO;
import com.taskmanagement.User.Service.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	
	
	@GetMapping
	public ResponseEntity<?> getUserDetail(@RequestHeader("Authorization") String jwt) {
		logger.info("Get User Profile Start");

		GetUserResponseTO userResponse = userService.getUserDetails(jwt);
		logger.info("Get User Profile:{}", userResponse.getEmail());

		return new ResponseEntity<>(userResponse, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> updateUserDetail(@RequestHeader("Authorization") String jwt,
			@RequestBody UpdateUserRequestTO req) {

//		userService.updateUser(jwt, req);

		return new ResponseEntity<>("User Updated...", HttpStatus.OK);
	}

}
