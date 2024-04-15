package com.taskmanagement.User.Service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.User.Service.dto.AuthResponseTO;
import com.taskmanagement.User.Service.dto.CreateUserRequestTO;
import com.taskmanagement.User.Service.dto.LoginRequestTO;
import com.taskmanagement.User.Service.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	private UserService userService;

	// Public API's

	@PostMapping("/register")
	public ResponseEntity<AuthResponseTO> registerUser(@RequestBody CreateUserRequestTO userDTO) {

//	 GenericValidator.validate(userDTO);

		// Validating mobile and email
//		MobileandEmailValidator.isValidEmail(userDTO.getEmail());
//		MobileandEmailValidator.isValidMobileNumber(userDTO.getMobile());

//	 	logger.info("Registartion Start");
		AuthResponseTO authResponse = userService.registerUser(userDTO);
		logger.info("User registered successfully: {}", userDTO.getEmail());

//    	 logger.info("Registartion End");
		return new ResponseEntity<>(authResponse, HttpStatus.CREATED);

	}

	@PostMapping("/signin")
	public ResponseEntity<AuthResponseTO> singnin(@RequestBody LoginRequestTO req) {

		logger.info("Login Start: {}", req.getEmail());
		AuthResponseTO authResponse = userService.userSignIn(req);
		logger.info("Login End: {}", req.getEmail());
		return new ResponseEntity<>(authResponse, HttpStatus.OK);

	}

}
