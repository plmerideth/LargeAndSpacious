/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.view;

import largeandspacious.LargeAndSpacious;
import largeandspacious.control.GameControl;
import largeandspacious.exceptions.MapControlException;

/**
 *
 * @author julzlee
 */
public class MainMenuView extends View
{
    public MainMenuView()
    {
        super("\n"
            + "\n|------------------------------------------|"
            + "\n|  Main Menu                               |"
            + "\n|------------------------------------------|"
            + "\n| G - Start game                           |"
            + "\n| H - Go to the help menu                  |"
            + "\n| P - Show players and high scores         |"
            + "\n| S - Save game                            |"
            + "\n| L - Load game                            |"
            + "\n| X - Exit game                            |"
            + "\n|------------------------------------------|");
    }
    
    @Override
    public boolean doAction(Object obj)
    {
        String value = (String) obj;
        value = value.toUpperCase();
        char choice = value.charAt(0);
        boolean done = false;
        
        switch (choice) {
            case 'G': 
                //Start a new game
                try
                {
                    this.startNewGame();                
                } catch( MapControlException me)
                {
                    this.console.println(me.getMessage());
                }
                
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
            case 'X':
                //Exit the game
                done = true;
                break;
            default: 
                this.console.println("Invalid selection");
                break;
        }
        return done;
    }
    
    private void startNewGame() throws MapControlException
    {   
        //Create a new Game
        GameControl.createNewGame(LargeAndSpacious.getPlayer());
        //Create a new Game Menu View
        
        GameMenuView gameMenu = new GameMenuView();
        //Display the Game Menu
        gameMenu.display();
        this.console.println("*** loadExistingGame function called ***");
    }

    private void loadExistingGame() {
        
        //prompt for and get the name of the file the game was saved in
        System.out.println("\\Enter the file path for the file where the game "
        + "was saved.");
        
        String filePath = this.getInput();
        
        try {
            // start a saved game
            GameControl.getSavedGame(filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        
        // display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void saveGame() {
        this.console.println("\n\nEnter the file path for file where the game "
                + "is to be saved:");
        String filePath = this.getInput();
        
        try {
            // save the game to the specified file
            GameControl.saveGame(LargeAndSpacious.getCurrentGame(), filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        
    }

    private void displayHelpMenu() {
        //Create a new help Menu View
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
        this.console.println("*** displayHelpMenu function called ***");
    }

    private void displayPlayersScores() {
        //Create a Players Score View
        PlayersScoreView scores = new PlayersScoreView();
        scores.display();
        this.console.println("*** displayPlayersScores function called ***");
    }
}
