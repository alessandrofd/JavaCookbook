package regex;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.util.regex.*;

/**
 * Created by Alessandro.Dantas on 06/03/14.
 */
public class GrepNIO {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println("Usage: GrepNIO patt file [...]");
            System.exit(1);
        }

        Pattern p = Pattern.compile(args[0]);
        for (int i = 1; i < args.length; i++) {
            process(p, args[i]);
        }
    }

    static void process(Pattern pattern, String filename) throws IOException {
        // Get a FileChannel from the given file.
        FileChannel fc = new FileInputStream(filename).getChannel();

        // Map the file's content
        ByteBuffer buf = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

        // Decode ByteBuffer into CharBuffer
        CharBuffer cbuf = Charset.forName("ISO-8859-1").newDecoder().decode(buf);

        Matcher m = pattern.matcher(cbuf);
        while (m.find()) {
            System.out.println(m.group(0));
        }
    }
}
