/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.view;

import java.util.Scanner;
import largeandspacious.model.Location;

/**
 *
 * @author julzlee
 */
public class GameMenuView extends View {
    
    public GameMenuView(String promptMessage) {
    super("\n"
            + "\n|------------------------------------------|"
            + "\n|  Game Menu                               |"
            + "\n|------------------------------------------|"
            + "\n| S - Select a resource to use             |"
            + "\n| M - Move to a map location (Move Menu)   |"
            + "\n| D - Display Map                          |"
            + "\n| I - List player items                    |"
            + "\n| C - List challenges                      |"
            + "\n| R - Return to Menu                       |"
            + "\n| H - Help                                 |"
            + "\n|------------------------------------------|");

    }      


    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
    
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
            case 'R': 
                //Return to Menu
                break;
            case 'H':
                //Help menu
                this.displayHelpMenu();
                break;
            default: 
                System.out.println("Invalid selection");
                break;
        }
        return false;
    }

    
    private void displayHelpMenu() {
        //Create a new help Menu View
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayMenu();
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
        
        //MapMenuView mapMenu = new MapMenuView();
        //mapMenu.displayMenu();
        System.out.println("*** displayPlayerItems function called ***");
    }

    private void displayPlayerItems() {
        System.out.println("*** displayPlayerItems function called ***");
    }

    private void listChallenges() {
        //Create a new map Menu View
        //ChallengesView challenges = new ChallengesView();
        //challenges.displayMenu();
        System.out.println("*** listChallenges function called ***");
    }

    private void selectResource() {
                //Create SelectResourceView object
        SelectResourceView selectResource = new SelectResourceView();
        selectResource.displayMenu();
    }
    
}
