/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.model;

import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author Paul Merideth
 */
public class Player implements Serializable
{
    private String name;
    private double bestScore;
    private Actor actor;
    private Point currentLocation = new Point();

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

    public void setCurentLocation(Point newLocation)
    {
        currentLocation = newLocation;
    }
    
    public Point getCurrentLocation()
    {
        return currentLocation;
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
