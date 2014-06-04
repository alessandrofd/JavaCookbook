package structure;

/**
 * Created by Alessandro on 20/03/2014.
 */
public class ToyStack2 implements SimpleStack<Integer> {

    protected int MAX_DEPTH = 10;
    protected int depth = 0;
    protected int[] stack = new int[MAX_DEPTH];

    @Override
    public boolean empty() {
        return depth == 0;
    }

    @Override
    public void push(Integer n) {
        stack[depth++] = n;
    }

    @Override
    public Integer pop() {
        return stack[--depth];
    }

    @Override
    public Integer peek() {
        return stack[depth-1];
    }
}
