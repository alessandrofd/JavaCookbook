package oo;

/**
 * Created by Alessandro on 24/03/2014.
 */
public class SingletonDemo {
    public static void main(String[] args) {
        Singleton tmp = Singleton.getInstance();
        System.out.println(tmp.demoMethod());
    }
}
