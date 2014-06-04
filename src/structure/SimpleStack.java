package structure;

/**
 * Created by Alessandro on 20/03/2014.
 */
public interface SimpleStack<T> {
    abstract boolean empty();
    abstract void push(T n);
    abstract T pop();
    abstract T peek();
}
