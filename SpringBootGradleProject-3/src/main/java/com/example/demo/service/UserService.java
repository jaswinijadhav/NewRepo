package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

	public User getUserById(int id);

	public User createUser(User user);

	public boolean isUserExist(int id);

}
