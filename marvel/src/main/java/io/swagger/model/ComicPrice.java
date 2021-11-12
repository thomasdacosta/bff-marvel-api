package io.swagger.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ComicPrice
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-11T22:48:12.266406300-03:00[America/Sao_Paulo]")

public class ComicPrice {
	@JsonProperty("type")
	private String type = null;

	@JsonProperty("price")
	private BigDecimal price = null;

	public ComicPrice type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * A description of the price (e.g. print price, digital price).
	 * 
	 * @return type
	 **/
	@ApiModelProperty(value = "A description of the price (e.g. print price, digital price).")

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ComicPrice price(BigDecimal price) {
		this.price = price;
		return this;
	}

	/**
	 * The price (all prices in USD).
	 * 
	 * @return price
	 **/
	@ApiModelProperty(value = "The price (all prices in USD).")

	@Valid
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ComicPrice comicPrice = (ComicPrice) o;
		return Objects.equals(this.type, comicPrice.type) && Objects.equals(this.price, comicPrice.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, price);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ComicPrice {\n");

		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    price: ").append(toIndentedString(price)).append("\n");
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
