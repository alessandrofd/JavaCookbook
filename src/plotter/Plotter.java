package plotter;

import java.awt.*;

/**
 * Created by Alessandro.Dantas on 25/03/2014.
 */
public abstract class Plotter {
    public final int MAXX = 800;
    public final int MAXY = 600;
    /** Current X co-ordinate (same reference frame as AWT!) */
    protected int curx;
    /** Current Y co-ordinate (same reference frame as AWT!) */
    protected int cury;
    /** The current stat: up or down */
    protected boolean penIsUp;
    /** The current color */

    Plotter() {
        penIsUp = true;
        curx = 0; cury = 0;
    }

    abstract void rmoveTo(int incrx, int incry);
    abstract void moveTo(int absx, int absy);
    abstract void penUp();
    abstract void penDown();
    abstract void penColor(int c);

    abstract void setFont(String fName, int fSize);
    abstract void drawString(String s);

    /* Concrete methods */
    /** Draw a box of width w and height h */
    public void drawBox(int w, int h) {
        penDown();
        rmoveTo(w, 0);
        rmoveTo(0, h);
        rmoveTo(-w, 0);
        rmoveTo(0, -h);
        penUp();
    }

    /** Draw a box given an AWT Dimension for its size */
    public void drawBox (Dimension d) {
        drawBox(d.width, d.height);
    }

    /** Draw a box given an AWT Rectangle for its location and size */
    public void drawBox(Rectangle r) {
        rmoveTo(r.x, r.y);
        drawBox(r.width, r.height);
    }

    /** Show current location; useful for testing, if nothing else */
    public Point getLocation() {
        return  new Point(curx, cury);
    }
}
