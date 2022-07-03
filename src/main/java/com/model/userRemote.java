package com.model;

import java.util.List;

import javax.ejb.Remote;
import com.entity.user;

@Remote
public interface userRemote {

	public String saveData(user user) throws Exception;
	public String saveAdminData(user user) throws Exception;
	public List<user> getData() throws Exception;
	public List<user> getAdminData() throws Exception;
	
}
