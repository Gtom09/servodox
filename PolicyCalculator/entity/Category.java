package com.carelon.policy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

 

@Entity
@Table(name = "PC_CATEGORIES")
@NamedQueries({ @NamedQuery(name = "Category.view", query = "from Category") })
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CATEGORY_ID")
	private int catId;

 

	@Column(name = "SCHEME_NUMBER")
	private String schemeNumber;

	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	@Column(name = "MALE")
	private String male;

	@Column(name = "FEMALE")
	private String female;

 

	public String getCategoryName() {
		return categoryName;
	}

 

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

 

	public String getSchemeNumber() {
		return schemeNumber;
	}

 

	public void setSchemeNumber(String schemeNumber) {
		this.schemeNumber = schemeNumber;
	}

 

	public String getMale() {
		return male;
	}

 

	public void setMale(String male) {
		this.male = male;
	}

 

	public String getFemale() {
		return female;
	}

 

	public void setFemale(String female) {
		this.female = female;
	}

 

	public int getCatId() {
		return catId;
	}

 

	public void setCatId(int catId) {
		this.catId = catId;
	}

 

}
