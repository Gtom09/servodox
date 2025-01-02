package com.carelon.rates.pojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rates {
	@JsonProperty("rates")
	private List<Rate> rates = new ArrayList<>();
 
	public List<Rate> getRates() {
		return rates;
	}
 
	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

}
