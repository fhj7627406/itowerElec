package com.fuhj.exception;

public class ApplicationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6696829387229157915L;

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
		cause.printStackTrace();
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
		cause.printStackTrace();
	}
}
