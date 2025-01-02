package com.carelon.discount.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PC_DISCOUNTS")
@NamedQueries({ @NamedQuery(name = "Discount.view", query = "from Discount"),
		@NamedQuery(name = "Discount.update", query = "update Discount e set e.maleNo = :maleNo, e.femaleNo = :femaleNo where e.slab= :slab") })
public class Discount {

	@Id
	@Column(name = "SLAB")
	private String slab;

	@Column(name = "MALE")
	private int maleNo;

	@Column(name = "FEMALE")
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
