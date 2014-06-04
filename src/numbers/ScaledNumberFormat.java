package numbers;

import java.text.*;

/** Format numbers scaled for human comprehension
 *
 * "Human-readable" output uses 43??? digits max, and puts unit suffixes at the end.
 * Makes output compact and easy-to-read esp. on huge disks.
 * Created by Alessandro.Dantas on 13/03/14.
 */
public class ScaledNumberFormat extends Format{

    final static int NONE = 0;
    final static int KILO = 1;
    final static int MEGA = 2;
    final static int GIGA = 3;
    final static int TERA = 4;
    final static int PETA = 5;
    final static int EXA = 6;

    DecimalFormat df;

    public ScaledNumberFormat() {
        df = new DecimalFormat("0");
    }

    /** The input scaling factor. All three arrays must be in same order */
    static char[] scale_chars = { 'B', 'K', 'M', 'G', 'T', 'P', 'E', };

    /** The numeric scale values. All three arrays must be in same order */
    int[] units = { NONE, KILO, MEGA, GIGA, TERA, PETA, EXA };

    /** The input scale sizes. All three arrays must be in same order. */
    static long[] scale_factors = { 1, 1024, 1048576L, 1073741824L,
            1099511627776L, 1125899906842624L, 1152921504606846976L};

    private final static long LLONG_MAX = scale_factors[6];

    // To prevent numeric overflow (Java doesn't have a "long long")
    static final int MAX_DIGITS = 10;

    /** Parse a String expected to contain a number in Human Scaled Form. */
    public Object parseObject(String s, ParsePosition where) {
        int i, sign = 0, fract_digits = 0;
        long scale_fact = 1, whole = 0;
        long fpart = 0;

        if (s == null)
            return null;

        char[] b = s.trim().toCharArray();
        int p = 0; // the index into b; the number of chars we've scanned

        // Then at most one leading + or -
        while (b[p] == '-' || b[p] == '+') {
            if (b[p] == '-') {
                if (sign != 0)
                    throw new NumberFormatException("Number " + s + " has more than one sign.");
                sign = -1;
                ++p;
            } else if (b[p] == '+') {
                if (sign != 0)
                    throw new NumberFormatException("Number " + s + " has more than one sign");
                sign = +1;
                ++p;
            }
        }

        /* Main loop: Scan digits, find decimal point, if present. We don't
        allow exponentials, so no scientific notation (but note that E for
        Exa might look like e to some!). Advance p to end, to get scale
        factor.
         */

        for (; p < b.length && (Character.isDigit(b[p]) || b[p] == '.'); ++p) {
            int ndigits = 0;
            if (b[p] == '.') {
                if (fract_digits > 0) {
                    throw new NumberFormatException("Number " + s + " has more than one decimal point ");
                }
                fract_digits = 1;
                continue;
            }

            i = (b[p]) - '0'; // finally a digit we can use
            if (fract_digits > 0) { // fractional digit
                if (fract_digits >= MAX_DIGITS)
                    throw new NumberFormatException("Number too large");
                fpart *= 10;
                fpart += i;
                ++fract_digits; // track for later scaling
            } else { // normal digit
                if (++ndigits >= MAX_DIGITS)
                    throw new NumberFormatException("Number too large");
                whole *= 10;
                whole += i;
            }
        }

        if (sign < 0) {
            whole *= sign;
            fpart *= sign;
        }

        // If no scale factor is given, we're done. fraction is discarded
        if (p >= b.length)
            return new Long(whole);

        // Validate scale factor, and scale whole and fraction in it.
        for ( i = 0; i < scale_factors.length; i++) {
            if (b[p] == scale_chars[i] || b[p] == Character.toLowerCase(scale_chars[i])) {
                scale_fact = scale_factors[i];
                whole *= scale_fact;
                // Truncate fpart so it doesn't overflow, then scale fractional part.
                while (fpart >= LLONG_MAX / scale_fact) {
                    fpart /= 10;
                    fract_digits--;
                }
                fpart *= scale_fact;
                if (fract_digits > 0) {
                    for (i = 0; i < fract_digits - 1; i++)
                        fpart /= 10;
                }
                whole += fpart;
                return new Long(whole);
            }
        }
        throw new IllegalArgumentException("invalid scale factor " + b[p]);
    }

    public Object parseObject(String s) throws ParseException {
        return parseObject(s, null);
    }

    /** Format the given Number as a Scaled Numeral, returning the StringBuffer
     * (updated), and <em>ignoring</em> the FieldPosition. Method signature is
     * overkill, but required as a subclass of Format
     */
    @Override
    public StringBuffer format(Object on, StringBuffer sb, FieldPosition fp) {
        if (on instanceof String) {
            String son = (String)on;
            if (son.length() == 0)
                return sb.append("0B");
            on = parseObject(son, null);
        }
        if (!(on instanceof  Long)){
            throw new IllegalArgumentException("Argument " + on + " must be String or Long");
        }
        long n = ((Long)on).longValue();
        sb.append(format(n));
        return sb;
    }

    /** Non-standard overload:
     * Format a double as a Scaled Numeral; just truncate to a long, and call format (long).
     */
    public String format(double n) {
        return format((long)n);
    }

    /** Non-standard overload:
     * Format a given long as a Scaled Numeral. This method is the REAL FORMATTING ENGINE
     */
    public String format(long number) {
        long fract = 0;
        int unit = NONE;

        StringBuffer buf = new StringBuffer();

        long abval = Math.abs(number);

        for (int i = 1; i < scale_factors.length; i++) {
            if (abval < scale_factors[i]) {
                unit = units[i-1];
                fract = i == 1 ? 0 : (((abval % scale_factors[i-1]) * 10) / scale_factors[i-1]);
                number /= scale_factors[i-1];
                break;
            }
        }

        if (fract < 0)
            fract = -fract;

        // scale fraction to one digit (truncate, not round)
        while (fract > 9)
            fract /= 10;

        if (number == 0)
            return "0B";
        else if (unit == NONE || number >= 100 || number <= -100)
            buf.append(df.format(number)).append(scale_chars[unit]);
        else
            buf.append(df.format(number)).append('.').append(fract).append(scale_chars[unit]);

        return buf.toString();

    }

}
