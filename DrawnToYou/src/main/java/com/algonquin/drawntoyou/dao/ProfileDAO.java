package com.algonquin.drawntoyou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.algonquin.drawntoyou.images.Profile;
import com.algonquin.drawntoyou.images.ProfilePic;

public class ProfileDAO {
    
public Map<String, Profile> readProfilePics() {
        
        Profile profile = null;
        
        Map<String, Profile> profileList = new LinkedHashMap<String, Profile>();

        try {
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            String sql = "SELECT * FROM PROFILE;";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet set = statement.executeQuery();
            while (set.next()) {
                profile = new Profile();
                profile.setUsername(set.getString("Username"));
                profile.setPinnedPicID(set.getString("PinnedPicID"));
                profile.setBio(set.getString("Bio"));
                           
                profileList.put(profile.getUsername(), profile);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } 
        return profileList;
    }
    
    public Profile readProfile(String username) {
        Profile profile = null;
        try {
            
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            String sql = "SELECT * FROM PROFILE WHERE Username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet set = statement.executeQuery();
            while (set.next()) {
                profile = new Profile();
                profile.setUsername(set.getString("Username"));
                profile.setPinnedPicID(set.getString("PinnedPicID"));
                profile.setBio(set.getString("Bio"));      
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return profile;
    }
    
    public void createProfile(Profile profile) {
        try {
            
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            String sql = "INSERT INTO PROFILE (Username, PinnedPicID, Bio) VALUES (?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, profile.getUsername());
            statement.setString(2, "111");
            statement.setString(3, "Hi, my name is " + profile.getUsername() + ". Welcome to my profile!");
            
            statement.execute();
            
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public void updateBio(Profile profile) {
        try {
            
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            String sql = "UPDATE PROFILE SET Bio=? WHERE Username=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, profile.getBio());
            statement.setString(2, profile.getUsername());

            statement.execute();
            
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }    
    
    public void updatePinnedPic(Profile profile) {
        try {
            
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            String sql = "UPDATE PROFILE SET PinnedPicID=? WHERE Username=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, profile.getPinnedPicID());
            statement.setString(2, profile.getUsername());

            statement.execute();
            
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }  
    
    public void deleteProfile(String username) {
        try {
  
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            String sql = "DELETE FROM PROFILE WHERE Username=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
}
