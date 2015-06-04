package largeandspacious.view;

import java.util.Scanner;
import largeandspacious.control.ProgramControl;
import largeandspacious.model.Player;

/**
 *
 * @author Paul Merideth
 */
public class StartProgramView
{
    public void startProgram()
    {
        //BEGIN
            //Display banner screen
            this.displayBanner();   
            
            //Get the player's name
            String playersName = this.getPlayersName();
            
            //Create a new player
            Player player = ProgramControl.createPlayer(playersName);
            
            //Display a custom welcome message
            this.displayWelcomeMessage(player);
            
            //Display the main menu
            MainMenuView mainMenu = new MainMenuView();
            mainMenu.displayMenu();
        //END
    }

    private void displayBanner()
    {
        System.out.println("\n\n********************************************************");
         
        System.out.println("*                                                      *"
                       + "\n* This is the game of The Large and Spacious Building  *"
                       + "\n* In this game you will attempt to cross the dark and  *"
                       + "\n* dreary wilderness and reach the Tree of Life.        *");
        
        System.out.println("*                                                      *"
                       + "\n* You will roll the dice to determine how many         *"
                       + "\n* spaces you can move.  Each location you land on      *"
                       + "\n* contains a question you must answer.  If you answer  *"
                       + "\n* correctly, you will earn fruit and either testimony  *"
                       + "\n* or obedience points, based on your choice at the     *"
                       + "\n* beginning of the question.                           *");

        System.out.println("*                                                      *"
                       + "\n* If you answer incorrectly, you must face a challenge *"
                       + "\n* to determine if you win or lose the points.          *");                   
    }

    private String getPlayersName()
    {
        boolean valid = false;
        String playersName = null;
        Scanner keyboard = new Scanner(System.in);
        
        while( !valid )
        {
            //Prompt for the player's name
            System.out.println("Enter the player's name below:");
            
            //Get the name from the keyboard and trim off spaces
            playersName = keyboard.nextLine();
            playersName = playersName.trim();
            
            if( playersName.length() < 1 )
            {
                System.out.println("Invalid name - the name must not be blank");
                continue;
            }
            break;
        }
        return playersName;
    }

    public void displayWelcomeMessage(Player player)
    {
        System.out.println("\n\n=================================================");
        System.out.println("\tWelcome to the game " + player.getName());
        System.out.println("\tHave fun!");
        System.out.println("=================================================");
    }
}
