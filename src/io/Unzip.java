package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by Alessandro on 23/04/2014.
 */
public class Unzip {
    /** Constants for mode listing or mode extracting */
    public static enum Mode { LIST, EXTRACT }

    /** Whether we are extracting or just printing TOC */
    protected Mode mode = Mode.LIST;

    /** The ZIP file that is used to reade a file */
    protected ZipFile zippy;

    /** The buffer for reading/writing the ZipFile data */
    protected byte[] b =  new byte[8092];

    public static void main(String[] args) {
        Unzip u = new Unzip();

        for (int i = 0; i < args.length; i++) {
            if ("-x".equals(args[i])) {
                u.setMode(Mode.EXTRACT);
                continue;
            }
            String candidate = args[i];
            if (candidate.endsWith(".zip") || candidate.endsWith(".jar"))
                u.unzip(args[i]);
            else System.err.println("Not a zip file? " + args[i]);
        }
        System.err.println("All done!");
    }

    protected void setMode(Mode m) {
        mode = m;
    }

    /** Cache of paths with mkdir()ed. */
    protected SortedSet<String> dirsMade;

    /** For a given Zip file, process each entry. */
    public void unzip(String filename) {
        dirsMade = new TreeSet<>();
        try {
            zippy = new ZipFile(filename);
            Enumeration all = zippy.entries();
            while (all.hasMoreElements())
                getFile((ZipEntry)all.nextElement());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected boolean warnedMkDir = false;

    /** Process one file from the zip, given its name.
     * Either print the name, or create the file on disk.
     */
    protected void getFile(ZipEntry entry) throws IOException {
        String zipName = entry.getName();
        switch(mode) {
            case EXTRACT:
                if(zipName.startsWith("/")) {
                    if (!warnedMkDir)
                        System.out.println("Ignoring absolute paths.");
                    warnedMkDir = true;
                    zipName = zipName.substring(1);
                }
                // If a directory, just return. We mkdir for every file,
                // since some widely-used Zip creators don't put out
                // any directory entries, or put them in the wrong place.
                if (zipName.endsWith("/"))
                    return;
                // Else must be a file; open the file for output
                // Get the directory part.
                int ix = zipName.lastIndexOf('/');
                if (ix > 0) {
                    String dirName = zipName.substring(0, ix);
                    if (!dirsMade.contains(dirName)) {
                        File d = new File(dirName);
                        // If it already exists as a dir, don't do anything
                        if (!(d.exists() && d.isDirectory())) {
                            // Try to create the directory, warn if it fails.
                            System.out.println("Creating directory " + dirName);
                            if (!d.mkdirs())
                                System.err.println("Unable to mkdir " + dirName);
                            dirsMade.add(dirName);
                        }
                    }
                }
                System.err.println("Creating " + zipName);
                FileOutputStream os = new FileOutputStream(zipName);
                InputStream is = zippy.getInputStream(entry);
                int n = 0;
                while ((n = is.read(b)) > 0)
                    os.write(b, 0, n);
                is.close();
                os.close();
                break;

            case LIST:
                // Not extracting, just listing
                if (entry.isDirectory())
                    System.out.println("Directory " + zipName);
                else
                    System.out.println("File " + zipName);
                break;
            default:
                throw new IllegalStateException("mode value (" + mode + ") bad");
        }
    }
}
