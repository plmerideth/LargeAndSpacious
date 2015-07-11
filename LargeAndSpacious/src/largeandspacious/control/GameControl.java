/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import largeandspacious.LargeAndSpacious;
import largeandspacious.control.Scene.SceneType;
import largeandspacious.exceptions.MapControlException;
import largeandspacious.model.Actor;
import largeandspacious.model.Game;
import largeandspacious.model.Item;
import largeandspacious.model.Location;
import largeandspacious.model.Map;
import largeandspacious.model.Player;

/**
 *
 * @author julzlee
 */
public class GameControl implements Serializable
{
       
    public static void createNewGame(Player player) throws MapControlException
    {      
        Actor actor = Actor.Lehi;
        
        Game game = new Game();
        
        LargeAndSpacious.setCurrentGame(game);
        game.setPlayer(player);
        
        Item[] inventoryList = GameControl.createInventoryList();
        game.setInventory(inventoryList);
        
        Map map = MapControl.createMap();
        game.setMap(map);
        
        MapControl.moveActorsToStartingLocation(map);
        
    }
    
    public static Item[] createInventoryList()
    {                
        // created an array(list) of inventory items
        Item[] inventory = new Item[Constants.NUMBER_OF_INVENTORY_ITEMS];
        
        Item fruit = new Item();
        fruit.setDescription("fruit                 ");
        fruit.setQuantityInStock(5);
        fruit.setValue(2);
        fruit.setRequiredAmount(0);
        inventory[inventoryItem.fruit.ordinal()] = fruit;
        
        Item obedience = new Item();
        obedience.setDescription("obedience             ");
        obedience.setQuantityInStock(5);
        obedience.setValue(3);
        obedience.setRequiredAmount(0);
        inventory[inventoryItem.obedience.ordinal()] = obedience;
        
        Item testimony = new Item();
        testimony.setDescription("testimony             ");
        testimony.setQuantityInStock(5);
        testimony.setValue(4);
        testimony.setRequiredAmount(0);
        inventory[inventoryItem.testimony.ordinal()] = testimony;
        
        Item ironRod = new Item();
        ironRod.setDescription("Rod of Iron           ");
        ironRod.setQuantityInStock(0);
        ironRod.setRequiredAmount(0);
        inventory[inventoryItem.ironRod.ordinal()] = ironRod;
        
        Item path = new Item();
        path.setDescription("Straight & Narrow Path");
        path.setQuantityInStock(0);
        path.setRequiredAmount(0);
        inventory[inventoryItem.path.ordinal()] = path;
        
        Item man = new Item();
        man.setDescription("Man in White Robe     ");
        man.setQuantityInStock(0);
        man.setRequiredAmount(0);
        inventory[inventoryItem.man.ordinal()] = man;
        
        return inventory;
    } 

    public static void assignScenesToLocations(Map map, Scene[] scenes)
    {
        Location[][] locations = map.getLocations();
        
        locations[0][0].setScene(scenes[SceneType.start.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.building.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.mists.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.finger.ordinal()]);        
        locations[0][4].setScene(scenes[SceneType.path.ordinal()]);        
        locations[0][5].setScene(scenes[SceneType.tree.ordinal()]);        
        locations[0][6].setScene(scenes[SceneType.river.ordinal()]);
        locations[0][7].setScene(scenes[SceneType.finish.ordinal()]);
        locations[0][8].setScene(scenes[SceneType.tree.ordinal()]);
        locations[0][9].setScene(scenes[SceneType.tree.ordinal()]);

        locations[1][0].setScene(scenes[SceneType.start.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.building.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.mists.ordinal()]);
        locations[1][3].setScene(scenes[SceneType.finger.ordinal()]);        
        locations[1][4].setScene(scenes[SceneType.path.ordinal()]);        
        locations[1][5].setScene(scenes[SceneType.tree.ordinal()]);        
        locations[1][6].setScene(scenes[SceneType.river.ordinal()]);
        locations[1][7].setScene(scenes[SceneType.finish.ordinal()]);
        locations[1][8].setScene(scenes[SceneType.tree.ordinal()]);
        locations[0][9].setScene(scenes[SceneType.tree.ordinal()]);
    }

    public static Item[] getSortedInventoryList()
    {
        Item[] originalInventoryList = LargeAndSpacious.getCurrentGame().getInventory();
        Item[] inventoryList = originalInventoryList.clone();      
        Item temp;
        
        /* Use insertion sort to list in order */
        for (int i=1; i<inventoryList.length; i++) {
            for(int j=i ; j>0 ; j--){
                if(inventoryList[j].getDescription().compareToIgnoreCase(inventoryList[j-1].getDescription()) < 0)
                {
                    temp = inventoryList[j];
                    inventoryList[j] = inventoryList[j-1];
                    inventoryList[j-1] = temp;
                }
            }
        }

        /*  Bubble sort example
        Item tempInventoryItem;
 
        for(int i=0; i<inventoryList.length-1; i++)
        {
            for(int j=0; j<inventoryList.length-1-i; j++)
            {
                if(inventoryList[j].getDescription().compareToIgnoreCase(inventoryList[j+1].getDescription())>0)
                {
                    tempInventoryItem = inventoryList[j];
                    inventoryList[j] = inventoryList[j+1];
                    inventoryList[j+1] = tempInventoryItem;
                }
            }
        }
        */
        return inventoryList;
    }

    public static void saveGame(Game game, String filePath) 
            throws MapControlException {
        try ( FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            output.writeObject(game); //write the game object out to file
        } catch (IOException e) {
            throw new MapControlException(e.getMessage());
        }
    }

    public static void getSavedGame(String filePath) throws MapControlException  {
        
        Game game = null;
        
        try(FileInputStream fips = new FileInputStream(filePath)) {
            ObjectInputStream input = new ObjectInputStream(fips);
            
            game = (Game) input.readObject(); //read the game object from file
        } catch (FileNotFoundException fnfe) {
            throw new MapControlException(fnfe.getMessage());
        } catch (Exception e) {
            throw new MapControlException(e.getMessage());
        }
        // close the output file
        LargeAndSpacious.setCurrentGame(game); // save in LargeAndSpacious
        
    }
    

    public enum inventoryItem
    {
        fruit,
        obedience,
        testimony,
        ironRod,
        path,
        man
    }
    
}
