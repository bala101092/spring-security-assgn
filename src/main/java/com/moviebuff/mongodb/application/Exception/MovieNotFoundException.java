package com.moviebuff.mongodb.application.Exception;

public class MovieNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MovieNotFoundException() {
		super();
	}

	public MovieNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MovieNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MovieNotFoundException(String message) {
		super(message);
	}

	public MovieNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}
