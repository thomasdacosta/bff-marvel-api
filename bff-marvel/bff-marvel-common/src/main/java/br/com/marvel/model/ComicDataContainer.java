package br.com.marvel.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ComicDataContainer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-11T22:48:12.266406300-03:00[America/Sao_Paulo]")

public class ComicDataContainer {
	@JsonProperty("offset")
	private BigDecimal offset = null;

	@JsonProperty("limit")
	private BigDecimal limit = null;

	@JsonProperty("total")
	private BigDecimal total = null;

	@JsonProperty("count")
	private BigDecimal count = null;

	@JsonProperty("results")
	@Valid
	private List<Comic> results = null;

	public ComicDataContainer offset(BigDecimal offset) {
		this.offset = offset;
		return this;
	}

	/**
	 * The requested offset (number of skipped results) of the call.
	 * 
	 * @return offset
	 **/
	@ApiModelProperty(value = "The requested offset (number of skipped results) of the call.")

	@Valid
	public BigDecimal getOffset() {
		return offset;
	}

	public void setOffset(BigDecimal offset) {
		this.offset = offset;
	}

	public ComicDataContainer limit(BigDecimal limit) {
		this.limit = limit;
		return this;
	}

	/**
	 * The requested result limit.
	 * 
	 * @return limit
	 **/
	@ApiModelProperty(value = "The requested result limit.")

	@Valid
	public BigDecimal getLimit() {
		return limit;
	}

	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}

	public ComicDataContainer total(BigDecimal total) {
		this.total = total;
		return this;
	}

	/**
	 * The total number of resources available given the current filter set.
	 * 
	 * @return total
	 **/
	@ApiModelProperty(value = "The total number of resources available given the current filter set.")

	@Valid
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public ComicDataContainer count(BigDecimal count) {
		this.count = count;
		return this;
	}

	/**
	 * The total number of results returned by this call.
	 * 
	 * @return count
	 **/
	@ApiModelProperty(value = "The total number of results returned by this call.")

	@Valid
	public BigDecimal getCount() {
		return count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}

	public ComicDataContainer results(List<Comic> results) {
		this.results = results;
		return this;
	}

	public ComicDataContainer addResultsItem(Comic resultsItem) {
		if (this.results == null) {
			this.results = new ArrayList<Comic>();
		}
		this.results.add(resultsItem);
		return this;
	}

	/**
	 * The list of comics returned by the call
	 * 
	 * @return results
	 **/
	@ApiModelProperty(value = "The list of comics returned by the call")
	@Valid
	public List<Comic> getResults() {
		return results;
	}

	public void setResults(List<Comic> results) {
		this.results = results;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ComicDataContainer comicDataContainer = (ComicDataContainer) o;
		return Objects.equals(this.offset, comicDataContainer.offset)
				&& Objects.equals(this.limit, comicDataContainer.limit)
				&& Objects.equals(this.total, comicDataContainer.total)
				&& Objects.equals(this.count, comicDataContainer.count)
				&& Objects.equals(this.results, comicDataContainer.results);
	}

	@Override
	public int hashCode() {
		return Objects.hash(offset, limit, total, count, results);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ComicDataContainer {\n");

		sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
		sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
		sb.append("    total: ").append(toIndentedString(total)).append("\n");
		sb.append("    count: ").append(toIndentedString(count)).append("\n");
		sb.append("    results: ").append(toIndentedString(results)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
