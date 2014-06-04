package io;

import java.io.IOException;
import java.io.StringReader;

public class IndentContLineReaderTest {

    protected final static String sampleTxt =
        "From: ian today now\n" +
        "Received: by foo.bar.com\n" +
        "	at 12:34:56 January 1, 2000\n" +
        "X-Silly-Headers: Too Many\n" +
        "This line should be line 5.\n" +
        "Test more indented line continues from line 6:\n" +
        "    space indented.\n" +
        "	tab indented;\n" +
        "\n" +
        "This is line 10\n" +
        "the start of a hypothetical mail/news message, \n" +
        "that is, it follows a null line.\n" +
        "	Let us see how it fares if indented.\n" +
        " also space-indented.\n" +
        "\n" +
        "How about text ending without a newline?";

    public static void main(String[] args) throws IOException {
        IndentContLineReader is = new IndentContLineReader(new StringReader(sampleTxt));
        String s;

        // Print Mail/News Header
        System.out.println("----- Message Header -----");
        while ((s = is.readLine()) != null && s.length() > 0)
            System.out.println(is.getLineNumber() + ": " + s);

        // Make "is" behave like a normal BufferedReader.
        is.setContinuationMode(false);
        System.out.println("----- Message Body -----");
        while ((s = is.readLine()) != null && s.length() > 0)
            System.out.println(is.getLineNumber() + ": " + s);

        is.close();
    }

}
