package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

/**
 * Created by Alessandro on 23/04/2014.
 */
public class ReadGZIP {
    public static void main(String[] args) throws IOException {
        String FILENAME = "file.txt.gz";

        // Since there are 4 constructor call here, I wrote them out in full.
        // In real life you would probably nest these constructor calls
        FileInputStream fin = new FileInputStream(FILENAME);
        GZIPInputStream gzis = new GZIPInputStream(fin);
        InputStreamReader xover = new InputStreamReader(gzis);
        BufferedReader is = new BufferedReader(xover);

        String line;
        // Now read lines of text: the BufferedReader puts them in lines,
        // the InputStreamReader does Unicode conversion, and the
        // GZIPInputStream "gunzip"s the data from the FileInputStream
        while ((line = is.readLine()) != null)
            System.out.println("Read: " + line);
    }
}
