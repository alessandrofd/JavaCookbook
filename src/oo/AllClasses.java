package oo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alessandro.Dantas on 24/03/2014.
 */
public class AllClasses {
    public class Data {  // Inner class, can be used anywhere in class AllClasses
        int x;
        int y;
    }
    public void getResults() {
        JButton b = new JButton("Press me");
        b.addActionListener(new ActionListener() {          // Anonymous inner class syntax, using new with a type
            public void actionPerformed(ActionEvent evt) {  // followed by (){, a class body, and }. Compiler will
                Data loc = new Data();                      // assign a name; class will extend or implement the given
                loc.x = ((Component)evt.getSource()).getX();// type, a appropriate.
                loc.y = ((Component)evt.getSource()).getY();
                System.out.println("Thanks for pressing me");
            }
        });
    }
}
/** Class contained in same file as AllClasses, but can be used (with a warning) in other contexts */
class AnotherClass {                                        // Non-public class; can be uses in the main class
    // methods and fields here ...
    AnotherClass() {
        // Inner class from above cannot be used here, of course
        // Data d = new Data(); // EXPECT COMPILE ERROR
    }
}
