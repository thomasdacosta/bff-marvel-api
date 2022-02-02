package br.com.marvel.client.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * TextObject
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-11T22:48:12.266406300-03:00[America/Sao_Paulo]")

public class TextObject {
	@JsonProperty("type")
	private String type = null;

	@JsonProperty("language")
	private String language = null;

	@JsonProperty("text")
	private String text = null;

	public TextObject type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * The canonical type of the text object (e.g. solicit text, preview text,
	 * etc.).
	 * 
	 * @return type
	 **/
	@ApiModelProperty(value = "The canonical type of the text object (e.g. solicit text, preview text, etc.).")

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TextObject language(String language) {
		this.language = language;
		return this;
	}

	/**
	 * The IETF language tag denoting the language the text object is written in.
	 * 
	 * @return language
	 **/
	@ApiModelProperty(value = "The IETF language tag denoting the language the text object is written in.")

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public TextObject text(String text) {
		this.text = text;
		return this;
	}

	/**
	 * The text.
	 * 
	 * @return text
	 **/
	@ApiModelProperty(value = "The text.")

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TextObject textObject = (TextObject) o;
		return Objects.equals(this.type, textObject.type) && Objects.equals(this.language, textObject.language)
				&& Objects.equals(this.text, textObject.text);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, language, text);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TextObject {\n");

		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    language: ").append(toIndentedString(language)).append("\n");
		sb.append("    text: ").append(toIndentedString(text)).append("\n");
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
