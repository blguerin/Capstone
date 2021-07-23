package com.algonquin.drawntoyou.reels;

import java.util.ArrayList;

import com.algonquin.drawntoyou.images.Artwork;

public abstract class Reel {
    
    protected Artwork artwork1;
    protected Artwork artwork2;
    protected Artwork artwork3;
    protected Artwork artwork4;
    protected Artwork artwork5;
    
    public abstract void populate();

    // Gets n Sets
    public Artwork getArtwork1() {
        return artwork1;
    }

    public void setArtwork1(Artwork artwork1) {
        this.artwork1 = artwork1;
    }

    public Artwork getArtwork2() {
        return artwork2;
    }

    public void setArtwork2(Artwork artwork2) {
        this.artwork2 = artwork2;
    }

    public Artwork getArtwork3() {
        return artwork3;
    }

    public void setArtwork3(Artwork artwork3) {
        this.artwork3 = artwork3;
    }

    public Artwork getArtwork4() {
        return artwork4;
    }

    public void setArtwork4(Artwork artwork4) {
        this.artwork4 = artwork4;
    }

    public Artwork getArtwork5() {
        return artwork5;
    }

    public void setArtwork5(Artwork artwork5) {
        this.artwork5 = artwork5;
    }
    
}
