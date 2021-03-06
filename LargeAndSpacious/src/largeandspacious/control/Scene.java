/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.control;

import java.io.Serializable;
import largeandspacious.model.Location;
import largeandspacious.model.Map;


/**
 *
 * @author julzlee
 */
public class Scene implements Serializable 
{
    private String description ;
    private boolean blocked;
    private int testimonyDestruction;
    private int obedienceDestruction;
  
    
    public static Scene[] createSceneList() {
        // created an array(list) of inventory items
        Scene[] scene = new Scene[Constants.NUMBER_OF_SCENES];
        
        /*Scene start = new Scene();
        start.setDescription("Start of Game");
        start.setBlocked(false);
        scene[SceneType.start.ordinal()] = start;        
                
        Scene building = new Scene();
        building.setDescription("Large and Spacious Building");
        building.setBlocked(false);
        building.setObedienceDestruction(3);
        building.setTestimonyDestruction(3);
        scene[SceneType.building.ordinal()] = building;
        
        Scene mists = new Scene();
        mists.setDescription("Miss of Darkness");
        mists.setBlocked(false);
        mists.setObedienceDestruction(3);
        mists.setTestimonyDestruction(3);
        scene[SceneType.mists.ordinal()] = mists;
        
        Scene finger = new Scene();
        finger.setDescription("Finger of Scorn");
        finger.setBlocked(false);
        finger.setObedienceDestruction(1);
        finger.setTestimonyDestruction(1);
        scene[SceneType.finger.ordinal()] = finger;
        
        Scene path = new Scene();
        path.setDescription("Straight & Narrow Path");
        path.setBlocked(false);
        path.setObedienceDestruction(2);
        path.setTestimonyDestruction(2);
        scene[SceneType.path.ordinal()] = path;
        
        Scene tree = new Scene();
        tree.setDescription("Tree of Life");
        tree.setBlocked(false);
        tree.setObedienceDestruction(4);
        tree.setTestimonyDestruction(4);
        scene[SceneType.tree.ordinal()] = tree;
        
        Scene river = new Scene();
        river.setDescription("River of Water");
        river.setBlocked(false);
        river.setObedienceDestruction(3);
        river.setTestimonyDestruction(3);
        scene[SceneType.river.ordinal()] = river;
        
      
        Scene finish = new Scene();
        finish.setDescription("Finish Game");
        finish.setBlocked(false);
        scene[SceneType.finish.ordinal()] = finish;*/
 
        
        return scene;
    }
    
    private static void assignScenesToLocation (Map map, Scene[] scenes) 
    {
        Location[][] locations = map.getLocations();
        
        //Fill out locations
       //locations[0][0].setScene(scenes[SceneType.start.ordinal()]);
    }
    
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription()
    {
        return this.description;
    }
    
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public void setTestimonyDestruction(int value)
    {
        this.testimonyDestruction = value;
    }
    
    public int getTestimonyDestruction()
    {
        return testimonyDestruction;
    }
    
    public void setObedienceDestruction(int value)
    {
        this.obedienceDestruction = value;
    }
    
    public int getObedienceDestruction()
    {
        return obedienceDestruction;
    }
    
    
    public enum SceneType {        
        building,
        mists,
        finger,
        path,
        tree,
        river        
    }
    
}

