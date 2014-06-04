package threads;

import java.applet.Applet;
import java.awt.Panel;
import java.awt.Image;
import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

/**
 * Created by Alessandro on 26/03/2014.
 */
public class Bounce extends Applet implements ActionListener {

    /** The main panel */
    protected Panel p;
    /** The image, shared by all Sprite objects */
    protected Image img;
    /** A Vector of Sprite objects */
    protected List<Sprite> v;

    public void init() {
        Button b = new Button("Start");
        b.addActionListener(this);
        setLayout(new BorderLayout());
        add(b, BorderLayout.NORTH);
        add(p = new Panel(), BorderLayout.CENTER);
        p.setLayout(null);
        String imgName = getParameter("imagefile");
        if (imgName == null) imgName = "duke.gif";
        img = getImage(getCodeBase(), imgName);
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(img, 0);
        try {
            mt.waitForID(0);
        } catch (InterruptedException e) {
            throw new IllegalArgumentException("InterruptedException while loading page");
        }
        if (mt.isErrorID(0)) {
            throw new IllegalArgumentException("Couldn't load image " + imgName);
        }
        v = new Vector<Sprite>(); // multithreaded, use Vector
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Creating another one");
        Sprite s = new Sprite(this, img);
        s.start();
        p.add(s);
        v.add(s);
    }

    public void stop() {
        for (int i = 0; i < v.size(); i++) {
            v.get(i).stop();
        }
        v.clear();
    }
}
