package structure;

import java.io.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by Alessandro.Dantas on 20/03/2014.
 */
public class FileProperties extends Properties {

    /** The Name of the file this FileProperties represents. */
    protected String fileName = null;
    /** True if the file represented by fileName exists. */
    private boolean exists = false;

    /** Construct a FileProperties given a fileName. */
    public FileProperties(String loadsaveFileName) throws IOException {
        super();
        setFileName(loadsaveFileName);
        load();
    }

    public FileProperties(String readonlyFileName, Class clazz) throws IOException {
        super();
        load(clazz.getResourceAsStream(readonlyFileName));
    }

    public FileProperties(InputStream is ) throws IOException { load(is); }

    /** Construct a FileProperties given a fileName and a list of default properties. */
    public FileProperties(String loadsaveFileName, Properties defProp) throws IOException {
        super(defProp);
        setFileName(loadsaveFileName);
        load();
    }

    void setFileName(String newName) {
        fileName = newName;
        if (new File(fileName).exists()) {
            exists = true;
            return;
        }
        if (!newName.endsWith(".properties")) {
            File f2 = new File(newName + ".properties");
            if (f2.exists()) {
                exists = true;
                fileName = newName + ".properties";
                return;
            }
        }
        System.err.println("File not found.");
    }

    public String getFileName() { return fileName; }

    public Properties load() throws IOException {
        if (!exists)
            return this;

        InputStream inStr = new FileInputStream(fileName);
        load(inStr);
        inStr.close();

        return this;
    }

    @Deprecated
    public void save() throws IOException {
        if (fileName == null)
            throw new IOException("Tried to save a FileProperties loaded from CLASSPATH");
        OutputStream outStr = new FileOutputStream(fileName);

        // Get the superclass to do most of the work for us.
        store(outStr, "# Written by FileProperties.save() at " + new Date());

        outStr.close();
    }

    @SuppressWarnings("unchecked")
    public Iterator<String> iterator() { return new EnumerationIterator(keys()); }

}
