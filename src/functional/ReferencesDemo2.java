package functional;

/**
 * Created by Alessandro on 25/03/2014.
 */
public class ReferencesDemo2 {

    void cloz() {
        System.out.println("Stand-in close() method called.");
    }

    public static void main(String[] args) throws Exception {
        ReferencesDemo2 rd2 = new ReferencesDemo2();

        // Use a method reference to assign the AutoCloseable interface
        // variable "ac" to the matching method signature "c"
        try (AutoCloseable autoCloseable = rd2::cloz) {
            System.out.println("Some action happening here");
        }
    }
}
