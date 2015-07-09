/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.view;

import java.util.Scanner;

/**
 *
 * @author julzlee
 */
public class ChallengesView extends View {

    public ChallengesView() {
        super("\n"
            + "\n|-------------------------------------------------------|"
            + "\n|  Challenges                                        |"
            + "\n|-------------------------------------------------------|"
            + "\n| Finger of Scorn (Obedience damage)                    |"
            + "\n| Mists of Darkness (Testimony damage)                  |"
            + "\n| Pride (Obedience & Testimony damage)                  |"
            + "\n| Lost & Forbidden Path (Obedience & Testimony damage)  |"
            + "\n| Mocking & Pointing (Obedience damage)                 |"
            + "\n|-------------------------------------------------------|"
            + "\n| X - Return to Game Menu                                         |"
            + "\n|-------------------------------------------------------|");
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
