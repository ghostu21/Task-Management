package com.taskmanagement.Submission.Service.service;

import java.util.List;

import com.taskmanagement.Submission.Service.model.Submission;

public interface SubmissionService {
	
	Submission submitTask(Long taskId, String githublink, Long userId)throws Exception;
	
	Submission getTaskSubmissionById(Long submissionId) throws Exception;
	
	List<Submission> getAllTaskSubmissions();
	
	List<Submission> getTaskSubmissionsByTaskId(Long taskId);
	
	Submission acceptDecLineSubmission(Long id, String status) throws Exception;

}
