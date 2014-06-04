package io;

import java.io.IOException;

/**
 * Created by Alessandro.Dantas on 22/04/2014.
 */
public class TeePrintStreamDemo {
    public static void main(String[] args) throws IOException {
        TeePrintStream ts = new TeePrintStream(System.err, "error.log");
        System.setErr(ts);

        System.err.println("Testing TeePrintStream");
    }
}
