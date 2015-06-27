/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.view;

// import java.util.Scanner;
import largeandspacious.control.GameControl;
import largeandspacious.model.Item;
import largeandspacious.model.Location;

/**
 *
 * @author julzlee
 */
public class GameMenuView extends View {
    
    public GameMenuView() {
        super("\n"
            + "\n|------------------------------------------|"
            + "\n|  Game Menu                               |"
            + "\n|------------------------------------------|"
            + "\n| S - Select a resource to use             |"
            + "\n| M - Move to a map location (Move Menu)   |"
            + "\n| D - Display Map                          |"
            + "\n| I - List player items                    |"
            + "\n| C - List challenges                      |"
            + "\n| A - List attributes                      |"                
            + "\n| X - Return to Main Menu                  |"
            + "\n| H - Help                                 |"
            + "\n|------------------------------------------|");
    }      

    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        boolean done = false;
        
        value = value.toUpperCase(); //convert to all upper case
        char choice = value.charAt(0); // get first character entered
        
        switch (choice) {
            case 'S':
                //Select a resource, if desired
                this.selectResource();
                break;
            case 'M': 
                //Move to a map location (Move Menu)
                this.displayMoveMenu();
                break;
            case 'D': 
                //Display Map
                this.displayMap();
                break;
            case 'I': 
                //List player items
                this.displayPlayerItems();
                break;
            case 'C': 
                // List challenges
                this.listChallenges();
                break;
            case 'A':
                //List Attributes
                this.listAttributes();
                break;
            case 'X':
                //Return to Menu
                done = true;
                break;
            case 'H':
                //Help menu
                this.displayHelpMenu();
                break;
            default: 
                System.out.println("Invalid selection");                
                break;
        }
        return done;
    }

    private void displayHelpMenu() {
        //Create a new help Menu View
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
        System.out.println("*** displayHelpMenu function called ***");
    }

    private void displayMoveMenu()
    {
        Location newLocation = new Location();
        
        MoveMenuView moveMenu = new MoveMenuView();
        moveMenu.rollDice();
        newLocation = moveMenu.selectLocation();
        
        //Add code to process move
    }

    public void displayMap() {
        //Create a new map Menu View
        
        MapMenuView mapMenu = new MapMenuView();
        mapMenu.display();
        System.out.println("*** displayPlayerItems function called ***");
    }

    private void displayPlayerItems()
    {
        String Desc;
        
        Item[] inventory = GameControl.getSortedInventoryList();
        System.out.println("\nList of Inventory Items");
        System.out.println("DESCRIPTION" + "\t\t\t" +
                           "VALUE" + "\t\t" +
                           "ITEM COUNT");
                
        for(Item inventoryItem : inventory)
        {            
            System.out.println(inventoryItem.getDescription() + "\t\t\t\t" + 
                               inventoryItem.getValue() + "\t\t" +
                               inventoryItem.getItemCount());
        }
    }

    private void listChallenges() {
        //Create a new map Menu View
        ChallengesView challenges = new ChallengesView();
        challenges.display();
    }

    private void selectResource() {
        //Create SelectResourceView object
        SelectResourceView selectResource = new SelectResourceView();
        selectResource.display();
    }

    private void listAttributes()
    {
        AttributeView attributes = new AttributeView();
        attributes.display();
    }
}
