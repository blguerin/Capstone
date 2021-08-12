package com.algonquin.drawntoyou.reels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.algonquin.drawntoyou.dao.ArtworkDAO;
import com.algonquin.drawntoyou.dao.ConnectDB;
import com.algonquin.drawntoyou.images.Artwork;

// OutReel showcases artworks created by the user who owns the profile.
public class OutReel extends Reel {
    
    private String username;
    
    public OutReel(String username) {
        this.username = username;

        this.reelList = populate();
    }

    public ArrayList<Artwork> populate() {        
        ArtworkDAO dao = new ArtworkDAO();       
        ArrayList<Artwork> artList = dao.getOutReel(username);
        return artList;
    }
}
