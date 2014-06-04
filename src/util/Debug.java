package util;

/**
 * Created by Alessandro.Dantas on 28/03/2014.
 */
public class Debug {
    private static final String DEBUG_STRING = "debug";

    /** Static method to see if a given category of debugging in enabled.
     * Enable by setting e.g., -Ddebug.fileio to debug file I/O operations.
     * For example:
     * if (Debug.isEnabled("fileio"))
     *      System.out.println("Starting to read file " + fileName);
     */
    public static boolean isEnabled(String category) { return System.getProperty(DEBUG_STRING + category) != null; }

    /** Static method to println a given message if the
     * given category is enabled for debugging, as reported by isEnabled.
     */
    public static void println(String category, String msg) {
        if (isEnabled(category))
            System.out.println(msg);
    }

    /** Static method to println an arbitrary Object if the given
     * category is enabled for debugging, as reported by isEnabled
     */

    public static void println(String category, Object stuff) { println (category, stuff.toString()); }

    /** Invoke System.out.printf if and only if the given
     * category is enabled for debugging, as reported by isEnabled.
     */
    public static void printf(String category, String format, Object...objects) {
        if (isEnabled(category))
            System.out.printf(format, objects);
    }
}
