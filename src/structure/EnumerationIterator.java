package structure;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created by Alessandro.Dantas on 20/03/2014.
 */
public class EnumerationIterator<T> implements Iterator {

    /** The Enumeration being delegated to. */
    private final Enumeration<T> oldEnum;

    /** Construct an EnumerationIterator from an old-style Enumeration.
     * @param old The Enumeration to be adapted.
     */
    public EnumerationIterator(final Enumeration<T> old) { oldEnum = old; }

    /** Fulfills the general contract of Iterator.hasNext(), that is, return true as long as there is at least one more
     * item in the Iterator.
     */
    public boolean hasNext() { return   oldEnum.hasMoreElements(); }

    /** Fulfills the general contract of Iterator.next(), that is, returns the next element in the Iterator. */
    public T next() { return oldEnum.nextElement(); }

    /** Remove is not implemented (optional method).
     * @throws java.lang.UnsupportedOperationException in all cases
     */
    public void remove() { throw new UnsupportedOperationException("remove"); }

}
