/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.control;

import largeandspacious.LargeAndSpacious;
import largeandspacious.model.Player;

/**
 *
 * @author Paul Merideth
 */
public class ProgramControl
{

    public static Player createPlayer(String playersName)
    {
        if( playersName == null)
            return null;
        
        Player player = new Player();
        player.setName(playersName);
        
        LargeAndSpacious.setPlayer(player);
        
        return player;
    }
    
}
