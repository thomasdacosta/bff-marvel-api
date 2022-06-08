package br.com.marvel.client.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import br.com.marvel.controller.dto.Pagination;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The results returned by the call
 */
@ApiModel(description = "The results returned by the call")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-11T22:48:12.266406300-03:00[America/Sao_Paulo]")
public class InlineResponse200Data extends Pagination {

	@JsonProperty("offset")
	private BigDecimal offset = null;

	@JsonProperty("limit")
	private BigDecimal limit = null;

	@JsonProperty("total")
	private BigDecimal total = null;

	@JsonProperty("count")
	private BigDecimal count = null;

//	@JsonProperty("results")
//	private Object results = null;

	@JsonProperty("results")
	@Valid
	private List<Character> results = null;

	public InlineResponse200Data offset(BigDecimal offset) {
		this.offset = offset;
		return this;
	}

	/**
	 * The requested offset (skipped results) of the call
	 * 
	 * @return offset
	 **/
	@ApiModelProperty(example = "0.0", value = "The requested offset (skipped results) of the call")

	@Valid
	public BigDecimal getOffset() {
		return offset;
	}

	public void setOffset(BigDecimal offset) {
		this.offset = offset;
	}

	public InlineResponse200Data limit(BigDecimal limit) {
		this.limit = limit;
		return this;
	}

	/**
	 * The requested result limit
	 * 
	 * @return limit
	 **/
	@ApiModelProperty(example = "20.0", value = "The requested result limit")

	@Valid
	public BigDecimal getLimit() {
		return limit;
	}

	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}

	public InlineResponse200Data total(BigDecimal total) {
		this.total = total;
		return this;
	}

	/**
	 * The total number of results available
	 * 
	 * @return total
	 **/
	@ApiModelProperty(example = "30920.0", value = "The total number of results available")

	@Valid
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public InlineResponse200Data count(BigDecimal count) {
		this.count = count;
		return this;
	}

	/**
	 * The total number of results returned by this call
	 * 
	 * @return count
	 **/
	@ApiModelProperty(example = "20.0", value = "The total number of results returned by this call")

	@Valid
	public BigDecimal getCount() {
		return count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}

	public List<Character> getResults() {
		return results;
	}

	public void setResults(List<Character> results) {
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
		InlineResponse200Data inlineResponse200Data = (InlineResponse200Data) o;
		return Objects.equals(this.offset, inlineResponse200Data.offset)
				&& Objects.equals(this.limit, inlineResponse200Data.limit)
				&& Objects.equals(this.total, inlineResponse200Data.total)
				&& Objects.equals(this.count, inlineResponse200Data.count)
				&& Objects.equals(this.results, inlineResponse200Data.results);
	}

	@Override
	public int hashCode() {
		return Objects.hash(offset, limit, total, count, results);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class InlineResponse200Data {\n");

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
