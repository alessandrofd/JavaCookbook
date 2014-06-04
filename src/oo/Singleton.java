package oo;

/**
 * Created by Alessandro on 24/03/2014.
 */
public class Singleton {
    private static Singleton instance;

    /** A private constructor prevents any other class from instantiating. */
    private Singleton() { } // Nothing to do this time

    /** The Static initializer constructs the instance at class loading time; this is to simulate a more involved
     * construction process(if it were really simple, you'd just use an initializer.
     */
    static {
        instance = new Singleton();
    }

    /** Static "instance" method */
    public static Singleton getInstance() { return instance; }

    public String demoMethod() { return "demoMethod"; }
}
