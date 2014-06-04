package io;

import java.io.*;
import java.util.Stack;

public class SimpleCalcStreamTok {
    // The StreamTokenizerInput
    protected StreamTokenizer tokenizer;
    // The Output file
    protected PrintWriter out = new PrintWriter(System.out, true);
    // The variable name (not used in this version)
    protected String variable;
    // The operand stack
    protected Stack stack;

    public static void main(String[] args) throws IOException {
        if (args.length == 0)
            new SimpleCalcStreamTok(new InputStreamReader(System.in)).doCalc();
        else
            for (int i = 0; i < args.length; i++)
                new SimpleCalcStreamTok(args[i]).doCalc();

    }

    /** Construct by filename */
    public SimpleCalcStreamTok(String filename) throws IOException {
        this(new FileReader(filename));
    }

    /** Construct from an existing reader */
    public SimpleCalcStreamTok(Reader reader) throws IOException {
        tokenizer = new StreamTokenizer(reader);
        // Control the input character set
        tokenizer.slashSlashComments(true); // treat "//" as comments
        tokenizer.ordinaryChar('-'); // used for subtraction
        tokenizer.ordinaryChar('/'); // used for division

        stack = new Stack();
    }

    /** Construct from a Reader and a PrintWriter */
    public SimpleCalcStreamTok(Reader reader, PrintWriter writer) throws IOException {
        this(reader);
        setOutput(writer);
    }

    /** Change the output destination */
    public void setOutput(PrintWriter out) { this.out = out; }

    protected void doCalc() throws IOException {
        int iType;
        double tmp;

        while ((iType = tokenizer.nextToken()) != StreamTokenizer.TT_EOF) {
            switch (iType) {
                case StreamTokenizer.TT_NUMBER: // found a number , push value to stack
                    push(tokenizer.nval);
                    break;
                case StreamTokenizer.TT_WORD: // Found a variable, save its name - not used here
                    variable = tokenizer.sval;
                    break;
                case '+': // + operator is commutative
                    push(pop() + pop());
                    break;
                case '-': // - operator: order matters
                    tmp = pop();
                    push(pop() - tmp);
                    break;
                case '*':
                    push(pop() * pop());
                    break;
                case '/':
                    tmp = pop();
                    push(pop() / tmp);
                    break;
                case '=':
                    out.println(peek());
                    break;
                default:
                    System.out.println("What is this? iType: " + iType);
            }
        }
    }

    void push(double val) { stack.push(new Double(val)); }
    double pop() { return ((Double)stack.pop()).doubleValue(); }
    double peek() { return ((Double)stack.peek()).doubleValue(); }
    void clearStack() { stack.removeAllElements(); }
}
