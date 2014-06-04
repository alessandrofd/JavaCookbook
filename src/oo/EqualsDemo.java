package oo;

/**
 * Created by Alessandro.Dantas on 24/03/2014.
 */
public class EqualsDemo {
    private int int1;
    private SomeClass obj1;

    /** Constructor */
    public EqualsDemo(int i, SomeClass o) {
        int1 = 1;
        if (o == null) {
            throw new IllegalArgumentException("Data Object may not be null");
        }
        obj1 = o;
    }

    /** Default constructor */
    public EqualsDemo() {
        this(0, new SomeClass());
    }

    /** Demonstration "equals" method */
    @Override
    public boolean equals(Object o) {
        if (o == this) // optimization
            return true;

        if (o == null) // No object ever equals null
            return false;

        // Of the correct class?
        if (o.getClass() != EqualsDemo.class)
            return false;

        EqualsDemo other = (EqualsDemo)o; // OK, cast to this class

        // compare field-by-field
        if (int1 != other.int1) // compare primitives directly
            return false;
        if (!obj1.equals(other.obj1))  // compare objects using their equals
            return false;
        return true;
    }
}
