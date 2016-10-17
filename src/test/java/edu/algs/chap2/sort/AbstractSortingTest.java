package edu.algs.chap2.sort;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractSortingTest {

    protected abstract AbstractSort getSut();

    @Test
    public void shouldSortGivenString() throws Exception {
        //given
        String[] input = "SORTEXAMPLE".split("");
        //when
        getSut().sort(input);
        //then
        assertThat(showArray(input)).isEqualTo("A E E L M O P R S T X");
    }

    @Test
    public void shouldSortInverseIntegerArray() throws Exception {
        //given
        Integer[] input = {20, 15, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -5};
        //when
        getSut().sort(input);
        //then
        assertThat(showArray(input)).isEqualTo("-5 0 1 2 3 4 5 6 7 8 9 10 15 20");
    }


    @Test
    public void shouldSortArrayWithManySameKeys() throws Exception {
        //given
        Integer[] input = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1};
        //when
        getSut().sort(input);
        //then
        assertThat(showArray(input)).isEqualTo("-1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1");
    }

    private String showArray(Comparable[] array) {
        String result = "";
        for (Comparable a : array) {
            result += a + " ";
        }
        return result.trim();
    }

}
