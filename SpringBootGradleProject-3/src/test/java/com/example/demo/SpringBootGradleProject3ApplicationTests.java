package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.dto.UserDto;
import com.example.demo.eo.UserEo;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootGradleProject3ApplicationTests {

	ObjectMapper obj = new ObjectMapper();

	@Autowired
	private MockMvc mvc;

	@MockBean
	UserEo userEo;

	@Test
	public void createUserTest() throws Exception {
		UserDto user = new UserDto();
		user.setId(1);
		user.setName("Jaswini");
		user.setAge(67);
		user.setPhone(65646);

		String jsonRequest = obj.writeValueAsString(user);
		when(userEo.createUser(any())).thenReturn(user);
		mvc.perform(post("/user/createUser").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
	}

	@Test
	public void getUserByIdTest() throws Exception {
		UserDto user = new UserDto(1, "Jaswini", 34, 65678);
		when(userEo.getUserById(1)).thenReturn(user);
		mvc.perform(get("http://localhost:8081/user/getById/1")).andExpect(status().isOk());
		assertEquals("Jaswini", user.getName());

	}

	@Test
	public void healthcheck() throws Exception {
		boolean isUserExist = userEo.isUserExist(1);
		when(userEo.isUserExist(1)).thenReturn(true);
		mvc.perform(get("/user/getById/1")).andExpect(status().isOk());
		assertEquals(false, isUserExist);

	}

//	@Test
//	public void healthcheck() throws Exception {
//		boolean isUserExist = userEo.isUserExist(1);
//		when(userEo.isUserExist(1)).thenReturn(true);
//		UserDto user = new UserDto(1, "Jaswini", 34, 65678);
//		when(userEo.isUserExist(1)).thenReturn(true);
//		mvc.perform(get("/health/1")).andExpect(status().isOk()).andExpect(content().string("true"));
//		assertEquals(false, isUserExist);
//
//	}

}
