/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.control;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paul Merideth
 */
public class CombinationControlTest {
    
    public CombinationControlTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getChallengeResult method, of class CombinationControl.
     */
    @Test
    public void testGetChallengeResult() {
        System.out.println("Test Case 1");
        double PlayerObedience = 4;
        double R1 = 3;
        double ChallengeObedience = 7;
        double R2 = 2;
        double ObedienceInventory = 9;
        CombinationControl instance1 = new CombinationControl();
        double expResult = -5;
        double result = instance1.getChallengeResult(PlayerObedience, R1, ChallengeObedience, R2, ObedienceInventory);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("Test Case 2");
        PlayerObedience = 10;
        R1 = 2;
        ChallengeObedience = 5;
        R2 = 4;
        ObedienceInventory = 9;
        CombinationControl instance2 = new CombinationControl();
        expResult = -9999;
        result = instance2.getChallengeResult(PlayerObedience, R1, ChallengeObedience, R2, ObedienceInventory);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("Test Case 3");
        PlayerObedience = 5;
        R1 = 4;
        ChallengeObedience = -3;
        R2 = 1;
        ObedienceInventory = 9;
        CombinationControl instance3 = new CombinationControl();
        expResult = -9999;
        result = instance3.getChallengeResult(PlayerObedience, R1, ChallengeObedience, R2, ObedienceInventory);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("Test Case 4");
        PlayerObedience = 4;
        R1 = 6;
        ChallengeObedience = 5;
        R2 = 2;
        ObedienceInventory = 9;
        CombinationControl instance4 = new CombinationControl();
        expResult = -9999;
        result = instance4.getChallengeResult(PlayerObedience, R1, ChallengeObedience, R2, ObedienceInventory);
        assertEquals(expResult, result, 0.0);        
        
        System.out.println("Test Case 5");
        PlayerObedience = 8;
        R1 = 3;
        ChallengeObedience = 5;
        R2 = 2;
        ObedienceInventory = 9;
        CombinationControl instance5 = new CombinationControl();
        expResult = 17;
        result = instance5.getChallengeResult(PlayerObedience, R1, ChallengeObedience, R2, ObedienceInventory);
        assertEquals(expResult, result, 0.0);        
        
        System.out.println("Test Case 6");
        PlayerObedience = 0;
        R1 = 1;
        ChallengeObedience = 5;
        R2 = 4;
        ObedienceInventory = 9;
        CombinationControl instance6 = new CombinationControl();
        expResult = -25;
        result = instance6.getChallengeResult(PlayerObedience, R1, ChallengeObedience, R2, ObedienceInventory);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("Test Case 7");
        PlayerObedience = 2;
        R1 = 3;
        ChallengeObedience = 2;
        R2 = 5;
        ObedienceInventory = 9;
        CombinationControl instance7 = new CombinationControl();
        expResult = -4;
        result = instance7.getChallengeResult(PlayerObedience, R1, ChallengeObedience, R2, ObedienceInventory);
        assertEquals(expResult, result, 0.0);        
    }
    
}
