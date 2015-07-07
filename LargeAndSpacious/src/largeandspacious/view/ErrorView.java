/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.view;

import java.io.PrintWriter;
import largeandspacious.LargeAndSpacious;

/**
 *
 * @author Paul Merideth
 */
public class ErrorView
{
    private static final PrintWriter errorFile = LargeAndSpacious.getOutFile();
    private static final PrintWriter logFile = LargeAndSpacious.getLogFile();
    
    public static void display(String className, String errorMessage)
    {
        errorFile.println(
                "----------------------------------------------------------"
              + "\n- Error - " + errorMessage
              + "\n----------------------------------------------------------");
        
        //Log error
        logFile.println(className + " -- " + errorMessage);
    }
}
