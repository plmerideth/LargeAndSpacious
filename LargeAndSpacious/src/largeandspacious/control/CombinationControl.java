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
  public double getChallengeResult( double PlayerObedience, double R1, 
          double ChallengeObedience, double R2, double ObedienceInventory)
  {
    
      if( PlayerObedience > ObedienceInventory || ChallengeObedience < 0 )
          return -9999;
      if( R1>5 || R1<0 || R2>5 || R2<0)
          return -9999;
      
      double Result = ((PlayerObedience * R1) - ChallengeObedience) - 
              ((ChallengeObedience * R2) - PlayerObedience);
      
      return Result;
  }  
  
  public double getCombinationResult(double challengeResult, 
          double questionResult, double questItemInvest, 
          double  challItemInvest, double challengeValue, 
          double questionValue) {
         
          double points;
          double result;
         
	if ((questItemInvest <= 0) || (challItemInvest <= 0)) {
		//at least one item needs to be invested per challenge/question
		return -9999;
          }
	if ((challengeValue <= 0) || (questionValue <= 0)) {
		//Challenge/Question must have a value greater than 0
		return -9999;
          }
	if (((challengeValue - questionValue) == 2) || 
        ((challengeValue - questionValue) == -2)) {
		/*The value points between a challenge and question cannot 
                    exceed 1 point.*/
		return -9999;
          }
	if ((challengeResult < 0) || (questionResult < 0)) {
		/*Total loss - Return the sum of the item investment as a 
                        negative value*/
            double multiplier = -1;
            result = (questItemInvest + challItemInvest) * multiplier;
          }
        else if ((challengeResult + questionResult)/2 > 2) {
		/* The question and challenge were both completed very 
                    successfully, gain 10%*/
		points = (challengeValue + questionValue);
		double extra = points * 1.10;
                double multiplier = Math.pow(10,0);
                result = Math.round(extra * multiplier) / multiplier;
                //result = Math.round(extra,1);
        }
        else {
		// The question and challenge were barely complete successfully, lose one point
		points = (challengeValue + questionValue);
		double loss = points -1;
		result = loss;
                        }
	return result;
        }
}
