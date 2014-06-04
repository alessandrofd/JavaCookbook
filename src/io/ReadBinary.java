package io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Alessandro.Dantas on 23/04/2014.
 */
public class ReadBinary {
    public static void main(String[] args) throws IOException{
        DataInputStream is = new DataInputStream(new FileInputStream("binary.dat"));
        int i = is.readInt();
        double d = is.readDouble();
        is.close();
        System.out.println("Just read " + i + " and " + d + " from a binary file.");

    }
}
