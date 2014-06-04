package structure;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alessandro.Dantas on 19/03/2014.
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("One");
        hashSet.add("Two");
        hashSet.add("One");
        hashSet.add("Three");
        hashSet.forEach(s -> System.out.println(s));

        for (String s: hashSet)
            System.out.println(s);
    }
}
