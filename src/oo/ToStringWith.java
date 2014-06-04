package oo;

/**
 * Created by Alessandro.Dantas on 24/03/2014.
 */
public class ToStringWith {
    int x, y;

    /** Simple constructor */
    public ToStringWith(int anX, int aY) {
        x = anX; y = aY;
    }

    @Override
    public String toString() {
        return  "ToStringWith[" + x + "," + y + "]";
    }

    /** Main just creates and prints an object. */
    public static void main(String[] args) {
        System.out.println(new ToStringWith(42, 86));
    }
}
