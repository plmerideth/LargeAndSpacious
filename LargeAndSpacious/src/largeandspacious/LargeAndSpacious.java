/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
just a test of github
 */
package largeandspacious;

import largeandspacious.model.Game;
import largeandspacious.model.Player;
import largeandspacious.model.Map;
import largeandspacious.model.QuestionScene;
import largeandspacious.model.Questions;

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
    }
    
}
