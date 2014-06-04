package numbers;

import java.text.NumberFormat;

/**
 * Created by Alessandro.Dantas on 12/03/14.
 */
public class NumFormat2 {
    /** A number to format */
    public static final double data[] = {
            0, 1, 22d/7, 100.2345678
    };

    /** The main (and only) method in this class. */
    public static void main(String[] args) {
        // Get a format instance
        NumberFormat form = NumberFormat.getInstance();

        // Set it to look like 999.99[99]
        form.setMinimumIntegerDigits(3);
        form.setMinimumFractionDigits(2);
        form.setMaximumFractionDigits(4);

        // Now print using it.
        for (int i = 0; i < data.length; i++)
            System.out.println(data[i] + "\tformat as " + form.format(data[i]));
    }
}
