package com.taskmanagement.Submission.Service.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanagement.Submission.Service.dto.TaskDTO;
import com.taskmanagement.Submission.Service.model.Submission;
import com.taskmanagement.Submission.Service.repo.SubmissionRepository;

@Service
public class SubmissionServiceImpl implements SubmissionService {

	@Autowired
	private SubmissionRepository submissionRepository;
	@Autowired
	private TaskService taskService;
	
	private UserService userService;
	
	@Override
	public Submission submitTask(Long taskId, String githublink, Long userId,String jwt) throws Exception {
		// TODO Auto-generated method stub
		
		TaskDTO task=taskService.getTaskId(taskId, jwt);
		
		if(task!=null) {
			Submission submission=new Submission();
			submission. setTaskId(taskId);
			submission.setUserId(userId);
			submission. setGithubLink (githublink);
			submission.setSubmissionTime (new Date());
			return submissionRepository.save(submission);
		}
			throw new Exception("Task not found with id : "+taskId);
	}

	@Override
	public Submission getTaskSubmissionById(Long submissionId) throws Exception {
		// TODO Auto-generated method stub
		return  submissionRepository.findById(submissionId).orElseThrow(()-> new Exception("Task Submisson not found with id"+submissionId));
	}

	@Override
	public List<Submission> getAllTaskSubmissions() {
		// TODO Auto-generated method stub
		return submissionRepository.findAll();
	}

	@Override
	public List<Submission> getTaskSubmissionsByTaskId(Long taskId) {
		// TODO Auto-generated method stub
		return submissionRepository.findByTaskId(taskId);
	}

	@Override
	public Submission acceptDecLineSubmission(Long id, String status) throws Exception {
		Submission submission=getTaskSubmissionById(id);
		submission. setStatus (status);
		if(status. equals("ACCEPT")){
		taskService.completeTask(submission.getTaskId());
		
		}
		return submissionRepository.save(submission);
	}

}
