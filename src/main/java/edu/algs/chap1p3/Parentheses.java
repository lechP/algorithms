package edu.algs.chap1p3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.3.4
 * reads in a text stream from standard input and uses a stack
 * to determine whether its parentheses are properly balanced.
 * For example, your program should print true for [()]{}{[()()]()} and false for [(]).
 */
public class Parentheses {

    public static void main(String[] args) {
        check("[()]{}{[()()]()}");
        check("[(])");
        check("[]]");
        check("[<(])");
    }

    private static void check(String input) {
        try {
            StdOut.println(input + " : " + new Parentheses().isBalanced(input));
        }catch(IllegalArgumentException e){
            StdOut.println(input + " : " + e.getMessage());
        }
    }

    private Map<Character, Character> rightToLeft = new HashMap<>(3);

    private Parentheses() {
        rightToLeft.put(')', '(');
        rightToLeft.put(']', '[');
        rightToLeft.put('}', '{');
        rightToLeft.put('>', '<');
    }

    private boolean isBalanced(String input) {
        Stack<Character> lefts = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isLeft(c)) {
                lefts.push(c);
            } else if (isRight(c)) {
                char left = rightToLeft.get(c);
                if (lefts.isEmpty() || lefts.pop() != left) return false;
            } else {
                throw new IllegalArgumentException("Unrecognized char: " + c + " at index: " +i);
            }
        }
        return lefts.isEmpty();
    }

    private boolean isRight(char c) {
        return rightToLeft.containsKey(c);
    }

    private boolean isLeft(char c) {
        return rightToLeft.containsValue(c);
    }
}
