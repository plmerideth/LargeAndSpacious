package largeandspacious.view;

import java.util.Scanner;

/**
 *
 * @author Paul Merideth
 */
public abstract class View implements ViewInterface
{
    private String promptMessage;
    
    //View constructor
    public View(String promptMessage)
    {
        this.promptMessage = promptMessage;
    }

    @Override
    public void display() {
        String selection = "";
        boolean done = false;
        
        do {
            System.out.println(promptMessage); // display the main menu
            
            selection = this.getInput();  // get the user's selection
            done = this.doAction(selection);          
        } while(!done); 
    }

    @Override
    public String getInput()
    {
        boolean valid = false;
        String playersInput = null;
        Scanner keyboard = new Scanner(System.in);
        
        while( !valid )
        {           
            //Get the name from the keyboard and trim off spaces
            playersInput = keyboard.nextLine();
            playersInput = playersInput.trim();
            
            if( playersInput.length() < 1 )
            {
                System.out.println("You must enter a value");
                continue;
            }
            break;
        }
        return playersInput;
    }
    
    public String getPromptMessage()
    {
        return promptMessage;
    }
    
    public void setPromptMessage(String message)
    {
        this.promptMessage = message;
    }
}

