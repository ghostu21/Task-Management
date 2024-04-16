package com.taskmanagement.Task.Service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.taskmanagement.Task.Service.dto.GetUserResponseTO;

@FeignClient (name="User-Service", url="http://localhost:5001")
public interface UserService {

	@GetMapping("/users")
	public GetUserResponseTO getUserDetail(@RequestHeader("Authorization") String jwt);
}
