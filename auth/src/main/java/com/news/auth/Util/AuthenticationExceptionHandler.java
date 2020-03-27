package com.news.auth.Util;

public class AuthenticationExceptionHandler {
	/**
	 * Exception if user Not found
	 */
	public static class UserNotFoundException extends Exception {
		public UserNotFoundException(String message) {
			super(message);
		}
	}

	/**
	 * Exception if user already exists
	 */
	public static class UserExistsException extends Exception {
		public UserExistsException(String message) {
			super(message);
		}
	}

	/**
	 * Exception if username and Password does not macth
	 */
	public static class UserPasswordMisMatchException extends Exception {
		public UserPasswordMisMatchException(String message) {
			super(message);
		}
	}
}