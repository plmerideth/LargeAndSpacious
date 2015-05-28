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
public class QuestionControl {
    public double getQuestionResult( double DifficultyLevel, double Time, double FullPoints)
    {
        double Points=0;
        
        if( DifficultyLevel < 1 || DifficultyLevel > 3)
            return -9999;
        
        if( Time <= 0 || Time > 30)
            return -9999;

        if( FullPoints != 2 && FullPoints != 4 && FullPoints != 6)
            return -9999;

        if( Time <= 5 )
            return FullPoints;

        if( Time > 5 && Time <= 30 )
        {
            //Calculate log base5 of Time.
            Points = DifficultyLevel * 2 * 1/(Math.log10(Time)/Math.log10(5));
        }
             
        return round(Points, 2); //return Points rounded to 2 decimal places.
    }
    
        private double round(double value, int places)
        {

            if (places < 0) throw new IllegalArgumentException();

            long factor = (long) Math.pow(10, places);
            value = value * factor;
            long tmp = Math.round(value);
            return (double) tmp / factor;
        }    
}
