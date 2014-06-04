package regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** A command-line grep-like program. No options, but takes a pattern
 * and a arbitrary list of text files
 * Created by Alessandro.Dantas on 07/03/14.
 */
public class Grep1 {
    /** The pattern we're looking for */
    protected Pattern pattern;
    /** The matcher for this pattern */
    protected Matcher matcher;

    /** Main will make a Grep object for this pattern, and run it
     * on all input files listed in args.
     */
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Usage: Grep1 pattern [filename]");
            System.exit(1);
        }

        Grep1 pg = new Grep1(args[0]);

        if (args.length ==1)
            pg.process(new BufferedReader(new InputStreamReader(System.in)), "(standard input)", false);
        else
            for (int i = 1; i < args.length; i++)
                pg.process(new BufferedReader(new FileReader(args[i])), args[i], true);


    }

    /** Construct a Grep1 program */
    public Grep1(String patt) {
        pattern = Pattern.compile(patt);
        matcher = pattern.matcher("");
    }

    /** Do the work of scanning one file
     * @param inputFile BufferedReader object already open
     * @param fileName String name of the input file
     * @param printFileName boolean - true to print filename before lines that match
     */
    void process(BufferedReader inputFile, String fileName, boolean printFileName) {
        String inputLine;
        try {
            while ((inputLine = inputFile.readLine()) != null) {
                matcher.reset(inputLine);
                if (matcher.lookingAt()) {
                    if (printFileName) {
                        System.out.print(fileName + ": ");
                    }
                    System.out.println(inputLine);
                }
            }
            inputFile.close();
        } catch (IOException e) { System.err.println(e); }
    }
}
