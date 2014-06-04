package dir_file;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class PathsFilesDemo {

    public static void main(String[] args) throws IOException {
        Path p = Paths.get("my_junk_file");
        boolean deleted = Files.deleteIfExists(p);
        InputStream is = PathsFilesDemo.class.getResourceAsStream("/dir_file/demo.txt");
        long newFileSize = Files.copy(is, p);
        System.out.println(newFileSize);
        final Path realPath = p.toRealPath();
        System.out.println(realPath);
        realPath.forEach(pc -> System.out.println(pc));
        Files.delete(p);
    }
}
