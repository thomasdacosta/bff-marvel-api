package io.swagger.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ComicSummary
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-11T22:48:12.266406300-03:00[America/Sao_Paulo]")

public class ComicSummary {
	@JsonProperty("resourceURI")
	private String resourceURI = null;

	@JsonProperty("name")
	private String name = null;

	public ComicSummary resourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
		return this;
	}

	/**
	 * The path to the individual comic resource.
	 * 
	 * @return resourceURI
	 **/
	@ApiModelProperty(value = "The path to the individual comic resource.")

	public String getResourceURI() {
		return resourceURI;
	}

	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}

	public ComicSummary name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * The canonical name of the comic.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "The canonical name of the comic.")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ComicSummary comicSummary = (ComicSummary) o;
		return Objects.equals(this.resourceURI, comicSummary.resourceURI)
				&& Objects.equals(this.name, comicSummary.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(resourceURI, name);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ComicSummary {\n");

		sb.append("    resourceURI: ").append(toIndentedString(resourceURI)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
