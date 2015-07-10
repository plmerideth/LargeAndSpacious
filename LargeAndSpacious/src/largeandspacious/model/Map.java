/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.model;

import java.io.Serializable;
import largeandspacious.model.Location;
import java.io.PrintWriter; 
import java.io.BufferedReader;

/**
 *
 * @author julzlee
 */
public class Map implements Serializable {
    //class instance variables
    private int noOfRows;
    private int noOfColumns;
    private Location[][] locations;
    

    public Map() {
    }

    public Map(int noOfRows, int noOfColumns) {
        if (noOfRows < 1 || noOfColumns < 1) {
            System.out.println("The number of rows and columns must be > zero.");
            return;
        }
        
        this.noOfRows = noOfRows;
        this.noOfColumns = noOfColumns;
        
        //create 2-D array for Location objects
        this.locations = new Location[noOfRows][noOfColumns];
        
        for (int row = 0; row < noOfRows; row++) {
            for (int column = 0; column < noOfColumns; column++) {
        
                // create and initialize new Location object instance
                Location location = new Location();
                location.setCol(column);
                location.setRow(row);
                location.setVisited(false);
                
                // assign the Location object to the current position in array
                locations[row][column]= location;
            }
        }
    }
    
    public Location[][] getLocations()
    {
        return locations;
    }
    
    public int getNoOfRows() {
        return noOfRows;
    }

    public void setRow(int noOfRows) {
        this.noOfRows = noOfRows;
    }

    public int getNoOfColumns() {
        return noOfColumns;
    }

    public void setColumn(int noOfColumns) {
        this.noOfColumns = noOfColumns;
    }

    @Override
    public String toString() {
        return "Map{" + "row=" + noOfRows + ", column=" + noOfColumns + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.noOfRows;
        hash = 17 * hash + this.noOfColumns;
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
        final Map other = (Map) obj;
        if (this.noOfRows != other.noOfRows) {
            return false;
        }
        if (this.noOfColumns != other.noOfColumns) {
            return false;
        }
        return true;
    }
    
    
}
