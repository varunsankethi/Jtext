package org.jtxt.obsolete;

import java.io.*;

// UNUSED CLASS
public class Experiment {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        File file = new File("/Users/varunsankethi/projects/coding/java-projects/text-editor/jtext/src/test/data/unknown.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        StringBuffer sb = new StringBuffer();
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        //OutputStream outputStream = new BufferedOutputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
    }
}
