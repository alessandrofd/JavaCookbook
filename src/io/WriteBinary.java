package io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBinary {
    public static void main(String[] args) throws IOException {
        int i = 42;
        double d = Math.PI;
        String filename = "binary.dat";
        DataOutputStream os = new DataOutputStream(new FileOutputStream(filename));
        os.writeInt(i);
        os.writeDouble(d);
        os.close();
        System.out.println("Wrote " + i + ", " + d + " to file " + filename);

    }
}
