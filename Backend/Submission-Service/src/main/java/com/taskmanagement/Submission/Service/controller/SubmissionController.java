package com.taskmanagement.Submission.Service.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.Submission.Service.dto.GetUserResponseTO;
import com.taskmanagement.Submission.Service.model.Submission;
import com.taskmanagement.Submission.Service.service.SubmissionService;
import com.taskmanagement.Submission.Service.service.TaskService;
import com.taskmanagement.Submission.Service.service.UserService;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {
	
	
	@Autowired
	private SubmissionService submissionService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping
			public ResponseEntity<Submission>submitTask(@RequestParam Long task_id,@RequestParam String github_link,@RequestHeader ("Authorization") String jwt
			) throws
			Exception{
			
			GetUserResponseTO user=userService.getUserDetail(jwt);
			
			Submission submission=submissionService.submitTask(task_id, github_link,user.getUserId(),jwt);
			
			return new ResponseEntity<>(submission, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Submission>getSubmissionById(
	@PathVariable Long id,
	@RequestHeader ("Authorization") String jwt
	) throws
	Exception{
	GetUserResponseTO user=userService.getUserDetail(jwt);
	Submission submission=submissionService. getTaskSubmissionById(id); 
	return new ResponseEntity<>(submission, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Submission>>getAllSubmission(
	@RequestHeader ("Authorization") String jwt
	) throws
	Exception{
	GetUserResponseTO user=userService.getUserDetail(jwt);
	List<Submission> submission=submissionService. getAllTaskSubmissions(); 
	return new ResponseEntity<>(submission, HttpStatus.OK);
	}
	
	@GetMapping("/task/{taskId}")
	public ResponseEntity<List<Submission>>getAllSubmissions(
	@PathVariable Long taskId,
	@RequestHeader ("Authorization") String jwt)throws Exception{
	
		GetUserResponseTO user=userService. getUserDetail (jwt);
	List<Submission> submissions=submissionService.getTaskSubmissionsByTaskId(taskId); 
	return new ResponseEntity<>(submissions, HttpStatus. CREATED);
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<Submission>acceptOrDeclineSubmission(
	@PathVariable Long id,
	@RequestParam ("status") String status,
	@RequestHeader ("Authorization") String jwt
	)throws Exception{
		GetUserResponseTO user=userService. getUserDetail (jwt);
	Submission submission= submissionService.acceptDecLineSubmission(id,status);
	return new ResponseEntity<>(submission, HttpStatus. CREATED);
	}

}
