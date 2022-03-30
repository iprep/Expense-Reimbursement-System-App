package com.training.dao;

import java.util.List;

import com.training.model.User;

public interface LoginDAO {
	public boolean register(User user);
	public boolean validate(String username,String password);
	public List<User> getUsers();
	public List<User> getUsersByUsername(String username);

}