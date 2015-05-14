/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
just a test of github
 */
package largeandspacious;

import largeandspacious.model.ChallengeScene;
import largeandspacious.model.Challenges;
import largeandspacious.model.CombinationScene;
import largeandspacious.model.Game;
import largeandspacious.model.Player;
import largeandspacious.model.Map;
import largeandspacious.model.QuestionScene;
import largeandspacious.model.Questions;
import largeandspacious.model.Item;
import largeandspacious.model.Location;

/**
 *
 * @author Paul Merideth
 */
public class LargeAndSpacious {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        
        playerOne.setName("Paul Merideth");
        playerOne.setBestScore(123.45);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
        
        Game gameOne = new Game();
        gameOne.setGameID(1);
        gameOne.setRemainingTime(10);
        gameOne.setTotalTime(15);
        
        String gameInfo = gameOne.toString();
        System.out.println(gameInfo);
        
        Map firstMap = new Map();
        firstMap.setRow(3);
        firstMap.setColumn(5);
        
        String myMap = firstMap.toString();
        System.out.println(myMap);
        
        QuestionScene questScene = new QuestionScene();
        questScene.setSceneTypeID(2);
        questScene.setQuestionID(7);
        questScene.setItemID(2);
        questScene.setDescription("Question about Lehi's dream.");
        
        String myQuestScene = questScene.toString();
        System.out.println(myQuestScene);
        
        Questions quest = new Questions();
        quest.setQuestionsID(9);
        quest.setQuestion("What does the iron rod represent in Lehi's dream?");
        quest.setAnswer("The word of God.");
        
        String myQuest = quest.toString();
        System.out.println(myQuest);
        
        Item myItem = new Item();
        myItem.setItemID(4);
        myItem.setName("Obedience");
        myItem.setDescription("Your level of obedience");
        myItem.setValue(3);
        myItem.setItemCount(1);
        
        String haveItems = myItem.toString();
        System.out.println(haveItems);
        
        Location mapLocation = new Location();
        mapLocation.setRow(3);
        mapLocation.setCol(2);
        mapLocation.setSceneTypeId(4);
        String locationInfo = mapLocation.toString();
        System.out.println(locationInfo);
        
        ChallengeScene challengeScene = new ChallengeScene();
        challengeScene.setSceneTypeID(32);
        challengeScene.setChallengeID(45);
        challengeScene.setItemID(56);
        challengeScene.setDescription("This is challenge scene 45 and is not for the faint of heart!");
        String challengeSceneInfo = challengeScene.toString();
        System.out.println(challengeSceneInfo);
        
        CombinationScene combinationScene = new CombinationScene();
        combinationScene.setSceneTypeID(99);
        combinationScene.setQuestionID(88);
        combinationScene.setChallengeID(77);
        combinationScene.setItemID(66);
        combinationScene.setDescription("This is the combination scene.  Double trouble!");
        String combinationSceneInfo = combinationScene.toString();
        System.out.println(combinationSceneInfo);
        
        Challenges challenges = new Challenges();
        challenges.setChallengeID(200);
        challenges.setChallengeValue(15);
        challenges.setDescription("The Mists of Darkness will destroy you if you're not careful!");
        String challengesInfo = challenges.toString();
        System.out.println(challengesInfo);
    }
    
}
