package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alessandro.Dantas on 06/03/14.
 */
public class REmatchTwoFields {
    public static void main(String[] args) {
        String inputLine = "Adams, John Quincy";
        // Construct an RE with paresn to "grab" both field1 and field2
        Pattern r = Pattern.compile("(.*), (.*)");
        Matcher m = r.matcher(inputLine);
        if (!m.matches())
            throw new IllegalArgumentException("Bad input");
        System.out.println(m.group(2) + ' ' + m.group(1));
    }
}
