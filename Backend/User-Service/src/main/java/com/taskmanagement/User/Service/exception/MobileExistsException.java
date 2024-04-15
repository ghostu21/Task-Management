package com.taskmanagement.User.Service.exception;

public class MobileExistsException extends RuntimeException {
	private static final long serialVersionUID = 8696357905206089149L;

	public MobileExistsException(String message) {
		super(message);
	}
}
