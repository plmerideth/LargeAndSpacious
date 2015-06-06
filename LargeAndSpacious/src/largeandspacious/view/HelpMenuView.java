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
public class HelpMenuView {
    
    private final String MENU = "\n"
            + "\n|------------------------------------------|"
            + "\n|  Help Menu                               |"
            + "\n|------------------------------------------|"
            + "\n| O - Overview of game                     |"
            + "\n| M - How to move                          |"
            + "\n| Q - Explains the quest                   |"
            + "\n| G - Explains the map                     |"
            + "\n| I - Explains how to use items            |"
            + "\n| L - Lists Items                          |"
            + "\n| C - Lists Challenges                     |"
            + "\n| R - Return to Menu                       |"
            + "\n|------------------------------------------|";
    
    public void displayMenu() {
        char selection = ' ';
        do {
            System.out.println(MENU); // display the help menu
            
            String input = this.getInput();  // get the user's selection
            selection = input.charAt(0);  // get first character of string
            
            this.doAction(selection); // do action based on selection
        } while (selection != 'R'); // the selection is not "Return to Menu"
        System.out.println("\n*** HelpMenuView displayMenu stub function called ***");
    }

    private String getInput() {
        boolean valid = false;
        String playersInput = null;
        Scanner keyboard = new Scanner(System.in);
        
        while( !valid )
        {
            //Prompt for the player's selection
            System.out.println("Enter the menu selection below:");
            
            //Get the name from the keyboard and trim off spaces
            playersInput = keyboard.nextLine();
            playersInput = playersInput.trim();
            playersInput = playersInput.toUpperCase();
            
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
            case 'O': 
                //Overview of the Game
                this.displayGameOverview();
                break;
            case 'M': 
                //How to move
                this.displayMoveHelp();
                break;
            case 'Q': 
                // Explains the quest 
                this.displayQuestHelp();
                break;
            case 'G': 
                // Explains the map
                this.displayMapHelp();
                break;
            case 'I': 
                // Explains how to use items 
                this.displayItemHelp();
                break;
            case 'L':
                //Lists Items
                this.displayItemList();
                break;
            case 'C':
                // Lists Challenges
                this.displayChallenges();
                break;
            case 'R':
                // Return to Menu  
                //this.returnToMainMenu();
                break;
            default: 
                System.out.println("Invalid selection");
                break;
        }
    }

    private void displayGameOverview() {
        String gameOverview = "\n|-------------------------------------------------|"
                + "\n| The Large and Spacious Building is an RPG where |"
                + "\n| the player has to journey through life making   |"
                + "\n| personal choices that will lead him/her         |"
                + "\n| across the dark and dreary wilderness, until    |"
                + "\n| the player reaches the tree of life and         |"
                + "\n| obtains eternal life.                           |"
                + "\n|-------------------------------------------------|";
        System.out.println(gameOverview);
    }

    private void displayMoveHelp() {
        System.out.println("*** displayMoveHelp function called ***");
    }

    private void displayQuestHelp() {
        System.out.println("*** displayQuestHelp function called ***");
    }

    private void displayMapHelp() {
        System.out.println("*** displayMapHelp function called ***");
    }

    private void displayItemHelp() {
        System.out.println("*** displayItemHelp function called ***");
    }

    private void displayItemList() {
        System.out.println("*** displayItemList function called ***");
    }

    private void displayChallenges() {
        System.out.println("*** displayChallenges function called ***");
    }

    
}
