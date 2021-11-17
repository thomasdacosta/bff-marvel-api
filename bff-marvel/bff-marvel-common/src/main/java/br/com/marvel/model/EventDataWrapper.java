package br.com.marvel.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * EventDataWrapper
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-11T22:48:12.266406300-03:00[America/Sao_Paulo]")

public class EventDataWrapper {
	@JsonProperty("code")
	private BigDecimal code = null;

	@JsonProperty("status")
	private String status = null;

	@JsonProperty("copyright")
	private String copyright = null;

	@JsonProperty("attributionText")
	private String attributionText = null;

	@JsonProperty("attributionHTML")
	private String attributionHTML = null;

	@JsonProperty("data")
	private EventDataContainer data = null;

	@JsonProperty("etag")
	private String etag = null;

	public EventDataWrapper code(BigDecimal code) {
		this.code = code;
		return this;
	}

	/**
	 * The HTTP status code of the returned result.
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "The HTTP status code of the returned result.")

	@Valid
	public BigDecimal getCode() {
		return code;
	}

	public void setCode(BigDecimal code) {
		this.code = code;
	}

	public EventDataWrapper status(String status) {
		this.status = status;
		return this;
	}

	/**
	 * A string description of the call status.
	 * 
	 * @return status
	 **/
	@ApiModelProperty(value = "A string description of the call status.")

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public EventDataWrapper copyright(String copyright) {
		this.copyright = copyright;
		return this;
	}

	/**
	 * The copyright notice for the returned result.
	 * 
	 * @return copyright
	 **/
	@ApiModelProperty(value = "The copyright notice for the returned result.")

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public EventDataWrapper attributionText(String attributionText) {
		this.attributionText = attributionText;
		return this;
	}

	/**
	 * The attribution notice for this result. Please display either this notice or
	 * the contents of the attributionHTML field on all screens which contain data
	 * from the Marvel Comics API.
	 * 
	 * @return attributionText
	 **/
	@ApiModelProperty(value = "The attribution notice for this result.  Please display either this notice or the contents of the attributionHTML field on all screens which contain data from the Marvel Comics API.")

	public String getAttributionText() {
		return attributionText;
	}

	public void setAttributionText(String attributionText) {
		this.attributionText = attributionText;
	}

	public EventDataWrapper attributionHTML(String attributionHTML) {
		this.attributionHTML = attributionHTML;
		return this;
	}

	/**
	 * An HTML representation of the attribution notice for this result. Please
	 * display either this notice or the contents of the attributionText field on
	 * all screens which contain data from the Marvel Comics API.
	 * 
	 * @return attributionHTML
	 **/
	@ApiModelProperty(value = "An HTML representation of the attribution notice for this result.  Please display either this notice or the contents of the attributionText field on all screens which contain data from the Marvel Comics API.")

	public String getAttributionHTML() {
		return attributionHTML;
	}

	public void setAttributionHTML(String attributionHTML) {
		this.attributionHTML = attributionHTML;
	}

	public EventDataWrapper data(EventDataContainer data) {
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
	public EventDataContainer getData() {
		return data;
	}

	public void setData(EventDataContainer data) {
		this.data = data;
	}

	public EventDataWrapper etag(String etag) {
		this.etag = etag;
		return this;
	}

	/**
	 * A digest value of the content returned by the call.
	 * 
	 * @return etag
	 **/
	@ApiModelProperty(value = "A digest value of the content returned by the call.")

	public String getEtag() {
		return etag;
	}

	public void setEtag(String etag) {
		this.etag = etag;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		EventDataWrapper eventDataWrapper = (EventDataWrapper) o;
		return Objects.equals(this.code, eventDataWrapper.code) && Objects.equals(this.status, eventDataWrapper.status)
				&& Objects.equals(this.copyright, eventDataWrapper.copyright)
				&& Objects.equals(this.attributionText, eventDataWrapper.attributionText)
				&& Objects.equals(this.attributionHTML, eventDataWrapper.attributionHTML)
				&& Objects.equals(this.data, eventDataWrapper.data) && Objects.equals(this.etag, eventDataWrapper.etag);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, status, copyright, attributionText, attributionHTML, data, etag);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EventDataWrapper {\n");

		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    copyright: ").append(toIndentedString(copyright)).append("\n");
		sb.append("    attributionText: ").append(toIndentedString(attributionText)).append("\n");
		sb.append("    attributionHTML: ").append(toIndentedString(attributionHTML)).append("\n");
		sb.append("    data: ").append(toIndentedString(data)).append("\n");
		sb.append("    etag: ").append(toIndentedString(etag)).append("\n");
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
