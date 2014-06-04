package oo;

/**
 * Created by Alessandro on 24/03/2014.
 */
public class StringParse {
    /** This is the function that has a return value of true but also passes back the offset into the String where the
     * value was found.
     */
    public static boolean parse(String in, char lookFor, MutableInteger whereFound) {
        int i = in.indexOf(lookFor);
        if (i == -1)
            return false;
        whereFound.setValue(i);
        return true;
    }

    public static void main(String[] args) {
        MutableInteger mi = new MutableInteger();
        String text = "Hello, World!";
        char c = 'X';

        if (parse(text, c, mi))
            System.out.println("Character " + c + " found at offset " + mi + " in " + text);
        else
            System.out.println("Not found.");
    }
}
