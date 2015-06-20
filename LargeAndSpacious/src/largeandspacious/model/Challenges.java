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
public class Challenges implements Serializable {
  
    private int challengeID;
    private int challengeValue;
    private String description;

    public Challenges() {
    }
    
    public int getChallengeID() {
        return challengeID;
    }

    public void setChallengeID(int challengeID) {
        this.challengeID = challengeID;
    }

    public int getChallengeValue() {
        return challengeValue;
    }

    public void setChallengeValue(int challengeValue) {
        this.challengeValue = challengeValue;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Challenges{" + "challengeID=" + challengeID + ", challengeValue=" 
                + challengeValue + ", description=" + description + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.challengeID;
        hash = 97 * hash + this.challengeValue;
        hash = 97 * hash + Objects.hashCode(this.description);
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
        final Challenges other = (Challenges) obj;
        if (this.challengeID != other.challengeID) {
            return false;
        }
        if (this.challengeValue != other.challengeValue) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
}
