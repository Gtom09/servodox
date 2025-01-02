package com.carelon.discount.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carelon.discount.dao.DiscountDAO;
import com.carelon.discount.entity.Discount;

@Repository("DiscountDAO")
public class DiscountDAOImpl implements DiscountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Discount> getDiscountData() {
		Session session = sessionFactory.getCurrentSession();
		return session.getNamedQuery("Discount.view").list();
	}

	@Override
	public String updateDiscountsData(String slab, int maleNo, int femaleNo) {
		Session session = sessionFactory.getCurrentSession();
		int response = session.getNamedQuery("Discount.update").setString("slab", slab).setInteger("maleNo", maleNo)
				.setInteger("femaleNo", femaleNo).executeUpdate();
		return response == 1 ? "success" : "failure";
	}

}
