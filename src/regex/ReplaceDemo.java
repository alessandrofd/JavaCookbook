package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Quick demo of RE substitution: correct U.S. 'favor'
 * to Canadian/British 'favour', but not in 'favorite'
 */
public class ReplaceDemo {
    public static void main(String[] args) {
        // Make an RE pattern to match as a word only (\b = word boundary)
        String patt = "\\bfavor\\b";

        // A test input
        String input = "Do me a favor? Fetch my favorite.";
        System.out.println("Input: " + input);

        // Run it from a RE instance and see taht it works
        Pattern r = Pattern.compile(patt);
        Matcher m = r.matcher(input);
        System.out.println("ReplaceAll: " + m.replaceAll("favour"));

        // Show the appendReplacement method
        m.reset();
        StringBuffer sb = new StringBuffer();
        System.out.println("Append methods: ");
        while (m.find()) {
            // Copy to before first match,
            // plus the word "favor"
            m.appendReplacement(sb, "favour");
        }
        m.appendTail(sb); // copy remainder
        System.out.println(sb.toString());
    }
}
