/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Paul Merideth
 */
public class Player implements Serializable
{
    private String name;
    private double bestScore;
    private double currentScore;
    private String actor;
    private Point currentLocation = new Point();
    private ArrayList<Point> pastLocations = new ArrayList<Point>();

    public Player() {
    }  
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBestScore() {
        return bestScore;
    }

    public void setBestScore(double bestScore) {
        this.bestScore = bestScore;
    }

    public void setCurrentLocation(Point newLocation)
    {
        currentLocation = newLocation;
    }
    
    public Point getCurrentLocation()
    {
        return currentLocation;
    }

    public void setPastLocation(Point pastLocation, Point newLocation)
    {
        if(pastLocation != newLocation)
            this.pastLocations.add(pastLocation);
    }
    
    public ArrayList<Point> getPastLocations()
    {
        return pastLocations;
    }
    
    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    /*public void setCurrentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
    }*/

    public double getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(double currentScore) {
        this.currentScore = currentScore;
    }
    
    
    
    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", bestScore=" + bestScore + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.bestScore) ^ (Double.doubleToLongBits(this.bestScore) >>> 32));
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
        final Player other = (Player) obj;
        if (Double.doubleToLongBits(this.bestScore) != Double.doubleToLongBits(other.bestScore)) {
            return false;
        }
        return true;
    }
    
    
}
