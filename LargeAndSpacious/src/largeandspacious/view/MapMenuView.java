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
public class MapMenuView {
    
    private final String MENU = "\n"
            + "\n   |---------------------------|"
            + "\n   | 1 | 2 | 3 | 4 | 5 | 6 | 7 |"
            + "\n---|---------------------------|"
            + "\n 1 |   |   |   |   |   |   |   |"
            + "\n---|---------------------------|"
            + "\n 2 |   |   |   |   |   |   |   |"
            + "\n---|---------------------------|"
            + "\n 3 |   |   |   |   |   |   |   |"
            + "\n---|---------------------------|"
            + "\n 4 |   |   |   |   |   |   |   |"
            + "\n---|---------------------------|"
            + "\n 5 |   |   |   |   |   |   |   |"
            + "\n---|---------------------------|"
            + "\n   | E - Exit Map              |"
            + "\n---|---------------------------|";
    
     public void displayMenu() {
        char selection = ' ';
        do {
            System.out.println(MENU); // display the game menu
            
            String input = this.getInput();  // get the user's selection
            selection = input.charAt(0);  // get first character of string
            
            this.doAction(selection); // do action based on selection
        } while (selection != 'E'); // the selection is not "Return to Main Menu"
        System.out.println("\n*** GameMenuView displayMenu stub function called ***");
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
        //System.out.println(Location(1,2));
        return playersInput;
    }

    private void doAction(char selection) {
        switch (selection) {
            case 'E':
                break;
            default:
                System.out.println("Invalid selection");
                break;
            
        }
    }
    


    
}
