package structure;

import java.util.Arrays;

/**
 * Created by Alessandro.Dantas on 20/03/2014.
 */
public class SortArray {
    public static void main(String[] args) {
        String[] strings = {
                "painful",
                "mainly",
                "gaining",
                "raindrops"
        };
        Arrays.sort(strings);
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }
}
