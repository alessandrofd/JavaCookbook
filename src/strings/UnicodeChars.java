package strings;

/**
 * Created by Alessandro.Dantas on 28/02/14.
 */
public class UnicodeChars {
    public static void main(String[] args) {
        StringBuffer b = new StringBuffer();
        for (char c = 'a'; c < 'd'; c++)
            b.append(c);
        b.append('\u00a5'); // Japanese Yen symbol
        b.append('\u01FC'); // Roman AE with acute accent
        b.append('\u03B1'); // Greek Capital Alpha
        b.append('\u03a9'); // Greek Capital Omega

        for (int i = 0; i < b.length(); i++)
            System.out.println("Character #" + i + " is " + b.charAt(i));
        System.out.println("Accumulated characters are " + b);
    }
}
