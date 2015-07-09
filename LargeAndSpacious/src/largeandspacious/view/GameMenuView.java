/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.view;

// import java.util.Scanner;
import java.awt.Point;
import static java.lang.Double.parseDouble;
import java.util.Scanner;
import largeandspacious.control.ChallengeControl;
import largeandspacious.control.GameControl;
import largeandspacious.control.InventoryControl;
import largeandspacious.control.MapControl;
import largeandspacious.exceptions.MapControlException;
import largeandspacious.model.Actor;
import largeandspacious.model.Item;
import largeandspacious.model.Location;

/**
 *
 * @author julzlee
 */
public class GameMenuView extends View {
    
    public GameMenuView() {
        super("\n"
            + "\n|------------------------------------------|"
            + "\n|  Game Menu                               |"
            + "\n|------------------------------------------|"
            + "\n| S - Select a resource to use             |"
            + "\n| M - Move to a map location (Move Menu)   |"
            + "\n| D - Display Map                          |"
            + "\n| I - List player items                    |"
            + "\n| C - List challenges                      |"
            + "\n| A - List attributes                      |"                
            + "\n| X - Return to Main Menu                  |"
            + "\n| H - Help                                 |"
            + "\n|------------------------------------------|");
    }      

    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        boolean done = false;
        
        value = value.toUpperCase(); //convert to all upper case
        char choice = value.charAt(0); // get first character entered
        
        switch (choice) {
            case 'S':
                //Select a resource, if desired
                this.selectResource();
                break;
            case 'M': 
                //Move to a map location (Move Menu)
                this.displayMoveMenu();
                break;
            case 'D': 
                //Display Map
                this.displayMap();
                break;
            case 'I': 
                //List player items
                this.displayPlayerItems();
                break;
            case 'C': 
                // List challenges
                this.listChallenges();
                break;
            case 'A':
                //List Attributes
                this.listAttributes();
                break;
            case 'X':
                //Return to Menu
                done = true;
                break;
            case 'H':
                //Help menu
                this.displayHelpMenu();
                break;
            default: 
                this.console.println("Invalid selection");                
                break;
        }
        return done;
    }

    private void displayHelpMenu() {
        //Create a new help Menu View
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
        this.console.println("*** displayHelpMenu function called ***");
    }

    private void displayMoveMenu()
    {
        Point coordinates = new Point();
        int diceRoll;
        Actor actor = Actor.Lehi;
        double challengeResult = 0;
        String returnValue;
        
        Location newLocation = new Location();
        
        MoveMenuView moveMenu = new MoveMenuView();
        diceRoll = moveMenu.rollDice();
        newLocation = moveMenu.selectLocation();
        
        coordinates.x = newLocation.getRow();
        coordinates.y = newLocation.getCol();
        
        try{
            MapControl.moveActorToLocation(actor, coordinates, diceRoll);
        }catch ( MapControlException me)
        {
            ErrorView.display(this.getClass().getName(), me.getMessage());
            return;
        }
        //Add code to process move
        try {
            challengeResult = ChallengeControl.getChallengeResult(getObediencePlayed(),moveMenu.rollDice(),
                    4,0, 5);
        } catch ( MapControlException me)
        {
                ErrorView.display(this.getClass().getName(), me.getMessage());
                return;
        }
        returnValue = "You have gained " + challengeResult + " obedience points!";
        this.console.println(returnValue);
        
    }
    private double getObediencePlayed()
    {
        boolean valid = false;
        double playersObedience = 0;
        
        while( !valid )
        {
            //Prompt for the player's name
            this.console.println("\n You have landed on a challenge! Your challenge "
        + "\n is the mists of darkness. You cannot see where you are going. "
        + "\n Enter the number of obedience points you wish to use below:");
            
            try
            {
                //Get the points from the keyboard 
                playersObedience = parseDouble(this.keyboard.readLine());
            } catch( NumberFormatException nf){
                ErrorView.display(this.getClass().getName(), "\n Hey Dude! You must enter a valid number." +
                        "Try again or enter X to exit");
                break;
            }
            catch(Exception e)
            {
                ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
                break;
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

    public void displayMap() {
        //Create a new map Menu View
        
        MapMenuView mapMenu = new MapMenuView();
        mapMenu.display();
        this.console.println("*** displayPlayerItems function called ***");
    }

    private void displayPlayerItems()
    {
        String Desc;
        
        Item[] inventory = GameControl.getSortedInventoryList();
        this.console.println("\nList of Inventory Items");
        this.console.println("DESCRIPTION             " + "\t\t\t" +
                           "VALUE" + "\t\t" +
                           "ITEM COUNT");
                
        for(Item inventoryItem : inventory)
        {            
            this.console.println(inventoryItem.getDescription() + "\t\t\t\t" + 
                               inventoryItem.getValue() + "\t\t" +
                               inventoryItem.getItemCount());
        }
        
    }

    private void listChallenges() {
        //Create a new map Menu View
        ChallengesView challenges = new ChallengesView();
        challenges.display();
    }

    private void selectResource() {
        //show the average health of the player
        this.console.println(InventoryControl.calculateAverageHealth());
        //Show the Obedience, Testimony, and Fruit Levels
        this.console.println(InventoryControl.showItemLevels());
        
        //Create SelectResourceView object
        SelectResourceView selectResource = new SelectResourceView();
        selectResource.display();
    }

    private void listAttributes()
    {
        AttributeView attributes = new AttributeView();
        attributes.display();
    }
    
}
