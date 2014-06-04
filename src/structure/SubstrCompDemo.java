package structure;

import java.util.Arrays;

/**
 * Created by Alessandro.Dantas on 20/03/2014.
 */
public class SubstrCompDemo {
    public static void main(String[] args) {
        String[] strings = {
                "painful",
                "mainly",
                "gaining",
                "raindrops"
        };
        Arrays.sort(strings);
        dump(strings, "Using Default Sort");

        Arrays.sort(strings, new SubstringComparator());
        dump(strings, "Using SubstringComparator");
    }

    static void dump(String[] args, String title) {
        System.out.println(title);
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}
