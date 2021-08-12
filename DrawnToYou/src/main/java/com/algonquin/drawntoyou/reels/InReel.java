package com.algonquin.drawntoyou.reels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.algonquin.drawntoyou.dao.ArtworkDAO;
import com.algonquin.drawntoyou.dao.ConnectDB;
import com.algonquin.drawntoyou.images.Artwork;

//InReel showcases artworks created by other users based on the user's profile pic.
public class InReel extends Reel {
    
    private String username;
    
    public InReel(String username) {
        this.username = username;
        this.reelList = populate();
    }

    public ArrayList<Artwork> populate() {        
        ArtworkDAO dao = new ArtworkDAO();       
        ArrayList<Artwork> artList = dao.getInReel(username);
        return artList;
    }
}
