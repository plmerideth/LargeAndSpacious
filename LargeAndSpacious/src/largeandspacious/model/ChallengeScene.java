/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Paul Merideth
 */
public class ChallengeScene implements Serializable {

    //Class instance variables
    private int sceneTypeID;
    private int challengeID;
    private int itemID;
    private String description;

    public ChallengeScene() {
    }
   
    public int getSceneTypeID() {
        return sceneTypeID;
    }

    public void setSceneTypeID(int sceneTypeID) {
        this.sceneTypeID = sceneTypeID;
    }

    public int getChallengeID() {
        return challengeID;
    }

    public void setChallengeID(int challengeID) {
        this.challengeID = challengeID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ChallengeScene{" + "sceneTypeID=" + sceneTypeID + ", challengeID=" + challengeID + ", itemID=" + itemID + ", description=" + description + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.sceneTypeID;
        hash = 29 * hash + this.challengeID;
        hash = 29 * hash + this.itemID;
        hash = 29 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChallengeScene other = (ChallengeScene) obj;
        if (this.sceneTypeID != other.sceneTypeID) {
            return false;
        }
        if (this.challengeID != other.challengeID) {
            return false;
        }
        if (this.itemID != other.itemID) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
    
}
