/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.control;


/**
 *
 * @author julzlee
 */
public class Scene {
    
    public static Scene[] createSceneList() {
        // created an array(list) of inventory items
        Scene[] scene = new Scene[Constants.NUMBER_OF_SCENES];
        
        Scene start = new Scene();
        start.setDescription("Start of Game");
        start.setBlocked(false);
        start.setSceneType(0);
        scene[SceneType.start.ordinal()] = start;
        
        Scene building = new Scene();
        building.setDescription("Large and Spacious Building");
        building.setBlocked(false);
        building.setSceneType(0);
        scene[SceneType.building.ordinal()] = building;
        
        Scene mists = new Scene();
        mists.setDescription("Miss of Darkness");
        mists.setBlocked(false);
        mists.setSceneType(0);
        scene[SceneType.mists.ordinal()] = mists;
        
        Scene finger = new Scene();
        finger.setDescription("Finger of Scorn");
        finger.setBlocked(false);
        finger.setSceneType(0);
        scene[SceneType.finger.ordinal()] = finger;
        
        Scene path = new Scene();
        path.setDescription("Straight & Narrow Path");
        path.setBlocked(false);
        path.setSceneType(0);
        scene[SceneType.path.ordinal()] = path;
        
        Scene tree = new Scene();
        tree.setDescription("Tree of Life");
        tree.setBlocked(false);
        tree.setSceneType(0);
        scene[SceneType.tree.ordinal()] = tree;
        
        Scene river = new Scene();
        river.setDescription("River of Water");
        river.setBlocked(false);
        river.setSceneType(0);
        scene[SceneType.river.ordinal()] = river;
        
        Scene finish = new Scene();
        finish.setDescription("Finish Game");
        finish.setBlocked(false);
        finish.setSceneType(0);
        scene[SceneType.finish.ordinal()] = finish;
        
        return scene;
    }
    private String description;
    private boolean blocked;
    private int sceneType;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public void setSceneType(int sceneType) {
        this.sceneType = sceneType;
    }
    
    public enum SceneType {
        start,
        building,
        mists,
        finger,
        path,
        tree,
        river,
        finish
    }
    
}

