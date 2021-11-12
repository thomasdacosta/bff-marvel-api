package io.swagger.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * SeriesDataContainer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-11T22:48:12.266406300-03:00[America/Sao_Paulo]")

public class SeriesDataContainer {
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
	private List<Series> results = null;

	public SeriesDataContainer offset(BigDecimal offset) {
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

	public SeriesDataContainer limit(BigDecimal limit) {
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

	public SeriesDataContainer total(BigDecimal total) {
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

	public SeriesDataContainer count(BigDecimal count) {
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

	public SeriesDataContainer results(List<Series> results) {
		this.results = results;
		return this;
	}

	public SeriesDataContainer addResultsItem(Series resultsItem) {
		if (this.results == null) {
			this.results = new ArrayList<Series>();
		}
		this.results.add(resultsItem);
		return this;
	}

	/**
	 * The list of series returned by the call
	 * 
	 * @return results
	 **/
	@ApiModelProperty(value = "The list of series returned by the call")
	@Valid
	public List<Series> getResults() {
		return results;
	}

	public void setResults(List<Series> results) {
		this.results = results;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SeriesDataContainer seriesDataContainer = (SeriesDataContainer) o;
		return Objects.equals(this.offset, seriesDataContainer.offset)
				&& Objects.equals(this.limit, seriesDataContainer.limit)
				&& Objects.equals(this.total, seriesDataContainer.total)
				&& Objects.equals(this.count, seriesDataContainer.count)
				&& Objects.equals(this.results, seriesDataContainer.results);
	}

	@Override
	public int hashCode() {
		return Objects.hash(offset, limit, total, count, results);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SeriesDataContainer {\n");

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
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
