package io;

import java.io.*;

public class FileSaver {
    private enum State {
        // The state before and after use
        AVAILABLE,
        // The state while in use
        INUSE }
    private State state;
    private final File inputFile;
    private final File tmpFile;
    private final File backupFile;

    public FileSaver(File input) throws IOException {
        // Step 1: Create tmp file in right place
        this.inputFile = input;
        tmpFile = new File(inputFile.getAbsolutePath() + ".tmp");
        tmpFile.createNewFile();
        tmpFile.deleteOnExit();
        backupFile = new File(inputFile.getAbsolutePath() + ".bak");
        state = State.AVAILABLE;
    }

    /**
     * Returned a reference to the contained File object, to
     * promote re-use (File objects are immutable so this
     * is at least moderately safe). Typical use would be:
     * <pre>
     *     if (fileSaver == null || !(fileSaver.getFile().equals(file)) {
     *         fileSaver = new FileSaver(file);
     *     }
     * </pre>
     */
    public File getFile() { return inputFile; }

    /**
     * Return an output file that the client should use to
     * write the client's data to.
     * @return An OutputStream, which should be wrapped in a
     *     buffered OutputStream to ensure reasonable performance.
     * @throws IOException if the temporary file cannot be written.
     */
    public OutputStream getOutputStream() throws IOException {

        if (state != State.AVAILABLE)
            throw new IllegalStateException("FileSaver not opened");

        OutputStream out = new FileOutputStream(tmpFile);
        state = State.INUSE;
        return out;
    }

    /**
     * Return an output file that the client should use to
     * write the client's data to.
     * @return A Writer, which should be wrapped in a
     *     buffered Writer to ensure reasonable performance.
     * @throws IOException if the temporary file cannot be written.
     */
    public Writer getWriter() throws IOException {

        if (state != State.AVAILABLE)
            throw new IllegalStateException("FileSaver not opened");

        Writer out = new FileWriter(tmpFile);
        state = State.INUSE;
        return out;
    }

    /**
     * Close the output file and rename the tmp file to the original name.
     * @throws IOException if anything goes wrong
     */
    public void finish() throws IOException {

        if (state != State.INUSE)
            throw new IllegalStateException("FileSaver not in use");

        // Delete the previous backup file if it exists
        backupFile.delete();

        // Rename the user's previous file to itsName.bak,
        // UNLESS this is a new file
        if (inputFile.exists() && !inputFile.renameTo(backupFile))
            throw new IOException("Could not rename file to backup file");

        // Rename the temporary file to the save file.
        if (!tmpFile.renameTo(inputFile))
            throw new IOException("Could not rename temp file to save file");

        state = State.AVAILABLE;
    }
}
