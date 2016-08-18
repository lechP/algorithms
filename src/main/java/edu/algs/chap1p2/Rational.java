package edu.algs.chap1p2;

/**
 * 1.2.16
 * data type Rational for rational numbers that supports addition, subtraction, multiplication, and division
 */
class Rational {

    private final long numerator; //upper side
    private final long denominator; //lower side

    Rational(long numerator, long denominator) {
        if (denominator == 0) throw new IllegalArgumentException("denominator cannot be zero");

        long gcd = Math.abs(gcd(numerator, denominator));
        int sign = denominator < 0 ? -1 : 1;
        this.numerator = sign * numerator / gcd;
        this.denominator = sign * denominator / gcd;
    }

    Rational plus(Rational that) {
        return new Rational(this.numerator * that.denominator + that.numerator * this.denominator, this.denominator * that.denominator);
    }

    Rational minus(Rational that) {
        return new Rational(this.numerator * that.denominator - that.numerator * this.denominator, this.denominator * that.denominator);
    }

    Rational times(Rational that) {
        return new Rational(this.numerator * that.numerator, this.denominator * that.denominator);
    }

    Rational dividedBy(Rational that) {
        return new Rational(this.numerator * that.denominator, this.denominator * that.numerator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rational rational = (Rational) o;
        return numerator == rational.numerator && denominator == rational.denominator;
    }

    @Override
    public int hashCode() {
        int result = (int) (numerator ^ (numerator >>> 32));
        result = 31 * result + (int) (denominator ^ (denominator >>> 32));
        return result;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    /**
     * Greatest common divisor of p and q
     */
    private long gcd(long p, long q) {
        if (q == 0) return p;
        long r = p % q;
        return gcd(q, r);
    }

}
