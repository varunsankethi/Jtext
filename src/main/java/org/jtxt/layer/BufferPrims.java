package org.jtxt.layer;

import java.io.IOException;
import java.util.List;

public interface BufferPrims {

    int addLines() throws IOException;
    void deleteLines(String line);

    int getNumberOfLines();

    void readBuffer() throws IOException, InterruptedException;
    void displayOpenedFile() throws IOException;

    void openBuffer();

    String getCurrentLine();

    void printAllLines(Command command);

    void writeToFile();

    StringBuffer readIntoBuffer(String fileName) throws IOException;
    List<String> readIntoBufferArray(String fileName) throws IOException;

    void writeToFile(String fileName) throws IOException;
}
