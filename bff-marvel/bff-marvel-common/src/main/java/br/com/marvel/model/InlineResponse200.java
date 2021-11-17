package br.com.marvel.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * InlineResponse200
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-11T22:48:12.266406300-03:00[America/Sao_Paulo]")

public class InlineResponse200 {
	@JsonProperty("code")
	private BigDecimal code = null;

	@JsonProperty("status")
	private String status = null;

	@JsonProperty("etag")
	private String etag = null;

	@JsonProperty("data")
	private InlineResponse200Data data = null;

	@JsonProperty("copyright")
	private String copyright = null;

	@JsonProperty("attributionText")
	private String attributionText = null;

	@JsonProperty("attributionHTML")
	private String attributionHTML = null;

	public InlineResponse200 code(BigDecimal code) {
		this.code = code;
		return this;
	}

	/**
	 * The HTTP status code of the returned result
	 * 
	 * @return code
	 **/
	@ApiModelProperty(example = "200.0", value = "The HTTP status code of the returned result")

	@Valid
	public BigDecimal getCode() {
		return code;
	}

	public void setCode(BigDecimal code) {
		this.code = code;
	}

	public InlineResponse200 status(String status) {
		this.status = status;
		return this;
	}

	/**
	 * A string description of the call status
	 * 
	 * @return status
	 **/
	@ApiModelProperty(example = "Ok", value = "A string description of the call status")

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public InlineResponse200 etag(String etag) {
		this.etag = etag;
		return this;
	}

	/**
	 * A digest value of the content
	 * 
	 * @return etag
	 **/
	@ApiModelProperty(example = "f0fbae65eb2f8f28bdeea0a29be8749a4e67acb3", value = "A digest value of the content")

	public String getEtag() {
		return etag;
	}

	public void setEtag(String etag) {
		this.etag = etag;
	}

	public InlineResponse200 data(InlineResponse200Data data) {
		this.data = data;
		return this;
	}

	/**
	 * Get data
	 * 
	 * @return data
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public InlineResponse200Data getData() {
		return data;
	}

	public void setData(InlineResponse200Data data) {
		this.data = data;
	}

	public InlineResponse200 copyright(String copyright) {
		this.copyright = copyright;
		return this;
	}

	/**
	 * The copyright notice for the returned result
	 * 
	 * @return copyright
	 **/
	@ApiModelProperty(value = "The copyright notice for the returned result")

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public InlineResponse200 attributionText(String attributionText) {
		this.attributionText = attributionText;
		return this;
	}

	/**
	 * The attribution notice for this result
	 * 
	 * @return attributionText
	 **/
	@ApiModelProperty(value = "The attribution notice for this result")

	public String getAttributionText() {
		return attributionText;
	}

	public void setAttributionText(String attributionText) {
		this.attributionText = attributionText;
	}

	public InlineResponse200 attributionHTML(String attributionHTML) {
		this.attributionHTML = attributionHTML;
		return this;
	}

	/**
	 * An HTML representation of the attribution notice for this result
	 * 
	 * @return attributionHTML
	 **/
	@ApiModelProperty(value = "An HTML representation of the attribution notice for this result")

	public String getAttributionHTML() {
		return attributionHTML;
	}

	public void setAttributionHTML(String attributionHTML) {
		this.attributionHTML = attributionHTML;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		InlineResponse200 inlineResponse200 = (InlineResponse200) o;
		return Objects.equals(this.code, inlineResponse200.code)
				&& Objects.equals(this.status, inlineResponse200.status)
				&& Objects.equals(this.etag, inlineResponse200.etag)
				&& Objects.equals(this.data, inlineResponse200.data)
				&& Objects.equals(this.copyright, inlineResponse200.copyright)
				&& Objects.equals(this.attributionText, inlineResponse200.attributionText)
				&& Objects.equals(this.attributionHTML, inlineResponse200.attributionHTML);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, status, etag, data, copyright, attributionText, attributionHTML);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class InlineResponse200 {\n");

		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    etag: ").append(toIndentedString(etag)).append("\n");
		sb.append("    data: ").append(toIndentedString(data)).append("\n");
		sb.append("    copyright: ").append(toIndentedString(copyright)).append("\n");
		sb.append("    attributionText: ").append(toIndentedString(attributionText)).append("\n");
		sb.append("    attributionHTML: ").append(toIndentedString(attributionHTML)).append("\n");
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
