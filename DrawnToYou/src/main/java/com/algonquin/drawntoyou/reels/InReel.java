package com.algonquin.drawntoyou.reels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.algonquin.drawntoyou.dao.ConnectDB;
import com.algonquin.drawntoyou.images.Artwork;

//InReel showcases artworks created by other users based on the user's profile pic.
public class InReel extends Reel {
    
    private String username;
    
    public InReel(String username) {
        this.username = username;
        populate();
    }

    // TODO
    // This needs to be customized to select 5 images from the Artwork table based on ModelUsername == Profile Username.
    // Often times there will not be enough images to populate all 5 reel images. Perhaps the empties can be filled
    // with some sort of placeholder image. Also make the placeholder unclickable or stay on page. 
    // ie: if (artwork1 == null) { set username to maybe a special one that triggers stay on page. Set source to placeholder image.
    public void populate() {
        
        ArrayList<Artwork> reelList = new ArrayList<Artwork>();
        
        try {
            
            Connection connection = ConnectDB.getInstance().getConnectionToDB();
            
            // This can live in a 5 iteration loop maybe, every loop chooses an Artwork.
            String sql = "This is a query that returns 5 pictures. There could be several sorting methods";
            PreparedStatement statement = connection.prepareStatement(sql);
            
        } catch (SQLException exception) {
            exception.printStackTrace();
        } 
        this.artwork1 = reelList.get(0);
        this.artwork2 = reelList.get(1);
        this.artwork3 = reelList.get(3);
        this.artwork4 = reelList.get(4);
        this.artwork5 = reelList.get(5);
    }
}
