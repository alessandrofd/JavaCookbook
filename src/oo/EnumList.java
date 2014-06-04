package oo;

/**
 * Created by Alessandro on 24/03/2014.
 */
public class EnumList {
    enum State {
        ON, OFF, UNKNOWN
    }

    public static void main(String[] args) {
        for (State i : State.values())
            System.out.println(i);
    }
}
