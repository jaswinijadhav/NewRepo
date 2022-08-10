package com.example.demo.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.bo.UserBo;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;


@Component
@Service
public class UserServiceImpl implements UserService {
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserBo userBo;
	
	@Autowired
	private UserMapper userMapper;

	

	@Override
	public User getUserById(int id) {
		logger.info("Getting user by id ");
		UserDto user = userBo.getUserById(id);
		return userMapper.convertToEntity(user);
	}

	@Override
	public User createUser(User user) {
		logger.info("User Added Sccessfully");
		UserDto adduser = userBo.createUser(userMapper.convertToDto(user));
		return userMapper.convertToEntity(adduser);
	}
    
	@Override
	public boolean isUserExist(int id)
	{
		return userBo.isUserExist(id);
	}






	
}
