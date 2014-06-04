package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Alessandro.Dantas on 18/03/14.
 */
public class DateParse {
    public static void main(String[] args) {
        String armisticeDate = "1914-11-11";
        LocalDate aLD = LocalDate.parse(armisticeDate);
        System.out.println("Date: " + aLD);

        String armisticeDateTime = "1914-11-11T11:11";
        LocalDateTime aLDT = LocalDateTime.parse(armisticeDateTime);
        System.out.println("Date/Time: " + aLDT);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMM uuuu");
        String anotherDate = "27 jan 2011";
        LocalDate random = LocalDate.parse(anotherDate, df);
        System.out.println(anotherDate + " parse as " + random);
    }
}
