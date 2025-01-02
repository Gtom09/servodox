package com.carelon.policy.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "schemeName", "schemeNumber", "effectiveDate", "anniversary", "businessSource", "taxID", "county",
		"employerContactInfo", "address1", "address2", "address3", "city", "state", "zip", "employerPhone",
		"employerExt", "employerFax", "categories", "premium"})

public class Policy {

	@JsonProperty("schemeName")
	private String schemeName;
	@JsonProperty("schemeNumber")
	private String schemeNumber;
	@JsonProperty("effectiveDate")
	private String effectiveDate;
	@JsonProperty("anniversary")
	private String anniversary;
	@JsonProperty("businessSource")
	private String businessSource;
	@JsonProperty("taxID")
	private String taxID;
	@JsonProperty("county")
	private String county;
	@JsonProperty("employerContactInfo")
	private String employerContactInfo;
	@JsonProperty("address1")
	private String address1;
	@JsonProperty("address2")
	private String address2;
	@JsonProperty("address3")
	private String address3;
	@JsonProperty("city")
	private String city;
	@JsonProperty("state")
	private String state;
	@JsonProperty("zip")
	private String zip;
	@JsonProperty("employerPhone")
	private String employerPhone;
	@JsonProperty("employerExt")
	private String employerExt;
	@JsonProperty("employerFax")
	private String employerFax;
	@JsonProperty("premium")
	private float premium;
	

 

	@JsonProperty("schemeName")
	public String getSchemeName() {
		return schemeName;
	}

 

	@JsonProperty("schemeName")
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

 

	@JsonProperty("schemeNumber")
	public String getSchemeNumber() {
		return schemeNumber;
	}

 

	@JsonProperty("schemeNumber")
	public void setSchemeNumber(String schemeNumber) {
		this.schemeNumber = schemeNumber;
	}

 

	@JsonProperty("effectiveDate")
	public String getEffectiveDate() {
		return effectiveDate;
	}

 

	@JsonProperty("effectiveDate")
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

 

	@JsonProperty("anniversary")
	public String getAnniversary() {
		return anniversary;
	}

 

	@JsonProperty("anniversary")
	public void setAnniversary(String anniversary) {
		this.anniversary = anniversary;
	}

 

	@JsonProperty("businessSource")
	public String getBusinessSource() {
		return businessSource;
	}

 

	@JsonProperty("businessSource")
	public void setBusinessSource(String businessSource) {
		this.businessSource = businessSource;
	}

 

	@JsonProperty("taxID")
	public String getTaxID() {
		return taxID;
	}

 

	@JsonProperty("taxID")
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

 

	@JsonProperty("county")
	public String getCounty() {
		return county;
	}

 

	@JsonProperty("county")
	public void setCounty(String county) {
		this.county = county;
	}

 

	@JsonProperty("employerContactInfo")
	public String getEmployerContactInfo() {
		return employerContactInfo;
	}

 

	@JsonProperty("employerContactInfo")
	public void setEmployerContactInfo(String employerContactInfo) {
		this.employerContactInfo = employerContactInfo;
	}

 

	@JsonProperty("address1")
	public String getAddress1() {
		return address1;
	}

 

	@JsonProperty("address1")
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

 

	@JsonProperty("address2")
	public String getAddress2() {
		return address2;
	}

 

	@JsonProperty("address2")
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

 

	@JsonProperty("address3")
	public String getAddress3() {
		return address3;
	}

 

	@JsonProperty("address3")
	public void setAddress3(String address3) {
		this.address3 = address3;
	}

 

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

 

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

 

	@JsonProperty("state")
	public String getState() {
		return state;
	}

 

	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
	}

 

	@JsonProperty("zip")
	public String getZip() {
		return zip;
	}

 

	@JsonProperty("zip")
	public void setZip(String zip) {
		this.zip = zip;
	}

 

	@JsonProperty("employerPhone")
	public String getEmployerPhone() {
		return employerPhone;
	}

 

	@JsonProperty("employerPhone")
	public void setEmployerPhone(String employerPhone) {
		this.employerPhone = employerPhone;
	}

 

	@JsonProperty("employerExt")
	public String getEmployerExt() {
		return employerExt;
	}

 

	@JsonProperty("employerExt")
	public void setEmployerExt(String employerExt) {
		this.employerExt = employerExt;
	}

 

	@JsonProperty("employerFax")
	public String getEmployerFax() {
		return employerFax;
	}

 

	@JsonProperty("employerFax")
	public void setEmployerFax(String employerFax) {
		this.employerFax = employerFax;
	}
	
	@JsonProperty("categories")
	private List<Category> categories;

 

	@JsonProperty("categories")
	public List<Category> getCategories() {
		return categories;
	}

 

	@JsonProperty("categories")
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

 
	@JsonProperty("premium")
	public float getPremium() {
		return premium;
	}

	@JsonProperty("premium")
	public void setPremium(float premium) {
		this.premium = premium;
	}
	
 

}

 

