/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.model;
import java.io.Serializable;
/**
 *
 * @author julzlee
 */

public class Game implements Serializable {
    
    private Map map;
    private Item[] item;
    private double totalTime;
    private double remainingTime;
    private Player player;
    private Item[] inventory;
    private Actor[] actors;
    

    public Game() {
    }

    public Map getMap() {
        return map;
    }

    public Item[] getItem() {
        return item;
    }

    public Player getPlayer() {
        return player;
    }
    
    public Actor[] getActors() {
        return actors;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setItem(Item[] item) {
        this.item = item;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setInventory(Item[] inventory)
    {
        this.inventory = inventory;
    }
        
    public void setActors(Actor[] actors) {
        this.actors = actors;
    }

    
    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public double getRemainingTime() {
        return remainingTime;
    }

    // class instance variables
    public void setRemainingTime(double remainingTime) {
        this.remainingTime = remainingTime;
    }

    @Override
    public String toString() {
        return "Game{" + ", totalTime=" + totalTime 
                + ", remainingTime=" + remainingTime + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.totalTime) ^ (Double.doubleToLongBits(this.totalTime) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.remainingTime) ^ (Double.doubleToLongBits(this.remainingTime) >>> 32));
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
        final Game other = (Game) obj;
        
        if (Double.doubleToLongBits(this.totalTime) != Double.doubleToLongBits(other.totalTime)) {
            return false;
        }
        if (Double.doubleToLongBits(this.remainingTime) != Double.doubleToLongBits(other.remainingTime)) {
            return false;
        }
        return true;
    }

    public Item[] getInventory()
    {
        return inventory;
    }
    

}
