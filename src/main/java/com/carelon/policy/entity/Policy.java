package com.carelon.policy.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PC_POLICIES")
@NamedQueries({ @NamedQuery(name = "Policy.view", query = "from Policy"),
@NamedQuery(name = "Policy.get", query = "from Policy p where p.schemeNumber=:schemeNumber") })

public class Policy {

	@Id

	@Column(name = "SCHEME_NUMBER")

	private String schemeNumber;

	@Column(name = "SCHEME_NAME")

	private String schemeName;

	@Column(name = "EFFECTIVE_DATE")

	private String effectiveDate;

	@Column(name = "ANNIVERSARY")

	private String anniversary;

	@Column(name = "BUSINESS_SOURCE")

	private String businessSource;

	@Column(name = "TAX_ID")

	private String taxID;

	@Column(name = "COUNTY")

	private String county;

	@Column(name = "EMPLOYER_CONTACT_INFO")

	private String employerContactInfo;

	@Column(name = "ADDRESS_1")

	private String address1;

	@Column(name = "ADDRESS_2")

	private String address2;

	@Column(name = "ADDRESS_3")

	private String address3;

	@Column(name = "CITY")

	private String city;

	@Column(name = "STATE")

	private String state;

	@Column(name = "ZIP")

	private String zip;

	@Column(name = "EMPLOYER_PHONE")

	private String employerPhone;

	@Column(name = "EMPLOYER_EXT")

	private String employerExt;

	@Column(name = "EMPLOYER_FAX")

	private String employerFax;

	@Column(name = "PREMIUM")

	private float premium;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "SCHEME_NUMBER")
	private List<Category> categories;

	public String getSchemeNumber() {

		return schemeNumber;

	}

	public void setSchemeNumber(String schemeNumber) {

		this.schemeNumber = schemeNumber;

	}

	public String getSchemeName() {

		return schemeName;

	}

	public void setSchemeName(String schemeName) {

		this.schemeName = schemeName;

	}

	public String getEffectiveDate() {

		return effectiveDate;

	}

	public void setEffectiveDate(String effectiveDate) {

		this.effectiveDate = effectiveDate;

	}

	public String getAnniversary() {

		return anniversary;

	}

	public void setAnniversary(String anniversary) {

		this.anniversary = anniversary;

	}

	public String getBusinessSource() {

		return businessSource;

	}

	public void setBusinessSource(String businessSource) {

		this.businessSource = businessSource;

	}

	public String getTaxID() {

		return taxID;

	}

	public void setTaxID(String taxID) {

		this.taxID = taxID;

	}

	public String getCounty() {

		return county;

	}

	public void setCounty(String county) {

		this.county = county;

	}

	public String getEmployerContactInfo() {

		return employerContactInfo;

	}

	public void setEmployerContactInfo(String employerContactInfo) {

		this.employerContactInfo = employerContactInfo;

	}

	public String getAddress1() {

		return address1;

	}

	public void setAddress1(String address1) {

		this.address1 = address1;

	}

	public String getAddress2() {

		return address2;

	}

	public void setAddress2(String address2) {

		this.address2 = address2;

	}

	public String getAddress3() {

		return address3;

	}

	public void setAddress3(String address3) {

		this.address3 = address3;

	}

	public String getCity() {

		return city;

	}

	public void setCity(String city) {

		this.city = city;

	}

	public String getState() {

		return state;

	}

	public void setState(String state) {

		this.state = state;

	}

	public String getZip() {

		return zip;

	}

	public void setZip(String zip) {

		this.zip = zip;

	}

	public String getEmployerPhone() {

		return employerPhone;

	}

	public void setEmployerPhone(String employerPhone) {

		this.employerPhone = employerPhone;

	}

	public String getEmployerExt() {

		return employerExt;

	}

	public void setEmployerExt(String employerExt) {

		this.employerExt = employerExt;

	}

	public String getEmployerFax() {

		return employerFax;

	}

	public void setEmployerFax(String employerFax) {

		this.employerFax = employerFax;

	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public float getPremium() {
		return premium;
	}

	public void setPremium(float premium) {
		this.premium = premium;
	}

}
