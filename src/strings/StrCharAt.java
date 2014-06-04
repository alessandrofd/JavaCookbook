package strings;

/**
 * Created by Alessandro.Dantas on 28/02/14.
 */
public class StrCharAt {
    public static void main(String[] args) {
        String a = "A quick bronze fox lept a lazy bovine.";
        for (int i = 0; i < a.length(); i++) // Don't use foreach
            System.out.println("Char " + i + " is " + a.charAt(i));
    }
}
