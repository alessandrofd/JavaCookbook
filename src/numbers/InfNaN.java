package numbers;

/**
 * Created by Alessandro.Dantas on 12/03/14.
 */
public class InfNaN {
    public static void main(String[] args) {
        double d = 123;
        double e = 0;
        if (d/e == Double.POSITIVE_INFINITY)
            System.out.println("Check for POSITIVE_INFINITY works");
        double s = Math.sqrt(-1);
        if (s == Double.NaN)
            System.out.println("Comparison with NaN incorrectly returns true");
        if (Double.isNaN(s))
            System.out.println("Double.isNaN() correctly returns true");
    }
}
