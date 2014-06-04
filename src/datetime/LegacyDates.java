package datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Alessandro.Dantas on 18/03/14.
 */
public class LegacyDates {

    public static void main(String[] args) {
        // There and back again, via Date
        Date legacyDate = new Date();
        System.out.println(legacyDate);

        LocalDateTime newDate = LocalDateTime.ofInstant(legacyDate.toInstant(), ZoneId.systemDefault());
        System.out.println(newDate);

        // And via Calendar
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        LocalDateTime newCal = LocalDateTime.ofInstant(c.toInstant(), ZoneId.systemDefault());
        System.out.println(newCal);

    }

}
