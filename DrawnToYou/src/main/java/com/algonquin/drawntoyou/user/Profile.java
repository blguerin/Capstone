package com.algonquin.drawntoyou.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.algonquin.drawntoyou.dao.ConnectDB;
import com.algonquin.drawntoyou.reels.InReel;
import com.algonquin.drawntoyou.reels.OutReel;

public class Profile {

    // TODO finish CRUD operations for bio, profilePicSource, and pinnedPicSource. Perhaps create ProfileDAO.
    private String username;
    private String profilePicSource;
    private String pinnedPicSource;
    private String bio;
    private InReel inReel;
    private OutReel outReel;
    
    // username is determined when Profile is instantiated upon navigation to profile page.
    // Reels are generated based on username. Bio, profile pic, and pinned pic is extracted from DB.
    public Profile(String username) {
        this.username = username;
        inReel = new InReel(username);
        outReel = new OutReel(username);
        getInfo();
    }
    
    // Gathers saved profile data from DB to populate the page with bio, profile pic, and pinned pic.
    private void getInfo() {
        
        try {           
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            String sql = "SELECT * FROM PROFILE WHERE Username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet set = statement.executeQuery();
            while (set.next()) {
                if (set.getString("ProfilePicSource") != null) {
                    profilePicSource = set.getString("ProfilePicSource");
                }
                if (set.getString("PinnedPicSource") != null) {
                    pinnedPicSource = set.getString("PinnedPicSource");
                }
                if (set.getString("Bio") != null) {
                    bio = set.getString("Bio");
                }
            }          
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
