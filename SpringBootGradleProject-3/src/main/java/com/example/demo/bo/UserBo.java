package com.example.demo.bo;

import com.example.demo.dto.UserDto;

public interface UserBo {
	public UserDto getUserById(int id);

	public UserDto createUser(UserDto user);

	public boolean isUserExist(int id);

}
