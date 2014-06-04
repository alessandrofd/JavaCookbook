package structure;

import java.util.Date;

/**
 * Created by Alessandro on 18/03/2014.
 */
public class Array2 {
    public final static int INITIAL = 10,
        GROW_FACTOR = 2;

    public static void main(String[] args) {
        int nDates = 0;
        Date[] dates = new Date[INITIAL];
        StructureDemo source = new StructureDemo(21);
        Date c;
        while ((c = source.getDate()) != null) {
/*
            if (nDates >= dates.length) {
                System.err.println("Too many dates. Simplify your life!!!");
                System.exit(1);
            }
*/

            // better reallocate making data structure dynamic
            if (nDates >= dates.length) {
                Date[] tmp = new Date[dates.length * GROW_FACTOR];
                System.arraycopy(dates, 0, tmp, 0, dates.length);
                dates = tmp; // copies the array reference
                // old array will be garbage collected soon ...
            }
            dates[nDates++] = c;
        }
        System.out.println("Final array size = " + dates.length);
    }
}
