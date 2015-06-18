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
public abstract class View implements ViewInterface {
    
    private String promptMessage;
    
    public View(String promptMessage) {
        this.promptMessage = promptMessage;
    }
    
    @Override
    public void display() {
        boolean done = false;
        
        do {
            System.out.println(this.promptMessage); // display the menu
            
            String input = this.getInput();  // get the user's selection
            
            done = this.doAction(input); // do action based on selection
        } while (!done); // the selection is not "Return to Menu"
        System.out.println("\n*** GameMenuView displayMenu stub function called ***");
    }
    
    @Override
    public String getInput() {
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

    public String getPromptMessage() {
        return promptMessage;
    }

    public void setPromptMessage(String promptMessage) {
        this.promptMessage = promptMessage;
    }
    
    
}

 
