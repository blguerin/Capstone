package com.algonquin.drawntoyou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import com.algonquin.drawntoyou.images.Artwork;

public class ArtworkDAO {
    
    public Map<UUID, Artwork> readArtwork() {
        
        Artwork artwork = null;
        
        Map<UUID, Artwork> artworkList = new LinkedHashMap<UUID, Artwork>();

        try {
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            // write select query to get all the artworks
            String sql = "SELECT * FROM ARTWORK;";
            PreparedStatement statement = connection.prepareStatement(sql);

            // execute query, get resultset and return User info
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                artwork = new Artwork();
                artwork.setImageID(UUID.fromString(set.getString("Id")));
                artwork.setSubmitterUsername(set.getString("SubmitterUsername"));
                artwork.setModelUsername(set.getString("ModelUsername"));
                artwork.setSource(set.getString("Source"));             
                
                artworkList.put(artwork.getImageID(), artwork);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } 
        return artworkList;
    }
    
    public Artwork readArtwork(String imageID) {
        Artwork artwork = null;
        try {
            
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            // write select query to get the artwork
            String sql = "SELECT * FROM ARTWORK WHERE Id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, imageID);

            // execute query, get resultset and return Artwork info
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                artwork = new Artwork();
                artwork.setImageID(UUID.fromString(set.getString("Id")));
                artwork.setSubmitterUsername(set.getString("SubmitterUsername"));
                artwork.setModelUsername(set.getString("ModelUsername"));
                artwork.setSource(set.getString("Source"));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return artwork;
    }
    
    public void createArtwork(Artwork artwork) {
        try {
            
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            // write select query to get the log (Add date later)
            String sql = "INSERT INTO ARTWORK (Id, SubmitterUsername, ModelUsername, Source) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, artwork.getImageID().toString());
            statement.setString(2, artwork.getSubmitterUsername());
            statement.setString(3, artwork.getModelUsername());
            statement.setString(4, artwork.getSource());

            // execute query, update resultset
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public void updateArtwork(Artwork artwork) {
        try {
            
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            // write select query to get the artwork
            String sql = "UPDATE ARTWORK SET SubmitterUsername=?, ModelUsername=?, Source=? WHERE Id=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, artwork.getSubmitterUsername());
            statement.setString(2, artwork.getModelUsername());
            statement.setString(2, artwork.getSource());
            statement.setString(4, artwork.getImageID().toString());

            // execute query, update resultset
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public void deleteArtwork(String imageID) {
        try {
  
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            // write select query to get the log
            String sql = "DELETE FROM ARTWORK WHERE Id=?;";
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
    
    public void createOrUpdateArtwork(Artwork artwork) {
        Artwork localArtwork = readArtwork(artwork.getImageID().toString());
        if (localArtwork == null) {
            createArtwork(artwork);
        } else {
            updateArtwork(artwork);
        }
    }

    // Getting display reels. InReel and OutReel, but only OutReel for MVP purposes. These should be moved to ReelDAO
    // when created.
    public ArrayList<Artwork> populateReel() {
        
        ArrayList<Artwork> reelList = new ArrayList<Artwork>();
        
        try {
            
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            String sql = "This is a query that returns 5 pictures. There could be several sorting methods";
            PreparedStatement statement = connection.prepareStatement(sql);

            // 5 SourceLink fields will be returned and used to populate the reel
            
        } catch (SQLException exception) {
            exception.printStackTrace();
        } 
        return reelList;
    }
    
            
}
