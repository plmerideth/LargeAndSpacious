/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author julzlee
 */
public class Item implements Serializable {
    // class instance variables
    private int itemID;
    private String name;
    private String description;
    private double value;
    private double itemCount;
    private double quantityInStock;
    private double requiredAmount;

    public Item() {
    }
    
    
    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void addValue(double value)
    {
        this.value += value;
    }
    
    public void subtractValue(double value)
    {
        this.value -= value;
    }
    
    public double getItemCount() {
        return itemCount;
    }

    public void setItemCount(double itemCount) {
        this.itemCount = itemCount;
    }

    public void setRequiredAmount(double requiredAmount) {
        this.requiredAmount = requiredAmount;
    }
    
    public double getRequiredAmount() {
        return requiredAmount;
    }
    

    @Override
    public String toString() {
        return "Item{" + "itemID=" + itemID + ", name=" + name + ", description=" + description + ", value=" + value + ", itemCount=" + itemCount + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.itemID;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.description);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.value) ^ (Double.doubleToLongBits(this.value) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.itemCount) ^ (Double.doubleToLongBits(this.itemCount) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.itemID != other.itemID) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (Double.doubleToLongBits(this.value) != Double.doubleToLongBits(other.value)) {
            return false;
        }
        if (Double.doubleToLongBits(this.itemCount) != Double.doubleToLongBits(other.itemCount)) {
            return false;
        }
        return true;
    }

   
    
    
}
