package com.niit.DAO;

import com.niit.Model.User;

public interface UserDAO {

	public boolean registerUser(User user);
	public boolean updateUser(User user);
	public User getUser(String username);
}
