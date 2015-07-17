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
import java.util.Random;
import largeandspacious.LargeAndSpacious;
import largeandspacious.control.Scene.SceneType;
import largeandspacious.exceptions.MapControlException;
import largeandspacious.model.Actor;
import largeandspacious.model.Game;
import largeandspacious.model.Location;
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
        
        Actor actor = LargeAndSpacious.getActor();
        Point coordinates = actor.getCoordinates();
        // move the player to the starting location
        LargeAndSpacious.getPlayer().setCurrentLocation(coordinates);
            //cannot use this.console.println from a static function
            // System.out.println("Actor = " + actor);
        MapControl.moveActorToLocation(actor, coordinates, 0);
    }
    
    public static void moveActorToLocation(Actor actor, Point coordinates, int diceRoll) 
            throws MapControlException {
        Map map = LargeAndSpacious.getCurrentGame().getMap();
        Player player = LargeAndSpacious.getCurrentGame().getPlayer();
        Location[][] locations = map.getLocations();
        
        int newRow = coordinates.x-1;
        int newColumn = coordinates.y-1;
        Point currentCoordinates = player.getCurrentLocation();
        
        //System.out.println("Current Location: " + currentCoordinates);
        
        if (newRow < 0 || newRow >= map.getNoOfRows() || 
            newColumn < 0 || newColumn >= map.getNoOfColumns()){
            throw new MapControlException("Can not move actor to location "
                + coordinates.x + ", " + coordinates.y
                + " because that location is outside "
                + "the bounds of the map.");
        }
        
        //Cannot move to a location you have already visited.
        if(locations[(int)(coordinates.getX()-1)][(int)(coordinates.getY()-1)].getVisited())
        {
            throw new MapControlException("You can not move to that location because you have already visited " 
                + coordinates.x + ", " + coordinates.y);
        }
        
        double moveCount = abs(currentCoordinates.getX()-coordinates.getX())+(abs(currentCoordinates.getY()-coordinates.getY()));
        
        if( diceRoll!=0 && moveCount > diceRoll)
        {
            throw new MapControlException("\nCan not move player to location ("
                + coordinates.x + ", " + coordinates.y
                + ") because that location requires " + moveCount + " moves, which exceeds your roll of " + diceRoll + " !");
                
        }
 
        player.setPastLocation(player.getCurrentLocation(), coordinates);
        player.setCurrentLocation(coordinates);
        
        //Set location coordinates as visited.
        locations[(int)(coordinates.getX()-1)][(int)(coordinates.getY()-1)].setVisited(true);
        //System.out.println("New Location: " + coordinates);        
    }

    public static Map createMap() {
        
        // set up random numbers between 5 and 10 so we have a decent map
        Random rand = new Random();
        int min = 5;
        int max = 10;
        //set up a random map
        int x = rand.nextInt((max - min) + 1) + min;
        //System.out.println("x = " + x);
        int y = rand.nextInt((max - min) + 1) + min;
        //System.out.println("y = " + y);
        //create the map
        Map map = new Map(x, y);
        //Map map = new Map(10,10); //Temporary for testing.
        
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
        startingScene.setDescription("STARTING: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        startingScene.setBlocked(false);
        scenes[SceneType.start.ordinal()] = startingScene;
        
        Scene buildingScene = new Scene();
        buildingScene.setDescription("BUILDING: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        buildingScene.setBlocked(false);
        scenes[SceneType.building.ordinal()] = buildingScene;
        
        Scene mistsScene = new Scene();
        mistsScene.setDescription("MISTS: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        mistsScene.setBlocked(false);
        scenes[SceneType.mists.ordinal()] = mistsScene;

        Scene fingerScene = new Scene();
        fingerScene.setDescription("FINGER: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        fingerScene.setBlocked(false);
        scenes[SceneType.finger.ordinal()] = fingerScene;
        
        Scene pathScene = new Scene();
        pathScene.setDescription("PATH: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        pathScene.setBlocked(false);
        scenes[SceneType.path.ordinal()] = pathScene;        
        
        Scene treeScene = new Scene();
        treeScene.setDescription("TREE: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        treeScene.setBlocked(false);
        scenes[SceneType.tree.ordinal()] = treeScene;        
        
        Scene riverScene = new Scene();
        riverScene.setDescription("RIVER: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        riverScene.setBlocked(false);
        scenes[SceneType.river.ordinal()] = riverScene;        
        
        Scene finishScene = new Scene();
        finishScene.setDescription("FINISH: They came and caught hold of the end of "
                + "the rod of iron; and they did press their way forward, "
                + "continually holding fast to the rod of iron, until they "
                + "came forth and fell down and partook of the fruit of the tree.");
        //finishScene.setMapSymbol(" FN ");
        finishScene.setBlocked(false);
        scenes[SceneType.finish.ordinal()] = finishScene;
        return scenes;
    }    
}
