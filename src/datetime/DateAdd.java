package datetime;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by Alessandro.Dantas on 18/03/14.
 */
public class DateAdd {
    public static void main(String[] args) {
        /** Today's date */
        LocalDate now = LocalDate.now();

        Period p = Period.ofDays(700);
        LocalDate then = now.plus(p);

        System.out.printf("Seven hundred days form %s is %s%n", now, then);
    }
}
