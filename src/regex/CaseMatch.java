package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Show case control using RE class.
 * Created by Alessandro.Dantas on 07/03/14.
 */
public class CaseMatch {
    public static void main(String[] args) {
        String pattern = "^q[^u]\\d+\\.";
        String input = "QA777. is the next flight. It is on time.";

        Pattern reCaseInsens = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Pattern reCaseSens = Pattern.compile(pattern);

        boolean found;
        Matcher m;
        m = reCaseInsens.matcher(input); // will match any case
        found = m.lookingAt();
        System.out.println("IGNORE_CASE match " + found);

        m = reCaseSens.matcher(input); // Get matcher w/o case-insens flag
        found = m.lookingAt(); // will match case-sensitively
        System.out.println("MATCH_NORMAL match was " + found);
    }
}
