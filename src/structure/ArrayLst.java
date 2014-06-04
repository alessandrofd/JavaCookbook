package structure;

import java.util.ArrayList;

/**
 * Created by Alessandro on 20/03/2014.
 */
public class ArrayLst {
    public static final int MAX = 250_000;

    public static void main(String[] args) {
        System.out.println(new ArrayLst().run());
    }

    public int run()  {
        ArrayList<MutableInteger> list = new ArrayList<>();
        for (int i = 0; i < MAX; i++) {
            list.add(new MutableInteger(i));
        }
        int sum = 0;
        for (int i = 0; i < MAX ; i++) {
            sum += list.get(i).getValue();
        }
        return sum;
    }


}
