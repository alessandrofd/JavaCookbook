package numbers;

/**
 * Created by Alessandro.Dantas on 12/03/14.
 */
public class Round {
    /** We round a number up if its fraction exceeds this threshold. */
    public static final double THRESHOLD = 0.54;

    /** numbers.Round floating values to integers.
     * @return the closes int to the argument
     * @param d a Non-negative value to be rounded.
     */
    public static int round(double d) {
        return (int)Math.floor(d + 1.0 - THRESHOLD);
    }

    public static void main(String[] args) {
        for (double d = 0.1; d <= 1.0; d += 0.05) {
            System.out.println("My way: " + d + "-> " + round(d));
            System.out.println("Math way: " + d + "-> " + Math.round(d));
        }
    }
}
