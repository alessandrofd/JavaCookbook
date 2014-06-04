package environ;

import sun.security.ssl.Debug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** GetOpt implements UNIX-style (single-character) command line argument
 * parsing. Originally patterned after (but not using code from) the UNIX
 * getopt(3) program, this has been redesigned to be more Java-friendly.
 * As a result, there are two ways of using it, referred to as
 * "the Unis way" and the "Java way".
 * Created by Alessandro.Dantas on 10/03/14.
 */
public class GetOpt {

    /** The List of File Names found after args */
    protected List<String> fileNameArguments;
    /** The set of characters to look for */
    protected final GetOptDesc[] options;
    /** Where we are in the options. */
    protected int optind = 0;
    /** Public constant form "no more options */
    public static final int DONE = 0;
    /** Internal flag - whether we are done all the options */
    protected boolean done = false;
    /** The current option argument */
    protected String optarg;

    /** Retrieve the index into args of the last option we looked at */
    public int getOptind() { return optind; }

    /** Retrieve the current option argument; UNIX variant spelling. */
    public String optarg() {
        return optarg;
    }

    /** Retrieve the current option argument; Java variant spelling */
    public String optArg() {
        return optarg;
    }

    /** Construct a GetOptParser, given the option specifications
     * in an array of GetOptDesc objects. This is the preferred constructor.
     */
    public GetOpt(final GetOptDesc[] opt) {
        this.options = opt.clone();
    }

    /** Construct a GetOpt parser, storing the set of option characters.
     * This is a legacy constructor for backwards compatibility.
     * That said, it is easier to use if you don't need long-name options,
     * so it has not been and will not be marked "deprecated".
     */
    public GetOpt(final String patt) {
        if (patt == null)
            throw new IllegalArgumentException("Pattern may not be null");

        if (patt.charAt(0) == ':')
            throw new IllegalArgumentException("Pattern incorrect, may not begin with ':'");


        // Pass One: just count the option letters in the pattern
        int n = 0;
        for (char ch : patt.toCharArray()) {
            if (ch != ':')
                ++n;
        }
        if (n == 0)
            throw new IllegalArgumentException("No option letters found in " + patt);

        // Pass Two: construct an array of GetOptDesc objects.
        options = new GetOptDesc[n];
        for (int i = 0, ix = 0; i < patt.length(); i++) {
            final char c = patt.charAt(i);
            boolean argTakesValue = false;
            if (i < patt.length()-1 && patt.charAt(i+1) == ':') {
                argTakesValue = true;
                ++i;
            }
            Debug.println("getopt", "CONSTR: options[" + ix + "] = " + c + ", " + argTakesValue);
            options[ix++] = new GetOptDesc(c, null, argTakesValue);
        }
    }

    /** Reset this GetOpt parser */
    public void rewind() {
        fileNameArguments = null;
        done = false;
        optind = 0;
        optarg = null;
    }

    /** Modern way of using GetOpt: call this once and get all options.
     * <p>
     * This parses the options, returns a Map whose keys are the found options.
     * Normally followed by a call to getFilenameList().
     * <br> Side effect: sets "fileNameArguments" to a new List
     * @return a Map whose keys are Stings of length 1 (containing the char
     * from the option tha was matched) and whose value is a String
     * containing the value, or null for a non-option argument.
     */
    public Map<String, String> parseArguments(String[] args) {
        Map<String, String> optionsValueMap = new HashMap<String, String>();
        fileNameArguments = new ArrayList<String>();
        for (int i = 0; i < args.length; i++) { //Cannot use foreach, need i
            Debug.println("getopt", "parseArg: i=" + i + ": arg " + args[i]);
            char c = getopt(args); // sets global "optarg"
            if (c == DONE) {
                fileNameArguments.add(args[i]);
            } else {
                optionsValueMap.put(Character.toString(c), optarg);
                // if this arg takes an option, must arrange here to skip it.
                if (optarg != null) {
                    i++;
                }
            }
        }
        return optionsValueMap;
    }

    /** Get the list of filename-like arguments after options;
     * only for use if you called parseArguments.
     */
    public List<String> getFilenameList() {
        if (fileNameArguments == null) {
            throw new IllegalArgumentException("Illegal call to getFilenameList() before parseOptions()");
        }
        return fileNameArguments;
    }

    /** The true heart of getopt, wether used old way or new way:
     * returns one argument; call repeatedly until it returns DONE.
     * Side-effect: sets globals optarg, optind
     */
    public char getopt(String[] args) {
        Debug.println("getopt", "optind=" + optind + ", args.length=" + args.length);

        if (optind >= args.length || !args[optind].startsWith("-")) {
            done = true;
        }

        // If we are finished (either now OR from before), bail.
        // Don not collapse this into the "if" above
        if (done) {
            return DONE;
        }

        optarg = null;

        // TODO - two-pass, 1st check long args, 2nd check for char, to allow advanced usage like "-no outfile" == "-n -o outfile"

        // Pick off next command line argument, if it starts "-" then look it up in the list of valid args.
        String thisArg = args[optind];

        if (thisArg.startsWith("-")) {
            for (GetOptDesc option: options) {
                if ((thisArg.length() == 2 && option.getArgLetter() == thisArg.charAt(1)) ||
                    (option.getArgName() != null && option.getArgName().equals(thisArg.substring(1)))) { //found it
                    // If it needs an option argument, get it.
                    if (option.TakesArgument()) {
                        if (optind < args.length - 1)
                            optarg = args[++optind];
                        else
                            throw new IllegalArgumentException("Option " + option.getArgLetter() + " needs value but found end of arg lis");
                    }
                    ++optind;
                    return option.getArgLetter();
                }
            }
            // Began with "-" but not matched, so must be error.
            ++optind;
            return '?';
        } else {
            // Found non-argument non-option word in args: end of options.
            ++optind;
            done = true;
            return DONE;
        }
    }

}
