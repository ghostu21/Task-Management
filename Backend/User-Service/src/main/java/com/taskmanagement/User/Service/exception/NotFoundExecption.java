package com.taskmanagement.User.Service.exception;

public class NotFoundExecption extends RuntimeException {

	private static final long serialVersionUID = 1592642868797241627L;

	public NotFoundExecption(String message) {
		super(message);
	}

}
