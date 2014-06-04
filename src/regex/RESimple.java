package regex;

import java.util.regex.Pattern;

/**
 * Created by Alessandro.Dantas on 06/03/14.
 */
public class RESimple {
    public static void main(String[] args) {
        String pattern = "^Q[^u]\\d+\\.";
        String input = "QA777 is the next flight. It is on time.";

        Pattern p = Pattern.compile(pattern);

        boolean found = p.matcher(input).lookingAt();

        System.out.println("'" + pattern + "'" + (found ? " matches '" : " doesn't match '") + input + "'");
    }
}
