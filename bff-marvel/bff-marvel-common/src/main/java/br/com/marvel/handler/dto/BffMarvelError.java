package br.com.marvel.handler.dto;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class BffMarvelError implements Serializable {

	private static final long serialVersionUID = 557098096679648463L;

	@Getter
	@Setter
	private Integer code;

	@Getter
	@Setter
	private String message;

	@Setter
	private String detail;

	@Getter
	@Setter
	private String traceId = UUID.randomUUID().toString();

	public static BffMarvelError badRequest(Exception ex) {
		return BffMarvelError.create().code(HttpStatus.BAD_REQUEST.value()).message("BAD_REQUEST")
				.detail(ex.getMessage());
	}

	public static BffMarvelError notFound(Exception ex) {
		return BffMarvelError.create().code(HttpStatus.NOT_FOUND.value()).message("NOT FOUND").detail(ex.getMessage());
	}

	public static BffMarvelError methodNotSupported(Exception ex) {
		return BffMarvelError.create().code(HttpStatus.METHOD_NOT_ALLOWED.value()).message("METHOD_NOT_ALLOWED")
				.detail(ex.getMessage());
	}

	public static BffMarvelError internalServerError(Exception ex) {
		return BffMarvelError.create().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).message("INTERNAL SERVER ERROR")
				.detail(ex.getMessage());
	}

	public static BffMarvelError create() {
		return new BffMarvelError();
	}

	public BffMarvelError code(Integer code) {
		this.setCode(code);
		return this;
	}

	public BffMarvelError message(String message) {
		this.setMessage(message);
		return this;
	}

	public BffMarvelError detail(String detail) {
		this.setDetail(detail);
		return this;
	}

	@JsonInclude(Include.NON_NULL)
	public String getDetail() {
		return detail;
	}

}
