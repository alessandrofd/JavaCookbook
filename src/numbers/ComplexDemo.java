package numbers;

/**
 * Created by Alessandro.Dantas on 17/03/14.
 */
public class ComplexDemo {
    public static void main(String[] args) {
        Complex c = new Complex(3, 5);
        Complex d = new Complex(2, -2);
        System.out.println(c);
        System.out.println(c + ".getReal() = " + c.getReal());
        System.out.println(c + " + " + d + " = " + c.add(d));
        System.out.println(c + " + " + d + " = " + Complex.add(c, d));
        System.out.println(c + " * " + d + " = " + c.multiply(c));
        System.out.println(Complex.divide(c, d));
    }
}
