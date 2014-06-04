package dir_file;

import java.io.File;
import java.util.Arrays;

/**
 * Created by Alessandro.Dantas on 25/04/2014.
 */
public class Ls {
    public static void main(String[] args) {
        String[] dirs = new File(".").list(); // Get list of names
        Arrays.sort(dirs); // Sort it
        for (String dir : dirs)
            System.out.println(dir);
    }
}
