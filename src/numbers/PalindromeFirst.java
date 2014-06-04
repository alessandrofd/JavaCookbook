package numbers;

/**
 * Find the first integer that cannot be palindromified
 */
public class PalindromeFirst {
    public static void main(String[] args) {
        int numErrors = 0;
        Palindrome.verbose = false;
        for (int i = 0; i < Long.MAX_VALUE; i++) {
            try {
                Palindrome.findPalindrome(i);
            } catch (RuntimeException e) {
                System.out.println("Caught exception on " + i + ": " + e);
                numErrors++;
            }
            if (numErrors > 200)
                return;
        }
    }
}
