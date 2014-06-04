package dir_file;

import java.io.File;
import java.io.IOException;

/**
 * Created by Alessandro.Dantas on 25/04/2014.
 */
public class Creat {
    public static void main(String[] args) throws IOException {
        // Ensure that a filename (or something) was given in args[0]
        if (args.length == 0) {
            System.err.println("Usage: Creat filename");
            System.exit(1);
        }

        for (String a : args) {
            // Constructing a File object doesn't affect the disk, but the createNewFile() method does.
            new File(a).createNewFile();
        }
    }
}
