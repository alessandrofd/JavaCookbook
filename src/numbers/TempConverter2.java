package numbers;

/**
 * Created by Alessandro on 17/03/14.
 */
public class TempConverter2 extends TempConverter {

    public static void main(String[] args) {
        TempConverter2 t = new TempConverter2();
        t.start();
        t.data();
        t.end();
    }

    protected void start() {
        System.out.println("Fahr Centigrade");
    }

    protected void print(float f, float c) {
        System.out.printf("%6.2f %6.2f%n", f, c);
    }

    protected void  end() {
        System.out.println("-------------------");
    }
}
