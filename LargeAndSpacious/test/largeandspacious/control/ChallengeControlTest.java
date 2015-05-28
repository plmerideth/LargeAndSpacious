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
        double playerObedience = 4.0;
        double rollOne = -3.0;
        double challengeObedience = 2.0;
        double rollTwo = 5.0;
        double inventory = 6.0;
        ChallengeControl instance = new ChallengeControl();
        double expResult = 0.0;
        double result = instance.getChallengeResult(playerObedience, rollOne, challengeObedience, rollTwo, inventory);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
