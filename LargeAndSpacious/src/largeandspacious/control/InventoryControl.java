/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.control;

import largeandspacious.model.Item;
import largeandspacious.control.Constants;

/**
 *
 * @author julzlee
 */
public class InventoryControl {
    
    public static Item[] createInventoryList() {
        // created an array(list) of inventory items
        Item[] inventory = new Item[Constants.NUMBER_OF_INVENTORY_ITEMS];
        
        Item fruit = new Item();
        fruit.setDescription("fruit");
        fruit.setQuantityInStock(0);
        fruit.setRequiredAmount(0);
        inventory[inventoryItem.fruit.ordinal()] = fruit;
        
        Item obedience = new Item();
        obedience.setDescription("obedience");
        obedience.setQuantityInStock(0);
        obedience.setRequiredAmount(0);
        inventory[inventoryItem.obedience.ordinal()] = obedience;
        
        Item testimony = new Item();
        testimony.setDescription("testimony");
        testimony.setQuantityInStock(0);
        testimony.setRequiredAmount(0);
        inventory[inventoryItem.testimony.ordinal()] = testimony;
        
        Item ironRod = new Item();
        ironRod.setDescription("Rod of Iron");
        ironRod.setQuantityInStock(0);
        ironRod.setRequiredAmount(0);
        inventory[inventoryItem.ironRod.ordinal()] = ironRod;
        
        Item path = new Item();
        path.setDescription("Straight & Narrow Path");
        path.setQuantityInStock(0);
        path.setRequiredAmount(0);
        inventory[inventoryItem.path.ordinal()] = path;
        
        Item man = new Item();
        man.setDescription("Man in White Robe");
        man.setQuantityInStock(0);
        man.setRequiredAmount(0);
        inventory[inventoryItem.man.ordinal()] = man;
        
        return inventory;
    }

    
    
    public enum inventoryItem {
        fruit,
        obedience,
        testimony,
        ironRod,
        path,
        man
    }
    
}
