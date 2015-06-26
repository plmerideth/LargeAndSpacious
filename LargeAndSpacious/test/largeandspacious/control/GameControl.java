/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.control;
import java.io.Serializable;
import largeandspacious.LargeAndSpacious;
import largeandspacious.model.Player;
import largeandspacious.model.Game;
import largeandspacious.model.Item;
import largeandspacious.model.Map;

/**
 *
 * @author julzlee
 */
public class GameControl implements Serializable {
    
    public static void createNewGame(Player player) {
        Game game = new Game(); //create mew game
        LargeAndSpacious.setCurrentGame(game); //save in LargeAndSpacious
        
        game.setPlayer(player);  // save the player in the game
        
        //create the inventory list and save it in the game
        Item[] itemList = GameControl.createInventoryList();
        game.setItem(itemList);
        
        Map map = MapControl.createMap();
        game.setMap(map);
        
        MapControl.moveActorsToStartingLocation(map);
        
        
    }

    private static Item[] createInventoryList() {
        System.out.println("\n*** createInventoryList stub function called ***");
        return null;
    }
    
}
