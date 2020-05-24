package org.jtxt.obsolete;

public class Commands {


    int startOfCommand;
    int endOfCommand;
    char command;

    public Commands(int startOfCommand, int endOfCommand, char command) {
        this.startOfCommand = startOfCommand;
        this.endOfCommand = endOfCommand;
        this.command = command;
    }

    public int getStartOfCommand() {
        return startOfCommand;
    }

    public void setStartOfCommand(int startOfCommand) {
        this.startOfCommand = startOfCommand;
    }

    public int getEndOfCommand() {
        return endOfCommand;
    }

    public void setEndOfCommand(int endOfCommand) {
        this.endOfCommand = endOfCommand;
    }

    public char getCommand() {
        return command;
    }

    public void setCommand(char command) {
        this.command = command;
    }


   /*
    q('q'), a('a'), p('p'), c('c'), w('w');

    private char command;

    Commands(char q) {
        this.command = command;
    }

    public char getCommand() {
        return command;
    }
*/




}
