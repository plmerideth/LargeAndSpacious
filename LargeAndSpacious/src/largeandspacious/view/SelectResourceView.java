package largeandspacious.view;

import static java.lang.Double.parseDouble;
import java.util.IllegalFormatException;
import java.util.Scanner;

/**
 *
 * @author Paul Merideth
 */
public class SelectResourceView extends View
{
    public SelectResourceView()
    {
        super("\n"
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
            + "\n| X - Return to Game Menu                  |"
            + "\n|------------------------------------------|");
    }

    @Override
    public boolean doAction(Object obj)
    {
        String value = (String) obj;
        value = value.toUpperCase();
        char choice = value.charAt(0);
        boolean done = false;
                        
        switch(choice)
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
            case 'X':
                //Return to game menu
                done = true;
                break;
            default: 
                this.console.println("Invalid selection");
                break;
        }
        return done;
    }

    private double selectObedience()
    {
        boolean valid = false;
        double playersObedience = 0;
        
        while( !valid )
        {
            //tell the player what scene they have landed on
            this.console.println("\nEnter the number of obedience points you wish to use below:");
            
            try
            {
                //Get the points from the keyboard 
                playersObedience = parseDouble(this.keyboard.readLine());
            }
            catch( NumberFormatException nf)
            {
                ErrorView.display(this.getClass().getName(), "\nYou must enter a valid number." +
                        "Try again or enter X to exit");
                break;
            }
            catch(Exception e)
            {
                ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
            }
            
            
            if( playersObedience == 0 )
            {
                this.console.println("Invalid - obedience points must be greater than 0.");
                continue;
            }
            break;
        }
        return playersObedience;        
    }

    private double selectTestimony()
    {
        boolean valid = false;
        double playersTestimony = 0;
        
        while( !valid )
        {
            //tell the player what scene they have landed on
            this.console.println("\nEnter the number of testimony points you wish to use below:");
            
            try
            {
                //Get the points from the keyboard 
                playersTestimony = parseDouble(this.keyboard.readLine());
            }
            catch( NumberFormatException nf)
            {
                ErrorView.display(this.getClass().getName(), "\nYou must enter a valid number." +
                        "Try again or enter X to exit");
                break;
            }
            catch(Exception e)
            {
                ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
            }
            
            
            if( playersTestimony == 0 )
            {
                this.console.println("Invalid - testimony points must be greater than 0.");
                continue;
            }
            break;
        }
        return playersTestimony; 
    }

    private double useRodOfIron()
    {
        boolean valid = false;
        double rodOfIron = 0;
        String response = "";
        
        while( !valid )
        {
            //tell the player what scene they have landed on
            this.console.println("\nEnter the number of Rod of Iron points you wish to use below:");
            
            try
            {
                //Get the points from the keyboard 
                rodOfIron = parseDouble(this.keyboard.readLine());
                
            }
            catch( IllegalFormatException ife)
            {
                ErrorView.display(this.getClass().getName(), "\nYou must enter a valid number." +
                        "Try again or enter X to exit");
                break;
            }
            catch(Exception e)
            {
                ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
            }
           
            break;
        }
        return rodOfIron;                        
    }

    private double useStraightAndNarrow()
    {
        boolean valid = false;
        double straightNarrow = 0;
        String response = "";
        
        while( !valid )
        {
            //tell the player what scene they have landed on
            this.console.println("\nEnter the number of Straight and Narrow points you wish to use below:");
            
            try
            {
                //Get the points from the keyboard 
                straightNarrow = parseDouble(this.keyboard.readLine());
            }
            catch( IllegalFormatException ife)
            {
                ErrorView.display(this.getClass().getName(), "\nYou must enter a valid number." +
                        "Try again or enter X to exit");
                break;
            }
            catch(Exception e)
            {
                ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
            }
            
            break;
        }
        return straightNarrow;
    }

    private double useManInWhiteRobe()
    {
        boolean valid = false;
        double manInWhite = 0;
        String response = "";
        
        while( !valid )
        {
            //tell the player what scene they have landed on
            this.console.println("\nEnter the number of Man in White Robe points you wish to use below:");
            
            try
            {
                //Get the points from the keyboard 
                manInWhite = parseDouble(this.keyboard.readLine());
            }
            catch( IllegalFormatException ife)
            {
                ErrorView.display(this.getClass().getName(), "\nYou must enter a valid number." +
                        "Try again or enter X to exit");
                break;
            }
            catch(Exception e)
            {
                ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
            }
            
            break;
        }
        return manInWhite;
    }
    private double getNumberInput(String item)
    {
        double playerInput = 0;
        
        try
        {
            //Get the points from the keyboard 
            playerInput = parseDouble(this.keyboard.readLine());
        }
        catch( NumberFormatException nf)
        {
            ErrorView.display(this.getClass().getName(), "\nYou must enter a valid number." +
                    "Try again or enter X to exit");
        }
        catch(Exception e)
        {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
        }
            
            
        if( playerInput == 0 )
        {
            this.console.println("Invalid - " + item + " points must be greater than 0.");
            return 0;
        }
        return playerInput;        
    }
    
}
