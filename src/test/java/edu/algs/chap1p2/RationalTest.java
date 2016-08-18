package edu.algs.chap1p2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RationalTest {

    @Test
    public void shouldConstructRational() throws Exception {
        Rational r = new Rational(1, 3);
        assertThat(r.toString()).isEqualTo("1/3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptZeroAsDenominator() throws Exception {
        new Rational(0, 0);
    }

    @Test
    public void shouldSimplifyComplexRational() throws Exception {
        Rational r = new Rational(10, 15);
        assertThat(r.toString()).isEqualTo("2/3");
    }

    @Test
    public void shouldLeaveNegativeNumerator() throws Exception {
        Rational r = new Rational(-1, 17);
        assertThat(r.toString()).isEqualTo("-1/17");
    }

    @Test
    public void shouldGetRidOfMinusWhenBothNumeratorAndDenominatorAreNegative() throws Exception {
        Rational r = new Rational(-10, -17);
        assertThat(r.toString()).isEqualTo("10/17");
    }

    @Test
    public void shouldMoveMinusToNumeratorWhenOnlyDenominatorIsNegative() throws Exception {
        Rational r = new Rational(10, -15);
        assertThat(r.toString()).isEqualTo("-2/3");
    }

    @Test
    public void shouldAddTwoRationalsWithTheSameDenominator() throws Exception {
        Rational a = new Rational(1, 5);
        Rational b = new Rational(2, 5);
        assertThat(a.plus(b).toString()).isEqualTo("3/5");
    }

    @Test
    public void shouldAddTwoRationalsWithDifferentDenominator() throws Exception {
        Rational a = new Rational(1, 3);
        Rational b = new Rational(1, 2);
        assertThat(a.plus(b).toString()).isEqualTo("5/6");
    }

    @Test
    public void shouldSubtractTwoRationalsWithTheSameDenominator() throws Exception {
        Rational a = new Rational(3, 5);
        Rational b = new Rational(2, 5);
        assertThat(a.minus(b).toString()).isEqualTo("1/5");
    }

    @Test
    public void shouldSubtractTwoRationalsWithDifferentDenominator() throws Exception {
        Rational a = new Rational(1, 3);
        Rational b = new Rational(1, 2);
        assertThat(a.minus(b).toString()).isEqualTo("-1/6");
    }

    @Test
    public void shouldMultiplyTwoRationals() throws Exception {
        Rational a = new Rational(-2, 5);
        Rational b = new Rational(-5, 11);
        assertThat(a.times(b).toString()).isEqualTo("2/11");
    }

    @Test
    public void shouldDivideTwoRationals() throws Exception {
        Rational a = new Rational(-5, 2);
        Rational b = new Rational(-5, 11);
        assertThat(a.dividedBy(b).toString()).isEqualTo("11/2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptZeroAsDividor() throws Exception {
        new Rational(1,1).dividedBy(new Rational(0, 1));
    }

}