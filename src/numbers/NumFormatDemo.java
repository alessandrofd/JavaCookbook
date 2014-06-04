package numbers;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Format a number our way and the default way
 */
public class NumFormatDemo {
    /** A number to format */
    public static final double intlNumber = 1024.25;
    /** Another number to format */
    public static final double ourNumber = 100.2345678;

    public static void main(String[] args) {
        NumberFormat defForm = NumberFormat.getInstance();
        NumberFormat ourForm = new DecimalFormat("##0.##");
        // to Pattern will reveal the combination of #0., etc
        // that this particular Locale uses to format with!
        System.out.println("defFormat's pattern is " + ((DecimalFormat)defForm).toPattern());
        System.out.println(intlNumber + " formats as " + defForm.format(intlNumber));
        System.out.println(ourNumber + " formats as " + ourForm.format(ourNumber));
        System.out.println(ourNumber + " formats as " + defForm.format(ourNumber) + " using the default format");
    }

}
