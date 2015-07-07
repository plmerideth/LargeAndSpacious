/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.view;

//import java.util.Scanner;

/**
 *
 * @author julzlee
 */
public class MapMenuView extends View {
    
    public MapMenuView() {
        super("\n"
            + "\n   |---------------------------|"
            + "\n   | 1 | 2 | 3 | 4 | 5 | 6 | 7 |"
            + "\n---|---------------------------|"
            + "\n 1 |   |   |   |   |   |   |   |"
            + "\n---|---------------------------|"
            + "\n 2 |   |   |   |   |   |   |   |"
            + "\n---|---------------------------|"
            + "\n 3 |   |   |   |   |   |   |   |"
            + "\n---|---------------------------|"
            + "\n 4 |   |   |   |   |   |   |   |"
            + "\n---|---------------------------|"
            + "\n 5 |   |   |   |   |   |   |   |"
            + "\n---|---------------------------|"
            + "\n   | X - Exit Map              |"
            + "\n---|---------------------------|");
    }

@Override
public boolean doAction(Object obj) {
    
    String value = (String) obj;
    boolean done = false;
    
    value = value.toUpperCase(); //convert to all upper case
    char choice = value.charAt(0); // get first character entered
        switch (choice) {
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
