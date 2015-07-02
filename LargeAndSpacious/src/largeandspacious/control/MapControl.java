/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.control;

import java.awt.Point;
import java.awt.image.BufferedImage;
import largeandspacious.LargeAndSpacious;
import largeandspacious.control.Scene.SceneType;
import largeandspacious.model.Actor;
import largeandspacious.model.Game;
import largeandspacious.model.Location;
import largeandspacious.model.Map;

/**
 *
 * @author julzlee
 */
public class MapControl {

   
    static void moveActorsToStartingLocation(Map map) {
        // for every actor
        Actor[] actors = Actor.values();
        
        for (Actor actor : actors) {
            Point coordinates = actor.getCoordinates();
            
        }
    }
    
    public static int moveActorToLocation(Actor actor, Point cooridinates) 
            throws MapControlException {
        Map map = LargeAndSpacious.getCurrentGame().getMap();
        //int newRow = Location.x-1;
        //int newColumn = Location.y-1;
        return 1;
        
    }

    public static Map createMap() {
        
        //create the map
        Map map = new Map(10,10);
        
        //create a list of the different challenge scenes in the game
        Scene[] scenes = createScenes();
        
        //assign the different scenes to location in the map
        GameControl.assignScenesToLocations(map, scenes);
               
        return map;
    }

    private static Scene[] createScenes() /*throws MapControlException*/
    {
        BufferedImage image = null;
        
        Game game = LargeAndSpacious.getCurrentGame();
        
        Scene[] scenes = new Scene[SceneType.values().length];
        
        Scene startingScene = new Scene();
        startingScene.setDescription("\n And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        startingScene.setBlocked(false);
        //startingScene.setTravelTime(240);
        //ImageIcon startingSceneImage = MapControl.getImage(startingScene,"")
        //startingScene.setIcon(startingSceneImage);
        scenes[SceneType.start.ordinal()] = startingScene;
        
        Scene buildingScene = new Scene();
        buildingScene.setDescription("\n BULDING: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        buildingScene.setBlocked(false);
        //startingScene.setTravelTime(240);
        //ImageIcon startingSceneImage = MapControl.getImage(startingScene,"")
        //startingScene.setIcon(startingSceneImage);
        scenes[SceneType.building.ordinal()] = buildingScene;
        
        Scene mistsScene = new Scene();
        mistsScene.setDescription("\n MISTS: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        mistsScene.setBlocked(false);
        //startingScene.setTravelTime(240);
        //ImageIcon startingSceneImage = MapControl.getImage(startingScene,"")
        //startingScene.setIcon(startingSceneImage);
        scenes[SceneType.mists.ordinal()] = mistsScene;

        Scene fingerScene = new Scene();
        fingerScene.setDescription("\n FINGER: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        fingerScene.setBlocked(false);
        //startingScene.setTravelTime(240);
        //ImageIcon startingSceneImage = MapControl.getImage(startingScene,"")
        //startingScene.setIcon(startingSceneImage);
        scenes[SceneType.finger.ordinal()] = fingerScene;
        
        Scene pathScene = new Scene();
        pathScene.setDescription("\n PATH: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        pathScene.setBlocked(false);
        //startingScene.setTravelTime(240);
        //ImageIcon startingSceneImage = MapControl.getImage(startingScene,"")
        //startingScene.setIcon(startingSceneImage);
        scenes[SceneType.path.ordinal()] = pathScene;        
        
        Scene treeScene = new Scene();
        treeScene.setDescription("\n TREE: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        treeScene.setBlocked(false);
        //startingScene.setTravelTime(240);
        //ImageIcon startingSceneImage = MapControl.getImage(startingScene,"")
        //startingScene.setIcon(startingSceneImage);
        scenes[SceneType.tree.ordinal()] = treeScene;        
        
        Scene riverScene = new Scene();
        riverScene.setDescription("\n RIVER: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        riverScene.setBlocked(false);
        //startingScene.setTravelTime(240);
        //ImageIcon startingSceneImage = MapControl.getImage(startingScene,"")
        //startingScene.setIcon(startingSceneImage);
        scenes[SceneType.river.ordinal()] = riverScene;        
        
        Scene finishScene = new Scene();
        finishScene.setDescription("\n FINISH: They came and caught hold of the end of "
                + "the rod of iron; and they did press their way forward, "
                + "continually holding fast to the rod of iron, until they "
                + "came forth and fell down and partook of the fruit of the tree.");
        //finishScene.setMapSymbol(" FN ");
        finishScene.setBlocked(false);
        //finishScene.setTravelTime(Double.POSITIVE_INFINITY);
        //ImageIcon finishSceneImage = MapControl.getImage(finishScene, "");
        //finishScene.setIcon(finishSceneImage);
        scenes[SceneType.finish.ordinal()] = finishScene;
        return scenes;
    }

    private static class MapControlException extends Exception {

        public MapControlException() {
        }
    }
    
}
