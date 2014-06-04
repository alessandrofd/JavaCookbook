package numbers;

/**
 * Created by Alessandro.Dantas on 17/03/14.
 */
public class FormatPlurals {
    public static void main(String[] args) {
        report(0);
        report(1);
        report(2);
    }

    public static void  report(int n){
        System.out.println("We used " + n + " item" + (n == 1 ? "" : "s"));
    }
}
