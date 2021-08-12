package com.algonquin.drawntoyou.reels;

import java.util.ArrayList;

import com.algonquin.drawntoyou.images.Artwork;

public abstract class Reel {
    
    protected ArrayList<Artwork> reelList;
    
    public abstract ArrayList<Artwork> populate();

    // Gets n Sets
    public ArrayList<Artwork> getReelList() {
        return reelList;
    }
    public void setReelList(ArrayList<Artwork> reelList) {
        this.reelList = reelList;
    }   
}
