package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alessandro.Dantas on 07/03/14.
 */
public class LogRegExp {
    public static void main(String[] args) {
        String logEntryPattern =
           "^([\\d.]+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+-]\\d{4})\\] \"(.+?)\" (\\d{3}) (\\d+) \"([^\"]+)\" \"([^\"]+)\"";

        System.out.println("RE Pattern: ");
        System.out.println(logEntryPattern);

        System.out.println("Input line is:");
        String logEntryLine = LogExample.logEntryLine;
        System.out.println(logEntryLine);

        Pattern p = Pattern.compile(logEntryPattern);
        Matcher matcher = p.matcher(logEntryLine);
        if (!matcher.matches() || LogExample.NUM_FIELDS != matcher.groupCount()) {
            System.err.println("Bad log entry (or problem with regex");
            System.err.println(logEntryLine);
            return;
        }
        System.out.println("IP Address: " + matcher.group(1));
        System.out.println("UserName: " + matcher.group(3));
        System.out.println("Date/Time: " + matcher.group(4));
        System.out.println("Request: " + matcher.group(5));
        System.out.println("Response: " + matcher.group(6));
        System.out.println("Bytes Sent: " + matcher.group(7));
        if (!matcher.group(8).equals("-"))
            System.out.println("Referer: " + matcher.group(8));
        System.out.println("User-Agent: " + matcher.group(9));

    }
}
