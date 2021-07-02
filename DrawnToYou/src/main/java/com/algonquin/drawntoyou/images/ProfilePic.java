package com.algonquin.drawntoyou.images;

import java.util.Date;
import java.util.UUID;

public class ProfilePic {
    
    private UUID profilePhotoID;
    private String hostLink;
    private String modelUsername;
    private Date submissionDate;
    
    public ProfilePic(UUID profilePhotoID, String hostLink, String modelUsername, Date submissionDate) {
        this.profilePhotoID = UUID.randomUUID();
        this.hostLink = hostLink;
        this.modelUsername = modelUsername;
        this.submissionDate = new Date();
    }

    // Getters n Setters
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
