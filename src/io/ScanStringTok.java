package io;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * Show scanning a file with a StringTokenizer
 */
public class ScanStringTok {
    LineNumberReader is;

    public static void main(String[] args) throws IOException{
        if (args.length == 0)
            new ScanStringTok(new InputStreamReader(System.in)).process();
        else
            for (int i = 0; i < args.length; i++) {
                new ScanStringTok(args[i]).process();
            }
    }

    /** Construct a file scanner by name */
    public ScanStringTok(String fileName) throws IOException {
        is = new LineNumberReader(new FileReader(fileName));
    }

    /** Construct a file scanner by existing reader */
    public ScanStringTok(Reader reader) throws IOException {
        // no point in adding another level of buffering, if already being buffered ...
        if (reader instanceof LineNumberReader)
            is = (LineNumberReader)reader;
        else
            is = new LineNumberReader(reader);
    }

    protected void process() {
        String s = null;
        try {
            while ((s = is.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(s, "@", true);
                String user = (String)st.nextElement();
                st.nextElement();
                String host = (String)st.nextElement();
                System.out.println("User name: " + user + "; host part: " + host);
            }
        } catch(IOException | NoSuchElementException e) {
            e.printStackTrace();
        }
    }

}
