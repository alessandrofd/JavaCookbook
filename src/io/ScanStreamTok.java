package io;

import java.io.*;

/**
 * Created by Alessandro on 21/04/2014.
 */
public class ScanStreamTok {
    protected StreamTokenizer tokenizer;

    public static void main(String[] args) throws IOException {
        if (args.length == 0)
            new ScanStreamTok(new InputStreamReader(System.in)).process();
        else
            for (int i = 0; i < args.length; i++)
                new ScanStreamTok(args[i]).process();

    }

    /** Construct a file scanner by name */
    public ScanStreamTok(String filename) throws IOException {
        this(new FileReader(filename));
    }

    /** Construct a file scanner by existeing reader */
    public ScanStreamTok(Reader reader) throws IOException{
        tokenizer = new StreamTokenizer(reader);
        tokenizer.eolIsSignificant(true);
    }

    private void process() throws IOException {
        int i;

        while ((i = tokenizer.nextToken()) != StreamTokenizer.TT_EOF)
            switch (i) {
                case StreamTokenizer.TT_EOF:
                    System.out.println("End of file");
                    break;
                case StreamTokenizer.TT_EOL:
                    System.out.println("End of line");
                    break;
                case StreamTokenizer.TT_NUMBER:
                    System.out.println("Number " + tokenizer.nval);
                    break;
                case StreamTokenizer.TT_WORD:
                    System.out.println("Word, length " + tokenizer.sval.length()  + " -> " + tokenizer.sval);
                    break;
                default:
                    System.out.println("Character " + (char)i);
            }
    }
}
