/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.view;

/**
 *
 * @author Paul Merideth
 */
public class AttributeView extends View
{
    public AttributeView()
    {
    super("\n"
        + "\n|----------------------------------------------------------|"
        + "\n|  Attributes                                              |"
        + "\n|----------------------------------------------------------|"
        + "\n| ROD OF IRON (Obedience strength)                         |"
        + "\n| The Rod of Iron attribute adds a 15% boost to your       |"
        + "\n| current obedience level.                                         |"            
        + "\n|----------------------------------------------------------|"            
        + "\n| MAN IN WHITE ROBE (Testimony strength)                   |"
        + "\n| The Man in White Robe attribute adds a 15% boost to your |"
        + "\n| testimony level.                                         |"            
        + "\n|----------------------------------------------------------|"                        
        + "\n| STRAIGHT & NARROW PATH (Obedience & Testimony strength)  |"
        + "\n| The Straight & Narrow Path attribute adds a 10% boost to |"
        + "\n| your obedience and testimony levels.                     |"                        
        + "\n|----------------------------------------------------------|"
        + "\n| X - Return to Game Menu                                            |"
        + "\n|----------------------------------------------------------|");
    }
    
@Override
public boolean doAction(Object obj) {
    
    String value = (String) obj;
    
    value = value.toUpperCase(); //convert to all upper case
    char choice = value.charAt(0); // get first character entered
    boolean done = false;
    
        switch (choice)
        {
            case 'X':
                done = true;
                break;
            default:
                this.console.println("Invalid selection");
                break;       
        }
        return done;
    }    
}
