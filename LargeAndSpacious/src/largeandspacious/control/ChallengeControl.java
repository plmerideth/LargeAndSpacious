/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.control;
import largeandspacious.LargeAndSpacious;
import largeandspacious.exceptions.MapControlException;
import largeandspacious.model.Item;

/**
 *
 * @author julzlee
 */
public class ChallengeControl {
    public static double getChallengeResult(double playerObedience, double rollOne, 
            double challengeObedience, double rollTwo, double inventory) 
            throws MapControlException {
        double result;
        if (playerObedience > inventory) {
                throw new MapControlException("You have "
                + inventory + " points. You have asked to use  "
                + playerObedience + " points, which exceeds your inventory level.");
        }
        
        if (challengeObedience < 0) {
            /* the player has assigned more inventory than they have
            or the challenge obedience points are less than zero*/
                throw new MapControlException("The challenge "
                + "obedience points are less than zero, which is not allowed.");
            }
        
        //PLM:  Dice roll from 1-6. 
	if ((rollOne > 6) || (rollOne < 0) || (rollTwo > 6) || (rollTwo < 0)) {
            /* the first roll should not be greater than 5 or less than 0
            or the 2nd roll should be greater than 5 or less than 0*/
		throw new MapControlException("The roll of the dice "
                + "should not be greater than 5 or less than 0.");
        }
        result = ((playerObedience * rollOne) - challengeObedience); 
        result = result - ((challengeObedience * rollTwo) - playerObedience);
        //update the player inventory
        Item[] inventoryList = LargeAndSpacious.getCurrentGame().getInventory();
        //System.out.println("About to set the inventory item level.");
        double inStock = inventoryList[GameControl.inventoryItem.obedience.ordinal()].getValue();
        System.out.println("inStock = " + inStock);
        System.out.println("result = " + result);
        if (inStock < result) {
            result = playerObedience * -1;
            inventoryList[GameControl.inventoryItem.obedience.ordinal()].setValue(0);
        } else {
            inventoryList[GameControl.inventoryItem.obedience.ordinal()].setValue(result);
        }
	return result;

    }
}
