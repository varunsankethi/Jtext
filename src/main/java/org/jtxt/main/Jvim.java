package org.jtxt.main;

import org.jtxt.layer.*;
import org.jtxt.layer.impl.BufferPrimsArrayList;

import java.io.*;

public class Jvim {
    public static void main(String[] args) throws IOException {

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(is);
        String line;

        BufferPrims bufferPrims = new BufferPrimsArrayList();
        ExecuteCommand commandExecuter = new ExecuteCommand(bufferPrims);
        while ((line = bufferedReader.readLine()) != null) {
            char[] commandArr = LineParser.parseCommand(line);
            Command command = new Command();
            Command c = command.commandParser(commandArr);

            if (c == null) {

            } else {
                commandExecuter.execute(c);
            }
        }


    }

}
