package com.carelon.rates.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
	"age",
    "ratesMaleNo",
    "ratesFemaleNo"
})
public class Rate {
	
		@JsonProperty("age")
	    private String age;
		
		@JsonProperty("ratesMaleNo")
		private int ratesMaleNo;

		@JsonProperty("ratesFemaleNo")
		private int ratesFemaleNo;

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public int getRatesMaleNo() {
			return ratesMaleNo;
		}

		public void setRatesMaleNo(int ratesMaleNo) {
			this.ratesMaleNo = ratesMaleNo;
		}

		public int getRatesFemaleNo() {
			return ratesFemaleNo;
		}

		public void setRatesFemaleNo(int ratesFemaleNo) {
			this.ratesFemaleNo = ratesFemaleNo;
		}

		
		

}
