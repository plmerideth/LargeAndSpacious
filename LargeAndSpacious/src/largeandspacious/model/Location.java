/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.model;

import java.io.Serializable;

/**
 *
 * @author Paul Merideth
 */
public class Location implements Serializable {
    //Class instance variables
    private int row;
    private int col;
    private int sceneTypeId;

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

    public int getSceneTypeId() {
        return sceneTypeId;
    }

    public void setSceneTypeId(int sceneTypeId) {
        this.sceneTypeId = sceneTypeId;
    }

    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", col=" + col + ", sceneTypeId=" + sceneTypeId + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.row;
        hash = 83 * hash + this.col;
        hash = 83 * hash + this.sceneTypeId;
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
        if (this.sceneTypeId != other.sceneTypeId) {
            return false;
        }
        return true;
    }
    
    
}
