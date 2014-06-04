package numbers;

import java.util.Calendar;

/**
 * Created by Alessandro.Dantas on 12/03/14.
 */
public class RomanYear {
    public static void main(String[] args) {
        RomanNumberFormat rf = new RomanNumberFormat();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);

        // If no arguments, just print the year.
        if (args.length == 0) {
            System.out.println(rf.format(year));
            return;
        }

        // Else a micro-formatter: replace "-" arg with year, else print
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-"))
                System.out.print(rf.format(year));
            else
                System.out.print(args[i]); // e.g., "Copyright"
            System.out.print(' ');
        }
        System.out.println();
    }
}
