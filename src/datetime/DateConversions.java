package datetime;

import sun.util.resources.cldr.de.TimeZoneNames_de;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by Alessandro.Dantas on 18/03/14.
 */
public class DateConversions {
    public static void main(String[] args) {
        // Convert a number of Seconds since the Epoch, to a local date/time
        Instant epochSec = Instant.ofEpochSecond(1000000000L);
        ZoneId zId = ZoneId.systemDefault();
        ZonedDateTime then = ZonedDateTime.ofInstant(epochSec, zId);
        System.out.println("The epoch was a billion seconds old on " + then);

        // Convert date/time to Epoch seconds
        long epochSeconds = ZonedDateTime.now().toInstant().getEpochSecond();
        System.out.println("Current epoch seconds = " + epochSeconds);

        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime there = now.atZone(ZoneId.of("Canada/Pacific"));
        System.out.printf("When it's %s here, it's %s in Vancouver%n", now, there);
    }
}
