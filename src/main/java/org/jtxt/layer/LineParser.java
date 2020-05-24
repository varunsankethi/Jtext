package org.jtxt.layer;

import org.jtxt.obsolete.Commands;

public class LineParser {

    // Unused as of now
    public static char parse(String lineToParse) {
        char[] lineToCharArray = lineToParse.toCharArray();
        Commands command;
        char commandChar = lineToCharArray.length > 0 ? lineToCharArray[0] : 'U';
        return commandChar;

    }
    public static Commands parseLine(String lineToParse) {
        char[] lineToCharArray = lineToParse.toCharArray();
        Commands command;
        char commandChar = lineToCharArray.length > 0 ? lineToCharArray[0] : 'U';

        int i =0;

        /*if (i==',') {
           getCommandOptions(',');
        }*/

        if(Character.isDigit(lineToCharArray[i])) {

            i++;
        }

        if (lineToCharArray[i] == ',') {

        }



        /*if (Commands.valueOf(String.valueOf(commandChar)) != null) {
            return Commands.valueOf(String.valueOf(commandChar));
        }*/
        return null;

        // getCommandOptions();

    }
    private static void getCommandOptions(char ch) {

    }

    public static char[] parseCommand(String line) {
        char[] lineToCharArray = line.toCharArray();

        //Commands command;
        //char commandChar = lineToCharArray.length > 0 ? lineToCharArray[0] : 'U';

        return lineToCharArray;
    }
}
