package com.moviebuff.mongodb.application.Exception;

public class MovieBuffServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MovieBuffServiceException() {
		super();
	}

	public MovieBuffServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public MovieBuffServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public MovieBuffServiceException(String arg0) {
		super(arg0);
	}

	public MovieBuffServiceException(Throwable arg0) {
		super(arg0);
	}
	
	

}
