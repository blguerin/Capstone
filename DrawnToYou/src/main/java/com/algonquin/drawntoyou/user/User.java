package com.algonquin.drawntoyou.user;

public class User {
    
//	private int id; // Not sure if this is needed, AUTO-INC'd in DB. Maybe UUID is better for some reason?
	private String username;
	private String email;
	private String password;
	private int verificationCode;
	private String verificationStatus; // This could be initially set to "unverified" maybe.
	
	public User(String username, String email, String password, int verificationCode, String verificationStatus) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.verificationCode = verificationCode;
        this.verificationStatus = verificationStatus;
    }
	
	// Gets&Sets
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

    public int getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(int verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

}
