package com.carelon.rates.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PC_RATES")
@NamedQueries({ @NamedQuery(name="Rates.view",query="from EntityRates"),
@NamedQuery(name="Rates.update",query="update EntityRates r set r.male = :male, r.female = :female where r.age=:age")})
public class EntityRates {
	@Id
	@Column(name = "AGE")
	@GeneratedValue
	private String age;
	@Column(name = "MALE")
	private int male;
	@Column(name = "FEMALE")
	private int female;
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getMale() {
		return male;
	}
	public void setMale(int male) {
		this.male = male;
	}
	public int getFemale() {
		return female;
	}
	public void setFemale(int female) {
		this.female = female;
	}
	@Override
	public String toString() {
		return "EntityRates [age=" + age + ", male=" + male + ", female=" + female + "]";
	}
	

}