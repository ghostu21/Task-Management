package com.taskmanagement.Submission.Service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanagement.Submission.Service.model.Submission;

public interface SubmissionRepository  extends JpaRepository<Submission, Long>{

	
	List<Submission> findByTaskId(Long taskId);
}
