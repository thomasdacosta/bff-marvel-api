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
 * CreatorList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-11T22:48:12.266406300-03:00[America/Sao_Paulo]")

public class CreatorList {
	@JsonProperty("available")
	private BigDecimal available = null;

	@JsonProperty("returned")
	private BigDecimal returned = null;

	@JsonProperty("collectionURI")
	private String collectionURI = null;

	@JsonProperty("items")
	@Valid
	private List<CreatorSummary> items = null;

	public CreatorList available(BigDecimal available) {
		this.available = available;
		return this;
	}

	/**
	 * The number of total available creators in this list. Will always be greater
	 * than or equal to the \"returned\" value.
	 * 
	 * @return available
	 **/
	@ApiModelProperty(value = "The number of total available creators in this list. Will always be greater than or equal to the \"returned\" value.")

	@Valid
	public BigDecimal getAvailable() {
		return available;
	}

	public void setAvailable(BigDecimal available) {
		this.available = available;
	}

	public CreatorList returned(BigDecimal returned) {
		this.returned = returned;
		return this;
	}

	/**
	 * The number of creators returned in this collection (up to 20).
	 * 
	 * @return returned
	 **/
	@ApiModelProperty(value = "The number of creators returned in this collection (up to 20).")

	@Valid
	public BigDecimal getReturned() {
		return returned;
	}

	public void setReturned(BigDecimal returned) {
		this.returned = returned;
	}

	public CreatorList collectionURI(String collectionURI) {
		this.collectionURI = collectionURI;
		return this;
	}

	/**
	 * The path to the full list of creators in this collection.
	 * 
	 * @return collectionURI
	 **/
	@ApiModelProperty(value = "The path to the full list of creators in this collection.")

	public String getCollectionURI() {
		return collectionURI;
	}

	public void setCollectionURI(String collectionURI) {
		this.collectionURI = collectionURI;
	}

	public CreatorList items(List<CreatorSummary> items) {
		this.items = items;
		return this;
	}

	public CreatorList addItemsItem(CreatorSummary itemsItem) {
		if (this.items == null) {
			this.items = new ArrayList<CreatorSummary>();
		}
		this.items.add(itemsItem);
		return this;
	}

	/**
	 * The list of returned creators in this collection.
	 * 
	 * @return items
	 **/
	@ApiModelProperty(value = "The list of returned creators in this collection.")
	@Valid
	public List<CreatorSummary> getItems() {
		return items;
	}

	public void setItems(List<CreatorSummary> items) {
		this.items = items;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CreatorList creatorList = (CreatorList) o;
		return Objects.equals(this.available, creatorList.available)
				&& Objects.equals(this.returned, creatorList.returned)
				&& Objects.equals(this.collectionURI, creatorList.collectionURI)
				&& Objects.equals(this.items, creatorList.items);
	}

	@Override
	public int hashCode() {
		return Objects.hash(available, returned, collectionURI, items);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CreatorList {\n");

		sb.append("    available: ").append(toIndentedString(available)).append("\n");
		sb.append("    returned: ").append(toIndentedString(returned)).append("\n");
		sb.append("    collectionURI: ").append(toIndentedString(collectionURI)).append("\n");
		sb.append("    items: ").append(toIndentedString(items)).append("\n");
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
