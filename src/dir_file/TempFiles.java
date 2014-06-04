package dir_file;

import java.io.File;
import java.io.IOException;

/**
 * Created by Alessandro.Dantas on 25/04/2014.
 */
public class TempFiles {
    public static void main(String[] args) throws IOException  {

        // 1. Make an existing file temporary
        File bkup = new File("bkp_file.txt");
        bkup.createNewFile();
        bkup.deleteOnExit();

        // 2. Create a new temporary file
        // Make a file object form foo.tmp in the default temp directory
        File tmp = File.createTempFile("foo", ".tmp");
        // Report on the filename that it made up for us.
        System.out.printf("Your temp file is " + tmp.getCanonicalPath());
        // Arrange for it to be deleted at exit.
        tmp.deleteOnExit();
        // Now do something with the temporary file, without having to worry about deleting it later
        writeDataInTemp(tmp.getCanonicalPath());
    }

    public static void writeDataInTemp(String tmpName) {
        // This version is dummy. Use your imagination.
    }
}
