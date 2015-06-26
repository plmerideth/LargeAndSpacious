/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.control;

import java.awt.image.BufferedImage;
import largeandspacious.control.Scene.SceneType;
import largeandspacious.model.Game;
import largeandspacious.model.Map;

/**
 *
 * @author julzlee
 */
public class MapControl {

   
    static void moveActorsToStartingLocation(Map map) {
        System.out.println("\n*** moveActorsToStartingLocation stub function called ***");
    }

    public static Map createMap() {
        
        //create the map
        Map map = new Map(10,10);
        
        //create a list of the different challenge scenes in the game
        //Scene[] scenes = createScenes();
        
        //assign the different scenes to location in the map
        //assignScenesToLocations(map, scenes);
        
        return map;
    }

    private static Scene[] createScenes() throws MapControlException {
        BufferedImage image = null;
        
        Game game = largeandspacious.LargeAndSpacious.getCurrentGame();
        
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
        
        Scene finishScene = new Scene();
        finishScene.setDescription("\n They came and caught hold of the end of "
                + "the rod of iron; and they did press their way forward, "
                + "continually holding fast to the rod of iron, until they "
                + "came forth and fell down and partook of the fruit of the tree.");
        //finishScene.setMapSymbol(" FN ");
        finishScene.setBlocked(false);
        //finishScene.setTravelTime(Double.POSITIVE_INFINITY);
        //ImageIcon finishSceneImage = MapControl.getImage(finishScene, "");
        //finishScene.setIcon(finishSceneImage);
        scenes[SceneType.finish.ordinal()] = finishScene;
        return null;
    }

    private static class MapControlException extends Exception {

        public MapControlException() {
        }
    }
    
}
