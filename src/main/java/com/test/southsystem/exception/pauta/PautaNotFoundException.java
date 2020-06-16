package com.test.southsystem.exception.pauta;

public class PautaNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8396594754652779460L;

	public PautaNotFoundException() {
		super();
	}

	public PautaNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PautaNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PautaNotFoundException(String message) {
		super(message);
	}

	public PautaNotFoundException(Throwable cause) {
		super(cause);
	}
}
