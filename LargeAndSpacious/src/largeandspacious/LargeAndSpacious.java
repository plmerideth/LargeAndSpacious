/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
just a test of github
 */
package largeandspacious;

//import largeandspacious.model.Actor;
//import largeandspacious.model.ChallengeScene;
//import largeandspacious.model.Challenges;
//import largeandspacious.model.CombinationScene;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import largeandspacious.model.Game;
import largeandspacious.model.Player;
import largeandspacious.view.ErrorView;
//import largeandspacious.model.Map;
//import largeandspacious.model.QuestionScene;
//import largeandspacious.model.Questions;
//import largeandspacious.model.Item;
//import largeandspacious.model.Location;
import largeandspacious.view.StartProgramView;

/**
 *
 * @author Paul Merideth
 */
public class LargeAndSpacious
{
    private static Game currentGame = null;
    private static Player player = null;

    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    private static PrintWriter logFile = null;

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {        
        try
        {
            LargeAndSpacious.inFile = new BufferedReader(new InputStreamReader(System.in));
            LargeAndSpacious.outFile = new PrintWriter(System.out, true);
        
            //Open log file
            String filePath = "log.txt";
            LargeAndSpacious.logFile = new PrintWriter(filePath);
            
            //Create StartProgramView and start the program
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.startProgram();
            return;
        }
        catch(Exception e)
        {
            ErrorView.display( LargeAndSpacious.class.getSimpleName(), "Exception: " + e.toString() +
                               "\nCause: " + e.getCause() +
                               "\nMessage: " + e.getMessage());
        }
        catch (Throwable te)
        {
            ErrorView.display("LargeAndSpacious.main()", te.getMessage());
            te.printStackTrace();
        }
        finally
        {
            try
            {
                if(LargeAndSpacious.inFile != null)
                    LargeAndSpacious.inFile.close();
                if(LargeAndSpacious.outFile != null)
                    LargeAndSpacious.outFile.close();
                if(LargeAndSpacious.logFile != null)
                    LargeAndSpacious.logFile.close();
            }
            catch(IOException ex)
            {
                System.out.println("Error closing files");
                return;
            }
        }
    }
   
    public static Game getCurrentGame() {
        return currentGame;
    }
    
   public static void setCurrentGame(Game currentGame) {
        LargeAndSpacious.currentGame = currentGame;
    }
    public static Player getPlayer() {
        return player;
    }
    
       public static void setPlayer(Player player) {
        LargeAndSpacious.player = player;
    }
       
    public static PrintWriter getOutFile()
    {
        return outFile;
    }
    
    public static void setOutFile(PrintWriter outFile)
    {
        LargeAndSpacious.outFile = outFile;
    }
    
    public static BufferedReader getInFile()
    {
        return inFile;
    }
    
    public static void setInFile(BufferedReader inFile)
    {
        LargeAndSpacious.inFile = inFile;
    }
    
    public static PrintWriter getLogFile()
    {
        return logFile;
    }
    
    public static void setLogFile(PrintWriter logFile)
    {
        LargeAndSpacious.logFile = logFile;
    }
}
