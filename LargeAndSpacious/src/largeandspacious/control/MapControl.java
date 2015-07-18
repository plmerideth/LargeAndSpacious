/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.control;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import static java.lang.Math.abs;
import java.util.Random;
import largeandspacious.LargeAndSpacious;
import largeandspacious.control.Scene.SceneType;
import largeandspacious.exceptions.MapControlException;
import largeandspacious.model.Actor;
import largeandspacious.model.Game;
import largeandspacious.model.Location;
import largeandspacious.model.Map;
import largeandspacious.model.Player;
import largeandspacious.model.Questions;

/**
 *
 * @author julzlee
 */
public class MapControl {
    protected final PrintWriter console = LargeAndSpacious.getOutFile();
   
    public static void moveActorsToStartingLocation(Map map) 
            throws MapControlException {
        
        Actor actor = LargeAndSpacious.getActor();
        Point coordinates = actor.getCoordinates();
        // move the player to the starting location
        LargeAndSpacious.getPlayer().setCurrentLocation(coordinates);
            //cannot use this.console.println from a static function
            // System.out.println("Actor = " + actor);
        MapControl.moveActorToLocation(actor, coordinates, 0);
    }
    
    public static void moveActorToLocation(Actor actor, Point coordinates, int diceRoll) 
            throws MapControlException {
        Map map = LargeAndSpacious.getCurrentGame().getMap();
        Player player = LargeAndSpacious.getCurrentGame().getPlayer();
        Location[][] locations = map.getLocations();
        
        int newRow = coordinates.x-1;
        int newColumn = coordinates.y-1;
        Point currentCoordinates = player.getCurrentLocation();
        
        //System.out.println("Current Location: " + currentCoordinates);
        
        if (newRow < 0 || newRow >= map.getNoOfRows() || 
            newColumn < 0 || newColumn >= map.getNoOfColumns()){
            throw new MapControlException("Can not move actor to location "
                + coordinates.x + ", " + coordinates.y
                + " because that location is outside "
                + "the bounds of the map.");
        }
        
        //Cannot move to a location you have already visited.
        if(locations[(int)(coordinates.getX()-1)][(int)(coordinates.getY()-1)].getVisited())
        {
            throw new MapControlException("You can not move to that location because you have already visited " 
                + coordinates.x + ", " + coordinates.y);
        }
        
        double moveCount = abs(currentCoordinates.getX()-coordinates.getX())+(abs(currentCoordinates.getY()-coordinates.getY()));
        
        if( diceRoll!=0 && moveCount > diceRoll)
        {
            throw new MapControlException("\nCan not move player to location ("
                + coordinates.x + ", " + coordinates.y
                + ") because that location requires " + moveCount + " moves, which exceeds your roll of " + diceRoll + " !");
                
        }
 
        player.setPastLocation(player.getCurrentLocation(), coordinates);
        player.setCurrentLocation(coordinates);
        
        //Set location coordinates as visited.
        locations[(int)(coordinates.getX()-1)][(int)(coordinates.getY()-1)].setVisited(true);
        //System.out.println("New Location: " + coordinates);        
    }

    public static Map createMap() {
        
        // set up random numbers between 5 and 10 so we have a decent map
        Random rand = new Random();
        int min = 5;
        int max = 10;
        //set up a random map
        int x = rand.nextInt((max - min) + 1) + min;
        //System.out.println("x = " + x);
        int y = rand.nextInt((max - min) + 1) + min;
        //System.out.println("y = " + y);
        //create the map
        Map map = new Map(x, y);
        //Map map = new Map(10,10); //Temporary for testing.
        
        //create a list of the different challenge scenes in the game
        Scene[] scenes = createScenes();
        Questions[] questionList = createQuestionList();
        
        //assign the different scenes to location in the map
        GameControl.assignScenesAndQuestionsToLocations(map, scenes, questionList);
               
        return map;
    }

    public static Questions[] createQuestionList()
    {
        int i=0;
        Questions[] questions = new Questions[Constants.NUMBER_OF_QUESTIONS];
        
        Questions Q1 = new Questions();
        Q1.setQuestion("Question " + Integer.toString(i+1));
        Q1.setAnswer("Answer " + Integer.toString(i+1));
        Q1.setFruitValue(5);
        questions[i++]=Q1;
        
        Questions Q2 = new Questions();
        Q2.setQuestion("Question " + Integer.toString(i+1));
        Q2.setAnswer("Answer " + Integer.toString(i+1));
        Q1.setFruitValue(3);
        questions[i++]=Q2;
        
        Questions Q3 = new Questions();
        Q3.setQuestion("Question " + Integer.toString(i+1));
        Q3.setAnswer("Answer " + Integer.toString(i+1));
        Q3.setFruitValue(1);
        questions[i++]=Q3;

        Questions Q4 = new Questions();
        Q4.setQuestion("Question " + Integer.toString(i+1));
        Q4.setAnswer("Answer " + Integer.toString(i+1));
        Q4.setFruitValue(1);
        questions[i++]=Q4;

        Questions Q5 = new Questions();
        Q5.setQuestion("Question " + Integer.toString(i+1));
        Q5.setAnswer("Answer " + Integer.toString(i+1));
        Q5.setFruitValue(1);
        questions[i++]=Q5;
        
        Questions Q6 = new Questions();
        Q6.setQuestion("Question " + Integer.toString(i+1));
        Q6.setAnswer("Answer " + Integer.toString(i+1));
        Q6.setFruitValue(1);
        questions[i++]=Q6;

        Questions Q7 = new Questions();
        Q7.setQuestion("Question " + Integer.toString(i+1));
        Q7.setAnswer("Answer " + Integer.toString(i+1));
        Q7.setFruitValue(1);
        questions[i++]=Q7;
        
        Questions Q8 = new Questions();
        Q8.setQuestion("Question " + Integer.toString(i+1));
        Q8.setAnswer("Answer " + Integer.toString(i+1));
        Q8.setFruitValue(1);
        questions[i++]=Q8;

        Questions Q9 = new Questions();
        Q9.setQuestion("Question " + Integer.toString(i+1));
        Q9.setAnswer("Answer " + Integer.toString(i+1));
        Q9.setFruitValue(1);
        questions[i++]=Q9;
        
        Questions Q10 = new Questions();
        Q10.setQuestion("Question " + Integer.toString(i+1));
        Q10.setAnswer("Answer " + Integer.toString(i+1));
        Q10.setFruitValue(1);
        questions[i++]=Q10;
        
        Questions Q11 = new Questions();
        Q11.setQuestion("Question " + Integer.toString(i+1));
        Q11.setAnswer("Answer " + Integer.toString(i+1));
        Q11.setFruitValue(1);
        questions[i++]=Q11;

        Questions Q12 = new Questions();
        Q12.setQuestion("Question " + Integer.toString(i+1));
        Q12.setAnswer("Answer " + Integer.toString(i+1));
        Q12.setFruitValue(1);
        questions[i++]=Q12;
        
        Questions Q13 = new Questions();
        Q13.setQuestion("Question " + Integer.toString(i+1));
        Q13.setAnswer("Answer " + Integer.toString(i+1));
        Q13.setFruitValue(1);
        questions[i++]=Q13;
        
        Questions Q14 = new Questions();
        Q14.setQuestion("Question " + Integer.toString(i+1));
        Q14.setAnswer("Answer " + Integer.toString(i+1));
        Q14.setFruitValue(1);
        questions[i++]=Q14;
        
        Questions Q15 = new Questions();
        Q15.setQuestion("Question " + Integer.toString(i+1));
        Q15.setAnswer("Answer " + Integer.toString(i+1));
        Q15.setFruitValue(1);
        questions[i++]=Q15;
        
        Questions Q16 = new Questions();
        Q16.setQuestion("Question " + Integer.toString(i+1));
        Q16.setAnswer("Answer " + Integer.toString(i+1));
        Q16.setFruitValue(1);
        questions[i++]=Q16;
        
        Questions Q17 = new Questions();
        Q17.setQuestion("Question " + Integer.toString(i+1));
        Q17.setAnswer("Answer " + Integer.toString(i+1));
        Q17.setFruitValue(1);
        questions[i++]=Q17;
        
        Questions Q18 = new Questions();
        Q18.setQuestion("Question " + Integer.toString(i+1));
        Q18.setAnswer("Answer " + Integer.toString(i+1));
        Q18.setFruitValue(1);
        questions[i++]=Q18;
        
        Questions Q19 = new Questions();
        Q19.setQuestion("Question " + Integer.toString(i+1));
        Q19.setAnswer("Answer " + Integer.toString(i+1));
        Q19.setFruitValue(1);
        questions[i++]=Q19;
        
        Questions Q20 = new Questions();
        Q20.setQuestion("Question " + Integer.toString(i+1));
        Q20.setAnswer("Answer " + Integer.toString(i+1));
        Q20.setFruitValue(1);
        questions[i++]=Q20;
        
        return questions;
    }    
    
    private static Scene[] createScenes() /*throws MapControlException*/
    {
        BufferedImage image = null;
        
        Game game = LargeAndSpacious.getCurrentGame();
        
        Scene[] scenes = new Scene[SceneType.values().length];
        
        /*
        Scene startingScene = new Scene();
        startingScene.setDescription("STARTING: And it came to pass that while my "
                + "father tarried in the wilderness he spake unto us, saying: "
                + "Behold, I have dreamed a dream; or, in other words, I have "
                + "seen a vision.");
        //startingScene.setMapSymbol(" ST ");
        startingScene.setBlocked(false);
        scenes[SceneType.start.ordinal()] = startingScene;
        */
                
        Scene buildingScene = new Scene();
        buildingScene.setDescription("BUI: The Large And Spacious Building:"
                + "\nTestimony Destructive Force:  3 points."
                + "\nObedience Destructive Force:  1 point.");        
        buildingScene.setBlocked(false);
        buildingScene.setTestimonyDestruction(3);
        buildingScene.setObedienceDestruction(1);
        scenes[SceneType.building.ordinal()] = buildingScene;
        
        Scene mistsScene = new Scene();
        mistsScene.setDescription("MIS: The Mists of Darkness:"
                + "\nTestimony Destructive Force:  2 points."
                + "\nObedience Destructive Force:  5 points.");                        
        mistsScene.setBlocked(false);
        mistsScene.setTestimonyDestruction(2);
        mistsScene.setObedienceDestruction(5);
        scenes[SceneType.mists.ordinal()] = mistsScene;

        Scene fingerScene = new Scene();
        fingerScene.setDescription("FIN: The Finger of Scorn:"
                + "\nTestimony Destructive Force:  2 points."
                + "\nObedience Destructive Force:  4 points.");                       
        fingerScene.setBlocked(false);
        fingerScene.setTestimonyDestruction(2);
        fingerScene.setObedienceDestruction(4);        
        scenes[SceneType.finger.ordinal()] = fingerScene;
        
        Scene pathScene = new Scene();
        pathScene.setDescription("PAT: Forbidden Paths:"
                + "\nTestimony Destructive Force:  5 points."
                + "\nObedience Destructive Force:  5 points.");
        pathScene.setBlocked(false);
        pathScene.setTestimonyDestruction(5);
        pathScene.setObedienceDestruction(5);
        scenes[SceneType.path.ordinal()] = pathScene;        
        
        Scene treeScene = new Scene();
        treeScene.setDescription("TRE: The Tree of Life"
                + "\nTestimony Destructive Force:  0 points."
                + "\nObedience Destructive Force:  0 points.");
        treeScene.setBlocked(false);
        treeScene.setTestimonyDestruction(0);
        treeScene.setObedienceDestruction(0);
        scenes[SceneType.tree.ordinal()] = treeScene;        
        
        Scene riverScene = new Scene();
        riverScene.setDescription("RIV: The River of Water:"
                + "\nTestimony Destructive Force:  3 points"
                + "\nObedience Destructive Force:  3 points");
        riverScene.setBlocked(false);
        riverScene.setTestimonyDestruction(3);
        riverScene.setObedienceDestruction(3);
        scenes[SceneType.river.ordinal()] = riverScene;        
        
        /*
        Scene finishScene = new Scene();
        finishScene.setDescription("FINISH: They came and caught hold of the end of "
                + "the rod of iron; and they did press their way forward, "
                + "continually holding fast to the rod of iron, until they "
                + "came forth and fell down and partook of the fruit of the tree.");
        //finishScene.setMapSymbol(" FN ");
        finishScene.setBlocked(false);
        scenes[SceneType.finish.ordinal()] = finishScene;
        */
                
        return scenes;
    }    
}
