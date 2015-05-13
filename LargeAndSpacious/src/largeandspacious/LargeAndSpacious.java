/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
just a test of github
 */
package largeandspacious;

import largeandspacious.model.Player;

/**
 *
 * @author Paul Merideth
 */
public class LargeAndSpacious {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        
        playerOne.setName("Paul Merideth");
        playerOne.setBestScore(123.45);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
    }
    
}
