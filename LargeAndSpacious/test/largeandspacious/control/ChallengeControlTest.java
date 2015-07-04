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
    public void testGetChallengeResult() throws MapControl.MapControlException {
        System.out.println("getChallengeResult");
        /* Test Case #1 */
        System.out.println("\tTest case #1");
        double playerObedience = 4;
        double rollOne = 3;
        double challengeObedience = 7;
        double rollTwo = 2;
        double inventory = 9;
        ChallengeControl instance = new ChallengeControl();
        double expResult = -5;
        double result; 
        result = instance.getChallengeResult(playerObedience, rollOne, 
                challengeObedience, rollTwo, inventory);
        assertEquals(expResult, result, 0.0);
        
        /* Test Case #2 */
        System.out.println("\tTest case #2");
        playerObedience = 10;
        rollOne = 2;
        challengeObedience = 5;
        rollTwo = 4;
        inventory = 9;
        ChallengeControl instance2 = new ChallengeControl();
        expResult = -9999;
        result = instance.getChallengeResult(playerObedience, rollOne, 
                challengeObedience, rollTwo, inventory);
        assertEquals(expResult, result, 0.0);
        
        /* Test Case #3 */
        System.out.println("\tTest case #3");
        playerObedience = 5;
        rollOne = 4;
        challengeObedience = -3;
        rollTwo = 1;
        inventory = 9;
        ChallengeControl instance3 = new ChallengeControl();
        expResult = -9999; 
        result = instance.getChallengeResult(playerObedience, rollOne, 
                challengeObedience, rollTwo, inventory);
        assertEquals(expResult, result, 0.0);
        
        /* Test Case #4 */
        System.out.println("\tTest case #4");
        playerObedience = 5;
        rollOne = 6;
        challengeObedience = 5;
        rollTwo = 2;
        inventory = 9;
        ChallengeControl instance4 = new ChallengeControl();
        expResult = -9999;
        result = instance.getChallengeResult(playerObedience, rollOne, 
                challengeObedience, rollTwo, inventory);
        assertEquals(expResult, result, 0.0);
        
        /* Test Case #5 */
        System.out.println("\tTest case #5");
        playerObedience = 8;
        rollOne = 3;
        challengeObedience = 5;
        rollTwo = 2;
        inventory = 9;
        ChallengeControl instance5 = new ChallengeControl();
        expResult = 17;
        result = instance.getChallengeResult(playerObedience, rollOne, 
                challengeObedience, rollTwo, inventory);
        assertEquals(expResult, result, 0.0);
        
        /* Test Case #6 */
        System.out.println("\tTest case #6");
        playerObedience = 0;
        rollOne = 0;
        challengeObedience = 5;
        rollTwo = 4;
        inventory = 9;
        ChallengeControl instance6 = new ChallengeControl();
        expResult = -25; 
        result = instance.getChallengeResult(playerObedience, rollOne, 
                challengeObedience, rollTwo, inventory);
        assertEquals(expResult, result, 0.0);
        
        /* Test Case #7 */
        System.out.println("\tTest case #7");
        playerObedience = 2;
        rollOne = 3;
        challengeObedience = 2;
        rollTwo = 5;
        inventory = 9;
        ChallengeControl instance7 = new ChallengeControl();
        expResult = -4;
        result = instance.getChallengeResult(playerObedience, rollOne, 
                challengeObedience, rollTwo, inventory);
        assertEquals(expResult, result, 0.0);
            
    }
    
}
