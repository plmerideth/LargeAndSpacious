
package largeandspacious.view;

import java.util.Scanner;
import largeandspacious.model.Location;
import largeandspacious.model.Player;

/**
 *
 * @author Paul Merideth
 */
public class MoveMenuView
{
        private final String ROLLDICE = "\n"
        + "\n|------------------------------------------|"
        + "\n|  Press R to roll dice!                   |"
        + "\n|------------------------------------------|";

        private final String XMENU = "\n"
        + "\n|------------------------------------------|"
        + "\n| Enter X location                         |"
        + "\n| R - Return to Previous Menu              |"                
        + "\n|------------------------------------------|";

        private final String YMENU = "\n"
        + "\n|------------------------------------------|"
        + "\n| Enter Y location                         |"
        + "\n| R - Return to Previous Menu              |"                
        + "\n|------------------------------------------|";
        
        private int xCoord;
        private int yCoord;
        
        
    Location selectLocation()
    {
        Location newLocation = new Location();
        //Get X coordinate
        char selection = ' ';
        do
        {
            System.out.println(XMENU); // display the SelectResource menu
            
            String input = this.getInput('X');  // get the user's selection
            selection = input.charAt(0);  // get first character of string
        }while (!this.validateX(selection)); // Continue until a valid x coordinate
        if(selection != 'R')
        {
            System.out.println("Player entered " + selection + " for X coordinate");
            newLocation.setRow(Character.getNumericValue(selection));
        
            //Get Y coordinate
            selection = ' ';
            do
            {
                System.out.println(YMENU); // display the SelectResource menu

                String input = this.getInput('Y');  // get the user's selection
                selection = input.charAt(0);  // get first character of string
            }while (!this.validateY(selection)); // Continue until a valid x coordinate
            if(selection != 'R')
            {
                System.out.println("Player entered " + selection + " for Y coordinate");
                System.out.println("Valid location coordinates entered");
                newLocation.setCol(Character.getNumericValue(selection));
            }
        }
        return newLocation;
    }
    
    private String getInput(char coord)
    {
        boolean valid = false;
        String playersInput = null;
        Scanner keyboard = new Scanner(System.in);
        
        while( !valid )
        {
            //Prompt for the player's selection
            if(coord == 'X')
                System.out.println("Enter X location below:");
            if(coord == 'Y') {
                System.out.println("Enter Y location below:");
            }
            
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
    
    private boolean validateX(char selection)
    {
        if (selection>='1' && selection<='7') {
            xCoord = Character.getNumericValue(selection);
            return true;
        }
        else if (selection == 'R') {
            return true;
        }
        else
        {
            System.out.println(selection + " is an invalid X coordinate\nPlease enter a valid coordinate");
            return false;
        }
    }
    
    private boolean validateY(char selection)
    {
        if (selection>='1' && selection<='5') {
            yCoord = Character.getNumericValue(selection);
            System.out.println(Location(xCoord,yCoord));
            return true;
        }
        else if (selection=='R') {
            return true;
        }
        else
        {
            System.out.println(selection + " is an invalid Y coordinate\nPlease enter a valid coordinate");
            return false;
        }
    }    
    
    int rollDice()
    {
        char selection = ' ';
        int diceValue = 0;
        do
        {
            System.out.println(ROLLDICE); // display the SelectResource menu
            
            String input = this.getDiceInput();  // get the user's selection
            selection = input.charAt(0);  // get first character of string
        }while (selection != 'R'); // the selection must be 'R' to roll dice
        System.out.println("\n*** rollDice() function called ***");
        
        //Add code to roll dice and return diceValue here
        diceValue = (int)(Math.random()*6) + 1;
        System.out.println("Player rolled a " + diceValue + "!");
        return diceValue;
    }

    private String getDiceInput()
    {
        boolean valid = false;
        String playersInput = null;
        Scanner keyboard = new Scanner(System.in);
        
        while( !valid )
        {            
            //Get the name from the keyboard and trim off spaces
            playersInput = keyboard.nextLine();
            playersInput = playersInput.trim();
            playersInput = playersInput.toUpperCase();
            
            if( playersInput.length() < 1 )
            {
                System.out.println("Invalid Entry - the entry must not be blank");
                continue;
            }
            break;
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
            if (x > 5 || y > 7) {
                return "Invalid x and y coordinates";
            }     
            else {
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
                            
        }
            return temp;
        }
        
}
