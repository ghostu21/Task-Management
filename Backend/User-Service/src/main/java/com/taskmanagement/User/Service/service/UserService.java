package com.taskmanagement.User.Service.service;

import com.taskmanagement.User.Service.dto.AuthResponseTO;
import com.taskmanagement.User.Service.dto.CreateUserRequestTO;
import com.taskmanagement.User.Service.dto.GetUserResponseTO;
import com.taskmanagement.User.Service.dto.LoginRequestTO;
import com.taskmanagement.User.Service.dto.UpdateUserRequestTO;
import com.taskmanagement.User.Service.model.User;

public interface UserService {

	AuthResponseTO registerUser(CreateUserRequestTO userDTO);

	AuthResponseTO userSignIn(LoginRequestTO req);

	GetUserResponseTO getUserDetails(String jwt);

	User getUserByEmail(String email);

	void updateUser(String jwt, UpdateUserRequestTO req);

}
