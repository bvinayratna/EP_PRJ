package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.entity.user;

@Stateless
public class userManager implements userRemote {
	
	@Override
	public String saveData(user user) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EP_PROJECT","root","vinAy@2003");
		PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?,?);");
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setInt(3, user.getAge());
		ps.setLong(4, user.getMobileno ());
		ps.setString(5, user.getPassword());
		
		ps.execute();
		con.close();
		return "data saved successfully";
	}

	@Override
	public List<user> getData() throws Exception {
		// TODO Auto-generated method stub
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EP_PROJECT","root","vinAy@2003");
		PreparedStatement ps=con.prepareStatement("select * from user;");
		ResultSet rs =ps.executeQuery();
		List<user> L= new ArrayList<user>();
		while(rs.next()) {
			user user =new user();
			user.setName(rs.getString(1));
			user.setEmail(rs.getString(2));
			user.setAge(rs.getInt(3));
			user.setMobileno(rs.getLong(4));
			user.setPassword(rs.getString(5));
			
			L.add(user);
			}
		con.close();
		
		return L;
	}
		

}
