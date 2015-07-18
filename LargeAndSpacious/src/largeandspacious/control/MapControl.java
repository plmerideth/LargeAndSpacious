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
 
        //Save player old current location to pastLocations ArrayList & player new current location
        player.setPastLocation(player.getCurrentLocation(), coordinates);
        player.setCurrentLocation(coordinates);
        
        //Set location coordinates status to visited.
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
        Q1.setQuestion("And it came to pass that while my father tarried in the "
                + "\nwilderness he spake unto us, saying: Behold, I have dreamed "
                + "\na dream; or, in other words, I have seen a ______.");
        Q1.setAnswer("vision");
        Q1.setFruitValue(2);
        questions[i++]=Q1;
        
        Questions Q2 = new Questions();
        Q2.setQuestion("It came to pass that I saw a man, and he was dressed in a _________.");
        Q2.setAnswer("white robe");
        Q1.setFruitValue(3);
        questions[i++]=Q2;
        
        Questions Q3 = new Questions();
        Q3.setQuestion("It came to pass that I did go forth and partake of the "
                + "\n______ thereof; and I beheld that it was most sweet, above "
                + "\nall that I ever before tasted.");
        Q3.setAnswer("fruit");
        Q3.setFruitValue(1);
        questions[i++]=Q3;

        Questions Q4 = new Questions();
        Q4.setQuestion("As I partook of the fruit thereof it filled my soul "
                + "\nwith __________ great joy");
        Q4.setAnswer("exceedingly");
        Q4.setFruitValue(2);
        questions[i++]=Q4;

        Questions Q5 = new Questions();
        Q5.setQuestion("I began to be desirous that my ______ should partake "
                + "\nof it also; for I knew that it was desirable above all other fruit.");
        Q5.setAnswer("family");
        Q5.setFruitValue(2);
        questions[i++]=Q5;
        
        Questions Q6 = new Questions();
        Q6.setQuestion("I cast my eyes round about, that perhaps I might "
                + "\ndiscover my ______ also");
        Q6.setAnswer("family");
        Q6.setFruitValue(3);
        questions[i++]=Q6;

        Questions Q7 = new Questions();
        Q7.setQuestion("What was was near the tree of which Lehi was partaking the fruit?");
        Q7.setAnswer("river of water");
        Q7.setFruitValue(3);
        questions[i++]=Q7;
        
        Questions Q8 = new Questions();
        Q8.setQuestion("And I looked to behold from whence it came; and I saw "
                + "\nthe head thereof a little way off; and at the head thereof "
                + "\nI beheld _______________________________________; and they "
                + "\nstood as if they knew not whither they should go."
                + "\n Who did Lehi behold?"
                + "\na. Sariah"
                + "\nb. Sam"
                + "\nc. Nephi"
                + "\nd. a & b"
                + "\ne. a & c"
                + "\nf. a, b & c");
        Q8.setAnswer("f");
        Q8.setFruitValue(2);
        questions[i++]=Q8;

        Questions Q9 = new Questions();
        Q9.setQuestion("And it came to pass that I __________ unto them");
        Q9.setAnswer("beckoned");
        Q9.setFruitValue(2);
        questions[i++]=Q9;
        
        Questions Q10 = new Questions();
        Q10.setQuestion("Who would not come and partake of the fruit"
                + "\na. Laman and Lemuel"
                + "\nb. Nephi and Sam"
                + "\nc. Zoram and Jacob");
        Q10.setAnswer("a");
        Q10.setFruitValue(2);
        questions[i++]=Q10;
        
        Questions Q11 = new Questions();
        Q11.setQuestion("What extended along the bank of the river, and led to "
                + "\nthe tree Lehi stood?"
                + "\na. mists of darkness"
                + "\nb. straight and narrow path"
                + "\nc. rod of iron");
        Q11.setAnswer("c");
        Q11.setFruitValue(3);
        questions[i++]=Q11;

        Questions Q12 = new Questions();
        Q12.setQuestion("What did Lehi also behold which came along by "
                + "\nthe rod of iron, even to the tree where he stood."
                + "\nthe tree Lehi stood?"
                + "\na. mists of darkness"
                + "\nb. straight and narrow path"
                + "\nc. rod of iron");
        Q12.setAnswer("b");
        Q12.setFruitValue(2);
        questions[i++]=Q12;
        
        Questions Q13 = new Questions();
        Q13.setQuestion("The strait and narrow path also led by the head of "
                + "\nthe fountain, unto a large and spacious field, as if it "
                + "\nhad been a ______");
        Q13.setAnswer("world");
        Q13.setFruitValue(1);
        questions[i++]=Q13;
        
        Questions Q14 = new Questions();
        Q14.setQuestion("I saw numberless ___________ of people, many of whom "
                + "\nwere pressing forward, that they might obtain the path "
                + "\nwhich led unto the tree by which I stood.");
        Q14.setAnswer("concourses");
        Q14.setFruitValue(3);
        questions[i++]=Q14;
        
        Questions Q15 = new Questions();
        Q15.setQuestion("And it came to pass that there arose a _______________; "
                + "\nyea, even an exceedingly great _______________, "
                + "\ninsomuch that they who had commenced in the path did lose "
                + "\ntheir way, that they wandered off and were lost.");
        Q15.setAnswer("mist of darkness");
        Q15.setFruitValue(4);
        questions[i++]=Q15;
        
        Questions Q16 = new Questions();
        Q16.setQuestion("They did press forward through the mist of darkness, "
                + "\n__________ to the rod of iron, even until they did come "
                + "\nforth and partake of the fruit of the tree");
        Q16.setAnswer("clinging");
        Q16.setFruitValue(4);
        questions[i++]=Q16;
        
        Questions Q17 = new Questions();
        Q17.setQuestion("And after they had partaken of the fruit of the tree "
                + "\nthey did cast their eyes about as if they were _________");
        Q17.setAnswer("ashamed");
        Q17.setFruitValue(1);
        questions[i++]=Q17;
        
        Questions Q18 = new Questions();
        Q18.setQuestion("And I also cast my eyes round about, and beheld, on "
                + "\nthe other side of the river of water, a great and spacious "
                + "\n_______; and it stood as it were in the air, high above "
                + "\nthe earth");
        Q18.setAnswer("building");
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
