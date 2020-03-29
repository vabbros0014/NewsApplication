package com.news.user.profile.exception;

public class UserAlreadyExistException extends Exception {


    /**
	 * Add User Already Exist Exception
	 */
	private static final long serialVersionUID = 1L;
	String messge;
    public UserAlreadyExistException(String message) {
        super(message);
        this.messge = message;

    }

    public UserAlreadyExistException() {
    }
}