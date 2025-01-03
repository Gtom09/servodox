package com.carelon.policy.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "categoryName", "male", "female" })
public class Category {

	private int catId;

	@JsonProperty("categoryName")
	private String categoryName;

	@JsonProperty("male")
	private String male;

	@JsonProperty("female")
	private String female;

	@JsonProperty("categoryName")
	public String getCategoryName() {
		return categoryName;
	}

	@JsonProperty("categoryName")
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@JsonProperty("male")
	public String getMale() {
		return male;
	}

	@JsonProperty("male")
	public void setMale(String male) {
		this.male = male;
	}

	@JsonProperty("female")
	public String getFemale() {
		return female;
	}

	@JsonProperty("female")
	public void setFemale(String female) {
		this.female = female;
	}

}
