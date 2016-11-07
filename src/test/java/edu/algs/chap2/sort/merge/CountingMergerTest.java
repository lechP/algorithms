package edu.algs.chap2.sort.merge;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountingMergerTest {

    @Test
    public void shouldCountArrayAccesses() throws Exception {
        //given
        Integer[] a = new Integer[]{3, 7, 11, 1, 10, 15};
        int low = 0;
        int mid = 2;
        int high = 5;
        //when
        CountingMerger sut = new CountingMerger();
        sut.merge(a, low, mid, high);
        //then
        assertThat(sut.getArrayAccessesCount()).isEqualTo(22);
        //why 22? 6 for copy, 5x3 for comparisons, 1x1 for copying when i exceeded mid
    }

    @Test
    public void shouldCountAllAccessesDuringSorting() throws Exception {
        //given
        Integer[] a = new Integer[]{4, 3, 2, 1};
        //when
        CountingMerger sut = new CountingMerger();
        MergeTopDown sort = new MergeTopDown(sut);
        sort.sort(a);
        //then
        assertThat(sut.getArrayAccessesCount()).isEqualTo(24);
        //why 24? 2x6 (for merge({4}, {3}) and merge ({2}, {1})) + 12 for merge({3, 4}, {1, 2})
    }

}