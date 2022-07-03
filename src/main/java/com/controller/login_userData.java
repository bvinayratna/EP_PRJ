package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="login_user",eager=true)
public class login_userData {
	String email, password,name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public String login() {
		String response="";
		try {
			String query = "SELECT * FROM user;";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ep_project","root","vinAy@2003");
			
			//STATEMENT TO EXECUTE CONNECTION
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				if(email.equals(rs.getString(2))) {
					if(password.equals(rs.getString(5))) {
						response="response";
						name=rs.getString(1);
						break;
					}
					else {
						 response="login";
					}
				}
				else {
					response="signup";
				}
			}
		}
		catch(Exception E) {
			System.out.println(E);
		}
		return response;
	}

}
