package com.algonquin.drawntoyou.images;

import java.util.UUID;

public class Artwork {

    private UUID imageID;
    private String submitterUsername;
    private String modelUsername;
    private String source;
    
    public Artwork() {}

    public Artwork(UUID imageID, String submitterUsername, String modelUsername, String source) {
        this.imageID = UUID.randomUUID();
        this.submitterUsername = submitterUsername;
        this.modelUsername = modelUsername;
        this.source = source;
    }

    // Gets n Sets
    public UUID getImageID() {
        return imageID;
    }

    public void setImageID(UUID imageID) {
        this.imageID = imageID;
    }

    public String getSubmitterUsername() {
        return submitterUsername;
    }

    public void setSubmitterUsername(String submitterUsername) {
        this.submitterUsername = submitterUsername;
    }

    public String getModelUsername() {
        return modelUsername;
    }

    public void setModelUsername(String modelUsername) {
        this.modelUsername = modelUsername;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
