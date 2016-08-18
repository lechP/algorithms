package edu.algs.chap1p1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Ch1ExcercisesTest {


    private Ch1Excercises sut = new Ch1Excercises();

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptZero() throws Exception {
        sut.lg(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptNegativeInteger() throws Exception {
        sut.lg(-23);
    }

    @Test
    public void shouldReturn0ForInput1 () throws Exception {
        assertThat(sut.lg(1)).isEqualTo(0);
    }

    @Test
    public void shouldReturn5ForInput63 () throws Exception {
        assertThat(sut.lg(63)).isEqualTo(5);
    }

    @Test
    public void shouldReturn6ForInput64 () throws Exception {
        assertThat(sut.lg(64)).isEqualTo(6);
    }

    @Test
    public void shouldHandleIntegerMaxValue () throws Exception {
        assertThat(sut.lg(Integer.MAX_VALUE)).isEqualTo(30);
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptNonPositiveArrayLength() throws Exception {
        sut.histogram(new int[1], 0);
    }

    @Test
    public void shouldReturnArrayOfSizeM() throws Exception {
        assertThat(sut.histogram(new int[0], 10)).hasSize(10);
    }

    @Test
    public void shouldCountAllElementsOfInputArray() throws Exception {
        assertThat(sut.histogram(new int[]{5, 5, 5, 4, 2, 5, 1, 1}, 6)).isEqualTo(new int[]{0, 2, 1, 0, 1, 4});
    }

    @Test
    public void shouldIgnoreTheNumbersOutsideTheRange() throws Exception {
        assertThat(sut.histogram(new int[]{5, 5, 5, 4, 2, 5, 1, 1, 6, -1, 99}, 6))
                .isEqualTo(new int[]{0, 2, 1, 0, 1, 4});
    }

    @Test
    public void shouldProperlyMarkRelativelyPrimeNumbers() throws Exception {
        boolean[][] primeMap = sut.relativePrimes(100);
        assertThat(primeMap).hasSize(100);
        assertThat(primeMap[0]).hasSize(100);
        assertThat(primeMap[0][0]).isTrue();
        assertThat(primeMap[0][5]).isTrue();
        assertThat(primeMap[44][0]).isTrue();

        assertThat(primeMap[1][1]).isTrue();
        assertThat(primeMap[1][23]).isTrue();
        assertThat(primeMap[5][11]).isTrue();
        assertThat(primeMap[12][91]).isTrue();

        assertThat(primeMap[15][15]).isFalse();
        assertThat(primeMap[6][33]).isFalse();
        assertThat(primeMap[42][77]).isFalse();
        assertThat(primeMap[64][62]).isFalse();
    }

}