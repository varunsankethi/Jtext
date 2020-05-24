package org.jtxt.layer.impl;

import org.jtxt.layer.BufferPrims;
import org.jtxt.layer.Command;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.List;


// Not used in the current version of the line editor
// Currently using the BufferPrims implementation class BufferPrimsArrayList
// This was an experiment to see if all the lines can be accepted in a String Buffer which can be done

public class BufferPrimsStringBuffer implements BufferPrims {

    public StringBuffer stringBuffer = new StringBuffer();
    String fileName;
    File f;

    public BufferPrimsStringBuffer(String fileName, File f) {
        this.fileName = fileName;
        this.f = f;
    }

    public BufferPrimsStringBuffer() {
    }

    @Override
    public int addLines() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null && !line.equals(".")) {
            stringBuffer.append(line);
            stringBuffer.append('\n');
        }

        return getNumberOfLines();
    }

    @Override
    public void deleteLines(String line) {


    }

    @Override
    public int getNumberOfLines() {
        return stringBuffer.toString().split("\n").length;
    }

    @Override
    //TODO: Eliminate this bad code into submission !
    public void readBuffer() throws IOException, InterruptedException {
        InputStream is = System.in;
        Reader reader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(reader);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f, true));
        BufferedWriter buffWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        if (this.f.exists()) {
            String line;
            BufferedReader buffRead = new BufferedReader(new FileReader(this.f));
            while ((line = buffRead.readLine()) != null) {
                System.out.println("Inside this");
                buffWriter.write(line);

            }
            buffWriter.flush();
            //buffWriter.close();
        }
        StringBuffer sb = new StringBuffer();
        byte[] s = new byte[1024];
        String curLine;
        /*while ((curLine = LineParser.parse(bufferedReader.readLine())) != null) {
            if (curLine.equals(EXIT)) {
                System.out.println("Command execution");
                doCommand(sb, bufferedReader, bufferedWriter);
            } else {
                sb.append(curLine);
            }
        }*/

    }

    private void doCommand(StringBuffer sb, BufferedReader bufferedReader, BufferedWriter bufferedWriter) throws IOException {
        System.out.println("Indide doCommand");
        bufferedWriter.write(sb.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    @Override
    // TODO: Eliminate this
    public void displayOpenedFile() throws IOException {
        FileInputStream input = new FileInputStream(this.f);
        FileChannel channel = input.getChannel();
        byte[] buffer = new byte[256 * 1024];
        ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);

        try {
            for (int length = 0; (length = channel.read(byteBuffer)) != -1; ) {
                System.out.write(buffer, 0, length);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
    }

    @Override
    public void openBuffer() {

    }

    @Override
    public String getCurrentLine() {
        List<String> bufferAsAList = Arrays.asList(stringBuffer.toString().split("\n"));
        System.out.println("Size of buffer: " + bufferAsAList.size());
        return bufferAsAList.get(bufferAsAList.size() - 1);
    }


    @Override
    public void printAllLines(Command command) {
        StringBuffer printBuffer = new StringBuffer();
        List<String> printList = null;
        List<String> lineList = getBufferAsAList();
        if (command.isAddressStartFound() && command.getAddressSeperator() == ',' && command.isAddressEndFound()) {
            printList = lineList.subList(command.getAddressStart() - 1, command.getAddressEnd());
            for (String s : printList) {
                printBuffer.append(s);
                printBuffer.append("\n");
            }
        } else if (command.getAddressSeperator() == ',' && command.isAddressEndFound()) {
            printList = lineList.subList(0, command.getAddressEnd());
            for (String s : printList) {
                printBuffer.append(s);
                printBuffer.append("\n");
            }
        } else if (command.isAddressEndFound()) {
            printList = lineList.subList(command.getAddressStart() - 1, lineList.size() - 1);
            for (String s : printList) {
                printBuffer.append(s);
                printBuffer.append("\n");
            }
        } else {
            System.out.println("Inside default condition");
            printList = getBufferAsAList();
            for (String s : printList) {
                printBuffer.append(s);
                printBuffer.append("\n");
            }
        }


        System.out.println(printBuffer.toString());
    }

    @Override
    public void writeToFile() {

    }

    @Override
    public StringBuffer readIntoBuffer(String fileName) throws IOException {
        String lineRead;
        //String currDir = System.getProperty("user.dir") + "/src/test/data/";
        //fileName = currDir +  fileName;
        System.out.println("Complete file path: "  + fileName);
        BufferedReader fileBufferedReader = new BufferedReader(new FileReader (fileName));
        while ((lineRead = fileBufferedReader.readLine()) != null) {
            stringBuffer.append(lineRead);
            stringBuffer.append('\n');
        }
        return stringBuffer;
    }

    @Override
    public List<String> readIntoBufferArray(String fileName) throws IOException {
        return null;
    }

    @Override
    public void writeToFile(String fileName) throws IOException {
        BufferedWriter fileBufferedWriter = new BufferedWriter(new FileWriter(fileName));
        fileBufferedWriter.write(stringBuffer.toString());
        fileBufferedWriter.flush();
        fileBufferedWriter.close();
    }

    private List<String> getBufferAsAList() {

        List<String> bufferAsAList = Arrays.asList(stringBuffer.toString().split("\n"));
        //System.out.println("Size of buffer: " + bufferAsAList.size());
        return bufferAsAList;
    }
}
