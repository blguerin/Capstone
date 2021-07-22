package com.algonquin.drawntoyou.images;

import java.util.UUID;

public class ProfilePic {
    
    private String username;
    private String source;
       
    public ProfilePic() {}

    public ProfilePic(String username, String source) {
        this.username = username;
        this.source = source;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
