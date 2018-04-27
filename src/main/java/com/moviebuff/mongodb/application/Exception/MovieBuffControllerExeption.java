package com.moviebuff.mongodb.application.Exception;

/**
 * @author Balamurugan M
 *
 */
public class MovieBuffControllerExeption extends Exception {

	
	private static final long serialVersionUID = 1L;

	public MovieBuffControllerExeption() {
		super();
	}

	public MovieBuffControllerExeption(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public MovieBuffControllerExeption(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public MovieBuffControllerExeption(String arg0) {
		super(arg0);
	}

	public MovieBuffControllerExeption(Throwable arg0) {
		super(arg0);
	}

	
}
