package com.algonquin.drawntoyou.images;

import java.util.Date;
import java.util.UUID;

public class ProfilePic {
    
    private UUID imageID;
    private String sourceLink;
    private String submitterUsername;
//    private Date submissionDate; //Ignoring Date for now
    
    public ProfilePic() {
        
    }
    
    public ProfilePic(UUID imageID, String sourceLink, String submitterUsername, Date submissionDate) {
        this.imageID = UUID.randomUUID();
        this.sourceLink = sourceLink;
        this.submitterUsername = submitterUsername;
//        this.submissionDate = new Date();
    }

    // Getters n Setters
    public UUID getImageID() {
        return imageID;
    }

    public void setImageID(UUID imageID) {
        this.imageID = imageID;
    }

    public String getSourceLink() {
        return sourceLink;
    }

    public void setSourceLink(String sourceLink) {
        this.sourceLink = sourceLink;
    }

    public String getSubmitterUsername() {
        return submitterUsername;
    }

    public void setSubmitterUsername(String submitterUsername) {
        this.submitterUsername = submitterUsername;
    }

//    public Date getSubmissionDate() {
//        return submissionDate;
//    }
//
//    public void setSubmissionDate(Date submissionDate) {
//        this.submissionDate = submissionDate;
//    }  
    
    

}
