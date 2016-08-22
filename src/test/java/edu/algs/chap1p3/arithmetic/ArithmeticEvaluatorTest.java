package edu.algs.chap1p3.arithmetic;

import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;


public class ArithmeticEvaluatorTest {

    private ArithmeticEvaluator sut = new ArithmeticEvaluator();

    @Test
    public void shouldEvaluateSimpleAdd() throws Exception {
        Stack<String> tokens = new Stack<>();
        tokens.push("12.6");
        tokens.push("4.4");
        tokens.push("+");
        //when
        double result = sut.evaluatePostfix(tokens);
        //then
        assertThat(result).isEqualTo(17);
    }

    @Test
    public void shouldEvaluateTwoSimpleAdditions() throws Exception {
        Stack<String> tokens = new Stack<>();
        tokens.push("2");
        tokens.push("3");
        tokens.push("+");
        tokens.push("4");
        tokens.push("+");
        //when
        double result = sut.evaluatePostfix(tokens);
        //then
        assertThat(result).isEqualTo(9);
    }

    @Test
    public void shouldEvaluateCompoundOperation() throws Exception {
        Stack<String> tokens = new Stack<>();
        tokens.push("2");
        tokens.push("3");
        tokens.push("4");
        tokens.push("*");
        tokens.push("+");
        //when
        double result = sut.evaluatePostfix(tokens);
        //then
        assertThat(result).isEqualTo(14); //2+3*4
    }

    @Test
    public void shouldEvaluateMoreCompound() throws Exception {
        Stack<String> tokens = new Stack<>();
        tokens.push("2");
        tokens.push("3");
        tokens.push("4");
        tokens.push("5");
        tokens.push("+");
        tokens.push("*");
        tokens.push("+");
        //when
        double result = sut.evaluatePostfix(tokens);
        //then
        assertThat(result).isEqualTo(29); //2+3*(4+5)
    }

    @Test
    public void shouldEvaluateReallyComplexOperation() throws Exception {
        Stack<String> tokens = new Stack<>();
        tokens.push("12");
        tokens.push("4");
        tokens.push("5");
        tokens.push("2");
        tokens.push("+");
        tokens.push("*");
        tokens.push("-");

        tokens.push("11");
        tokens.push("8");
        tokens.push("2");
        tokens.push("2");
        tokens.push("+");
        tokens.push("/");
        tokens.push("-");

        tokens.push("+");
        //when
        double result = sut.evaluatePostfix(tokens);
        //then
        assertThat(result).isEqualTo(-7); //12-4*(5+2)+11-8/(2+2)
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForTooMuchOperands() throws Exception {
        Stack<String> tokens = new Stack<>();
        tokens.push("2");
        tokens.push("3");
        tokens.push("+");
        tokens.push("-");
        //when
        sut.evaluatePostfix(tokens);
        //then exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForInvalidToken() throws Exception {
        Stack<String> tokens = new Stack<>();
        tokens.push("wrong");
        //when
        sut.evaluatePostfix(tokens);
        //then exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForInproperOrderOfTokens() throws Exception {
        Stack<String> tokens = new Stack<>();
        tokens.push("2");
        tokens.push("+");
        tokens.push("3");
        //when
        sut.evaluatePostfix(tokens);
        //then exception
    }

}