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
import largeandspacious.exceptions.MapControlException;
import largeandspacious.model.Actor;
import largeandspacious.model.Game;
import largeandspacious.model.Item;
import largeandspacious.model.Location;
import largeandspacious.model.Map;
import largeandspacious.model.Player;
import largeandspacious.model.Questions;

/**
 *
 * @author julzlee
 */
public class GameControl implements Serializable
{
       
    public static void createNewGame(Player player) throws MapControlException
    {      
        
        Game game = new Game();
        
        //Create game obj to hold all game data for save and resume
        LargeAndSpacious.setCurrentGame(game);
        game.setPlayer(player);
        
        //Create array (inventoryList) to hold inventory of items.
        Item[] inventoryList = GameControl.createInventoryList();
        //Set pointer to inventoryList in game.
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
        fruit.setValue(2);
        fruit.setRequiredAmount(0);
        inventory[inventoryItem.fruit.ordinal()] = fruit;
        
        Item obedience = new Item();
        obedience.setDescription("obedience             ");
        obedience.setValue(2);
        obedience.setRequiredAmount(0);
        inventory[inventoryItem.obedience.ordinal()] = obedience;
        
        Item testimony = new Item();
        testimony.setDescription("testimony             ");
        testimony.setValue(2);
        testimony.setRequiredAmount(0);
        inventory[inventoryItem.testimony.ordinal()] = testimony;
        
        Item ironRod = new Item();
        ironRod.setDescription("Rod of Iron           ");
        ironRod.setRequiredAmount(0);
        inventory[inventoryItem.ironRod.ordinal()] = ironRod;
        
        Item path = new Item();
        path.setDescription("Straight & Narrow Path");
        path.setRequiredAmount(0);
        inventory[inventoryItem.path.ordinal()] = path;
        
        Item man = new Item();
        man.setDescription("Man in White Robe     ");
        man.setRequiredAmount(0);
        inventory[inventoryItem.man.ordinal()] = man;
        
        return inventory;
    } 

    public static void assignScenesAndQuestionsToLocations(Map map, Scene[] scenes, Questions[] questionList)
    {
        Location[][] locations = map.getLocations();
        
        int rows = map.getNoOfRows();
        int cols = map.getNoOfColumns();
        int randomIndex;
        
        //Loop thru array, generate random number between 0 and NUMBER_OF_SCENES-1 to serve as index
        for(int i=0, questionNumber=0; i<rows; i++)
            for(int j=0; j<cols; j++, questionNumber++)
            {
                randomIndex = (int)Math.floor(Math.random()*(Constants.NUMBER_OF_SCENES));
                locations[i][j].setScene(scenes[randomIndex]);
                if(questionNumber==Constants.NUMBER_OF_QUESTIONS)
                    questionNumber = 0; //Start over with first question
                locations[i][j].setQuestions(questionList[questionNumber]);
            }
        
        //DEBUG:  Print all locations to console
        /*
        for(int i=0; i<rows; i++)
            for(int j=0; j<cols; j++)
            {
                String myDesc = "["+i+"]}"+"["+j+"]="+locations[i][j].getSceneType().getDescription()+"\n";
                System.out.println(myDesc);
            }
        */        
    }
    
    public static void getLocationScenes(Map map,int x, int y)
    {
        Location[][] locations = map.getLocations();
        
        //pass in the location to get the scene
        locations[x][y].getScene();
        
        //DEBUG:  Print all locations to console
        String myDesc = "["+x+"]}"+"["+y+"]="+locations[x][y].getScene().getDescription()+"\n";
        System.out.println(myDesc);
                            
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
