package io;

import java.io.Console;
import java.util.Arrays;

public class ReadPassword {
    public static void main(String[] args) {
        Console console;
        if ((console = System.console()) != null) {
            char[] password = null;
            try {
                password = console.readPassword("Password: ");
                // In real life you would send the password into authentication code
                System.out.println("Your password was: " + new String(password));
            } finally {
                // Shred this is-memory copy for security reasons
                if (password != null)
                    Arrays.fill(password, ' ');
            }
        } else {
            throw new RuntimeException("No console, can't get password!");
        }
    }
}
