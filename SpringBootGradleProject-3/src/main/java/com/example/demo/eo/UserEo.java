package com.example.demo.eo;

import com.example.demo.dto.UserDto;

public interface UserEo {
public UserDto getUserById(int id);
	
	
public UserDto createUser(UserDto user);
	
public boolean isUserExist(int id);

}
