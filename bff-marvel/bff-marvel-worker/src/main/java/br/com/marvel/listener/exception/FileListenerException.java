package br.com.marvel.listener.exception;

public class FileListenerException extends Exception {

	private static final long serialVersionUID = 2589082267055876279L;

	public FileListenerException() {}

	public FileListenerException(String message) {
		super(message);
	}

	public FileListenerException(Throwable cause) {
		super(cause);
	}

	public FileListenerException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileListenerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
