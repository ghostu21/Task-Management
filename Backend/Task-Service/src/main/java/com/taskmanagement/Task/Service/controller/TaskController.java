package com.taskmanagement.Task.Service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.Task.Service.constant.TaskStatus;
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
			@RequestHeader("Authorization") String jwt) throws Exception{
		
			GetUserResponseTO user=userService.getUserDetail(jwt);
			Task createdTask=taskService.createTask(task, user.getRole());
			
			return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
			
			
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> getTaskId(@PathVariable Long id,
			@RequestHeader("Authorization") String jwt) throws Exception{
		
			GetUserResponseTO user=userService.getUserDetail(jwt);
			Task task=taskService.getTaskById(id);
			
			return new ResponseEntity<>(task, HttpStatus. CREATED);
			
			
			}
	
//	getAssignedUsersTask(
	
	@GetMapping("/user")
	public ResponseEntity<List<Task>> getAssignedUsersTask(@RequestParam(required = false) TaskStatus status,
			@RequestHeader("Authorization") String jwt) throws Exception{
		
			GetUserResponseTO user=userService.getUserDetail(jwt);
			List<Task> userTask=taskService.assignedUsersTask(user.getUserId(),status);
			
			return new ResponseEntity<>(userTask, HttpStatus. CREATED);
			
			
			}
	
	@GetMapping
			public ResponseEntity<List<Task>> getAllTask(@RequestParam(required=false) TaskStatus status, @RequestHeader ("Authorization") String jwt) throws
			Exception {
		GetUserResponseTO user=userService.getUserDetail(jwt);
			List<Task> tasks=taskService.getAllTask(status);
			return new ResponseEntity<>(tasks, HttpStatus. CREATED);
	}
	
	
	@PutMapping("/{id}/user/{userid}/assigned")
	public ResponseEntity<Task>
	assignedTaskToUser (@PathVariable Long id,
			@PathVariable Long userid,
	@RequestHeader ("Authorization") String jwt)
	throws
	Exception {
		GetUserResponseTO user=userService.getUserDetail(jwt);
	
	Task tasks=taskService.assignedToUser(userid,id);
	return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(
	@PathVariable Long id,
	@RequestBody Task req,
	@RequestHeader ("Authorization") String jwt) throws Exception {
		GetUserResponseTO user=userService. getUserDetail(jwt);
	Task tasks=taskService.updateTask(id, req, user.getUserId());
	return new ResponseEntity<>(tasks, HttpStatus. CREATED);
	
	}
	
	@PutMapping("/{id}/complete")
	public ResponseEntity<Task> completeTask(@PathVariable Long id)
	throws Exception {
	Task tasks=taskService.completeTask(id);
	return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Void>deleteTask(@PathVariable Long id) throws Exception {
	taskService.deleteTask(id);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	
	}
	


}
