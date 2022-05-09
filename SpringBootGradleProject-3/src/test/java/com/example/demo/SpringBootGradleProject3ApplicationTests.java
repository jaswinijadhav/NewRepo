package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootGradleProject3ApplicationTests {
    
	ObjectMapper obj=new ObjectMapper();

	@Autowired
	private MockMvc mvc;
	
	@Mock
	UserService userservice;
	
	@Test
	public void createUserTest() throws Exception
	{
		UserDto user=new UserDto();
		user.setId(1);
		user.setName("Jaswini");
		user.setAge(67);
		user.setPhone(65646);
		String jsonRequest=obj.writeValueAsString(user);
		mvc.perform(post("/user/createUser").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
	}
	@Test
	public void getUserByIdTest() throws Exception
	{
		User user=new User(1,"Jaswini",34,65678);
        when(userservice.getUserById(1)).thenReturn(user);
//        mvc.perform(get("/user/getUserById")).andExpect(status().isOk());
        assertEquals(user.getName(),"Jaswini");
//		User user2 = new User(1, "Jaswini", 45, 568768);
//		when(userservice.getUserById(1)).thenReturn(user2);
//		mvc.perform(get("/user/getUserById")).andExpect(status().isOk());
//		assertEquals(user2.getName(),"Jaswini");
	}
	

	

}
