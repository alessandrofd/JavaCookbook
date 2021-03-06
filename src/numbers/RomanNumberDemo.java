package numbers;


/**
 * Created by Alessandro.Dantas on 13/03/14.
 */
public class RomanNumberDemo {
    public static void main(String[] args) {
        RomanNumberFormat nf = new RomanNumberFormat();
        System.out.println("Test of " + nf);
        try {
            System.out.println("0->" + nf.format(0));
            System.out.println("Failed to object to zero");
        } catch (NumberFormatException ex) {
            System.out.println("Correctly rejected zero");
        }

        System.out.println("42->" + nf.format(42));
        System.out.println("678->" + nf.format(678));
        System.out.println("1999->" + nf.format(1999));
        System.out.println("2000->" + nf.format(2000));
        System.out.println("2001->" + nf.format(2001));
        System.out.println("3999->" + nf.format(3999));
        //System.out.println("4000->" + nf.format(4000)); // expect Exception

        System.out.println("XIV->" + nf.parseObject("XIV", null));
    }
}
