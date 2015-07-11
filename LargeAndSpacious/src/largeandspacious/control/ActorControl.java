/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
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
        List<Actor> actors = new ArrayList<>(EnumSet.allOf(Actor.class));
        description = "    LIST OF ACTORS";
        // go through each of the actors, get the name and description   
        for (Actor actor: actors)
        {
            description = description + "\n" + actor.name() + ":\t\t" + actor.getDescription();   
        }
    
        return description;                   
}
    
}
