package io;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class SimpleCalcScanner {
    protected Scanner scanner;
    protected PrintWriter out = new PrintWriter(System.out, true);
    protected String variable;
    protected Stack<Double> s = new Stack<>();

    public static void main(String[] args) throws IOException {
        if (args.length == 0)
            new SimpleCalcScanner(new InputStreamReader(System.in)).doCalc();
        else
            for (String arg : args) {
                new SimpleCalcScanner(arg).doCalc();
            }
    }

    /** Construct a SimpleCalcScanner by name */
    public SimpleCalcScanner(String fileName) throws IOException {
        this(new FileReader(fileName));
    }

    /** Construct a SimpleCalcScanner from an open Reader */
    public SimpleCalcScanner(Reader reader) throws IOException {
        scanner = new Scanner(reader);
    }

    /** Construct a SimpleCalcScanner from a Reader and an PrintWriter */
    public SimpleCalcScanner(Reader reader, PrintWriter writer) throws IOException {
        this(reader);
        out = writer;
    }

    /** Change the output to a new PrintWriter */
    public void setWriter(PrintWriter writer) {
        out = writer;
    }

    protected void doCalc() throws IOException {
        double tmp;

        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                push(scanner.nextDouble());
            } else {
                String token = scanner.next();
                if (token.equals("+")) {
                    push(pop() + pop());
                } else if (token.equals("-")) {
                    tmp = pop();
                    push(pop() - tmp);
                } else if (token.equals("*")) {
                    push(pop() * pop());
                } else if (token.equals("/")) {
                    tmp = pop();
                    push(pop() / tmp);
                } else if (token.equals("=")) {
                    out.println(peek());
                } else {
                    out.println("What's this? " + token);
                }
            }
        }
    }

    void push(double val) {
        s.push((Double)val);
    }

    double pop() {
        return s.pop().doubleValue();
    }

    double peek() {
        return s.peek().doubleValue();
    }

    void clearStack() {
        s.removeAllElements();
    }
}
