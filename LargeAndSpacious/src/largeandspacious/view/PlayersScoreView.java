/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.view;

/**
 *
 * @author julzlee
 */
public class PlayersScoreView extends View {
    
    
    public PlayersScoreView() {
        
        //String highScores = "\n";
        
        super("\n"
            + "\n------------------------------------------"
            + "\n  Player High Scores                      "
            + "\n------------------------------------------"
            + "\n Thomas - " + (int)(Math.random()*25) + 5 
            + "\n Sarah - " + (int)(Math.random()*25) + 5 
            + "\n Frank - " + (int)(Math.random()*25) + 5 
            + "\n Michelle - " + (int)(Math.random()*25) + 5 
            + "\n Jeff - " + (int)(Math.random()*25) + 5 
            + "\n------------------------------------------"
            + "\n E - Exit menu                            "
            + "\n------------------------------------------");
    }
    
@Override
public boolean doAction(Object obj) {
    
    String value = (String) obj;
    
    value = value.toUpperCase(); //convert to all upper case
    char choice = value.charAt(0); // get first character entered
    boolean done = false;
    
        switch (choice) {
            case 'E':
                done = true;
                break;
            default:
                System.out.println("Invalid selection");
                break;
            
        }
        return done;
    }
    
}
