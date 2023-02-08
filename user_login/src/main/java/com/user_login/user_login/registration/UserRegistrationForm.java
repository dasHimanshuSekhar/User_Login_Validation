package com.user_login.user_login.registration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "registration_table")
public class UserRegistrationForm {
	
	@Column(name = "Name")
	private String name;
	
	@Id
	@Column(name = "Email_Id")
	private String emailId;
	
	@Column(name = "Password")
	private String password;
	
	public UserRegistrationForm() {}
	
	public UserRegistrationForm(String name, String emailId, String password) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public String getEmailId() {
		return emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
