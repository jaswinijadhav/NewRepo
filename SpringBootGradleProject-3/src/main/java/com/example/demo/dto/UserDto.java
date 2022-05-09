package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;


//@Validated
@Entity
public class UserDto {

//    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message="Name Should not be null")
	private String name;
	//@Min(value=10,message="Age must be greater than 10")
	private int age;
	private long phone;
	
	public UserDto() {
		super();
	}
	
	public UserDto(int id, String name, int age, long phone) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone= phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + "]";
	}
	
}
