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
                System.out.println("Invalid selection");                
                break;
        }
        return done;
    }

    private void displayHelpMenu() {
        //Create a new help Menu View
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
        System.out.println("*** displayHelpMenu function called ***");
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
        }catch ( MapControl.MapControlException me)
        {
            System.out.println(me.getMessage());
        }
        //Add code to process move
        try {
            challengeResult = ChallengeControl.getChallengeResult(getObediencePlayed(),moveMenu.rollDice(),
                    4,0, 5);
        } catch ( MapControl.MapControlException me)
        {
                System.out.println(me.getMessage());
        }
        returnValue = "You have gained " + challengeResult + " obedience points!";
        System.out.println(returnValue);
        
    }
    private double getObediencePlayed()
    {
        boolean valid = false;
        double playersObedience = 0;
        Scanner keyboard = new Scanner(System.in);
        
        while( !valid )
        {
            //Prompt for the player's name
            System.out.println("You have landed on a challenge! Your challenge "
        + "is the mists of darkness. You cannot see where you are going. "
        + "Enter the number of obedience points you wish to use below:");
            
            try{
                //Get the points from the keyboard 
                playersObedience = parseDouble(keyboard.nextLine());
            } catch( NumberFormatException nf){
                System.out.println("\nYou must enter a valid number." +
                        "Try again or enter X to exit");
            }
            
            
            if( playersObedience == 0 )
            {
                System.out.println("Invalid - obedience points must be greater than 0.");
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
        System.out.println("*** displayPlayerItems function called ***");
    }

    private void displayPlayerItems()
    {
        String Desc;
        
        Item[] inventory = GameControl.getSortedInventoryList();
        System.out.println("\nList of Inventory Items");
        System.out.println("DESCRIPTION             " + "\t\t\t" +
                           "VALUE" + "\t\t" +
                           "ITEM COUNT");
                
        for(Item inventoryItem : inventory)
        {            
            System.out.println(inventoryItem.getDescription() + "\t\t\t\t" + 
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
        System.out.println(InventoryControl.calculateAverageHealth());
        //Show the Obedience, Testimony, and Fruit Levels
        System.out.println(InventoryControl.showItemLevels());
        
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
