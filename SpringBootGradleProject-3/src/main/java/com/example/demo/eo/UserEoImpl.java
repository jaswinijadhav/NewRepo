package com.example.demo.eo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;



@Component
public class UserEoImpl implements UserEo{
	Logger logger = LoggerFactory.getLogger(UserEoImpl.class);

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserMapper userMapper;
	@Override
	public UserDto getUserById(int id) {
		logger.info("Getting By Id from EO");
		return userDao.getById(id);
	}
	@Override
	public UserDto createUser(UserDto user) {
		logger.info("Adding From EO");
		return userDao.save(user);
	}
    @Override
    public boolean isUserExist(int id)
    {
    	return userDao.existsById(id);
    }

}
