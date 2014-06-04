package structure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Alessandro on 20/03/2014.
 */
public class ArrayIterator<T> implements Iterable<T>, Iterator<T> {

    protected T[] data;
    protected int index = 0;

    public ArrayIterator(final T[] d) {
        setData(d);
    }

    public void setData(final T[] d) {
        this.data = d;
        index = 0;
    }

    //---------------------
    // Methods of Iterable
    //---------------------
    @Override
    public Iterator<T> iterator() {
        index = 0;
        return this; // since main class implements both interfaces
    }

    //---------------------
    // Methods of Iterator
    //---------------------
    @Override
    public boolean hasNext() {
        return (index < data.length);
    }

    @Override
    public T next() {
        if (hasNext()) {
            return data[index++];
        }
        throw new NoSuchElementException("only " + data.length + " elements");
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("This demo iterator does not implement the remove method.");
    }
}
