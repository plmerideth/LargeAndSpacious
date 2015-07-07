/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.control;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import static java.lang.Math.abs;
import largeandspacious.LargeAndSpacious;
import largeandspacious.control.Scene.SceneType;
import largeandspacious.model.Actor;
import largeandspacious.model.Game;
import largeandspacious.model.Map;
import largeandspacious.model.Player;

/**
 *
 * @author julzlee
 */
public class MapControl {
    protected final PrintWriter console = LargeAndSpacious.getOutFile();
   
    public static void moveActorsToStartingLocation(Map map) 
            throws MapControlException {
        // for every actor
        Actor[] actors = Actor.values();
        
        for (Actor actor : actors) {
            Point coordinates = actor.getCoordinates();
            System.out.println("Actor = " + actor);
            MapControl.moveActorToLocation(actor, coordinates, 0);
        }
    }
    
    public static void moveActorToLocation(Actor actor, Point coordinates, int diceRoll) 
            throws MapControlException {
        Map map = LargeAndSpacious.getCurrentGame().getMap();
        Player player = LargeAndSpacious.getCurrentGame().getPlayer();
        
        int newRow = coordinates.x-1;
        int newColumn = coordinates.y-1;
        Point currentCoordinates = player.getCurrentLocation();
        
        System.out.println("Current Location: " + currentCoordinates);
        
        if (newRow < 0 || newRow >= map.getNoOfRows() || 
            newColumn < 0 || newColumn >= map.getNoOfColumns()){
            throw new MapControlException("Can not move actor to location "
                + coordinates.x + ", " + coordinates.y
                + " because that location is outside "
                + "the bounds of the map.");
        }
        
        double moveCount = abs(currentCoordinates.getX()-coordinates.getX())+(abs(currentCoordinates.getY()-coordinates.getY()));
        
        if( diceRoll!=0 && moveCount > diceRoll)
        {
            throw new MapControlException("\nCan not move actor to location ("
                + coordinates.x + ", " + coordinates.y
                + ") because that location requires " + moveCount + " moves, which exceeds your roll of " + diceRoll + " !");
                
        }
 
        player.setCurentLocation(coordinates);
        System.out.println("New Location: " + coordinates);        
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
        scenes[SceneType.start.ordinal()] = startingScene;
        
        Scene buildingScene = new Scene();
        buildingScene.setDescription("\n BULDING: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        buildingScene.setBlocked(false);
        scenes[SceneType.building.ordinal()] = buildingScene;
        
        Scene mistsScene = new Scene();
        mistsScene.setDescription("\n MISTS: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        mistsScene.setBlocked(false);
        scenes[SceneType.mists.ordinal()] = mistsScene;

        Scene fingerScene = new Scene();
        fingerScene.setDescription("\n FINGER: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        fingerScene.setBlocked(false);
        scenes[SceneType.finger.ordinal()] = fingerScene;
        
        Scene pathScene = new Scene();
        pathScene.setDescription("\n PATH: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        pathScene.setBlocked(false);
        scenes[SceneType.path.ordinal()] = pathScene;        
        
        Scene treeScene = new Scene();
        treeScene.setDescription("\n TREE: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        treeScene.setBlocked(false);
        scenes[SceneType.tree.ordinal()] = treeScene;        
        
        Scene riverScene = new Scene();
        riverScene.setDescription("\n RIVER: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        riverScene.setBlocked(false);
        scenes[SceneType.river.ordinal()] = riverScene;        
        
        Scene finishScene = new Scene();
        finishScene.setDescription("\n FINISH: They came and caught hold of the end of "
                + "the rod of iron; and they did press their way forward, "
                + "continually holding fast to the rod of iron, until they "
                + "came forth and fell down and partook of the fruit of the tree.");
        //finishScene.setMapSymbol(" FN ");
        finishScene.setBlocked(false);
        scenes[SceneType.finish.ordinal()] = finishScene;
        return scenes;
    }

    public static class MapControlException extends Exception {

        public MapControlException() {
        }

        public MapControlException(String string) {
            super(string);
        }

        public MapControlException(String string, Throwable thrwbl) {
            super(string, thrwbl);
        }

        public MapControlException(Throwable thrwbl) {
            super(thrwbl);
        }

        public MapControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
            super(string, thrwbl, bln, bln1);
        }
    }
    
}
