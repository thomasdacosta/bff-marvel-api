package br.com.marvel.controller.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

public class Pagination {

	@Getter
	@Setter
	private BigDecimal offset;

	@Getter
	@Setter
	private BigDecimal limit;

	@Getter
	@Setter
	private BigDecimal total;

	@Getter
	@Setter
	private BigDecimal count;

	@Getter
	@Setter
	private String fileName;

	@Getter
	@Setter
	private Object data;

}
