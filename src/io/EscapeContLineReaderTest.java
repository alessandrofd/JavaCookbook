package io;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Alessandro on 22/04/2014.
 */
public class EscapeContLineReaderTest {
    final static String testData =
        "Some lines of text to test the LineReader class.\n" +
        "This second line is continued with backslash.\\\n" +
        "This is a backslash continuation.\\\n" +
        "This is the end\n" +
        "This line should be the third output line.\n" +
        "EXPECT THE NEXT LINE TO THROW AN IOException\n" +
        "This tests for line ending in \\";


    public static void main(String[] args) {
        EscapeContLineReader is = new EscapeContLineReader(new StringReader(testData));
        String s;
        try {
            while ((s = is.readLine()) != null)
                System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
