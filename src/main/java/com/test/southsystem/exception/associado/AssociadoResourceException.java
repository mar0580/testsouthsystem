package com.test.southsystem.exception.associado;

public class AssociadoResourceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3134814679484790405L;

	public AssociadoResourceException() {
		super();
	}

	public AssociadoResourceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AssociadoResourceException(String message, Throwable cause) {
		super(message, cause);
	}

	public AssociadoResourceException(String message) {
		super(message);
	}

	public AssociadoResourceException(Throwable cause) {
		super(cause);
	}
}
