package com.algonquin.drawntoyou.images;

import java.util.Date;
import java.util.UUID;

public class TestProfilePic {
    
    private UUID profilePhotoID = UUID.randomUUID();
    private String source = "https://picsum.photos/250";
    private String user = "Graham";
    private Date submissionDate = new Date();
    
    // Gets n Sets
    public UUID getProfilePhotoID() {
        return profilePhotoID;
    }
    public void setProfilePhotoID(UUID profilePhotoID) {
        this.profilePhotoID = profilePhotoID;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public Date getSubmissionDate() {
        return submissionDate;
    }
    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }
   
}
