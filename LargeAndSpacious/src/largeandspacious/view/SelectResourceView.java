package largeandspacious.view;

import java.util.Scanner;

/**
 *
 * @author Paul Merideth
 */
public class SelectResourceView extends View
{
    public SelectResourceView()
    {
        super("\n"
            + "\n|------------------------------------------|"
            + "\n|  Select Resource Menu                    |"
            + "\n|------------------------------------------|"
            + "\n| O - Play for Obedience                   |"
            + "\n| T - Play for Testimony                   |"
            + "\n| -----------------------------------------|"
            + "\n|   Use an Attribute                       |"
            + "\n| I - Rod of Iron                          |"
            + "\n| S - Straight and Narrow Path             |"
            + "\n| W - Man in White Rob                     |"
            + "\n| X - Return to Game Menu                  |"
            + "\n|------------------------------------------|");
    }

    @Override
    public boolean doAction(Object obj)
    {
        String value = (String) obj;
        value = value.toUpperCase();
        char choice = value.charAt(0);
        boolean done = false;
                        
        switch(choice)
        {
            case 'O': 
                //Play for obedience
                this.selectObedience();
                break;
            case 'T': 
                //Play for Testimony
                this.selectTestimony();
                break;                
            case 'I': 
                //Use Rod of Iron
                this.useRodOfIron();
                break;
            case 'S': 
                //Use Straight and Narrow
                this.useStraightAndNarrow();
                break;
            case 'W': 
                //Use Man in White Robe
                this.useManInWhiteRobe();
                break;
            case 'X':
                //Return to game menu
                done = true;
                break;
            default: 
                System.out.println("Invalid selection");
                break;
        }
        return done;
    }

    private void selectObedience()
    {
        System.out.println("*** selectObedience function called ***");        
    }

    private void selectTestimony()
    {
        System.out.println("*** selectTestimony function called ***");                
    }

    private void useRodOfIron()
    {
        System.out.println("*** useRodOfIron function called ***");                        
    }

    private void useStraightAndNarrow()
    {
        System.out.println("*** useStraightAndNarrow function called ***");                
    }

    private void useManInWhiteRobe()
    {
        System.out.println("*** useManInWhiteRobe function called ***");                        
    }
}
