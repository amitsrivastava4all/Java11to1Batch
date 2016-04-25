package com.brainmentors.ims.user.dto;

import java.util.List;

public class User {
	private String userid;
	private String password;
	private String role;
	private List<UserRights> rights;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<UserRights> getRights() {
		return rights;
	}
	public void setRights(List<UserRights> rights) {
		this.rights = rights;
	}
	
}
