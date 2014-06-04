package dir_file;

import java.io.File;

/**
 * Created by Alessandro.Dantas on 25/04/2014.
 */
public class Delete2 {
    public static void main(String[] args) {
        for (String a : args)
            delete(a);
    }

    public static void delete(String fileName) {
        try {
            // Construct a File object for the file to be deleted.
            File target = new File(fileName);

            if (!target.exists()) {
                System.err.println("File " + fileName + " not present to begin with!");
                return;
            }

            // Now delete it:
            if (target.delete())
                System.err.println("** Deleted " + fileName + " **");
            else
                System.err.println("Failed to delete " + fileName);
        } catch (SecurityException e) {
            System.err.println("Unable to delete " + fileName + "(" + e.getMessage() + ")");
        }
    }
}
