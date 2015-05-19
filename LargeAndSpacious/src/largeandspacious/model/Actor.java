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
 * @author julzlee
 */
public class Actor implements Serializable {
    // class instance variables
    private int actorID;
    private String actorName;

    public Actor() {
    }
    
    

    public int getActorID() {
        return actorID;
    }

    public void setActorID(int actorID) {
        this.actorID = actorID;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Override
    public String toString() {
        return "Actor{" + "actorID=" + actorID + ", actorName=" + actorName + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.actorID;
        hash = 97 * hash + Objects.hashCode(this.actorName);
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
        final Actor other = (Actor) obj;
        if (this.actorID != other.actorID) {
            return false;
        }
        if (!Objects.equals(this.actorName, other.actorName)) {
            return false;
        }
        return true;
    }
    
    
    
}
