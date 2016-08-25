package edu.algs.chap1.p4;

import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class CommonElementsFinderTest {

    private CommonElementsFinder sut = new CommonElementsFinder();

    @Test
    public void shouldHandleEmptyArrays() throws Exception {
        //given
        int[] a = new int[0];
        int[] b = new int[0];
        //when
        Set<Integer> result = sut.findCommonElements(a, b);
        //then
        assertThat(result).isEmpty();
    }

    @Test
    public void shouldFindSingleElementAtTheEnd() throws Exception {
        //given
        int[] a = new int[]{0, 1, 2, 3, 10};
        int[] b = new int[]{-5, -4, -7, 4, 10, 10};
        //when
        Set<Integer> result = sut.findCommonElements(a, b);
        //then
        assertThat(result).hasSize(1).contains(10);
    }

    @Test
    public void shouldFindSingleElementInTheMiddle() throws Exception {
        //given
        int[] a = new int[]{0, 1, 2, 3, 10, 15, 17, 150};
        int[] b = new int[]{-5, -4, -7, 4, 10, 10, 44, 762};
        //when
        Set<Integer> result = sut.findCommonElements(a, b);
        //then
        assertThat(result).hasSize(1).contains(10);
    }


    @Test
    public void shouldFindSingleElementAtTheBeginning() throws Exception {
        //given
        int[] a = new int[]{10, 15, 17, 150};
        int[] b = new int[]{10, 10, 44, 762};
        //when
        Set<Integer> result = sut.findCommonElements(a, b);
        //then
        assertThat(result).hasSize(1).contains(10);
    }

    @Test
    public void shouldFindAllCommonElements() throws Exception {
        //given
        int[] a = new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int[] b = new int[]{-5, - 3, -1, 1, 3, 4, 5, 7, 9, 11, 13, 15, 17, 18, 20, 21, 99, 1000};
        //when
        Set<Integer> result = sut.findCommonElements(a, b);
        //then
        assertThat(result).hasSize(3).contains(4, 18, 20);
    }

}