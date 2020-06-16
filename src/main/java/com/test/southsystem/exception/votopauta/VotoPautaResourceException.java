package com.test.southsystem.exception.votopauta;

public class VotoPautaResourceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5139002329844869569L;

	public VotoPautaResourceException() {
		super();
	}

	public VotoPautaResourceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public VotoPautaResourceException(String message, Throwable cause) {
		super(message, cause);
	}

	public VotoPautaResourceException(String message) {
		super(message);
	}

	public VotoPautaResourceException(Throwable cause) {
		super(cause);
	}
}
