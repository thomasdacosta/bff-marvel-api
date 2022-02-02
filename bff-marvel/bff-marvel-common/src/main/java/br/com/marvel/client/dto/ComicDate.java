package br.com.marvel.client.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ComicDate
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-11T22:48:12.266406300-03:00[America/Sao_Paulo]")

public class ComicDate {
	@JsonProperty("type")
	private String type = null;

	@JsonProperty("date")
	private String date = null;

	public ComicDate type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * A description of the date (e.g. onsale date, FOC date).
	 * 
	 * @return type
	 **/
	@ApiModelProperty(value = "A description of the date (e.g. onsale date, FOC date).")

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ComicDate date(String date) {
		this.date = date;
		return this;
	}

	/**
	 * The date.
	 * 
	 * @return date
	 **/
	@ApiModelProperty(value = "The date.")

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ComicDate comicDate = (ComicDate) o;
		return Objects.equals(this.type, comicDate.type) && Objects.equals(this.date, comicDate.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, date);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ComicDate {\n");

		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    date: ").append(toIndentedString(date)).append("\n");
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
