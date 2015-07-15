/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.view;

// import java.util.Scanner;
import java.awt.Point;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import largeandspacious.LargeAndSpacious;
import largeandspacious.control.ActorControl;
import largeandspacious.control.ChallengeControl;
import largeandspacious.control.GameControl;
import largeandspacious.control.InventoryControl;
import largeandspacious.control.MapControl;
import largeandspacious.exceptions.MapControlException;
import largeandspacious.model.Actor;
import largeandspacious.model.Item;
import largeandspacious.model.Location;
import largeandspacious.model.Map;

/**
 *
 * @author julzlee
 */
public class GameMenuView extends View
{
    ErrorView errorView = new ErrorView();
    private static PrintWriter mapFile = null;
    private static PrintWriter actorFile = null;
    
    
    private final String FILE_PATH_MENU =
            "\n|------------------------------------|"
         +  "\n| Please enter below the full path   |"
         +  "\n| and file name for the Map Contents |"
         +  "\n| Contents Report                    |"
         +  "\n|                                    |"
         +  "\n| Or enter X to return to Game Menu  |"
         +  "\n|------------------------------------|"
         +  "\n  File path and name: ";

    
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
            + "\n| N - List Actor Names                     |"  
            + "\n| A - List attributes                      |"
            + "\n| Y - Create Map Report                    |"                
            + "\n| R - Create Actor Report                    |" 
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
            case 'N':
                //List Actors Names
                this.listActorNames();
                break;
            case 'X':
                //Return to Menu
                done = true;
                break;
            case 'H':
                //Help menu
                this.displayHelpMenu();
                break;
            case 'Y':
                //Create map report
                this.createMapReport();
                break;
            case 'R':
        {
            try {
                // create the actor report
                this.createActorReport();
            } catch (MapControlException ex) {
                Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
        // calculate the high score from the last challenge
        // get the current score
        double currentScore = LargeAndSpacious.getPlayer().getBestScore();
        // get the new score - current score plus the challenge result
        double newScore = currentScore + challengeResult ;
        //set the players current score
        LargeAndSpacious.getPlayer().setCurrentScore(newScore);
        // if the new score is higher than the current score, we have a new high score.
        // set the best score appropriately.
        if (currentScore + challengeResult > currentScore) {
            LargeAndSpacious.getPlayer().setBestScore(newScore);
        }
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
            }
            catch( NumberFormatException nf)
            {
                ErrorView.display(this.getClass().getName(), "\n Hey Dude! You must enter a valid number." +
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

    public void displayMap() {
        //Create a new map Menu View
        
        MapMenuView mapMenu = new MapMenuView();
        mapMenu.display();
        
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

    private void listChallenges()
    {
        //Create a new map Menu View
        ChallengesView challenges = new ChallengesView();
        challenges.display();
    }

    private void selectResource()
    {
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

    private void listActorNames() {
        //Show the Obedience, Testimony, and Fruit Levels
        this.console.println(ActorControl.showActors());
    }
    
    private void createMapReport()
    {            
        int path = -1;
        String input = "";
        
        try
        {        
            while(path < 0)
            {
                this.console.println(FILE_PATH_MENU);
                String mapFilePath = this.getPath();  // get the user's selection
                
                if( mapFilePath.equals("X"))
                    break;
                
                try
                {
                    mapFile = new PrintWriter(mapFilePath);            
                }
                catch( Exception e)
                {
                    ErrorView.display(this.getClass().getName(),
                          "File creation failed.\n"
                        + "Exception: "
                        + e.toString()
                        + e.getCause()
                        + e.getMessage());
                    
                    return;
                }
                
                this.printReport(mapFile, mapFilePath);
                
                break;
            }                        
        }
        finally
        {
            try
            {
                if(mapFile != null)
                    mapFile.close();
            }
            catch(Exception ex)
            {
                ErrorView.display(this.getClass().getName(), "Exception: "
                    + ex.toString()
                    + ex.getCause()
                    + ex.getMessage());
            }
        }
    }

    private void printReport(PrintWriter mapFile, String mapFilePath)
    {        
        Map map = LargeAndSpacious.getCurrentGame().getMap();
        Location[][] locations = map.getLocations();
        int NoOfRows = map.getNoOfRows();
        int NoOfCols = map.getNoOfColumns();
        int rowNumber = 0;
        int rowCycles = (NoOfRows*2)+1;
        char desc[] = new char[3];
        String reportOutput = "\n\nTHE LARGE AND SPACIOUS BUILDING MAP";
        
        //Draw map and insert scene types in each location
        for(int row=0; row<rowCycles; row++)
        {
            if(row==0) //For first row, add newline plus extra space at beginning of number line
                reportOutput+="\n\n   ";
            else //After 1st row, just add a new line
                reportOutput +="\n";
            
            if(row>0 && (row&1)==0)//Increment row counter if row number is even and past row 0
                rowNumber++;
            
            for(int col=0; col<NoOfCols; col++)
            {
                if(row==0) //First row, print row numbers
                {
                    reportOutput += " "+(col+1)+"  ";
                }
                if(col==0 && row>=1 && (row&1)==0) //Print Col numbers on even rows
                {
                    if(rowNumber<=9)
                        reportOutput += " " + rowNumber + "|"; //Add extra leading space for single digit numbers
                    else
                        reportOutput += rowNumber + "|";
                }
                if((row&1)==1) //Odd numbered row, add lines
                {
                    if(col==0) //Add extra leading space for first col
                        reportOutput += "  ----";
                    else
                        reportOutput += "----";                   
                }
                else if(row!=0)
                {
                    String tempStr = locations[rowNumber-1][col].getSceneType().getDescription();
                    tempStr.getChars(0, 3, desc,0);
                    tempStr = String.valueOf(desc);
                    
                    reportOutput += tempStr + "|";
                }
            }
        }
        
        reportOutput += "\n\nSTA = Starting"
                + "\nBUI = Building"
                + "\nMIS = Mists of Darkness"
                + "\nFIN = Finger of Scorn"
                + "\nPAT = Lost & Forbidden Path"
                + "\nTRE = Tree of Life"
                + "\nRIV = River of Water"
                + "\nFIN = Finish";
        
        this.console.println("\n\nThe Map Report was successfully created in "
                                + mapFilePath);
        this.console.println(reportOutput); //Print to console           
        mapFile.println(reportOutput);  //Write to file.
    }
    
    private String getPath()
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
                //playersInput = playersInput.toUpperCase();

                if( playersInput.length() < 1 )
                {
                    this.console.println("Invalid entry, the selection must not be blank");
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

    private void createActorReport() throws MapControlException {
        
        String description = null;
        
        this.console.println("\nEnter the file path for file where the game "
                + "is to be saved:");
        
        String filePath = this.getInput();
        try (FileWriter writer = new FileWriter(filePath)) {
            
             //get the actors
        List<Actor> actors = new ArrayList<>(EnumSet.allOf(Actor.class));
        writer.write("    LIST OF ACTORS\r\n");
        // go through each of the actors, get the name and description   
        for (Actor actor: actors)
        {
            writer.write(actor.name() + ":\t\t" + actor.getDescription()+ "\r\n") ;     
        }
        writer.close();
        } catch (IOException e) {
    throw new MapControlException(e.getMessage());
        }

    }




}
