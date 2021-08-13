package com.algonquin.drawntoyou.images;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.algonquin.drawntoyou.dao.ArtworkDAO;
import com.algonquin.drawntoyou.dao.ConnectDB;
import com.algonquin.drawntoyou.dao.ProfileDAO;
import com.algonquin.drawntoyou.dao.ProfilePicDAO;
import com.algonquin.drawntoyou.reels.InReel;
import com.algonquin.drawntoyou.reels.OutReel;

public class Profile {
       
    private String username;
    private String profilePicSource;
    private String pinnedPicSource; 
    private String pinnedPicID;
    private String bio;
    private InReel inReel;
    private OutReel outReel;
    
    public Profile() {}
    
    public Profile(String username) {
        this.username = username;  
        loadPage();
        this.inReel = new InReel(username);
        this.outReel = new OutReel(username);       
    }

    // Load a profile with settings saved in the database.
    private void loadPage() {
        ProfilePicDAO profilePicDAO = new ProfilePicDAO();
        if (profilePicDAO.readProfilePic(username) != null) {
            this.profilePicSource = profilePicDAO.readProfilePic(username).getSource();
        } else {
            this.profilePicSource = "https://www.teqport.com/images/employees/lower_res/Placeholder_no_text.svg.png";
        }
        
        ProfileDAO profileDAO = new ProfileDAO();
        this.pinnedPicID = profileDAO.readProfile(username).getPinnedPicID();
        this.bio = profileDAO.readProfile(username).getBio();
        
        ArtworkDAO artworkDAO = new ArtworkDAO();
        this.pinnedPicSource = artworkDAO.readArtwork(pinnedPicID).getSource();          
    }

    // gets & sets
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePicSource() {
        return profilePicSource;
    }

    public void setProfilePicSource(String profilePicSource) {
        this.profilePicSource = profilePicSource;
    }

    public String getPinnedPicSource() {
        return pinnedPicSource;
    }

    public void setPinnedPicSource(String pinnedPicSource) {
        this.pinnedPicSource = pinnedPicSource;
    }

    public String getPinnedPicID() {
        return pinnedPicID;
    }

    public void setPinnedPicID(String pinnedPicID) {
        this.pinnedPicID = pinnedPicID;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public InReel getInReel() {
        return inReel;
    }

    public void setInReel(InReel inReel) {
        this.inReel = inReel;
    }

    public OutReel getOutReel() {
        return outReel;
    }

    public void setOutReel(OutReel outReel) {
        this.outReel = outReel;
    }
}
