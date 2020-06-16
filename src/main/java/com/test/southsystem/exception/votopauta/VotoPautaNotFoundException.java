package com.test.southsystem.exception.votopauta;

public class VotoPautaNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2171260444439400078L;

	public VotoPautaNotFoundException() {
		super();
	}

	public VotoPautaNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public VotoPautaNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public VotoPautaNotFoundException(String message) {
		super(message);
	}

	public VotoPautaNotFoundException(Throwable cause) {
		super(cause);
	}
}
