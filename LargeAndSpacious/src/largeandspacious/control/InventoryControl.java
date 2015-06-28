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
            total = total + item.getQuantityInStock();
        }
        double average = total / items.length;
        //return the average number of items in stock
        avgHealth = "\n Your average health is " + average;
        return avgHealth; 
    }
}
