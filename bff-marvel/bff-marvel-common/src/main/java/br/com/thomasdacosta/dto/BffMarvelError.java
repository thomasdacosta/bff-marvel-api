package br.com.thomasdacosta.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class BffMarvelError implements Serializable {

	private static final long serialVersionUID = 557098096679648463L;

	@Getter @Setter
	private String message;

	@Setter
	private String detail;

	public static BffMarvelError notFound(Exception ex) {
		return BffMarvelError.create().message("NOT FOUND").detail(ex.getMessage());
	}

	public static BffMarvelError failedPrecondition(Exception ex) {
		return BffMarvelError.create().message("FAILED PRECONDITION").detail(ex.getMessage());
	}

	public static BffMarvelError internalServerError(Exception ex) {
		return BffMarvelError.create().message("INTERNAL SERVER ERROR").detail(ex.getMessage());
	}

	public static BffMarvelError create() {
		return new BffMarvelError();
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
