package com.carelon.discount.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carelon.discount.dao.DiscountDAO;
import com.carelon.discount.entity.Discount;
import com.carelon.discount.pojo.Discounts;

@Service
public class DiscountService {

	@Autowired
	DiscountDAO discountDao;

	@Transactional
	public Discounts getEmployeeData() {
		List<Discount> disList = discountDao.getDiscountData();
		List<com.carelon.discount.pojo.Discount> list = new ArrayList<>();
		com.carelon.discount.pojo.Discount emp = null;
		for (Discount e : disList) {
			emp = new com.carelon.discount.pojo.Discount();
			emp.setSlab(e.getSlab());
			emp.setMaleNo(e.getMaleNo());
			emp.setFemaleNo(e.getFemaleNo());
			list.add(emp);
		}

		Discounts dl = new Discounts();
		dl.setEmployees(list);

		return dl;
	}

	@Transactional
	public String updateDiscountsData(String slab, int maleNo, int femaleNo) {
		String message = discountDao.updateDiscountsData(slab, maleNo, femaleNo);
		return message;
	}

}
