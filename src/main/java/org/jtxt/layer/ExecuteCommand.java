package org.jtxt.layer;

import static org.jtxt.util.Constants.READ_FILE_NAME;
import static org.jtxt.util.Constants.WRITE_FILE_NAME;
import java.io.IOException;
import java.util.Map;

public class ExecuteCommand {

    BufferPrims bufferPrims;
    Map<String, String> paramMap;

    public ExecuteCommand(BufferPrims bufferPrims) {
        this.bufferPrims = bufferPrims;
    }

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
                break;
            case 'p':
                bufferPrims.printAllLines(command);
                break;
            case 'c':
                System.out.println(bufferPrims.getCurrentLine());
                break;
            case 'w':
                bufferPrims.writeToFile(paramMap.get(WRITE_FILE_NAME));
                break;
            case 'r':
                bufferPrims.readIntoBufferArray(paramMap.get(READ_FILE_NAME));
                System.out.println("File Read into buffer, Buffer is ready to be appended !!!! Fire away !!");
                break;
            default:
                System.out.println("Unknown command ?");

        }
    }
}
