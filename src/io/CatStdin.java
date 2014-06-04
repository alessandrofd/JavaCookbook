package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CatStdin {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputLine;

            while ((inputLine = reader.readLine())!= null)
                System.out.println(inputLine);

            reader.close();
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }
    }
}
