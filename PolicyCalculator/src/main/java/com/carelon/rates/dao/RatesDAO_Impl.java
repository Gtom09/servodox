package com.carelon.rates.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carelon.rates.entity.EntityRates;

@Repository("RatesDAO")
public class RatesDAO_Impl implements RatesDAO {
	@Autowired
	private SessionFactory sessionfactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionfactory = sf;
	}

	@Override
	public List<EntityRates> getRatesData() {
		Session session = sessionfactory.getCurrentSession();

		return session.getNamedQuery("Rates.view").list();
	}

	@Override
	public String updateRatesData(String age, int ratesMaleNo, int ratesFemaleNo) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.getCurrentSession();

		int response = session.getNamedQuery("Rates.update").setString("age", age).setInteger("male", ratesMaleNo)
				.setInteger("female", ratesFemaleNo).executeUpdate();
		return response == 1 ? "success" : "failure";

	}
}
