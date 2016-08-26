package edu.algs.chap1.p4;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatrixLocalMinimumTest {

    private MatrixLocalMinimum sut = new MatrixLocalMinimum();

    @Test
    public void shouldHandle1x1matrix() throws Exception {
        //given
        int[][] matrix = new int[1][1];
        matrix[0][0] = -2;
        //when
        int result = sut.localMinimum(matrix);
        //then
        assertThat(result).isEqualTo(-2);
    }

    @Test
    public void shouldHandle2x2matrix() throws Exception {
        //given
        int[][] matrix = new int[2][2];
        matrix[0] = new int[]{1, 2};
        matrix[1] = new int[]{3, 4};
        //when
        int result = sut.localMinimum(matrix);
        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldHandle3x3matrixWithMinimumInTheMiddle() throws Exception {
        //given
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1, 2, 3};
        matrix[1] = new int[]{4, 0, 6};
        matrix[2] = new int[]{7, 8, 9};
        //when
        int result = sut.localMinimum(matrix);
        //then
        assertThat(result).isEqualTo(0);
    }


    @Test
    public void shouldHandle3x3matrixWithMinimumOnTheEdge() throws Exception {
        //given
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{5, 2, 3};
        matrix[1] = new int[]{1, 4, 6};
        matrix[2] = new int[]{7, 8, 9};
        //when
        int result = sut.localMinimum(matrix);
        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldHandle4x4matrixWithMinimumNotOnTheMiddleLine() throws Exception {
        //given
        int[][] matrix = new int[4][4];
        matrix[0] = new int[]{5, 2, 3, 11};
        matrix[1] = new int[]{4, 1, 6, 15};
        matrix[2] = new int[]{7, 8, 9, 10};
        matrix[3] = new int[]{13, 12, 5, 14};
        //when
        int result = sut.localMinimum(matrix);
        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldHandle11x11matrixWithMinimumInSomeQuarter() throws Exception {
        //given
        int[][] matrix = new int[11][11];
        int m = 1;
        matrix[ 0] = new int[]{62, 63, 39, 64, 65, 50, 66, 67, 68, 69, 70};
        matrix[ 1] = new int[]{71, 72, 38, 73, 74, 49, 75, 76, 77, 78, 79};
        matrix[ 2] = new int[]{37, 36, 33, 34, 35, 48, 98, 95, 96, 97, 94};
        matrix[ 3] = new int[]{99, 28, 32, 103, m, 10, 108, 109, 110, 111, 112};
        matrix[ 4] = new int[]{29, 4, 31, 102, 81, 47, 113, 114, 115, 116, 117};
        matrix[ 5] = new int[]{46, 45, 30, 44, 43, 60, 51, 52, 53, 54, 55};
        matrix[ 6] = new int[]{11, 100, 2, 3, 101, 56, 118, 119, 120, 121, 107};
        matrix[ 7] = new int[]{12, 18, 88, 19, 0, 57, 22, 23, 122, 123, 106};
        matrix[ 8] = new int[]{13, 17, 89, 20, 27, 58, 21, 24, 124, 125, 105};
        matrix[ 9] = new int[]{14, 87, 90, 86, 85, 59, 26, 25, 126, 127, 104};
        matrix[10] = new int[]{15, 16, 91, 92, 93, 61, 84, 83, 82, 80, 103};
        //when
        int result = sut.localMinimum(matrix);
        //then
        assertThat(result).isEqualTo(m);
    }

}