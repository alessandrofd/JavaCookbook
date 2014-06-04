package io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;

public class OpenFileByName {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("myFile.txt"));
        BufferedOutputStream bytesOut = new BufferedOutputStream(new FileOutputStream("bytes.dat"));

        // code here to read from reader, write to bytesOut

        bytesOut.close();
    }
}
