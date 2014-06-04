package datetime;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Alessandro.Dantas on 18/03/14.
 */
public class CurrentDateTime {
    public static void main(String[] args) {
        LocalDate dNow = LocalDate.now();
        System.out.println(dNow);
        LocalTime tNow = LocalTime.now();
        System.out.println(tNow);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }
}
