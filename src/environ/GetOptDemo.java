package environ;

/** Demonstrate the modern way of using GetOpt. This allows a subset of
 * <pre>UNIX sort options: sort -n -o outfile infile1 infile2</pre>
 * which means: sort numerically (-n), writing to file "outfile" (-o
 * outfile), sort from infile1 and infile2.
 */
public class GetOptDemo {
    public static void main(String[] args) {
        GetOpt go = new GetOpt("hno:");
        boolean numeric_option = false;
        String outFileName = "(standard output)";
        char c;
        while ((c = go.getopt(args)) != GetOpt.DONE) {
            switch (c) {
            case 'h':
                doHelp(0);
                break;
            case 'n':
                numeric_option = true;
                break;
            case 'o':
                outFileName = go.optarg();
                break;
            default:
                System.err.println("Unknown option character" + c);
                doHelp(1);
            }
        }
        System.out.print("Options: ");
        System.out.print("Numeric: " + numeric_option + ' ');
        System.out.print("Output " + outFileName + "; ");
        System.out.print("Inputs: ");
        if (go.getOptind() == args.length) {
            doFile("(standard input)");
        } else for (int i = go.getOptind(); i < args.length; i++) {
            doFile(args[i]);
        }
        System.out.println();
    }

    static void doHelp(int returnValue) {
        System.err.println("Usage: GetOptDemo [-h][-n][-o outfile] file ...");
        System.err.println(returnValue);
    }

    static void doFile(String fileName) {
        System.out.print(fileName + ' ');
    }
}
