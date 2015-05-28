/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author julzlee
 */
public class ChallengeControlTest {
    
    public ChallengeControlTest() {
    }

    /**
     * Test of getChallengeResult method, of class ChallengeControl.
     */
    @Test
    public void testGetChallengeResult() {
        System.out.println("getChallengeResult");
        /* Test Case #1 */
        System.out.println("\tTest case #7");
        double playerObedience = 2;
        double rollOne = 3;
        double challengeObedience = 2;
        double rollTwo = 5;
        double inventory = 9;
        ChallengeControl instance = new ChallengeControl();
        double expResult = -4;
        double result; 
        result = instance.getChallengeResult(playerObedience, rollOne, 
                challengeObedience, rollTwo, inventory);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The rollOne is less than 0.");
    }
    
}
