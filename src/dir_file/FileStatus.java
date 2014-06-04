package dir_file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileStatus {
    public static void main(String[] args) throws IOException {
        // Ensure that a filename (or something) was given in args[0]
        if (args.length == 0) {
            System.err.println("Usage FileStatus filename");
            System.exit(1);
        }
        for (String arg : args)
            status(arg);
    }

    public static void status(String filename) throws IOException {
        System.out.println("--- " + filename + " ---");

        // Construct a File object for the given file
        File f = new File(filename);

        // See if it actually exists
        if (!f.exists()) {
            System.out.println("file not found");
            System.out.println();
            return;
        }

        // Print full name
        System.out.println("Canonical name " + f.getCanonicalPath());
        // Print parent directory if possible
        String p = f.getParent();
        if (p != null)
            System.out.println("Parent directory: " + p);

        // Check if the file is readable
        if (f.canRead())
            System.out.println("File is readable.");

        // Check if the file is writable
        if (f.canWrite())
            System.out.println("File is writable.");

        // Report on the modification time.
        Date d = new Date(f.lastModified());
        System.out.println("Last modified: " + d);

        // See if file, directory, or other. If file, print size.
        if (f.isFile())
            // Report on the file's size
            System.out.println("File size is " + f.length() + " bytes.");
        else if (f.isDirectory())
            System.out.println("Its a directory");
        else
            System.out.println("I dunno! Neither a file nor a directory!");

        System.out.println(); // blank line between entries
    }
}
