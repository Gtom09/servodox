package com.carelon.account.dao;

import com.carelon.account.entity.User;

public interface UserDAO {
	public String registerUser(User user);
	public User authenticateUser(String username);
  	public User findByUsername(String username);

}
