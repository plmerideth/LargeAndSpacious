/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.control;
import largeandspacious.exceptions.MapControlException;

/**
 *
 * @author julzlee
 */
public class ChallengeControl {
    public static int getChallengeResult(double playerObedPoints, double playerTestPoints, 
            double destructObedPoints, double destructTestPoints, double playerMult, double destructMult) 
            throws MapControlException
    {
        int result;
        
        if (playerObedPoints<0 || playerTestPoints<0 || destructObedPoints<0 || destructTestPoints<0)
        {
                throw new MapControlException("Point values in getChallengeResult are less than zero.");
        }
        
        //PLM:  Dice roll from 1-6. 
	if(playerMult>6 || playerMult<0 || destructMult>6 || destructMult<0)
        {
            /* the dice rolls should never be less than 0 or greater than 6 */
		throw new MapControlException("The roll of the dice "
                + "should not be greater than 5 or less than 0.");
        }
        result = (int)((playerObedPoints * playerMult) - destructObedPoints); 
        result = (int)(result - ((destructTestPoints * destructMult) - playerObedPoints));
        //return the result
	return result;

    }
}
