package br.com.marvel.utils;

import org.springframework.http.HttpHeaders;

import br.com.marvel.controller.dto.Pagination;

public class ResponseHeadersUtils {
	
	public static HttpHeaders paginationHeaders(Pagination pagination) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("offset", pagination.getOffset().toString());
		httpHeaders.set("limit", pagination.getLimit().toString());
		httpHeaders.set("total", pagination.getTotal().toString());
		httpHeaders.set("count", pagination.getCount().toString());
		
		return httpHeaders;
	}

}
