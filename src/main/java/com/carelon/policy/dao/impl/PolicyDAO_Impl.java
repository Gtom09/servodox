package com.carelon.policy.dao.impl;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.carelon.policy.dao.PolicyDAO;

import com.carelon.policy.entity.Policy;

@Repository

public class PolicyDAO_Impl implements PolicyDAO {

	@Autowired

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {

		this.sessionFactory = sf;

	}

	@Override

	public String savePolicyData(Policy p) {

		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(p);

		return "success";

	}

	public Policy getPolicy(String schemeNumber) {
		Session session = sessionFactory.getCurrentSession();
		//List<Object> list = session.getNamedQuery("Policy.get").setString("schemeNumber", schemeNumber).list();
		Policy policy = session.get(Policy.class, schemeNumber);
		return policy;
	}
	

}

