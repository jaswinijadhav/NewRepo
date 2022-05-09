package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;


@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
	
	UserDto convertToDto(User user);
	User convertToEntity(UserDto userDto);
	List<UserDto> toDtoList(List<User> users);
	List<User> fromDtoList(List<UserDto> usersDto);
	

}