package io.swagger.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Url
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-11T22:48:12.266406300-03:00[America/Sao_Paulo]")

public class Url {
	@JsonProperty("type")
	private String type = null;

	@JsonProperty("url")
	private String url = null;

	public Url type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * A text identifier for the URL.
	 * 
	 * @return type
	 **/
	@ApiModelProperty(value = "A text identifier for the URL.")

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Url url(String url) {
		this.url = url;
		return this;
	}

	/**
	 * A full URL (including scheme, domain, and path).
	 * 
	 * @return url
	 **/
	@ApiModelProperty(value = "A full URL (including scheme, domain, and path).")

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Url url = (Url) o;
		return Objects.equals(this.type, url.type) && Objects.equals(this.url, url.url);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, url);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Url {\n");

		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
