package edu.algs.chap1.p4;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BigIntThreeSumTest {

    private BigIntThreeSum sut = new BigIntThreeSum();

    @Test
    public void shouldFindOneThreeInGroupOfFourNumbers() throws Exception {
        //given
        int[] input = new int[]{0, 1, 2, -3};
        //when
        int result = sut.countThreeSums(input);
        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldNotOverflow() throws Exception {
        //given
        int[] input = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 2}; //in the case of overflow those three numbers sum up to 0
        //when
        int result = sut.countThreeSums(input);
        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldFindTenThreesInMediumSizedGroup() throws Exception {
        //given
        int[] input = new int[]{0, 1, 2, -3, 5, -5, 3, 7, -7, 4, Integer.MAX_VALUE, Integer.MIN_VALUE + 150, -150, 70, 80, -40, -30};
        //1,2,-3; 0,3,-3; 0,5,-5; 0,7,-7; 2,5,-7; 3,4,-7; -5,1,4; MAX,MIN-150,150; 70,80,-150; -30,-40,70
        //when
        int result = sut.countThreeSums(input);
        //then
        assertThat(result).isEqualTo(10);
    }


}