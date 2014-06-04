package io;

import strings.StringBuilderCommaList;

import java.io.*;

public class FileIO {

    protected static final int BLKSIZ = 16384;

    /** Copy a file from one filename to another */
    public static void copyFile(String inName, String outName) throws FileNotFoundException, IOException {
        BufferedInputStream is = null;
        BufferedOutputStream os = null;
        try {
            is = new BufferedInputStream(new FileInputStream(inName));
            os = new BufferedOutputStream(new FileOutputStream(outName));
            copyFile(is, os, false);
        } finally {
            if (is != null)
                is.close();
            if (os != null)
                os.close();
        }

    }

    /** Copy a file from an opened InputStream to an opened OutputStream */
    public static void copyFile(InputStream is, OutputStream os, boolean close) throws IOException {
        byte[] b = new byte[BLKSIZ];
        int i;
        while ((i = is.read(b)) != -1)
            os.write(b, 0, i);
        is.close();
        if (close)
            os.close();
    }

    /** Copy a file from an opened Reader to an opened Writer */
    public static void copyFile(Reader is, Writer os, boolean close) throws IOException {
        int b;
        while ((b = is.read()) != -1)
            os.write(b);
        is.close();
        if (close)
            os.close();
    }

    /** Copy a file from a filename to a PrintWriter */
    public static void copyFile(String filename, PrintWriter writer, boolean close)
    throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        copyFile(reader,writer, close);
    }

    /**
     * Copy a file to a directory, given File objects representing the files
     * @param file File representing the source, must be a single file
     * @param target File representing the location, may be file or directory
     * @throws java.io.IOException
     */
    public static void copyFile(File file, File target) throws IOException {
        if (!file.exists() || !file.isFile() || !file.canRead()) {
            throw new IOException(file + " is not a readable file");
        }

        File dest = target;
        if (target.isDirectory())
            dest = new File(dest, file.getName());

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(file);
            outputStream = new FileOutputStream(dest);
            int count = 0;
            byte[] b = new byte[BLKSIZ];
            while ((count = inputStream.read(b)) != -1)
                outputStream.write(b);
        } finally {
                inputStream.close();
                outputStream.close();
        }
    }

    /**
     * Read the entire content of a Reader into a String;
     * of course Readers should only be used for text files;
     * please do not use this to read a JPEG file, for example.
     */
    public static String readerToString(Reader is) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] b = new char[BLKSIZ];
        int n;

        // Read a block. If it gets any chars, append them
        while ((n = is.read(b)) > 0) {
            sb.append(b, 0, n);
        }

        // Only construct the String object once, here.
        return sb.toString();
    }

    /** Read the content of a Stream into a String */
    public static String inputStreamToString(InputStream is) throws IOException {
        return readerToString(new InputStreamReader(is));
    }

    public static String readAsString(String filename) throws IOException {
        return readerToString(new FileReader(filename));
    }

    /** Write a String as the entire content of a File. */
    public static void stringToFile(String text, String filename) throws IOException {
        BufferedWriter os = new BufferedWriter(new FileWriter(filename));
        os.write(text);
        os.flush();
        os.close();
    }
}
