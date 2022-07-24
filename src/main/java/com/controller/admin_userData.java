package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.entity.user;
import com.model.userRemote;

@ManagedBean(name="admin_user",eager=true)
public class admin_userData {
	String email, password, name;
	List<user> list;
	String response;
	int age;
	Long mobileno;
	
	@EJB(lookup="java:global/EP_PROJECT/userManager!com.model.userRemote")
	userRemote UR;
	
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
	
	public String login() {
		String res="";
		try {
			String query = "SELECT * FROM admin_users;";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ep_project","root","root");
			System.out.println("Connection Success");
			//STATEMENT TO EXECUTE CONNECTION
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			System.out.println("Result set success");
			while(rs.next()) {
				if(email.equals(rs.getString(2))) {
					if(password.equals(rs.getString(5))) {
						res="admin_response";
						name=rs.getString(1);
						break;
					}
					else {
						 res="admin_login";
					}
				}
				else {
					res="signup";
				}
			}
		}
		catch(Exception E) {
			System.out.println(E);
		}
		return res;
	}
	
	public List<user> getList() {
		{
			try {
				list= UR.getAdminData();
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
	
	public void save() {
		try {
			user user = new user();
			user.setName(name);
			user.setEmail(email);
			user.setAge(age);
			user.setMobileno(mobileno);
			user.setPassword(password);
			
			response = UR.saveAdminData(user);
		}
		catch(Exception e) {
			response=e.getMessage();
		}
	}
	

}
