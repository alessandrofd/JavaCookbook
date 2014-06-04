package functional;

/**
 * Created by Alessandro on 25/03/2014.
 */
public class ReferencesDemo3 {

    interface FunInterface {
        void process(int i, String s, char c, double d);
    }

    public static void work(int i, String s, char c, double d) {
        System.out.println("Moo");
    }

    public static void main(String[] args) {
        FunInterface sample = ReferencesDemo3::work;
        System.out.println("My process method is " + sample);
    }
}
