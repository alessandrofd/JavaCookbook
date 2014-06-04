package strings;

import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

/**
 * Created by Alessandro.Dantas on 05/03/14.
 */
public class Fmt {
    //** The maximum column width */
    public static final int COLWIDTH = 72;
    /** The file tha we read and format */
    final BufferedReader in;
    /** Where the output goes */
    PrintWriter out;

    /** If files present, format each, else format the standart input. */
    public static void main(String[] args) throws IOException {
        if (args.length == 0)
            new Fmt(System.in).format();
        else for (String name: args)
            new Fmt(name).format();
    }

    public Fmt(BufferedReader inFile, PrintWriter outFile) {
        this.in = inFile;
        this.out = outFile;
    }

    public Fmt(PrintWriter out) {
        this(new BufferedReader(new InputStreamReader(System.in)), out);
    }

    /** Construct a Formatter given an open Reader */
    public Fmt(BufferedReader file) throws IOException {
        this(file, new PrintWriter(System.out));
    }

    /**Construct a Formatter give a filename */
    public Fmt(String fname) throws IOException {
        this(new BufferedReader(new FileReader(fname)));
    }

    /** Construct a Formatter given an open Stream. */
    public Fmt(InputStream file) throws IOException {
        this(new BufferedReader(new InputStreamReader(file)));
    }

    /** Format the File contained in a constructed Fmt object */
    public void format() throws IOException {
        String line;
        StringBuilder outBuf = new StringBuilder();
        System.out.println("Beginning formatting");
        while ((line = in.readLine()) != null) {
            if (line.length() == 0) { // null line
                out.println(outBuf); // end current line
                out.println(); // output blank line
                outBuf.setLength(0);
            } else {
                // otherwise it's text, so format it.
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreElements()) {
                    String word = st.nextToken();

                    // If this word would go past the margin,
                    // first dump out anything previous.
                    if (outBuf.length() + word.length() > COLWIDTH) {
                        out.println(outBuf);
                        outBuf.setLength(0);
                    }
                    outBuf.append(word).append(' ');
                }
            }
        }
        if (outBuf.length() > 0) {
            out.println(outBuf);
        } else {
            out.println();
        }
        out.flush();
    }
}
