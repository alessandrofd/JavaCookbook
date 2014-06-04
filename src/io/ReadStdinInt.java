package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadStdinInt {
    public static void main(String[] args) {
        String line = null;
        int val = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            line = reader.readLine();
            val = Integer.parseInt(line);
            System.out.println("I read this number: " + val);
        } catch (NumberFormatException e) {
            System.err.println("Not a valid number: " + line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
