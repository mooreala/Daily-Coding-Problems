package February;

import java.util.Stack;

public class P481 {
    public static void main(String args[]) {
        printDesc();

        String[] example = {"15", "7", "1", "1", "+", "-", "/", "3", "*", "2", "1", "1", "+", "+", "-"};
        //String[] example2 = {"5", "3", "+"};
        System.out.print("Evaluation of the expression: [15, 7, 1, 1, '+', '-', '/', 3, '*', 2, 1, 1, '+', '+', '-'] = ");
        System.out.println(evalRPN(example));
    }

    public static int evalRPN(String[] expression) {
        int num, denom;
        Stack<Integer> stack = new Stack<>();
        for (String s : expression) {
            if (s.equals("+")) {
                stack.add(stack.pop() + stack.pop());
            } else if (s.equals("/")) {
                num = stack.pop();
                denom = stack.pop();
                stack.add(num/denom);
            } else if (s.equals("*")) {
                stack.add(stack.pop() * stack.pop());
            } else if (s.equals("-")) {
                num = stack.pop();
                denom = stack.pop();
                stack.add(num - denom);
            } else {
                stack.add(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void printDesc() {
        System.out.println("Given an arithmetic expression in Reverse Polish Notation, write a program to evaluate it.");
    }
}
