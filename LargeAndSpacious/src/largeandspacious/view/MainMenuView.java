/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.view;

import java.util.Scanner;
import static largeandspacious.LargeAndSpacious.getPlayer;
import largeandspacious.control.GameControl;
//import largeandspacious.control.ProgramControl;

/**
 *
 * @author julzlee
 */
public class MainMenuView {
    
    private final String MENU = "\n"
            + "\n|------------------------------------------|"
            + "\n|  Main Menu                               |"
            + "\n|------------------------------------------|"
            + "\n| G - Start game                           |"
            + "\n| H - Go to the help menu                  |"
            + "\n| P - Show players and high scores         |"
            + "\n| S - Save game                            |"
            + "\n| L - Load game                            |"
            + "\n| E - Exit game                            |"
            + "\n|------------------------------------------|";

    public void displayMenu() {
        char selection = ' ';
        do {
            System.out.println(MENU); // display the main menu
            
            String input = this.getInput();  // get the user's selection
            selection = input.charAt(0);  // get first character of string
            
            this.doAction(selection); // do action based on selection
        } while (selection != 'E'); // the selection is not "Exit"
        System.out.println("\n*** MainMenuView displayMenu stub function called ***");
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
        //BEGIN
        switch (selection) {
            case 'G': 
                //Start a new game
                this.startNewGame();
                break;
            case 'H': 
                //Display the help menu
                this.displayHelpMenu();
                break;
            case 'P': 
                //Display players and high scores
                this.displayPlayersScores();
                break;
            case 'S': 
                //Save the current game
                this.saveGame();
                break;
            case 'L': 
                //Load a saved game
                this.loadExistingGame();
                break;
            case 'E':
                //Exit the game
                break;
            default: 
                System.out.println("Invalid selection");
                break;
        }
    }

    public void startNewGame() {
       
        //Create a new Game
        GameControl.createNewGame(getPlayer());
        //Create a new Game Menu View
        
        //GameMenuView gameMenu = new GameMenuView();
        //Display the Game Menu
        //gameMenu.display();
        System.out.println("*** loadExistingGame function called ***");
    }

    private void loadExistingGame() {
        System.out.println("*** loadExistingGame function called ***");
    }

    private void saveGame() {
        System.out.println("*** saveGame function called ***");
    }

    private void displayHelpMenu() {
        //Create a new help Menu View
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayMenu();
        System.out.println("*** displayHelpMenu function called ***");
    }

    private void displayPlayersScores() {
        
        System.out.println("*** displayPlayersScores function called ***");
    }
    
}
