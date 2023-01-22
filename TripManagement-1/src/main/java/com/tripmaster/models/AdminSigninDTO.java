package com.tripmaster.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class AdminSigninDTO {
	
	private String adminName;
	private String email;
	private String mobile;
	private String password;
	public AdminSigninDTO(String adminName, String password, String mobile, String email) {
		super();
		this.adminName = adminName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}
	public AdminSigninDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
