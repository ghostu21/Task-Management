package com.taskmanagement.Task.Service.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanagement.Task.Service.constant.TaskStatus;
import com.taskmanagement.Task.Service.model.Task;
import com.taskmanagement.Task.Service.repo.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Task createTask(Task task, String requesterRole) throws Exception {
		// TODO Auto-generated method stub
		
		if(!requesterRole. equals (("ROLE_ADMIN"))){
			throw new Exception("only admin can create task");
		}
			task.setStatus (TaskStatus. PENDING);
			task.setCreatedTime(new Date());
			return taskRepository.save(task);
	}

	@Override
	public Task getTaskById(Long id) throws Exception {
		// TODO Auto-generated method stub
		
		return taskRepository.findById(id).orElseThrow(()-> new Exception("Task Not Found!!!"));
	}

	@Override
	public List<Task> getAllTask(TaskStatus status) {
		

		List<Task> allTask=taskRepository.findAll();
		
		List<Task> filteredTasks=allTask.stream().filter(
		task -> status==null || task.getStatus().name().equalsIgnoreCase(status.toString())
		).collect(Collectors.toList());
		
		return filteredTasks;
		
	}
	

	@Override
	public Task updateTask(Long id, Task updatedTask, Long userId) throws Exception {
		// TODO Auto-generated method stub
		
		
		Task existingTask = getTaskById (id);
		if (updatedTask.getTitle()!=null) {
		existingTask.setTitle(updatedTask.getTitle());
	}
		
		if (updatedTask.getImage() !=null){
			existingTask.setImage(updatedTask. getImage());
		}
			
			if (updatedTask.getDescription()!=null){
			existingTask. setDescription(updatedTask.getDescription());
			}
			
			
			if (updatedTask.getStatus() !=null){
			existingTask.setStatus(updatedTask.getStatus());
			}
		
			if (updatedTask.getDeadline()!=null){
				existingTask.setDeadline(updatedTask.getDeadline());
				}
				return taskRepository.save(existingTask);
	}

	@Override
	public void deleteTask(Long id) throws Exception {
		
		getTaskById(id);
		taskRepository.deleteById(id);
		

	}

	@Override
	public Task assignedToUser(Long userId, Long taskId) throws Exception {
		Task task = getTaskById(taskId);
		task.setAssignedUserId(userId); 
		task.setStatus(TaskStatus. DONE);
		return taskRepository.save(task);
	}

	@Override
	public List<Task> assignedUsersTask(Long userId, TaskStatus status) {

		List<Task> allTask=taskRepository.findByAssignedUserId(userId);
		
		List<Task> filteredTasks=allTask.stream().filter(
				task -> status==null || task.getStatus().name().equalsIgnoreCase(status.toString())
				).collect(Collectors.toList());
				
				return filteredTasks;
		
	}

	@Override
	public Task completeTask(Long taskId) throws Exception {
		Task task = getTaskById(taskId);
		
		task.setStatus(TaskStatus. DONE);
		return taskRepository.save(task);
	}

}
