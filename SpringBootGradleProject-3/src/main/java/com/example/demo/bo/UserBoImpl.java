package com.example.demo.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.UserDto;
import com.example.demo.eo.UserEo;

@Component
public class UserBoImpl implements UserBo {

	@Autowired
	private UserEo userEo;

	Logger logger = LoggerFactory.getLogger(UserBoImpl.class);

	@Override
	public UserDto getUserById(int id) {
		logger.info("Getting User By Id from BO");
		return userEo.getUserById(id);
	}

	@Override
	public UserDto createUser(UserDto user) {
		logger.info("Adding the user from BO");
		return userEo.createUser(user);
	}

	@Override
	public boolean isUserExist(int id) {
		return userEo.isUserExist(id);
	}

}
