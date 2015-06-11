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
public class ChallengesView {
    
    private final String MENU = "\n"
            + "\n|-------------------------------------------------------|"
            + "\n|  Challenges                                        |"
            + "\n|-------------------------------------------------------|"
            + "\n| Finger of Scorn (Obedience damage)                    |"
            + "\n| Mists of Darkness (Testimony damage)                  |"
            + "\n| Pride (Obedience & Testimony damage)                  |"
            + "\n| Lost & Forbidden Path (Obedience & Testimony damage)  |"
            + "\n| Mocking & Pointing (Obedience damage)                 |"
            + "\n|-------------------------------------------------------|"
            + "\n| E - Exit menu                                         |"
            + "\n|-------------------------------------------------------|";
    
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
