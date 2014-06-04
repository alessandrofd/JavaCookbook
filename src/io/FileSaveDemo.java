package io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class FileSaveDemo {
    public static final String FILENAME = "FileSaverDemo.txt";
    public static final String MESSAGE = "The quick brown fox jumps over the lazy dog.";

    public static void main(String[] args) throws IOException{
        FileSaver saver = new FileSaver(new File(FILENAME));
        PrintWriter writer = new PrintWriter(saver.getWriter());
        writer.println(MESSAGE);
        writer.close();
        saver.finish();
    }

}
