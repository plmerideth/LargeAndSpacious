/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.control;

import largeandspacious.LargeAndSpacious;
import largeandspacious.model.Item;

/**
 *
 * @author julzlee
 */
public class InventoryControl
{
    public static String calculateAverageHealth() {
        //get the items in the inventory
        Item[] items = LargeAndSpacious.getCurrentGame().getInventory();
        
        double total = 0.0;
        String avgHealth;
        //get the number of items in stock
        for (Item item : items) {
            total = total + item.getValue();
        }
        double average = total / items.length;
        //return the average number of items in stock
        avgHealth = "\n Your average health is " + average;
        return avgHealth; 
    }
    
    public static String showItemLevels()
    {
        String itemLevels = "\nRESOURCE LEVELS";
        double value;
        
        //get the items in the inventory
        Item[] items = LargeAndSpacious.getCurrentGame().getInventory();
        Item[] inventoryList = items.clone();      
        Item temp;
        
        /* Use insertion sort to list in order */
        for (int i=1; i<inventoryList.length; i++) {
            for(int j=i ; j>0 ; j--){
                if(inventoryList[j].getDescription().compareToIgnoreCase(inventoryList[j-1].getDescription()) < 0)
                {
                    temp = inventoryList[j];
                    inventoryList[j] = inventoryList[j-1];
                    inventoryList[j-1] = temp;
                }
            }
        }
                
        for (Item item: inventoryList)
        {
            switch(item.getDescription())
            {
                case "fruit                 ":
                    value = item.getValue();
                    itemLevels += "\nYour Fruit level is " + value;
                break;
                case "testimony             ":
                    value = item.getValue();
                    itemLevels += "\nYour Testimony level is " + value;
                break;
                case "obedience             ":
                    value = item.getValue();
                    itemLevels += "\nYour Obedience level is " + value;
                break;
                case "Rod of Iron           ":
                    value = item.getValue();
                    itemLevels += "\nYour Rod of Iron level is " + value;
                break;
                case "Straight & Narrow Path":
                    value = item.getValue();
                    itemLevels += "\nYour Straight & Narrow Path level is " + value;
                break;
                case "Man in White Robe     ":
                    value = item.getValue();
                    itemLevels += "\nYour Your Man in White Robe level is " + value;
                break;                
                /*  Printout for debug purposes
                default:
                    System.out.println("\nDesc = " + item.getDescription());
                break;
                */
            }
        }
        return itemLevels;
    }
}
