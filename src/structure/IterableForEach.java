package structure;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Alessandro.Dantas on 19/03/2014.
 */
public class IterableForEach {
    public static void main(String[] args) {
        Collection<String> c = Arrays.asList("One", "Two", "Three");
        c.forEach(s -> System.out.println(s));
    }
}
