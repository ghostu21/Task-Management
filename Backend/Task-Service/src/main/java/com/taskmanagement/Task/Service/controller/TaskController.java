package com.taskmanagement.Task.Service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.Task.Service.dto.GetUserResponseTO;
import com.taskmanagement.Task.Service.model.Task;
import com.taskmanagement.Task.Service.service.TaskService;
import com.taskmanagement.Task.Service.service.UserService;

@RestController
@RequestMapping("/api/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping
	public ResponseEntity<Task> createTask(@RequestBody Task task,
			@RequestHeader("Authorization") String jwt) throws Exception
			{
		
			GetUserResponseTO user=userService.getUserDetail(jwt);
			Task createdTask=taskService.createTask(task, user.getRole());
			
			return new ResponseEntity<>(createdTask, HttpStatus. CREATED);
			
			
			}

}
