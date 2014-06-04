package environ;

import java.util.Map;

/**
 * Created by Alessandro.Dantas on 10/03/14.
 */
public class GetOptParseArgsDemo {
    public static void main(String[] args) {
        GetOptDesc[] options = {
                new GetOptDesc('n', "numeric", false),
                new GetOptDesc('o', "output-file", true),
        };
        Map<String, String> optionsFound = new GetOpt(options).parseArguments(args);
        if (optionsFound.get("n") != null) {
            System.out.println("sortType = NUMERIC;");
        }
        String outputFile = null;
        if ((outputFile = optionsFound.get("o")) != null) {
            System.out.println("output file specified as " + outputFile);
        } else {
            System.out.println("output to System.out");
        }
    }
}
