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

            String sql = "SELECT * FROM drawntoyou.ARTWORK;";
            PreparedStatement statement = connection.prepareStatement(sql);

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

            String sql = "SELECT * FROM drawntoyou.ARTWORK WHERE Id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, imageID);

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

            String sql = "INSERT INTO drawntoyou.ARTWORK (Id, SubmitterUsername, ModelUsername, Source) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, artwork.getImageID().toString());
            statement.setString(2, artwork.getSubmitterUsername());
            statement.setString(3, artwork.getModelUsername());
            statement.setString(4, artwork.getSource());
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

            String sql = "UPDATE drawntoyou.ARTWORK SET SubmitterUsername=?, ModelUsername=?, Source=? WHERE Id=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, artwork.getSubmitterUsername());
            statement.setString(2, artwork.getModelUsername());
            statement.setString(2, artwork.getSource());
            statement.setString(4, artwork.getImageID().toString());
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

            String sql = "DELETE FROM drawntoyou.ARTWORK WHERE Id=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, UUID.fromString(imageID).toString());
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
    
    public ArrayList<Artwork> getInReel(String modelUsername) {
        
        Artwork artwork = null;
        
        ArtworkDAO dao = new ArtworkDAO();
        Artwork placeholder = dao.readArtwork("10155836-76f7-47ba-a8dc-7ca24d5b0730");
        
        ArrayList<Artwork> artworkList = new ArrayList<Artwork>();
        artworkList.add(0, placeholder);
        artworkList.add(1, placeholder);
        artworkList.add(2, placeholder);
        artworkList.add(3, placeholder);
        artworkList.add(4, placeholder);
        
        try {
            Connection connection = ConnectDB.getInstance().getConnectionToDB();
           

            String sql = "SELECT * FROM drawntoyou.ARTWORK WHERE ModelUsername=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, modelUsername);

            ResultSet set = statement.executeQuery();
            
            for (int i = 0; i < 5; i++) {
                if (set.next()) {
                    artwork = new Artwork();
                    artwork.setImageID(UUID.fromString(set.getString("Id")));
                    artwork.setSubmitterUsername(set.getString("SubmitterUsername"));
                    artwork.setModelUsername(set.getString("ModelUsername"));
                    artwork.setSource(set.getString("Source"));
                    
                    artworkList.set(i, artwork);
                }
            }          
        } catch (SQLException exception) {
            exception.printStackTrace();
        } 
        return artworkList;
    }
    
public ArrayList<Artwork> getOutReel(String submitterUsername) {
        
        Artwork artwork = null;
        
        ArtworkDAO dao = new ArtworkDAO();
        Artwork placeholder = dao.readArtwork("10155836-76f7-47ba-a8dc-7ca24d5b0730");
        
        ArrayList<Artwork> artworkList = new ArrayList<Artwork>();
        artworkList.add(0, placeholder);
        artworkList.add(1, placeholder);
        artworkList.add(2, placeholder);
        artworkList.add(3, placeholder);
        artworkList.add(4, placeholder);
        
        try {
            Connection connection = ConnectDB.getInstance().getConnectionToDB();
           

            String sql = "SELECT * FROM drawntoyou.ARTWORK WHERE SubmitterUsername=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, submitterUsername);

            ResultSet set = statement.executeQuery();
            
            for (int i = 0; i < 5; i++) {
                if (set.next()) {
                    artwork = new Artwork();
                    artwork.setImageID(UUID.fromString(set.getString("Id")));
                    artwork.setSubmitterUsername(set.getString("SubmitterUsername"));
                    artwork.setModelUsername(set.getString("ModelUsername"));
                    artwork.setSource(set.getString("Source"));
                    
                    artworkList.set(i, artwork);
                }
            }          
        } catch (SQLException exception) {
            exception.printStackTrace();
        } 
        return artworkList;
    }
}
