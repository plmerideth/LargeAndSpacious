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
import largeandspacious.control.GameControl.inventoryItem;
import largeandspacious.control.InventoryControl;
import largeandspacious.control.MapControl;
import largeandspacious.exceptions.MapControlException;
import largeandspacious.model.Actor;
import largeandspacious.model.Item;
import largeandspacious.model.Location;
import largeandspacious.model.Map;
import largeandspacious.model.Player;

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
            //+ "\n| S - Select a resource to use             |"
            + "\n| M - Move to a map location (Move Menu)   |"
            + "\n| D - Display Map                          |"
            + "\n| I - List player items                    |"
            + "\n| C - List challenges                      |"
            + "\n| A - List attributes                      |"                
            + "\n| N - List Actor Names                     |"  
            + "\n| Y - Create Map Report                    |"                
            + "\n| R - Create Actor Report                  |" 
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
                done = this.displayMoveMenu();
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

    private boolean displayMoveMenu()
    {
        Point coordinates = new Point();
        int diceRoll;
        Actor actor = LargeAndSpacious.getActor();
        Map map = LargeAndSpacious.getCurrentGame().getMap();
        Player player = LargeAndSpacious.getCurrentGame().getPlayer();
        Location[][] locations = map.getLocations();
        Item[] inventory = LargeAndSpacious.getCurrentGame().getInventory();        
        
        boolean done=false;
        double sceneResult = 0;
        double playerObedience, playerTestimony;
        int questionResult, questionValue, challengeResult = 0;
        String returnValue;
        double currentRow, currentCol;
        
        Location newLocation = new Location();
        
        MoveMenuView moveMenu = new MoveMenuView();
        // roll the dice to find out how many spaces the player can move
        diceRoll = moveMenu.rollDice("Player"); //Force player to press 'R' to roll dice
        
        /* PLM(7-16-15):  I added this while() loop to player doesn't have to re-roll the dice when
        * an invalid location is entered.  Previously, if the player entered an invalid
        * set of coordinates or coordinates requiring more moves than allowed by the dice,
        * the player had to re-roll the dice.  He should keep the same roll, but be
        * required to enter valid coordinates.
        */
        while(true)
        {
            // get the location the player has selected
            newLocation = moveMenu.selectLocation();
            
            if(newLocation.getRow()==-1)//This indicates 'X' entered by user
                break;

            coordinates.x = newLocation.getRow();
            coordinates.y = newLocation.getCol();

            try
            {
                MapControl.moveActorToLocation(actor, coordinates, diceRoll);
            }catch ( MapControlException me)
            {
                ErrorView.display(this.getClass().getName(), me.getMessage());
                continue;
            }
            displayMap();
            break;
        }
        
        if(newLocation.getRow() != -1) //If user did not enter 'X' to exit
        {
            try
            {
                //Check to see if player owns "Man in White Robe".  If so, show scene before getting
                //testimony and obedience inputs.

                //Create SelectResourceView object
                SelectResourceView selectResource = new SelectResourceView();
                //show the available resources
                this.displayPlayerItems();
        
                while(true) //Get player input for obedience
                {                                                    
                    playerObedience = selectResource.selectObedience();
                    if(playerObedience <= inventory[inventoryItem.obedience.ordinal()].getValue())
                        break;
                    else
                        this.console.println("ERROR:  You may not use more obedience points than you have in inventory.  Please try again!");
                }
        
                while(true) //Get player input for testimony
                {            
                    playerTestimony = selectResource.selectTestimony();
                    if(playerTestimony <= inventory[inventoryItem.testimony.ordinal()].getValue())
                        break;
                    else
                        this.console.println("ERROR:  You may not use more testimony points than you have in inventory.  Please try again!");
                }                                                                               
         
                //Ask player question based on location
                questionResult = askQuestion();

                currentRow = player.getCurrentLocation().getX()-1;
                currentCol = player.getCurrentLocation().getY()-1;
                //Get value of question from locations[][]
                questionValue = locations[(int)currentRow][(int)currentCol].getQuestions().getFruitValue();
                
                if(questionResult>=0) //If player answered correctly, award points
                {
                    this.console.println("\nCONGRATULATIONS, you are correct!\n");
                    inventory[inventoryItem.fruit.ordinal()].addValue(questionResult);
                    inventory[inventoryItem.obedience.ordinal()].addValue(playerObedience); //Temporary value
                    inventory[inventoryItem.testimony.ordinal()].addValue(playerTestimony); //Temporary value
                }
                else  //Player must take challenge
                {
                    double playerRoll = moveMenu.rollDice("Auto");
                    double destructionRoll = moveMenu.rollDice("Auto");

                    this.console.println("\nYou have answered the question incorrectly.  You must take a challenge."
                            + "\n\nThe scene you have landed on is "
                            + locations[(int)currentRow][(int)currentCol].getScene().getDescription()
                            + "\n\nThe Player random multiplier is: " + playerRoll
                            + "\nThe scene random multiplier is " + destructionRoll);
                    
                    double destructObedPoints = locations[(int)currentRow][(int)currentCol].getScene().getObedienceDestruction();
                    double destructTestPoints = locations[(int)currentRow][(int)currentCol].getScene().getTestimonyDestruction();
                    double playerObedPoints = inventory[inventoryItem.obedience.ordinal()].getValue();
                    double playerTestPoints = inventory[inventoryItem.testimony.ordinal()].getValue();
                    
                    challengeResult = ChallengeControl.getChallengeResult(playerObedience, playerTestimony, destructObedPoints, destructTestPoints, playerRoll, destructionRoll);
                    this.console.println("\nPRESS <ENTER> KEY TO SEE CHALLENGE RESULT ...");
                    getResponse("AnyCharacter");
                    this.console.println("The challenge result score is: " + challengeResult);
                                        
                    if(challengeResult >= 0)//player wins points.
                    {
                        this.console.println("\nCONGRATULATIONS, you have won the challenge!\n");
                        inventory[inventoryItem.fruit.ordinal()].addValue(questionValue);
                        inventory[inventoryItem.obedience.ordinal()].addValue(playerObedience);
                        inventory[inventoryItem.testimony.ordinal()].addValue(playerTestimony);
                    }
                    else //Player loses points
                    {
                        this.console.println("\nSorry, but you have lost the challenge!\n");
                        inventory[inventoryItem.fruit.ordinal()].subtractValue(questionValue);
                        inventory[inventoryItem.obedience.ordinal()].subtractValue(playerObedience);
                        inventory[inventoryItem.testimony.ordinal()].subtractValue(playerTestimony);
                    }
                }
                
                this.console.println("Here are your new scores: \n");
                this.displayPlayerItems();
                
                //Check for winning game
                if(questionResult>=0 || challengeResult>=0)
                {
                    // calculate the high score from the last challenge
                    // get the current score
                    double currentScore = LargeAndSpacious.getPlayer().getBestScore();
                    // get the new score - current score plus the challenge result
                    double newScore = currentScore + sceneResult ;
                    //set the players current score
                    LargeAndSpacious.getPlayer().setCurrentScore(newScore);
                    // if the new score is higher than the current score, we have a new high score.
                    // set the best score appropriately.
                    if (currentScore + sceneResult > currentScore)
                    {
                        LargeAndSpacious.getPlayer().setBestScore(newScore);
                    }
                
                    this.console.println("\nYou have won "
                            + questionValue + " fruit, "
                            + playerObedience + " obedience points, and "
                            + playerTestimony + " testimony points!");

                    if((currentRow+1)==5 && (currentCol+1)==7)  //If player reaches bottom right corner, and has fruit, game is won.
                    {
                        //Clear out pastLocations ArrayList in player.
                        player.getPastLocations().clear();
                        this.console.println(                       
                           "\n*****************************************************"                                    
                          +"\n* CONGRATULATIONS, YOU MADE IT TO THE TREE OF LIFE! *"                                    
                          +"\n*                 YOU WIN THE GAME!                 *"
                          +"\n*****************************************************");
                        done=true;
                    }
                }
                else //Check for losing game
                {
                    this.console.println("\nYou have lost "
                            + questionValue + " fruit, "
                            + playerObedience + " obedience points, and "
                            + playerTestimony + " testimony points!");
                
                    if(inventory[GameControl.inventoryItem.fruit.ordinal()].getValue() <= 0)  //Zero fruit = losing game
                    {
                        //Clear out pastLocations ArrayList in player.
                        player.getPastLocations().clear();

                        this.console.println("\n\nSORRY, YOU LOST ALL YOUR FRUIT!  YOU LOSE THE GAME!\nTry again!");
                        done=true;
                    }
                }                
            } catch ( MapControlException me)
            {
                    ErrorView.display(this.getClass().getName(), me.getMessage());
                    return false;
            }
        }
        return done;
    }
    
    private int askQuestion() throws MapControlException
    {
        int result;
        String input, verify;
        
        Map map = LargeAndSpacious.getCurrentGame().getMap();
        Player player = LargeAndSpacious.getCurrentGame().getPlayer();
        Location[][] locations = map.getLocations();
        Point currentLocation;
        
        currentLocation = player.getCurrentLocation();
        int row = (int)currentLocation.getX()-1;
        int col = (int)currentLocation.getY()-1;
        
        //Display scene description at current location.
        //this.console.println("\nThe scene at this location is: "
        //   + locations[row][col].getScene().getDescription()+ "\n");
        
        //Ask player question at location
        this.console.println("\nHere is your question: "
            + locations[row][col].getQuestions().getQuestion()+ "?");
        
        OUTER:
        while (true) {
            this.console.println("Your answer: ");
            input = this.getResponse("String");            
            this.console.println("\nIs this your final answer (Y/N)?");
            verify = this.getResponse("String");
            switch (verify)
            {
                case "Y":
                    break OUTER;
                case "N":
                    continue;
                default:
                    this.console.println("Invalid response.  Try again!");                    
            }
        }
        
        String answer = locations[row][col].getQuestions().getAnswer();
        answer = answer.toUpperCase();
        
        if(answer.equals(input))
            result=locations[row][col].getQuestions().getFruitValue();
        else
            result=-1;        
        
        return result;
    }
    
    private String getResponse(String Type)
    {
        boolean valid = false;
        String playersInput = null;
        int keyPress;
        
        try
        {
            while( !valid )
            {
                //Get the name from the keyboard and trim off spaces
                if(Type.equals("AnyCharacter"))
                {
                    keyPress = this.keyboard.read();
                    break;
                }
                else
                {
                    playersInput = this.keyboard.readLine();
                    playersInput = playersInput.trim();
                    playersInput = playersInput.toUpperCase();

                    if( playersInput.length() < 1 )
                    {
                        this.console.println("Invalid answer - the selection must not be blank");
                        continue;
                    }
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
    
    
    
    private double getObediencePlayed()
    {
        boolean valid = false;
        double playersObedience = 0;
        
        while( !valid )
        {
            //tell the player what scene they have landed on
            this.console.println("\n You have landed on a challenge! Your challenge "
        + "\n is the mists of darkness. You cannot see where you are going. "
        + "\n Enter the number of obedience points you wish to use below:");
            //Create SelectResourceView object
            this.displayPlayerItems();
            //this.console.println(selectResource();
            
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

    public void displayMap()
    {
        //Create a new map Menu View
        /*
        MapMenuView mapMenu = new MapMenuView();
        mapMenu.display();
        */

        Map map = LargeAndSpacious.getCurrentGame().getMap();
        Player player = LargeAndSpacious.getCurrentGame().getPlayer();
        Location[][] locations = map.getLocations();
        int NoOfRows = map.getNoOfRows();
        int NoOfCols = map.getNoOfColumns();
        int rowNumber = 0;
        int rowCycles = (NoOfRows*2)+1;
        int moveNumber = 1;
        Point currentLoc = new Point();
        Point pastLoc = new Point();
        char desc[] = new char[3];
        Boolean visited; //Used to indicate a grid space has been visited.
        String reportOutput = "\n\nTHE LARGE AND SPACIOUS BUILDING MAP";
        ArrayList<Point> coordinates;
        coordinates = player.getPastLocations();
        Point currentCoordinates = player.getCurrentLocation();
        
        
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
                    //int myTest = coordinates.size();
                    visited = false;
                    currentLoc.setLocation(rowNumber, col+1);
                    
                    //If current location of player equals current map location
                    if( currentCoordinates.equals(currentLoc)) 
                    {
                        reportOutput += " X |";
                        visited = true;
                    }
                    else
                    {
                        for (Point coordinate : coordinates)
                        {
                            pastLoc = coordinate;                        
                            if( pastLoc.equals(currentLoc))
                            {
                                //Set moveNumber equal to index position of coordinates in coordinates ArrayList
                                moveNumber = coordinates.indexOf(pastLoc)+1;
                                if(moveNumber>9) //If moveNumber is one digit
                                    reportOutput += " " + moveNumber + "|";
                                else  //If moveNumber is two digits
                                    reportOutput += " " + moveNumber + " |";
                                moveNumber++;
                                visited =true;
                            }
                        }
                    }
                    if(!visited)
                        reportOutput += "   |";
                    /*
                    if((rowNumber-1)<coordinates.size())
                    {
                    currentLoc = coordinates.get(rowNumber-1);
                    double myTest2 = currentLoc.getX();
                    myTest2 = currentLoc.getY();
                    if( (rowNumber-1)==currentLoc.getX() && col==currentLoc.getY())
                    {
                    //Print move number
                    reportOutput += moveNumber + "|";
                    moveNumber++;
                    }
                    }
                     */
                    /*
                    currentLoc = coordinates.get(col);
                    String temp = Double.toString(currentLoc.getX());
                    temp += ", " + Double.toString(currentLoc.getY());
                    this.console.println(temp);
                     */
                    /*
                    String tempStr = locations[rowNumber-1][col].getScene().getDescription();
                    tempStr.getChars(0, 3, desc,0);
                    tempStr = String.valueOf(desc);
                     */
                    //reportOutput += tempStr + "|";
                }
            }
        }
        this.console.println(reportOutput); //Print to console                  
    }

    private void displayPlayerItems()
    {
        String Desc;
        Item[] inventory = LargeAndSpacious.getCurrentGame().getInventory();        
        
        this.console.println("\nPlayer's list of Inventory Items");
        this.console.println("====== RESOURCES ========== " + "\t" +
                           "QUANTITY");                           
                
        int i=0;
        for(Item inventoryItem : inventory)
        {
            i++;
            this.console.println(inventoryItem.getDescription() + "\t\t  " + 
                               inventoryItem.getValue());
            if(i==3)
                this.console.println("====== ATTRIBUTES =========");
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
        //Show the actors in the game
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
                    String tempStr = locations[rowNumber-1][col].getScene().getDescription();
                    tempStr.getChars(0, 3, desc,0);
                    tempStr = String.valueOf(desc);
                    
                    reportOutput += tempStr + "|";
                }
            }
        }
        
        reportOutput += "\n\nBUI = Building"
                + "\nMIS = Mists of Darkness"
                + "\nFIN = Finger of Scorn"
                + "\nPAT = Lost & Forbidden Path"
                + "\nTRE = Tree of Life"
                + "\nRIV = River of Water";                
        
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
