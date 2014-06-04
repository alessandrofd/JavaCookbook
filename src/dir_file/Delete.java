package dir_file;

import java.io.File;

/**
 * Created by Alessandro.Dantas on 25/04/2014.
 */
public class Delete {
    public static void main(String[] args) {
        File f = new File("copied_file.txt");
        f.delete();
    }
}
