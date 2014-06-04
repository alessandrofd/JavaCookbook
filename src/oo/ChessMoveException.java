package oo;

/**
 * Created by Alessandro.Dantas on 25/03/2014.
 */
public class ChessMoveException extends Exception {
    public ChessMoveException() { super(); }
    public ChessMoveException(String msg) { super(msg); }
    public ChessMoveException(String msg, Exception cause) { super(msg, cause); }
}
