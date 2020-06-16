package com.test.southsystem.exception.associado;

public class AssociadoNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3699145702081993062L;

	public AssociadoNotFoundException() {
		super();
	}

	public AssociadoNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AssociadoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public AssociadoNotFoundException(String message) {
		super(message);
	}

	public AssociadoNotFoundException(Throwable cause) {
		super(cause);
	}
}
