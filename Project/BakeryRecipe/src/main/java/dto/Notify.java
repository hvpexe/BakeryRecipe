/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Admin
 */
public class Notify {

    private int id;//notify id
    private int notifictionID;
    private int userID;
    private int destinationID;
    private String typeOfNotification;
    private boolean seen;
    private boolean deleted;

    public Notify () {
    }

    public Notify (int id, int notifictionID, int userID, int destinationID, String typeOfNotification, boolean seen, boolean deleted) {
        this.id = id;
        this.notifictionID = notifictionID;
        this.userID = userID;
        this.destinationID = destinationID;
        this.typeOfNotification = typeOfNotification;
        this.seen = seen;
        this.deleted = deleted;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public int getNotifictionID () {
        return notifictionID;
    }

    public void setNotifictionID (int notifictionID) {
        this.notifictionID = notifictionID;
    }

    public int getUserID () {
        return userID;
    }

    public void setUserID (int userID) {
        this.userID = userID;
    }

    public int getDestinationID () {
        return destinationID;
    }

    public void setDestinationID (int destinationID) {
        this.destinationID = destinationID;
    }

    public String getTypeOfNotification () {
        return typeOfNotification;
    }

    public void setTypeOfNotification (String typeOfNotification) {
        this.typeOfNotification = typeOfNotification;
    }

    public boolean isSeen () {
        return seen;
    }

    public void setSeen (boolean seen) {
        this.seen = seen;
    }

    
    public boolean isDeleted () {
        return deleted;
    }

    public void setDeleted (boolean deleted) {
        this.deleted = deleted;
    }
    
    

}
