package largeandspacious.view;

import java.util.Scanner;

/**
 *
 * @author Paul Merideth
 */
public class SelectResourceView
{
    private final String MENU = "\n"
        + "\n|------------------------------------------|"
        + "\n|  Select Resource Menu                    |"
        + "\n|------------------------------------------|"
        + "\n| O - Play for Obedience                   |"
        + "\n| T - Play for Testimony                   |"
        + "\n| -----------------------------------------|"
        + "\n|   Use an Attribute                       |"
        + "\n| I - Rod of Iron                          |"
        + "\n| S - Straight and Narrow Path             |"
        + "\n| W - Man in White Rob                     |"
        + "\n| R - Return to Game Menu                       |"
        + "\n|------------------------------------------|";

    void displayMenu()
    {
        char selection = ' ';
        do
        {
            System.out.println(MENU); // display the SelectResource menu
            
            String input = this.getInput();  // get the user's selection
            selection = input.charAt(0);  // get first character of string
            
            this.doAction(selection); // do action based on selection
        }while (selection != 'R'); // the selection is not "Return to Menu"
        System.out.println("\n*** HelpMenuView displayMenu stub function called ***");
    }

    private String getInput()
    {
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

    private void doAction(char selection)
    {
        switch (selection)
        {
            case 'O': 
                //Play for obedience
                this.selectObedience();
                break;
            case 'T': 
                //Play for Testimony
                this.selectTestimony();
                break;                
            case 'I': 
                //Use Rod of Iron
                this.useRodOfIron();
                break;
            case 'S': 
                //Use Straight and Narrow
                this.useStraightAndNarrow();
                break;
            case 'W': 
                //Use Man in White Robe
                this.useManInWhiteRobe();
                break;
            default: 
                System.out.println("Invalid selection");
                break;
        }
    }

    private void selectObedience()
    {
        System.out.println("*** selectObedience function called ***");        
    }

    private void selectTestimony()
    {
        System.out.println("*** selectTestimony function called ***");                
    }

    private void useRodOfIron()
    {
        System.out.println("*** useRodOfIron function called ***");                        
    }

    private void useStraightAndNarrow()
    {
        System.out.println("*** useStraightAndNarrow function called ***");                
    }

    private void useManInWhiteRobe()
    {
        System.out.println("*** useManInWhiteRobe function called ***");                        
    }
}
