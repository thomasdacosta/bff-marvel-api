package br.com.marvel.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.marvel.dto.BffMarvelError;
import br.com.marvel.exception.NotFoundException;
import br.com.marvel.exception.OperationException;

@RestControllerAdvice
public class RestControllerHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(RestControllerHandler.class);
	
	/**
	 * Erro 400
	 */	
	
	/**
	 * Erro 404 
	 */
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> handleNotFound(NotFoundException ex) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(BffMarvelError.notFound(ex), HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Erro 405
	 */
	@Override
	public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(BffMarvelError.failedPrecondition(ex), status);
	}
	
	/**
	 * Erro 500
	 */
	@ExceptionHandler(OperationException.class)
	public ResponseEntity<Object> handleThrowable(final Exception ex) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(BffMarvelError.internalServerError(ex), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
