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
public class QuestionScene implements Serializable {
    // class instance variables
    private int sceneTypeID;
    private int questionID;
    private int itemID;
    private String description;

    public QuestionScene() {
    }
    
    
    public int getSceneTypeID() {
        return sceneTypeID;
    }

    public void setSceneTypeID(int sceneTypeID) {
        this.sceneTypeID = sceneTypeID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
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
        return "QuestionScene{" + "sceneTypeID=" + sceneTypeID + ", questionID=" 
                + questionID + ", itemID=" + itemID + ", description=" 
                + description + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.sceneTypeID;
        hash = 97 * hash + this.questionID;
        hash = 97 * hash + this.itemID;
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
        final QuestionScene other = (QuestionScene) obj;
        if (this.sceneTypeID != other.sceneTypeID) {
            return false;
        }
        if (this.questionID != other.questionID) {
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
