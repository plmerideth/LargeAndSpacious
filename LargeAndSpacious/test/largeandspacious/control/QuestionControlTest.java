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
public class QuestionControlTest {
    
    public QuestionControlTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getQuestionResult method, of class QuestionControl.
     */
    @Test
    public void testGetQuestionResult() {
        System.out.println("Test Case 1");
        double DifficultyLevel = 3;
        double Time = 7;
        double FullPoints = 4;
        QuestionControl instance1 = new QuestionControl();
        double expResult = 4.96;
        double result = instance1.getQuestionResult(DifficultyLevel, Time, FullPoints);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");

        System.out.println("Test Case 2");
        DifficultyLevel = 4;
        Time = 5;
        FullPoints = 2;
        QuestionControl instance2 = new QuestionControl();
        expResult = -9999;
        result = instance2.getQuestionResult(DifficultyLevel, Time, FullPoints);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("Test Case 3");
        DifficultyLevel = 2;
        Time = -5;
        FullPoints = 4;
        QuestionControl instance3 = new QuestionControl();
        expResult = -9999;
        result = instance3.getQuestionResult(DifficultyLevel, Time, FullPoints);
        assertEquals(expResult, result, 0.0);        
        
        System.out.println("Test Case 4");
        DifficultyLevel = 1;
        Time = 3;
        FullPoints = 8;
        QuestionControl instance4 = new QuestionControl();
        expResult = -9999;
        result = instance4.getQuestionResult(DifficultyLevel, Time, FullPoints);
        assertEquals(expResult, result, 0.0);        
        
        System.out.println("Test Case 5");
        DifficultyLevel = 1;
        Time = 10;
        FullPoints = 2;
        QuestionControl instance5 = new QuestionControl();
        expResult = 1.4;
        result = instance5.getQuestionResult(DifficultyLevel, Time, FullPoints);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("Test Case 6");
        DifficultyLevel = 2;
        Time = 30;
        FullPoints = 4;
        QuestionControl instance6 = new QuestionControl();
        expResult = 1.89;
        result = instance6.getQuestionResult(DifficultyLevel, Time, FullPoints);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("Test Case 7");
        DifficultyLevel = 3;
        Time = 5.01;
        FullPoints = 6;
        QuestionControl instance7 = new QuestionControl();
        expResult = 5.99;
        result = instance7.getQuestionResult(DifficultyLevel, Time, FullPoints);
        assertEquals(expResult, result, 0.0);        
    }   
}
