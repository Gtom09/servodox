package com.carelon.account.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carelon.account.dao.UserDAO;
import com.carelon.account.entity.User;

@Repository("UserDao")
public class UserDAO_Impl implements UserDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public String registerUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return "Success";
	}

	@Override
	public User authenticateUser(String username) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Query<User> query = session.createNamedQuery("LoginUser.authenticate", User.class);
			query.setParameter("username", username);

			User loginUser = query.uniqueResult();
			return loginUser;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
  
    @Override
      public User findByUsername(String username) {
          Session session = sessionFactory.getCurrentSession();
          try {
              Query<User> query = session.createNamedQuery("LoginUser.authenticate", User.class);
              query.setParameter("username", username);

              User loginUser = query.uniqueResult();
              return loginUser;
          } catch (Exception e) {
              e.printStackTrace();
              return null;
          }
      }
}
