/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.view;

import largeandspacious.model.Player;

/**
 *
 * @author julzlee
 */
public class PlayersScoreView extends View {
    
    
    public PlayersScoreView(Player player) {
        
        
        super("\n"
            + "\n------------------------------------------"
            + "\n  Player High Scores                      "
            + "\n------------------------------------------"
            + "\n " + PlayersStats(player) + " "
            + "\n------------------------------------------"
            + "\n X - Exit menu                            "
            + "\n------------------------------------------");
    }
    
    public static String PlayersStats(Player player) {
        
        String playerName = player.getName();
        double playerScore = player.getBestScore();
        return playerName + " - " + playerScore;
    }
    
       
@Override
public boolean doAction(Object obj) {
    
    String value = (String) obj;
    
    value = value.toUpperCase(); //convert to all upper case
    char choice = value.charAt(0); // get first character entered
    boolean done = false;
    
        switch (choice) {
            case 'X':
                done = true;
                break;
            default:
                this.console.println("Invalid selection");
                break;
            
        }
        return done;
    }
    
}
