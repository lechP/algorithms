package edu.algs.chap1p1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Ch1HistogramTest {

    private Ch1Histogram sut = new Ch1Histogram();

    @Test
    public void shouldComputeExactlyNCardinalities() throws Exception {
        final int expected = 10;
        int[] result = sut.computeCardinalities(expected, 0, 1, new double[]{});
        assertThat(result).hasSize(expected);
    }

    @Test
    public void shouldCountDataIntoProperIntervals() throws Exception {
        int[] result = sut.computeCardinalities(2, 0, 1, new double[]{0.8, 0.2, 0.3});
        assertThat(result[0]).isEqualTo(2);
        assertThat(result[1]).isEqualTo(1);
    }

    @Test
    public void shouldIgnoreDataOutsideTheInterval() throws Exception {
        int[] result = sut.computeCardinalities(2, 0, 1, new double[]{10.8, 1.2, -0.3});
        assertThat(result[0]).isEqualTo(0);
        assertThat(result[1]).isEqualTo(0);
    }

}