package com.fuhj.exception;

public class ServiceException extends ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4494350858604062622L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
		cause.printStackTrace();
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		cause.printStackTrace();
	}
}
