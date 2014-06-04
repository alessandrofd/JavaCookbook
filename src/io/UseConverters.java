package io;

import java.io.*;

public class UseConverters {
    public static void main(String[] args) {
        try {
            BufferedReader fromKanji =
                new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("kanji.txt"), "Shift_JIS"));
            PrintWriter toSwedish =
                new PrintWriter(
                    new OutputStreamWriter(
                        new FileOutputStream("sverige.txt"), "ISO8859_3"));

            // reading and writing here ...
            String line = fromKanji.readLine();
            System.out.println("-->" + line + "<--");
            toSwedish.println(line);
            fromKanji.close();
            toSwedish.close();
        } catch (UnsupportedEncodingException e) {
            System.err.println("Bad encoding: " + e);
            return;
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
            return;
        }
    }
}
