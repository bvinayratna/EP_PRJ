package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.*;

import com.model.userRemote;
import com.entity.user;

@ManagedBean(name="signin_user",eager=true)

public class userData {

	//@Size(min=1)
    static String name;
	//@NotNull
	static String email;
	//@Min(18)
	//@Max(30)
	static int age;
	//@Size(min=10,max=10)
	static Long mobileno;
	//@NotNull
	//@Size(min=8)
	static String password;
	List<user> list;
	String response;
	
	@EJB(lookup="java:global/EP_PROJECT/userManager!com.model.userRemote")
	userRemote UR;
	public void save() {
		try {
			user user = new user();
			user.setName(name);
			user.setEmail(email);
			user.setAge(age);
			user.setMobileno(mobileno);
			user.setPassword(password);
			
			response = UR.saveData(user);
		}
		catch(Exception e) {
			response=e.getMessage();
		}
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
	public Long getMobileno() {
		return mobileno;
	}
	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public String getEmail() {
		return email;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	public List<user> getList() {
		{
			try {
				list= UR.getData();
				System.out.println(list);
			}catch(Exception e)
			{
				response = e.getMessage();
				System.out.println(response);
			}
		}
		return list;
	}
	public void setList(List<user> list) {
		this.list = list;
	}
	
}
