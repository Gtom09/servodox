package com.carelon.discount.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "slab", "maleNo", "femaleNo" })
public class Discount {

	@JsonProperty("slab")
	private String slab;

	@JsonProperty("maleNo")
	private int maleNo;

	@JsonProperty("femaleNo")
	private int femaleNo;

	public String getSlab() {
		return slab;
	}

	public void setSlab(String slab) {
		this.slab = slab;
	}

	public int getMaleNo() {
		return maleNo;
	}

	public void setMaleNo(int maleNo) {
		this.maleNo = maleNo;
	}

	public int getFemaleNo() {
		return femaleNo;
	}

	public void setFemaleNo(int femaleNo) {
		this.femaleNo = femaleNo;
	}

}
