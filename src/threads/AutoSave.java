package threads;

/**
 * Created by Alessandro.Dantas on 28/03/2014.
 */
public class AutoSave extends Thread {
    /** The FileSaver interface is implemented by the main class */
    protected FileSaver model;
    /** How long to sleep between tries */
    public static final int MINUTES = 5;
    private static final int SECONDS = MINUTES * 60;

    public AutoSave(FileSaver m) {
        super("AutoSave Thread");
        setDaemon(true);
        model = m;
    }

    public void run() {
        while (true) { // entire run method runs forever
            try {
                sleep(SECONDS * 1000);
            } catch (InterruptedException e) {
                // do nothing
            }
            if (model.wantAutoSave() && model.hasUnsavedChanges())
                model.saveFile(null);
        }
    }

    // Not shown:
    // 1) saveFile() must now be synchronized.
    // 2) method that shuts down main program be synchronized on the *SAME* object
}

/** Local copy of FileSaver interface for compiling AutoSave demo */
interface FileSaver {
    /** Load new model from fn; if null, prompt for a new fname */
    public void loadFile(String fn);

    /** Ask the model if ti wants AutoSave done for it */
    public boolean wantAutoSave();

    /** Ask the model if ti has any unsaved changes, don't save otherwise */
    public boolean hasUnsavedChanges();

    /**Save the current model's data in fn
     * if fn -- null, use the current fname or prompt for a filename if null.
     */
    public void saveFile(String fn);
}
