package io;

import java.io.IOException;

public class FileIODemo {
    public static void main(String[] args) {
        try {
            //FileIO.copyFile("FileIO.java", "FileIO.bak");
            System.out.println(FileIO.readAsString("file1.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
