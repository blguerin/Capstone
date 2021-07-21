package com.algonquin.drawntoyou.dao;

import com.algonquin.drawntoyou.images.ProfilePic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/* This is very similar to Artwork but slightly different. Artwork only has one more attribute. 
   This class can implement a CRUD interface that can be used for all CRUD operations within the program
   as it does in the Assignment 3 solution. For MVP all images are Profile Pics. */

public class ProfilePicDAO {
    
    public Map<UUID, ProfilePic> readProfilePics() {
        
        ProfilePic profilePic = null;
        
        Map<UUID, ProfilePic> profilePicList = new LinkedHashMap<UUID, ProfilePic>();

        try {
            
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            // write select query to get all the profilePics
            String sql = "SELECT * FROM PROFILE_PIC;";
            PreparedStatement statement = connection.prepareStatement(sql);

            // execute query, get resultset and return User info
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                profilePic = new ProfilePic();
                profilePic.setImageID(UUID.fromString(set.getString("Id")));
                profilePic.setSourceLink(set.getString("SourceLink"));
                profilePic.setSubmitterUsername(set.getString("SubmitterUsername"));
//                profilePic.setSubmissionDate(set.getXXXXX("SubmissionDate"));
                
                profilePicList.put(profilePic.getImageID(), profilePic);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } 
        return profilePicList;
    }
    
    public ProfilePic readProfilePic(String imageID) {
        ProfilePic profilePic = null;
        try {
            
            Connection connection = ConnectDB.getConnectionToDB();

            // write select query to get the profilePic
            String sql = "SELECT * FROM PROFILE_PIC WHERE ID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, imageID);

            // execute query, get resultset and return ProfilePic info
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                profilePic = new ProfilePic();
                profilePic.setImageID(UUID.fromString(set.getString("ID")));
                profilePic.setSourceLink(set.getString("SourceLink"));
                profilePic.setSubmitterUsername(set.getString("SubmitterUsername"));
//                profilePic.setSubmissionDate(set.getXXXXX("SubmissionDate"));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return profilePic;
    }
    
    public void createLog(ProfilePic profilePic) {
        try {
            
            Connection connection = ConnectDB.getConnectionToDB();

            // write select query to get the log (Add date later)
            String sql = "INSERT INTO PROFILE_PIC (ID, SourceLink, SubmitterUsername) VALUES (?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, profilePic.getImageID().toString());
            statement.setString(2, profilePic.getSourceLink());
            statement.setString(3, profilePic.getSubmitterUsername());

            // execute query, update resultset
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public void updateProfilePic(ProfilePic profilePic) {
        try {
            
            Connection connection = ConnectDB.getConnectionToDB();

            // write select query to get the profilePic
            String sql = "UPDATE PROFILE_PIC SET SourceLink=?, SubmitterUsername=? WHERE ID=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, profilePic.getSourceLink());
            statement.setString(2, profilePic.getSubmitterUsername());
            statement.setString(3, profilePic.getImageID().toString());

            // execute query, update resultset
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public void deleteProfilePic(String imageID) {
        try {
  
            Connection connection = ConnectDB.getConnectionToDB();

            // write select query to get the log
            String sql = "DELETE FROM PROFILE WHERE ID=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, UUID.fromString(imageID).toString());

            // execute query, delete resultset
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public void createOrUpdateProfilePic(ProfilePic profilePic) {
        ProfilePic localProfilePic = readProfilePic(profilePic.getImageID().toString());
        if (localProfilePic == null) {
            createLog(profilePic);
        } else {
            updateProfilePic(profilePic);
        }
    }

    // Getting display reels. InReel and OutReel, but only OutReel for MVP purposes.
    public ArrayList<ProfilePic> populateReel() {
        
        ArrayList<ProfilePic> reelList = new ArrayList<ProfilePic>();
        
        try {
            
            Connection connection = ConnectDB.getConnectionToDB();

            String sql = "This is a query that returns 5 pictures. There could be several sorting methods";
            PreparedStatement statement = connection.prepareStatement(sql);

            // 5 SourceLink fields will be returned and used to populate the reel
            
        } catch (SQLException exception) {
            exception.printStackTrace();
        } 
        return reelList;
    }
    
            
}
