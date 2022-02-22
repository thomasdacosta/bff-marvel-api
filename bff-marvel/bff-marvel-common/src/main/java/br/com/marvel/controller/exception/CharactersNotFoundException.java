package br.com.marvel.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CharactersNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -571374318141836939L;

	public CharactersNotFoundException(String message) {
		super(message);
	}

	public CharactersNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
