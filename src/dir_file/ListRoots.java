package dir_file;

import java.io.File;

public class ListRoots {
    public static void main(String[] args) {
        File[] drives = File.listRoots();
        for (File dr : drives)
            System.out.println(dr);
    }
}
