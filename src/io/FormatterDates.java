package io;

import java.util.Calendar;
import java.util.Date;

/**
 * Shows some usage patterns and format-code examples of the Formatter class.
 */
public class FormatterDates {
    public static void main(String[] args) {
        // Format numbers as dates e.g., 2014-06-28
        System.out.printf("%04d-%02d-%02d%n", 2014, 6, 28);

        // Format fields directly from a Date object: multiple fields form "1$"
        // (hard-coded formatting for Date not advisable; see I18N chapter)
        Date today = Calendar.getInstance().getTime();
        System.out.printf("Today is %1$tB %1$td, %1$tY%n", today); // e.g., July 4, 2014
    }
}
