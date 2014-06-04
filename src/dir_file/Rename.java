package dir_file;


import java.io.File;

public class Rename {
    public static void main(String[] args) {
        // Construct the file object. Does NOT create a file on disk!
        File f = new File("file1.txt");

        // Renaming requires a File object for the target.
        f.renameTo(new File("copied_file.txt"));
    }
}
