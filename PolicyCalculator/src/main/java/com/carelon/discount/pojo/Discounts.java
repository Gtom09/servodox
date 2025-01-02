package com.carelon.discount.pojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Discounts {
	@JsonProperty("discounts")

	private List<Discount> discounts = new ArrayList<>();

	public void setEmployees(List<Discount> discounts) {
		this.discounts = discounts;
	}
}