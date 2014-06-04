package strings;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Alessandro.Dantas on 28/02/14.
 */
public class StringReverse {
    public static void main(String[] args) {
        String s = "Father Charles Goes Down And Ends Battle";

        // Put it in the stack frontwards
        Stack<String> myStack = new Stack<String>();
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreElements())
            myStack.push(st.nextToken());

        // Print the stack backwards
        System.out.print('"' + s + '"' + " backwards by word is:\n\t\"");
        while (!myStack.empty()) {
            System.out.print(myStack.pop());
            System.out.print(' ');
        }
        System.out.println('"');
    }
}
