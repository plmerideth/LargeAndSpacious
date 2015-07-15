package largeandspacious.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import largeandspacious.LargeAndSpacious;
import largeandspacious.control.ActorControl;
import largeandspacious.control.ProgramControl;
import largeandspacious.model.Actor;
import largeandspacious.model.Game;
import largeandspacious.model.Item;
import largeandspacious.model.Player;

/**
 *
 * @author Paul Merideth
 */
public class StartProgramView
{
    protected final BufferedReader keyboard = LargeAndSpacious.getInFile();
    protected final PrintWriter console = LargeAndSpacious.getOutFile();
    
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
            
            //Get the Actor for the game
            String actorName = this.getActor();
            
            //Display the main menu
            MainMenuView mainMenu = new MainMenuView();
            mainMenu.display();
        //END
    }

    private void displayBanner()
    {
        this.console.println("\n\n********************************************************");
         
        this.console.println("*                                                      *"
                       + "\n* This is the game of The Large and Spacious Building  *"
                       + "\n* In this game you will attempt to cross the dark and  *"
                       + "\n* dreary wilderness and reach the Tree of Life.        *");
        
        this.console.println("*                                                      *"
                       + "\n* You will roll the dice to determine how many         *"
                       + "\n* spaces you can move.  Each location you land on      *"
                       + "\n* contains a question you must answer.  If you answer  *"
                       + "\n* correctly, you will earn fruit and either testimony  *"
                       + "\n* or obedience points, based on your choice at the     *"
                       + "\n* beginning of the question.                           *");

        this.console.println("*                                                      *"
                       + "\n* If you answer incorrectly, you must face a challenge *"
                       + "\n* to determine if you win or lose the points.          *");                   
    }

    private String getPlayersName()
    {
        boolean valid = false;
        String playersName = null;
        
        try
        {
            while( !valid )
            {
                //Prompt for the player's name
                this.console.println("Enter the player's name below:");

                //Get the name from the keyboard and trim off spaces
                playersName = this.keyboard.readLine();
                playersName = playersName.trim();

                if( playersName.length() < 1 )
                {
                    this.console.println("Invalid name - the name must not be blank");
                    continue;
                }
                break;
            }
        }
        catch(Exception e)
        {
            this.console.println("Error reading input: " + e.getMessage());
        }
        return playersName;
    }
    
    private String getActor()
    {
        boolean valid = false;
        String actorName = null;
        
        try
        {
            while( !valid )
            {
                //Show the actors and prompt the user to type in an actor name
                this.console.println(ActorControl.showActors());
                this.console.println("Enter the character's name you want to be below:");

                //Get the name from the keyboard and trim off spaces
                actorName = this.keyboard.readLine();
                actorName = actorName.trim();

                if( actorName.length() < 1 )
                {
                    this.console.println("Invalid name - the name must not be blank");
                    continue;
                } else {
                    //this.console.println("The name entered is " + actorName);
                    switch (actorName.toUpperCase()) {
                            case "LEHI":
                                LargeAndSpacious.setActor(Actor.Lehi);
                                break;
                            case "SARIAH":
                                LargeAndSpacious.setActor(Actor.Sariah);
                                break;
                            case "NEPHI":
                                LargeAndSpacious.setActor(Actor.Nephi);
                                break;
                            case "JACOB":
                                LargeAndSpacious.setActor(Actor.Jacob);
                                break;
                            case "SAM":
                                LargeAndSpacious.setActor(Actor.Sam);
                                break;
                            case "LAMAN":
                                LargeAndSpacious.setActor(Actor.Laman);
                                break;
                            case "LEMUEL":
                                LargeAndSpacious.setActor(Actor.Lemuel);
                                break;
                            case "ZORAM":
                                LargeAndSpacious.setActor(Actor.Zoram);
                                break;
                            default:
                               this.console.println("Invalid name - please enter a name from the list"); 
                    }

                }
                break;
            }
        }
        catch(Exception e)
        {
            this.console.println("Error reading input: " + e.getMessage());
        }
        return actorName;
    }

    public void displayWelcomeMessage(Player player)
    {
        this.console.println("\n\n=================================================");
        this.console.println("\tWelcome to the game " + player.getName());
        this.console.println("\tHave fun!");
        this.console.println("=================================================");
    }
}
