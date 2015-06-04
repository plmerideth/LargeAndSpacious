/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.view;

import java.util.Scanner;

/**
 *
 * @author julzlee
 */
public class GameMenuView {
    
    private final String MENU = "\n"
            + "\n|------------------------------------------|"
            + "\n|  Game Menu                               |"
            + "\n|------------------------------------------|"
            + "\n| M - Move to a map location (Move Menu)   |"
            + "\n| D - Display Map                          |"
            + "\n| I - List player items                    |"
            + "\n| C - List challenges                      |"
            + "\n| R - Return to Main Menu                  |"
            + "\n| H - Help                                 |"
            + "\n| E - Exit                                 |"
            + "\n|------------------------------------------|";

    
    public void displayMenu() {
        char selection = ' ';
        do {
            System.out.println(MENU); // display the main menu
            
            String input = this.getInput();  // get the user's selection
            selection = input.charAt(0);  // get first character of string
            
            this.doAction(selection); // do action based on selection
        } while (selection != 'E'); // the selection is not "Exit"
        System.out.println("\n*** displayMenu stub function called ***");
    }

    private String getInput() {
        boolean valid = false;
        String playersInput = null;
        Scanner keyboard = new Scanner(System.in);
        
        while( !valid )
        {
            //Prompt for the player's name
            System.out.println("Enter the menu selection below:");
            
            //Get the name from the keyboard and trim off spaces
            playersInput = keyboard.nextLine();
            playersInput = playersInput.trim();
            
            if( playersInput.length() < 1 )
            {
                System.out.println("Invalid menu selection - the selection must not be blank");
                continue;
            }
            break;
        }
        return playersInput;
    }

    private void doAction(char selection) {
        switch (selection) {
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
                //Return to Main Menu
                this.returnToMainMenu();
                break;
            case 'H':
                //Help menu
                this.displayHelpMenu();
                break;
            case 'E':
                //Exit
                break;
            default: 
                System.out.println("Invalid selection");
                break;
        }
    }

    private void displayHelpMenu() {
        System.out.println("*** displayHelpMenu function called ***");
    }

    private void displayMoveMenu() {
        System.out.println("*** displayMoveMenu function called ***");
    }

    private void displayMap() {
        System.out.println("*** displayMap function called ***");
    }

    private void displayPlayerItems() {
        System.out.println("*** displayPlayerItems function called ***");
    }

    private void listChallenges() {
        System.out.println("*** listChallenges function called ***");
    }

    private void returnToMainMenu() {
        System.out.println("*** returnToMainMenu function called ***");
    }
    
}
