package org.jtxt.layer;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.Map;

public class ExecuteCommand {

    BufferPrims bufferPrims;
    Map<String, String> paramMap;

    public ExecuteCommand(BufferPrims bufferPrims) {
        this.bufferPrims = bufferPrims;
    }

    /*public void execute (Commands command) throws IOException {
        switch (command) {
            case q:
                System.exit(0);
                break;
            case a:
                int i = bufferPrims.addLines();
                bufferPrims.printAllLines();
                //}
                break;
            case p:
                bufferPrims.printAllLines();
                break;
            case c:
                System.out.println(bufferPrims.getCurrentLine());
                break;
            case w:
                break;
            default:
                System.out.println("Unknown command ?");

        }
    }*/
    /*public void execute (char command) throws IOException {
        switch (command) {
            case 'q':
                System.exit(0);
                break;
            case 'a':
                int i = bufferPrims.addLines();
                //bufferPrims.printAllLines();
                //}
                break;
            case 'p':
                bufferPrims.printAllLines(command);
                break;
            case 'c':
                System.out.println(bufferPrims.getCurrentLine());
                break;
            case 'w':
                break;
            default:
                System.out.println("Unknown command ?");

        }
    }*/

    public void execute(Command command) throws IOException {
        if (command.isParametersFound()) {

            paramMap = command.getParameterMap();
        }
        switch (command.commandLetter) {
            case 'q':
                System.exit(0);
                break;
            case 'a':
                int i = bufferPrims.addLines();
                //bufferPrims.printAllLines();
                //}
                break;
            case 'p':
                bufferPrims.printAllLines(command);
                break;
            case 'c':
                System.out.println(bufferPrims.getCurrentLine());
                break;
            case 'w':
                bufferPrims.writeToFile(paramMap.get("WriteFileName"));
                break;
            case 'r':
                //bufferPrims.readIntoBuffer(paramMap.get("ReadFileName"));
                bufferPrims.readIntoBufferArray(paramMap.get("ReadFileName"));
                System.out.println("File Read into buffer, Buffer is ready to be appended !!!! Fire away !!");
                break;
            default:
                System.out.println("Unknown command ?");

        }
    }
}
