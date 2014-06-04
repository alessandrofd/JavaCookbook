package numbers;

import java.math.BigInteger;

/**
 * Created by Alessandro on 17/03/14.
 */
public class PalindromeBig {

    public static boolean verbose = true;

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                BigInteger l = new BigInteger(args[i]);
                if (l.compareTo(BigInteger.ZERO) < 0) {
                    System.err.println(args[i] + " -> TOO SMALL");
                    continue;
                }
                System.out.println(args[i] + " -> " + findPalindrome(l));
            } catch (NumberFormatException e) {
                System.err.println(args[i] + " -> INVALID");
            } catch (IllegalStateException e) {
                System.err.println(args[i] + " -> " + e);
            }
        }
    }

    public static BigInteger findPalindrome(BigInteger num) {
        if (num.compareTo(BigInteger.ZERO) < 0)
            throw new IllegalStateException("negative");
        if (isPalindrome(num))
            return num;
        if (verbose)
            System.out.println("Trying " + num);
        return findPalindrome(num.add(reverseNumber(num)));
    }

    // A ridiculously large number
    protected static final int MAX_DIGITS = 255;

    public static boolean isPalindrome(BigInteger num) {
        String digits = num.toString();
        int numDigits = digits.length();
        if (numDigits > MAX_DIGITS)
            throw new IllegalStateException("too big");

        if (numDigits == 1)
            return true;

        for (int i = 0; i < numDigits/2; i++) {
            if (digits.charAt(i) != digits.charAt(numDigits - 1 - i))
                return false;
        }
        return true;
    }

    static BigInteger reverseNumber(BigInteger num) {
        String digits = num.toString();
        int numDigits = digits.length();
        char[] sb = new char[numDigits];
        for (int i = 0; i < numDigits; i++) {
            sb[i] = digits.charAt(numDigits-1-i);
        }
        return new BigInteger(new String(sb));
    }
}
