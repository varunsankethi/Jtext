package org.jtxt.layer.impl;

import org.jtxt.layer.BufferPrims;
import org.jtxt.layer.Command;

import java.io.*;
import java.util.ArrayList;
import java.util.List;




public class BufferPrimsArrayList implements BufferPrims {

    List<String> bufferArray = new ArrayList<>();
    String fileName;
    File f;

    @Override
    public int addLines() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null && !line.equals(".")) {
            line = line + '\n';
            bufferArray.add(line);
        }

        return getNumberOfLines();
    }


    @Override
    public int getNumberOfLines() {
        return bufferArray.size();
    }


    @Override
    public String getCurrentLine() {
        return bufferArray.get(bufferArray.size() - 1);
    }

    @Override
    public void printAllLines(Command command) {

        StringBuffer printBuffer = new StringBuffer();
        List<String> printList = null;
        if (command.isAddressStartFound() && command.getAddressSeperator() == ',' && command.isAddressEndFound()) {
            printList = bufferArray.subList(command.getAddressStart() - 1, command.getAddressEnd());
            for (String s : printList) {
                printBuffer.append(s);
            }
        } else if (command.getAddressSeperator() == ',' && command.isAddressEndFound()) {
            if(command.getAddressEnd() >= bufferArray.size()) {
                command.setAddressEnd(bufferArray.size() -1);
            }
            printList = bufferArray.subList(0, command.getAddressEnd());
            for (String s : printList) {
                printBuffer.append(s);
            }
        } else if (command.isAddressEndFound()) {
            printList =bufferArray.subList(command.getAddressStart() - 1, bufferArray.size() - 1);
            for (String s : printList) {
                printBuffer.append(s);
            }
        } else {
            System.out.println("Inside default condition");
            for (String s : bufferArray) {
                printBuffer.append(s);
            }
        }

        System.out.println(printBuffer.toString());
    }

    @Override
    public List<String> readIntoBufferArray(String fileName) throws IOException {
        String lineRead;
        System.out.println("Complete file path: "  + fileName);
        BufferedReader fileBufferedReader = new BufferedReader(new FileReader(fileName));
        while ((lineRead = fileBufferedReader.readLine()) != null) {
            lineRead = lineRead + '\n'; // Appending the newline character // TODO: Change this to System.lineSeparator() while refactoring
            bufferArray.add(lineRead);
        }
        System.out.println("Size of buffer read = " + bufferArray.size());
        return bufferArray;
    }

    @Override
    public void writeToFile(String fileName) throws IOException {
        BufferedWriter fileBufferedWriter = new BufferedWriter(new FileWriter(fileName));
        String line = "";
        for (String s : bufferArray) {
            line = line + s;
        }
        fileBufferedWriter.write(line);
        fileBufferedWriter.flush();
        fileBufferedWriter.close();

    }

    @Override
    public void deleteLines(String line) {

    }

    @Override
    public void readBuffer() throws IOException, InterruptedException {

    }

    @Override
    public void displayOpenedFile() throws IOException {

    }

    @Override
    public void writeToFile() {

    }

    @Override
    public void openBuffer() {

    }

    // Unused here. Was previously used in the BufferPrimsStringBuffer class
    // Not needed here in the BufferPrimsArrayList implementation
    @Override
    public StringBuffer readIntoBuffer(String fileName) throws IOException {
        return null;
    }
}
