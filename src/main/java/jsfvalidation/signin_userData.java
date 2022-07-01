package jsfvalidation;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.*;

@ManagedBean(name="signin_user",eager=true)

public class signin_userData {

	@Size(min=1)
    String name;
	
	@NotNull
	String emailaddress;
	
	@Min(18)
	@Max(30)
	int age;
	
	@Size(min=10,max=10)
	String mobileno;
	
	@NotNull
	@Size(min=8)
	String password;
	
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
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	public void setEmail(String email) {
		this.emailaddress=email;
	}
	public String getEmail() {
		return emailaddress;
	}
}
