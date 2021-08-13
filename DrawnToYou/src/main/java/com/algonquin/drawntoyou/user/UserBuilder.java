package com.algonquin.drawntoyou.user;

public class UserBuilder {
    private String username = "";
    private String email = "";
    private String password = "";
    
    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }
    
    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }
    
    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }
    
    public User createUser() {
        return new User(username, email, password);
    }
}
