package com.news.auth.Util;

public class AuthenticationExceptionHandler {
    public static class UserNotFoundException extends Exception {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    public static class UserExistsException extends Exception {
        public UserExistsException(String message) {
            super(message);
        }
    }

    public static class UserPasswordMisMatchException extends Exception {
        public UserPasswordMisMatchException(String message) {
            super(message);
        }
    }
}