/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.view;

import java.util.Scanner;

/**
 *
 * @author julzlee
 */
public class HelpMenuView extends View
{   
    public HelpMenuView()
    {
        super("\n"
            + "\n|------------------------------------------|"
            + "\n|  Help Menu                               |"
            + "\n|------------------------------------------|"
            + "\n| O - Overview of game                     |"
            + "\n| M - How to move                          |"
            + "\n| Q - Explains the quest                   |"
            + "\n| G - Explains the map                     |"
            + "\n| I - Explains how to use items            |"
            + "\n| L - Lists Items                          |"
            + "\n| C - Lists Challenges                     |"
            + "\n| R - Return to Menu                       |"
            + "\n|------------------------------------------|");
    }
    
    private final String OVERVIEW = "\n"
            + "\n|-------------------------------------------------|"
            + "\n| Game Overview                                   |"
            + "\n|-------------------------------------------------|"
            + "\n| The Large and Spacious Building is an RPG where |"
            + "\n| the player has to journey through life making   |"
            + "\n| personal choices that will lead him/her         |"
            + "\n| across the dark and dreary wilderness, until    |"
            + "\n| the player reaches the tree of life and         |"
            + "\n| obtains eternal life.                           |"
            + "\n|-------------------------------------------------|";
    
    private final String MOVEH = "\n"
            + "\n|-------------------------------------------------|"
            + "\n| ***How to move on the map***                    |"
            + "\n|-------------------------------------------------|"
            + "\n| 1. From the Game Menu, select M (Move Menu)     |"
            + "\n| 2. Press R to roll the dice to get move spaces  |"
            + "\n| 3. Enter the row number (X location)            |"
            + "\n| 4. Enter the column number (Y location)         |"
            + "\n|-------------------------------------------------|";
    
    private final String QUEST = "\n"
            + "\n|-------------------------------------------------|"
            + "\n| Quest Help                                      |"
            + "\n|-------------------------------------------------|"
            + "\n| The quest of Large and Spacious Building is to  |"
            + "\n| get through the questions and challenges in     |"
            + "\n| the map locations to get to the tree of life.   |"
            + "\n| Each map location contains fruit, obedience     |"
            + "\n| or testimony points and a possible special item |"
            + "\n| such as a Man in a white robe. Items found or   |"
            + "\n| earned at a map location will increase your     |"
            + "\n| health and strength. Items are used as a wager  |"
            + "\n| in challenges and questions and will increase   |"
            + "\n| your ability to succeed.                        |"
            + "\n|-------------------------------------------------|";
    
    private final String MAPH = "\n"
            + "\n|-------------------------------------------------|"
            + "\n| Map Help                                        |"
            + "\n|-------------------------------------------------|"
            + "\n| The map shows the locations that you have       |"
            + "\n| visited and what locations are still available. |"
            + "\n| Any location on the map that contains an X has  |"
            + "\n| already been solved. If you move to a location  |"
            + "\n| on the map and did not win the challenge or     |"
            + "\n| answer the question correctly, it will show as  |"
            + "\n| an unvisited map location. The locations on the |"
            + "\n| map increase in difficulty as you get closer to |"
            + "\n| the tree of life.                               |"
            + "\n|-------------------------------------------------|";
    
    private final String ITEMH = "\n"
            + "\n|-------------------------------------------------|"
            + "\n| *** How to use Items ***                        |"
            + "\n|-------------------------------------------------|"
            + "\n| Items are used to help defend yourself when you |"
            + "\n| visit map locations. Each map location will     |"
            + "\n| contain at least one adversity. It could be a   |"
            + "\n| question, a challenge or a combination of both. |"
            + "\n| The special items will have even greater power  |"
            + "\n| in defending against the adversity to be faced. |"
            + "\n| They may even counteract any damage to          |"
            + "\n| testimony or obedience points.                  |"
            + "\n|-------------------------------------------------|";
    
    private final String ITEMLIST = "\n"
            + "\n|-------------------------------------------------|"
            + "\n| Regular Items                                   |"
            + "\n|-------------------------------------------------|"
            + "\n| *Fruit - Supplies you with physical health      |"
            + "\n| *Testimony - Supplies you with points to help   |"
            + "\n|     with facing testimony impacting adversity.  |"
            + "\n| *Obedient - Supplies you with point to help     |"
            + "\n|     with facing obedience impacting adversity.  |"
            + "\n|-------------------------------------------------|"
            + "\n| Special Items                                   |"
            + "\n|-------------------------------------------------|"
            + "\n| *Rod of Iron - If holding the Rod of Iron,      |"
            + "\n|     damage levels are eliminated, even when     |"
            + "\n|     losing a battle.                            |"
            + "\n| *Straight & Narrow Path - If holding “Straight  |"
            + "\n|     & Narrow” the challenges “Mists of Darkness” |"
            + "\n|     and “Lost and Forbidden Path” have no        |"
            + "\n|     effect.                                     |"
            + "\n| *Man in White Robe - The man in the white robe  |"
            + "\n|     provides prophecy and guidance for a future |"
            + "\n|     move.  If you fail to answer correctly and  |"
            + "\n|     possess the “Man in White Robe” attribute,   |"
            + "\n|     you win the resource points.                |"
            + "\n|-------------------------------------------------|" ;
    
   @Override
    public boolean doAction(Object obj)
    {
        String value = (String) obj;
        value = value.toUpperCase();
        char choice = value.charAt(0);
        boolean done = false;
                
        switch (choice)
        {
            case 'O': 
                //Overview of the Game
                this.displayGameOverview();
                break;
            case 'M': 
                //How to move
                this.displayMoveHelp();
                break;
            case 'Q': 
                // Explains the quest 
                this.displayQuestHelp();
                break;
            case 'G': 
                // Explains the map
                this.displayMapHelp();
                break;
            case 'I': 
                // Explains how to use items 
                this.displayItemHelp();
                break;
            case 'L':
                //Lists Items
                this.displayItemList();
                break;
            case 'C':
                // Lists Challenges
                this.displayChallenges();
                break;
            case 'R':
                // Return to Menu
                done = true;
                break;
            default: 
                System.out.println("Invalid selection");
                break;
        }
        return done;
    }

    private void displayGameOverview() {
        System.out.println(OVERVIEW); // display the Overview menu
    }

    private void displayMoveHelp() {
        System.out.println(MOVEH); // display the move help menu
    }

    private void displayQuestHelp() {
        System.out.println(QUEST); // display the quest help menu
    }

    private void displayMapHelp() {
        System.out.println(MAPH); // display the map help menu
    }

    private void displayItemHelp() {
        System.out.println(ITEMH); // display the item help menu
    }

    private void displayItemList() {
       System.out.println(ITEMLIST); // display the list of items & their use
    }

    private void displayChallenges() {
        //Create a new help Menu View
        ChallengesView challenges = new ChallengesView();
        challenges.display();
        System.out.println("*** displayChallenges function called ***");
    }

    
}
