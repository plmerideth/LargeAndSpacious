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
        System.out.println("getChallengeResult");
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

    /**
     * Test of getCombinationResult method, of class CombinationControl.
     * author julzlee
     */
    @Test
    public void testGetCombinationResult() {
        System.out.println("getCombinationResult");
        System.out.println("Test Case #1");
        double challengeResult = 0.0;
        double questionResult = 7.0;
        double questItemInvest = 3.0;
        double challItemInvest = 4.0;
        double challengeValue = 2.0;
        double questionValue = 3.0;
        CombinationControl instance = new CombinationControl();
        double expResult = 6.0;
        double result = instance.getCombinationResult(challengeResult, 
                questionResult, questItemInvest, challItemInvest, 
                challengeValue, questionValue);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("Test Case #2");
        challengeResult = -2;
        questionResult = 5.0;
        questItemInvest = 2.0;
        challItemInvest = 2.0;
        challengeValue = 2.0;
        questionValue = 2.0;
        CombinationControl instance2 = new CombinationControl();
        expResult = -4;
        result = instance.getCombinationResult(challengeResult, questionResult, 
                questItemInvest, challItemInvest, challengeValue, questionValue);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("Test Case #3");
        challengeResult = 1.0;
        questionResult = 1.0;
        questItemInvest = 2.0;
        challItemInvest = 2.0;
        challengeValue = 1.0;
        questionValue = 2.0;
        CombinationControl instance3 = new CombinationControl();
        expResult = 2.0;
        result = instance.getCombinationResult(challengeResult, questionResult, 
                questItemInvest, challItemInvest, challengeValue, questionValue);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("Test Case #4");
        challengeResult = 10.0;
        questionResult = 5.0;
        questItemInvest = 0.0;
        challItemInvest = 2.0;
        challengeValue = 2.0;
        questionValue = 2.0;
        CombinationControl instance4 = new CombinationControl();
        expResult = -9999;
        
        System.out.println("Test Case #5");
        challengeResult = 5.0;
        questionResult = -3.0;
        questItemInvest = 4.0;
        challItemInvest = 0.0;
        challengeValue = 3.0;
        questionValue = 3.0;
        CombinationControl instance5 = new CombinationControl();
        expResult = -9999;
        result = instance.getCombinationResult(challengeResult, questionResult, 
                questItemInvest, challItemInvest, challengeValue, questionValue);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("Test Case #6");
        challengeResult = 4.0;
        questionResult = 5.0;
        questItemInvest = 3.0;
        challItemInvest = 6.0;
        challengeValue = 0.0;
        questionValue = 3.0;
        CombinationControl instance6 = new CombinationControl();
        expResult = -9999;
        result = instance.getCombinationResult(challengeResult, questionResult, 
                questItemInvest, challItemInvest, challengeValue, questionValue);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("Test Case #7");
        challengeResult = 4.0;
        questionResult = 5.0;
        questItemInvest = 2.0;
        challItemInvest = 1.0;
        challengeValue = 1.0;
        questionValue = 0.0;
        CombinationControl instance7 = new CombinationControl();
        expResult = -9999;
        result = instance.getCombinationResult(challengeResult, questionResult, 
                questItemInvest, challItemInvest, challengeValue, questionValue);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("Test Case #8");
        challengeResult = 10.0;
        questionResult = 7.0;
        questItemInvest = 5.0;
        challItemInvest = 6.0;
        challengeValue = 3.0;
        questionValue = 1.0;
        CombinationControl instance8 = new CombinationControl();
        expResult = -9999;
        result = instance.getCombinationResult(challengeResult, questionResult, 
                questItemInvest, challItemInvest, challengeValue, questionValue);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("Test Case #9");
        challengeResult = -100.0;
        questionResult = 100.0;
        questItemInvest = 5.0;
        challItemInvest = 3.0;
        challengeValue = 1.0;
        questionValue = 2.0;
        CombinationControl instance9 = new CombinationControl();
        expResult = -8;
        result = instance.getCombinationResult(challengeResult, questionResult, 
                questItemInvest, challItemInvest, challengeValue, questionValue);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("Test Case #10");
        challengeResult = 100.0;
        questionResult = -100.0;
        questItemInvest = 3.0;
        challItemInvest = 4.0;
        challengeValue = 3.0;
        questionValue = 3.0;
        CombinationControl instance10 = new CombinationControl();
        expResult = -7;
        result = instance.getCombinationResult(challengeResult, questionResult, 
                questItemInvest, challItemInvest, challengeValue, questionValue);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("Test Case #11");
        challengeResult = 25.0;
        questionResult = 15.0;
        questItemInvest = 1.0;
        challItemInvest = 100.0;
        challengeValue = 2.0;
        questionValue = 3.0;
        CombinationControl instance11 = new CombinationControl();
        expResult = 6;
        result = instance.getCombinationResult(challengeResult, questionResult, 
                questItemInvest, challItemInvest, challengeValue, questionValue);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("Test Case #12");
        challengeResult = 50.0;
        questionResult = -10.0;
        questItemInvest = 100.0;
        challItemInvest = 1.0;
        challengeValue = 2.0;
        questionValue = 3.0;
        CombinationControl instance12 = new CombinationControl();
        expResult = -101;
        result = instance.getCombinationResult(challengeResult, questionResult, 
                questItemInvest, challItemInvest, challengeValue, questionValue);
        assertEquals(expResult, result, 0.0);
    }
    
}
