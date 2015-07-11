/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.model;

import java.io.Serializable;
import java.awt.Point;
//import java.util.Objects;

/**
 *
 * @author julzlee
 */
public enum Actor implements Serializable {
    
    Lehi("He is the prophet and father of the family."),
    Sariah("She is the wife of Lehi and mother of the family."),
    Nephi("Righteous son and later a prophet to the Nephites."),
    Jacob("Righteous son and prophet, successor to Nephi."),
    Sam("Youngest righteous brother of Nephi."),
    Laman("Oldest unrighteous son of Lehi and Sariah."),
    Lemuel("Next oldest unrighteous son of Lehi and Sariah."),
    Zoram("Laban's servant and faithful follower of Nephi.");
    
    // class instance variables
    private final String description;
    private final Point coordinates;
    
    

    Actor(String description) {
        this.description = description;
        coordinates = new Point(1,1);
    }

    public String getDescription() {
        return description;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public static Actor getLehi() {
        return Lehi;
    }

    public static Actor getSariah() {
        return Sariah;
    }

    public static Actor getNephi() {
        return Nephi;
    }

    public static Actor getJacob() {
        return Jacob;
    }

    public static Actor getSam() {
        return Sam;
    }

    public static Actor getLaman() {
        return Laman;
    }

    public static Actor getLemuel() {
        return Lemuel;
    }

    public static Actor getZoram() {
        return Zoram;
    }

   
    
    
}
