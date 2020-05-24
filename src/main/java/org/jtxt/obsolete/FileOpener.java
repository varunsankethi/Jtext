package org.jtxt.obsolete;

import java.io.File;
import java.io.FileNotFoundException;

public class FileOpener {

    String fileName;
    public FileOpener() {
    }

    public FileOpener(String fileName) {
        this.fileName = fileName;
    }

    public File createFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        return file;
    }
}
