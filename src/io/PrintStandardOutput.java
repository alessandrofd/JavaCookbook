package io;

import java.io.PrintWriter;

public class PrintStandardOutput {
    public static void main(String[] args) {
        // Just a string to include in printouts
        String myAnswer = "No, and that's final,";

        // Print to standard output
        System.out.println("Hello world of Java");
        // Print several things concatenated
        System.out.println("The answer is " + myAnswer + " at this time.");

        System.out.printf("The answer is %s at this time\n", myAnswer); // the 1.5 way

        // Print to standard output using a Writer
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("The answer is " + myAnswer + " at this time");

        // Caveat printing ints and chars together
        int i = 42;
        pw.println(i + '=' + " the answer."); //WRONG  prints "103 the answer"
        pw.println("Note: " + i + '=' + " the answer."); // OK

        // Some of the workarounds for the caveat above:
        pw.println(i + "=" + " the answer.");   // using quotes
        pw.println(i + ('=' + " the answer.")); // parenthesis

        pw.close(); // if you open it, you close it
    }
}
