package regex;

/**
 * Created by Alessandro.Dantas on 06/03/14.
 */
public class StringConvenience {
    public static void main(String[] args) {
        String pattern = ".*Q[^u]\\d+\\..*";
        String line = "Order QTX300. Now!";
        if (line.matches(pattern)) {
            System.out.println(line + " matches \"" + pattern + "\"");
        } else {
            System.out.println("NO MATCH");
        }
    }
}
