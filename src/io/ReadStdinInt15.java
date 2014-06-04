package io;

import java.util.Scanner;

public class ReadStdinInt15 {
    public static void main(String[] args) {
        int val = 0;
        Scanner scanner = new Scanner(System.in);  // Requires Java 5
        val = scanner.nextInt();
        System.out.println("I read this number: " + val);
    }
}
