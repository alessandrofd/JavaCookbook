package structure;

/**
 * Created by Alessandro on 20/03/2014.
 */
public class ToyStack {

    protected int MAX_DEPTH = 10;
    protected int depth = 0;
    protected int[] stack = new int[MAX_DEPTH];

    protected void push(int n) {
        stack[depth++] = n;
    }

    protected int pop() {
        return stack[--depth];
    }

    protected int peek() {
        return stack[depth-1];
    }
}
