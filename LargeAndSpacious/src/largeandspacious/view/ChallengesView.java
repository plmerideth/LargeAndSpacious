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

    public ChallengesView(String promptMessage) {
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
            + "\n| E - Exit menu                                         |"
            + "\n|-------------------------------------------------------|");
    }
    

@Override
public boolean doAction(Object obj) {
    
    String value = (String) obj;
    
    value = value.toUpperCase(); //convert to all upper case
    char choice = value.charAt(0); // get first character entered
        switch (choice) {
            case 'E':
                break;
            default:
                System.out.println("Invalid selection");
                break;
            
        }
        return false;
    }
    
}
