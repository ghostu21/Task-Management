package com.taskmanagement.Submission.Service.constant;

public enum TaskStatus {
	
	PENDING("PENDING"),ASSIGNED("ASSIGNED"),DONE("DONE");
	
	public final String status;

	private TaskStatus(String status) {
		this.status = status;
	}

}
