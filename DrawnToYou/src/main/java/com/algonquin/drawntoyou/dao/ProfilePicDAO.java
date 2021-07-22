package com.algonquin.drawntoyou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import com.algonquin.drawntoyou.images.ProfilePic;

public class ProfilePicDAO {
    
    public Map<String, ProfilePic> readProfilePics() {
        
        ProfilePic profilePic = null;
        
        Map<String, ProfilePic> profilePicList = new LinkedHashMap<String, ProfilePic>();

        try {
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            // write select query to get all the profilePics
            String sql = "SELECT * FROM PROFILE_PIC;";
            PreparedStatement statement = connection.prepareStatement(sql);

            // execute query, get resultset and return User info
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                profilePic = new ProfilePic();
                profilePic.setUsername(set.getString("Username"));
                profilePic.setSource(set.getString("Source"));
                           
                profilePicList.put(profilePic.getUsername(), profilePic);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } 
        return profilePicList;
    }
    
    public ProfilePic readProfilePic(String username) {
        ProfilePic profilePic = null;
        try {
            
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            // write select query to get the profilePic
            String sql = "SELECT * FROM PROFILE_PIC WHERE Username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            // execute query, get resultset and return ProfilePic info
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                profilePic = new ProfilePic();
                profilePic.setUsername(set.getString("Username"));
                profilePic.setSource(set.getString("Source"));       
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return profilePic;
    }
    
    public void createProfilePic(ProfilePic profilePic) {
        try {
            
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            // write select query to get the log (Add date later)
            String sql = "INSERT INTO PROFILE_PIC (Username, Source) VALUES (?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, profilePic.getUsername());
            statement.setString(2, profilePic.getSource());
            
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
            
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            // write select query to get the profilePic
            String sql = "UPDATE PROFILE_PIC SET Source=? WHERE Username=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, profilePic.getSource());
            statement.setString(2, profilePic.getUsername());

            // execute query, update resultset
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public void deleteProfilePic(String username) {
        try {
  
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            // write select query to get the log
            String sql = "DELETE FROM PROFILE WHERE Username=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            // execute query, delete resultset
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public void createOrUpdateProfilePic(ProfilePic profilePic) {
        ProfilePic localProfilePic = readProfilePic(profilePic.getUsername());
        if (localProfilePic == null) {
            createProfilePic(profilePic);
        } else {
            updateProfilePic(profilePic);
        }
    }         
}
