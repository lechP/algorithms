package edu.algs.chap1p3.arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Program gets as input space-separated infix arithmetical expression, parses it to postfix and computes value.
 * It's a merge of the two following problems:
 * 1.3.10 Write a filter InfixToPostfix that converts an arithmetic expression from infix to postfix.
 * 1.3.11 Write a program EvaluatePostfix that takes a postfix expression from standard input, evaluates it,
 * and prints the value. (Piping the output of your program from the previous exercise
 * to this program gives equivalent behavior to Evaluate.)
 */
class ArithmeticEvaluator {

    List<String> parseInfixExpression(String input) {
        return new ArrayList<>();
    }

    double evaluatePostfix(Stack<String> tokens) {
        validate(tokens);
        Stack<Operation> ops = new Stack<>();
        while (Operation.isOperation(tokens.peek())) {
            ops.push(Operation.fromString(tokens.pop()));
        }
        Double right = Double.valueOf(tokens.pop());
        while (!ops.empty()) {
            if (Operation.isOperation(tokens.peek())) {
                right = ops.pop().apply(evaluatePostfix(tokens), right);
            } else {
                Double left = Double.valueOf(tokens.pop());
                right = ops.pop().apply(left, right);
            }
        }
        return right;
    }

    private void validate(Stack<String> tokens) {
        int operations = 0;
        int operands = 0;
        Stack<String> tokensCopy = new Stack<>();
        tokens.forEach(tokensCopy::push);
        while (!tokensCopy.empty()) {
            String token = tokensCopy.pop();
            if (Operation.isOperation(token)) {
                operations++;
            } else try {
                //noinspection ResultOfMethodCallIgnored
                Double.parseDouble(token);
                operands++;
                if(operations==0 || operands == operations+2){
                    throw new IllegalArgumentException("Too much operands: " + operands + " for operations: " + operations);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Token which is neither operation symbol nor number: " + token);
            }
        }
        if (operations + 1 != operands) {
            throw new IllegalArgumentException("Invalid number of operations and operands.");
        }
    }

}
