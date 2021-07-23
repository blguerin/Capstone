package com.algonquin.drawntoyou.user;

public class User {
    
	private String username;
	private String email;
	private String password;
	private String code;
	
	public User() {}
	
	public User(String username, String email, String password, String code) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.code = code;
    }
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	// Gets n Sets
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCode() {
		return code;
	}
}
