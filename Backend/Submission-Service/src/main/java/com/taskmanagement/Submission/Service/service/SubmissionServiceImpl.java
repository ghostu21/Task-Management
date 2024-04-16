package com.taskmanagement.Submission.Service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taskmanagement.Submission.Service.model.Submission;
import com.taskmanagement.Submission.Service.repo.SubmissionRepository;

public class SubmissionServiceImpl implements SubmissionService {

	@Autowired
	private SubmissionRepository submissionRepository;
	
	@Override
	public Submission submitTask(Long taskId, String githublink, Long userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Submission getTaskSubmissionById(Long submissionId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Submission> getAllTaskSubmissions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Submission> getTaskSubmissionsByTaskId(Long taskId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Submission acceptDecLineSubmission(Long id, String status) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
