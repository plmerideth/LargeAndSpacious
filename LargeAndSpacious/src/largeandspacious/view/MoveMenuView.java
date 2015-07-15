
package largeandspacious.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import largeandspacious.LargeAndSpacious;
import largeandspacious.model.Location;
import largeandspacious.model.Player;

/**
 *
 * @author Paul Merideth
 */
public class MoveMenuView
{
    protected final BufferedReader keyboard = LargeAndSpacious.getInFile();
    protected final PrintWriter console = LargeAndSpacious.getOutFile();

    private final String ROLLDICE = "\n"
        + "\n|------------------------------------------|"
        + "\n|  Press R to roll dice!                   |"
        + "\n|------------------------------------------|";
    
    private final String XMENU = "\n"
        + "\n|------------------------------------------|"
        + "\n| Enter X location                         |"
        + "\n| X - Return to Previous Menu              |"                
        + "\n|------------------------------------------|";
                
    private final String YMENU = "\n"
        + "\n|------------------------------------------|"
        + "\n| Enter Y location                         |"
        + "\n| X - Return to Previous Menu              |"                
        + "\n|------------------------------------------|";
             
    private int xCoord;
    private int yCoord;
        
    Location selectLocation()
    {
        Location newLocation = new Location();
        //Get X coordinate
        //char selection = ' ';
        int number = -1;
        String input = "";
        
        while(number < 0)
        {
            this.console.println(XMENU); // display the SelectResource menu            
            
            input = this.getInput('X');  // get the user's selection
            
            if(input.equals("X"))
                break;      
           
            try{
                number = parseInt(input);
            } catch( NumberFormatException nf){
                this.console.println("\nYou must enter a valid number." +
                        "Try again or enter X to exit");
            }
                
            if(!validateX(number))
                number = -1;            
        }

        if( !input.equals("X"))
        {
            this.console.println("Player entered " + number + " for X coordinate");
            newLocation.setRow(number);
        
            //Get Y coordinate
            number = -1;
            while(number < 0)
            {
                this.console.println(YMENU); // display the SelectResource menu            

                input = this.getInput('Y');  // get the user's selection

                if(input.equals("X"))
                    break;      

                try{
                    number = parseInt(input);
                }catch( NumberFormatException nf)
                {
                    this.console.println("\nYou must enter a valid number." +
                        "Try again or enter X to exit");                
                }
                if(!validateY(number))
                    number = -1;            
            }
            
            if(!input.equals("X"))
            {
                this.console.println("Player entered " + number + " for Y coordinate");
                this.console.println("Valid map coordinates entered");
                newLocation.setCol(number);                
            }            
        }
        return newLocation;
    }
        
    private String getInput(char coord)
    {
        boolean valid = false;
        String playersInput = null;
        
        try
        {
            while( !valid )
            {
                //Prompt for the player's selection
                if(coord == 'X')
                    this.console.println("Enter X location below:");
                if(coord == 'Y') {
                    this.console.println("Enter Y location below:");
                }

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
    
    private boolean validateX(int number)
    {
        if (number>=1 && number<=10) {
            xCoord = number;
            return true;
        }
        else
        {
            this.console.println("Invalid X coordinate\nPlease enter a valid coordinate");
            return false;
        }
    }
    
    private boolean validateY(int number)
    {
        if (number>=1 && number<=10) {
            yCoord = number;
            this.console.println(Location(xCoord,yCoord));
            return true;
        }
        else
        {
            this.console.println("Invalid Y coordinate\nPlease enter a valid coordinate");
            return false;
        }
    }    
    
    int rollDice()
    {
        char selection = ' ';
        int diceValue = 0;
        do
        {
            this.console.println(ROLLDICE); // display the SelectResource menu
            
            String input = this.getDiceInput();  // get the user's selection
            selection = input.charAt(0);  // get first character of string
            if(selection != 'R')
                this.console.println("\nInvalid entry.  Please try again");
        }while (selection != 'R'); // the selection must be 'R' to roll dice
        //this.console.println("\n*** rollDice() function called ***");
        
        //Add code to roll dice (1-6) and return diceValue here
        diceValue = (int)(Math.random()*6) + 1;
        this.console.println("Player rolled a " + diceValue + "!");
        return diceValue;
    }

    private String getDiceInput()
    {
        boolean valid = false;
        String playersInput = null;
        
        try
        {
            while( !valid )
            {            
                //Get the name from the keyboard and trim off spaces
                playersInput = this.keyboard.readLine();
                playersInput = playersInput.trim();
                playersInput = playersInput.toUpperCase();

                if( playersInput.length() < 1 )
                {
                    this.console.println("Invalid Entry - the entry must not be blank");
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
        private String Location(int x, int y) {

            // build the beginning of the map since it will always be the same
            String temp = "\n"
            + "\n   |---------------------------|"
            + "\n   | 1 | 2 | 3 | 4 | 5 | 6 | 7 |"
            + "\n---|---------------------------|";
            // if we don't have valid coordinates, return the invalid coordinates string.
            /*
            if (x > 5 || y > 7) {
                return "Invalid x and y coordinates";
            }     
            else {
            */       
                // Get x coordinate
                for (int j = 1; j <6; j++) {
                    if (x == j) {
                        // if they match put an X in the right coordinate on the map
                        // Get y coordinate
                        temp = temp + "\n " + j + " | "; 
                        for (int i = 1; i < 8; i++) {
                            
                            if (y == i) {
                                temp = temp + "X | ";
                            }
                            else {
                                temp = temp + "  | ";
                            }    
                        }
                        
                        temp = temp + "\n---|---------------------------|";
                    }
                    else {
                        temp = temp + "\n " + j + " |   |   |   |   |   |   |   |";
                        temp = temp + "\n---|---------------------------|";
                    }                            
        }
            return temp;
        }
        
}
