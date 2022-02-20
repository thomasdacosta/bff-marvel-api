package br.com.marvel.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_IMPLEMENTED)
public class MethodNotImplementedException extends RuntimeException {
	
	private static final long serialVersionUID = -1642248787152180962L;

	public MethodNotImplementedException(String message) {
		super(message);
	}

	public MethodNotImplementedException(String message, Throwable cause) {
		super(message, cause);
	}	

}
