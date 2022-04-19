package Mihaidono;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack {

    private int top;
    private Vector<String> myStack;

    MyStack() {
        myStack = new Vector<>();
        top = -1;
    }

    public void sPush(String i) {
        top++;
        myStack.add(i);
    }

    public String sPop() {
        String element;
        if (sEmpty()) {
            throw new EmptyStackException();
        } else {
            element=myStack.elementAt(top);
            myStack.remove(top);
            top = top - 1;
            return element;
        }
    }

    public boolean sEmpty() {
        if (this.top == -1) {
            return true;
        } else return false;
    }

    public void printStack() {
        for (String str : myStack) {
            System.out.print(str + " ");
        }
    }

    private boolean isOperator(Character character) {
        if (character == '%' || character == '/' || character == '*' || character == '+' || character == '-') {
            return true;
        }
        return false;
    }

    private int doOperation(int v1, int v2, Character chr) {
        switch (chr) {
            case '%':
                return v2 % v1;
            case '/':
                return v2 / v1;
            case '*':
                return v2 * v1;
            case '+':
                return v2 + v1;
            case '-':
                return v2 - v1;
            default:
                return 0;
        }
    }

    public int postFixed(String line) {
        int sum = 0, it = 0;
        while (it<line.length()) {
            sum = 0;
            if (Character.isDigit(line.charAt(it))) {
                sPush(String.valueOf(line.charAt(it)));
            } else if (isOperator(line.charAt(it))) {
                Integer v1 = Integer.parseInt(sPop());
                Integer v2 = Integer.parseInt(sPop());
                sum += doOperation(v1, v2, line.charAt(it));
                sPush(String.valueOf(sum));
            }
            it++;
        }
        return sum;
    }
}
