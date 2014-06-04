package oo;

/**
 * Created by Alessandro.Dantas on 24/03/2014.
 */
public class SomeClass {
    public boolean equals(Object o2) {
        if (!(o2 instanceof SomeClass))
            return false;
        // compare fields; if any differ, return false
        return true;
    }
}
