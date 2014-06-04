package strings;

/**
 * Created by Alessandro.Dantas on 28/02/14.
 */
public class ForEachChar {
    public static void main(String[] args) {
        String s = "Hello, World";
        // for (char ch : s) {...} Does not work in Java 7
        for (char ch : s.toCharArray())
            System.out.println(ch);
    }
}
