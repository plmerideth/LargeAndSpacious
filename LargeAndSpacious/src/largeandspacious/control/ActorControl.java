/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.control;

import largeandspacious.LargeAndSpacious;
import largeandspacious.model.Actor;

/**
 *
 * @author julzlee
 */
public class ActorControl {
    
    public static String showActors() {
        
        String description = null;
        
        //get the actors
        Actor[] actors = LargeAndSpacious.getCurrentGame().getActors();
           
        for (Actor actor: actors)
        {
            switch(actor.name()) {
                case "Lehi":
                        description = description + "\n" + actor.name() + ": " + actor.getDescription();
                case "Sariah":
                case "Nephi":
                case "Jacob":
                case "Sam":
                case "Laman":
                case "Lemuel":
                case "Zoram": 
        }
    }
        return description;                   
}
    
}
