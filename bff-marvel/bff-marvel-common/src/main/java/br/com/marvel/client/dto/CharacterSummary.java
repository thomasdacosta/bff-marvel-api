package br.com.marvel.client.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CharacterSummary
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-11T22:48:12.266406300-03:00[America/Sao_Paulo]")

public class CharacterSummary {
	@JsonProperty("resourceURI")
	private String resourceURI = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("role")
	private String role = null;

	public CharacterSummary resourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
		return this;
	}

	/**
	 * The path to the individual character resource.
	 * 
	 * @return resourceURI
	 **/
	@ApiModelProperty(value = "The path to the individual character resource.")

	public String getResourceURI() {
		return resourceURI;
	}

	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}

	public CharacterSummary name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * The full name of the character.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "The full name of the character.")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CharacterSummary role(String role) {
		this.role = role;
		return this;
	}

	/**
	 * The role of the creator in the parent entity.
	 * 
	 * @return role
	 **/
	@ApiModelProperty(value = "The role of the creator in the parent entity.")

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CharacterSummary characterSummary = (CharacterSummary) o;
		return Objects.equals(this.resourceURI, characterSummary.resourceURI)
				&& Objects.equals(this.name, characterSummary.name) && Objects.equals(this.role, characterSummary.role);
	}

	@Override
	public int hashCode() {
		return Objects.hash(resourceURI, name, role);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CharacterSummary {\n");

		sb.append("    resourceURI: ").append(toIndentedString(resourceURI)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    role: ").append(toIndentedString(role)).append("\n");
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
