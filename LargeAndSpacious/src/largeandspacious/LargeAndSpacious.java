/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
just a test of github
 */
package largeandspacious;

//import largeandspacious.model.Actor;
//import largeandspacious.model.ChallengeScene;
//import largeandspacious.model.Challenges;
//import largeandspacious.model.CombinationScene;
import largeandspacious.model.Game;
import largeandspacious.model.Player;
//import largeandspacious.model.Map;
//import largeandspacious.model.QuestionScene;
//import largeandspacious.model.Questions;
//import largeandspacious.model.Item;
//import largeandspacious.model.Location;
import largeandspacious.view.StartProgramView;

/**
 *
 * @author Paul Merideth
 */
public class LargeAndSpacious
{
    private static Game currentGame = null;
    private static Player player = null;


    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //Create StartProgramView and start the program
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.startProgram();
        
    }
   
    public static Game getCurrentGame() {
        return currentGame;
    }
    
   public static void setCurrentGame(Game currentGame) {
        LargeAndSpacious.currentGame = currentGame;
    }
    public static Player getPlayer() {
        return player;
    }
    
       public static void setPlayer(Player player) {
        LargeAndSpacious.player = player;
    }
}
