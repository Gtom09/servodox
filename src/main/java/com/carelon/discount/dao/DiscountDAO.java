package com.carelon.discount.dao;

import java.util.List;

import com.carelon.discount.entity.Discount;

public interface DiscountDAO {
	public List<Discount> getDiscountData();
	
	public String updateDiscountsData(String slab, int maleNo, int femaleNo);
	
}
