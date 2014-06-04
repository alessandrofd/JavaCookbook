package dir_file;

import java.io.File;
import java.util.Arrays;

/**
 * Created by Alessandro.Dantas on 25/04/2014.
 */
public class FNFilter2 {
    public static void main(String[] args) {
        // Generate the selective list with a Lambda Expression
        String[] dirs = new File(".").list(
                (dir, s) -> {
                    return s.endsWith(".java") || s.endsWith(".class") || s.endsWith(".jar");
                }
        );
        Arrays.sort(dirs);
        for (String d : dirs)
            System.out.println(d);
    }
}
