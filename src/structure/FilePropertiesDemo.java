package structure;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Alessandro.Dantas on 20/03/2014.
 */
public class FilePropertiesDemo {
    public static void main(String[] args) {


/*
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));

        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
*/


        try {
            Properties p = new FileProperties("PropsDemo.txt");
            p.list(System.out);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
