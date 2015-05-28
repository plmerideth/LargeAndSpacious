/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.control;

/**
 *
 * @author julzlee
 */
public class ChallengeControl {
    public double getChallengeResult(double playerObedience, double rollOne, 
            double challengeObedience, double rollTwo, double inventory) {
        double result;
        if ((playerObedience > inventory) || (challengeObedience < 0)) {
            /* the player has assigned more inventory than they have
            or the challenge obedience points are less than zero*/
                return -9999;
        }
	if ((rollOne > 5) || (rollOne < 0) || (rollTwo > 5) || (rollTwo < 0)) {
            /* the first roll should not be greater than 5 or less than 0
            or the 2nd roll should be greater than 5 or less than 0*/
		return -9999;
        }
        result = ((playerObedience * rollOne) - challengeObedience); 
        result = result - ((challengeObedience * rollTwo) - playerObedience);

	return result;

    }
}
