package com.taskmanagement.Task.Service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanagement.Task.Service.model.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{

	public List<Task> findByAssignedUserId(Long userId);
	
}
