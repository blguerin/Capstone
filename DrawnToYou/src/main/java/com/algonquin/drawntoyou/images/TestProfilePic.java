package com.algonquin.drawntoyou.images;

import java.util.Date;
import java.util.UUID;

public class TestProfilePic {
    
    private UUID profilePhotoID = UUID.randomUUID();
    private String hostLink = "placeholder";
    private String modelUsername = "Graham";
    private Date submissionDate = new Date();
    
    // Gs and Ss
    public UUID getProfilePhotoID() {
        return profilePhotoID;
    }
    public void setProfilePhotoID(UUID profilePhotoID) {
        this.profilePhotoID = profilePhotoID;
    }
    public String getHostLink() {
        return hostLink;
    }
    public void setHostLink(String hostLink) {
        this.hostLink = hostLink;
    }
    public String getModelUsername() {
        return modelUsername;
    }
    public void setModelUsername(String modelUsername) {
        this.modelUsername = modelUsername;
    }
    public Date getSubmissionDate() {
        return submissionDate;
    }
    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }
    
    

}
