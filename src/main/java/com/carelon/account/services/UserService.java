package com.carelon.account.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carelon.account.dao.UserDAO;
import com.carelon.account.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDao;
	

	@Transactional
	public String registerUser(com.carelon.account.pojo.User user) {
		User userExist = userDao.authenticateUser(user.getUsername());
		if(userExist==null){
			com.carelon.account.entity.User userEntity = new com.carelon.account.entity.User();
			userEntity.setUsername(user.getUsername());
			userEntity.setPassword(user.getPassword());
			userEntity.setType("agent");
			return userDao.registerUser(userEntity);
		}
		return "duplicate";
	}
	
	@Transactional
	public String loginUser(String username, String password) {
		User user = userDao.authenticateUser(username);
		if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)){
			return user.getType();
		}
		return "failure";
	}
	
//	@Transactional
//	public boolean userExist(String username) {
//		User user = userDao.findByUsername(username);
//		if(user != null) {
//			System.out.println(user);
//			return true;
//		} else {
//			return false;
//		}
//	}
}


