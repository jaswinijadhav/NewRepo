package com.example.demo.entity;

import javax.persistence.Id;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;


import org.springframework.validation.annotation.Validated;

@Validated
public class User {
	
	@NotNull
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private long phone;
	
	public User() {
		super();
	}
	
	public User(int id, String name, int age, long phone) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
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

