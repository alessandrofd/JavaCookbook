package environ;

/**
 * Created by Alessandro.Dantas on 10/03/14.
 */
public class GetOptSimple {
    public static void main(String[] args) {
        GetOpt go = new GetOpt("h");
        char c;
        while ((c = go.getopt(args)) != 0) {
            switch (c) {
            case 'h':
                helpAndExit(0);
                break;
            default:
                System.err.println("Unknown option in " + args[go.getOptind()-1]);
                helpAndExit(1);
            }
        }
        System.out.println();
    }

    static void helpAndExit(int returnValue) {
        System.err.println("This would tell you how to use this program");
        System.err.println(returnValue);
    }
}
