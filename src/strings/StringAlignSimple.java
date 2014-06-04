package strings;

/**
 * Created by Alessandro.Dantas on 28/02/14.
 */
public class StringAlignSimple {
    public static void main(String[] args) {
        // Construct a "formatter" to center strings.
        StringAlign formatter = new StringAlign(70, StringAlign.JUST_CENTER);
        // Try it out, for page "i"
        System.out.println(formatter.format("- i -"));
        // Try it out, for page 4. Since this formatter
        // is optimized for Strings, not specifically for page numbers,
        // we have to convert the number to a String.
        System.out.println(formatter.format(Integer.toString(4)));
    }
}
