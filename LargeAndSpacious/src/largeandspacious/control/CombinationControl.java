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
public class CombinationControl
{
  public double getChallengeResult( double PlayerObedience, double R1, double ChallengeObedience, double R2, double ObedienceInventory)
  {
    
      if( PlayerObedience > ObedienceInventory || ChallengeObedience < 0 )
          return -9999;
      if( R1>5 || R1<0 || R2>5 || R2<0)
          return -9999;
      
      double Result = ((PlayerObedience * R1) - ChallengeObedience) - ((ChallengeObedience * R2) - PlayerObedience);
      
      return Result;
  }  
}
