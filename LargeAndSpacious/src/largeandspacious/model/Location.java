/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.model;

import java.io.Serializable;
import java.util.ArrayList;
import largeandspacious.control.Scene;
//import largeandspacious.control.Scene.SceneType;

/**
 *
 * @author Paul Merideth
 */
public class Location implements Serializable {
    //Class instance variables
    private int row;
    private int col;
    private Scene scene;
    private boolean visited=false;
   
    //private ChallengeScene challengeScene;
    //private QuestionScene questionScene;
    //private CombinationScene combinationScene;
    
    private Questions question;
    private ArrayList<Actor> actors;

    public Location() {
    }
    
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean getVisited()
    {
        return this.visited;
    }
    
    public void setScene(Scene index)
    {
        scene = index;
    }
    
    public Scene getScene()
    {
        return scene;
    }
    
    public void setQuestions(Questions question)
    {
        this.question = question;
    }
    
    public Questions getQuestions()
    {
        return this.question;
    }
    
    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", col=" + col  + "}";
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.row;
        hash = 83 * hash + this.col;
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
        final Location other = (Location) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.col != other.col) {
            return false;
        }
        return true;
    }
    
    
}
