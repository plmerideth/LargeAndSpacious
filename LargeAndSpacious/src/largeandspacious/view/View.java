/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import largeandspacious.LargeAndSpacious;
import largeandspacious.control.GameControl;
import largeandspacious.model.Item;
import largeandspacious.model.Location;
import largeandspacious.model.Map;
import largeandspacious.model.Player;

/**
 *
 * @author julzlee
 */
public abstract class View implements ViewInterface {
    
    private String promptMessage;
    protected final BufferedReader keyboard = LargeAndSpacious.getInFile();
    protected final PrintWriter console = LargeAndSpacious.getOutFile();
    
    public View(String promptMessage) {
        this.promptMessage = promptMessage;
    }
    
    @Override
    public void display() {
        boolean done = false;
        
        do
        {
            this.console.println(this.promptMessage); // display the menu
            
            String input = this.getInput();  // get the user's selection
            
            done = this.doAction(input); // do action based on selection            
                    
        } while (!done); // the selection is not "Return to Menu"
    }
    
    @Override
    public String getInput() {
        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        String playersInput = null;

        try
        {
            while( !valid )
            {
                //Prompt for the player's selection
                this.console.println("Enter the menu selection below:");

                //Get the name from the keyboard and trim off spaces
                playersInput = this.keyboard.readLine();

                playersInput = playersInput.trim();
                playersInput = playersInput.toUpperCase();

                if( playersInput.length() < 1 )
                {
                    this.console.println("Invalid menu selection - the selection must not be blank");
                    continue;
                }
                break;
            }
        }
        catch(Exception e)
        {
            this.console.println("Error reading input: " + e.getMessage());
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

 
