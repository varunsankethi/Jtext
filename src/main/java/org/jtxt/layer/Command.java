package org.jtxt.layer;

import java.util.HashMap;
import java.util.Map;

public class Command {

    int addressStart;
    int addressEnd;
    char commandLetter;
    char commandParameter;
    char addressSeperator;
    boolean addressSeparatorFound;
    boolean addressStartFound;
    boolean addressEndFound;
    Map<String, String> parameterMap = new HashMap<>();
    boolean parametersFound;


    public Map<String, String> getParameterMap() {
        return parameterMap;
    }

    public void setParameterMap(Map<String, String> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public boolean isParametersFound() {
        return parametersFound;
    }

    public void setParametersFound(boolean parametersFound) {
        this.parametersFound = parametersFound;
    }

    public boolean isAddressStartFound() {
        return addressStartFound;
    }

    public void setAddressStartFound(boolean addressStartFound) {
        this.addressStartFound = addressStartFound;
    }

    public boolean isAddressEndFound() {
        return addressEndFound;
    }

    public void setAddressEndFound(boolean addressEndFound) {
        this.addressEndFound = addressEndFound;
    }

    public boolean isAddressSeparatorFound() {
        return addressSeparatorFound;
    }

    public void setAddressSeparatorFound(boolean addressSeparatorFound) {
        this.addressSeparatorFound = addressSeparatorFound;
    }

    public int getAddressStart() {
        return addressStart;
    }

    public void setAddressStart(int addressStart) {
        this.addressStart = addressStart;
    }

    public int getAddressEnd() {
        return addressEnd;
    }

    public void setAddressEnd(int addressEnd) {
        this.addressEnd = addressEnd;
    }

    public char getCommandLetter() {
        return commandLetter;
    }

    public void setCommandLetter(char commandLetter) {
        this.commandLetter = commandLetter;
    }

    public char getCommandParameter() {
        return commandParameter;
    }

    public void setCommandParameter(char commandParameter) {
        this.commandParameter = commandParameter;
    }

    public char getAddressSeperator() {
        return addressSeperator;
    }

    public void setAddressSeperator(char addressSeperator) {
        this.addressSeperator = addressSeperator;
    }

    public Command commandParser(char[] commandArr) {
        Command command = new Command();
        int i=0;
        if (Character.isDigit(commandArr[i])) {
            command.addressStartFound = true;
            i++;
            if (commandArr[i] == ',') {
                command.addressSeparatorFound = true;
                i++;
            }
            if (command.addressStartFound && command.addressSeparatorFound && Character.isDigit(commandArr[i])) {
                command.addressEndFound = true;
                i++;
            }

        } else if (commandArr[i] == ',') {
            System.out.println("In this if condition!");
            command.addressSeparatorFound = true;
            i++;
            if (Character.isDigit(commandArr[i])) {
                System.out.println("Also inside this if condition");
                command.addressEndFound = true;
                i++;
            }
        }

        if (command.addressStartFound && command.addressSeparatorFound && command.addressEndFound) {
            System.out.println("First condition is executed instead of the second");
            command.addressStart=Character.getNumericValue(commandArr[0]);
            command.addressEnd=Character.getNumericValue(commandArr[2]);
            command.addressSeperator=',';
        } else if (command.addressSeparatorFound && command.addressEndFound) {
            System.out.println("Expecting this if condition to be executed!!");
            command.addressStart=0;
            command.addressSeperator=',';
            command.addressEnd=Character.getNumericValue(commandArr[1]);
        } else if (command.addressStartFound && !command.addressSeparatorFound && !command.addressEndFound) {
            System.out.println("Third condition is executed instead of the second");
            command.addressStart=0;
            command.addressSeperator=',';
            command.addressEnd=Character.getNumericValue(commandArr[0]);
        } else {

        }

        if (commandArr[i] == 'q') {
            command.commandLetter = 'q';
        }

        if (commandArr[i] == 'a') {
            command.commandLetter = 'a';
        }

        if (commandArr[i] == 'p') {
            command.commandLetter = 'p';
        }

        if (commandArr[i] == 'r') {
            command.commandLetter = 'r';
            i++;
            String fileName = new String(commandArr, i, commandArr.length-1);
            command.parametersFound = true;
            command.parameterMap.put("ReadFileName", fileName);
        }

        if(commandArr[i] == 'w') {
            command.commandLetter = 'w';
            i++;
            String fileName = new String(commandArr, i, commandArr.length-1);
            command.parametersFound = true;
            command.parameterMap.put("WriteFileName", fileName);
        }

        return command;
    }
}
