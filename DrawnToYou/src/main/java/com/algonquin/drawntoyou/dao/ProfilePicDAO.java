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

            String sql = "SELECT * FROM drawntoyou.PROFILE_PIC;";
            PreparedStatement statement = connection.prepareStatement(sql);

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

            String sql = "SELECT * FROM drawntoyou.PROFILE_PIC WHERE Username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

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

            String sql = "INSERT INTO drawntoyou.PROFILE_PIC (Username, Source) VALUES (?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, profilePic.getUsername());
            statement.setString(2, profilePic.getSource());
            
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

            String sql = "UPDATE drawntoyou.PROFILE_PIC SET Source=? WHERE Username=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, profilePic.getSource());
            statement.setString(2, profilePic.getUsername());

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

            String sql = "DELETE FROM drawntoyou.PROFILE_PIC WHERE Username=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

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
