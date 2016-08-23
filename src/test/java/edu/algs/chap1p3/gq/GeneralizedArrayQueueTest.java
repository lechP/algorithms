package edu.algs.chap1p3.gq;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneralizedArrayQueueTest {

    private GeneralizedQueue<Integer> queue = new GeneralizedArrayQueue<>();

    @Test
    public void shouldAddThreeElementsAndRemoveMiddleOne() throws Exception {
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        assertThat(queue.delete(1)).isEqualTo(2);
    }

    @Test
    public void shouldAddThreeElementsAndRemoveLastOne() throws Exception {
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        assertThat(queue.delete(2)).isEqualTo(3);
    }

    @Test
    public void shouldAddThreeElementsAndRemoveFirstOne() throws Exception {
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        assertThat(queue.delete(0)).isEqualTo(1);
    }

    @Test
    public void shouldAddFiveElementsAndRemoveThemInSomeRandomOrder() throws Exception {
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        assertThat(queue.delete(2)).isEqualTo(3); //1 2 4 5
        assertThat(queue.delete(3)).isEqualTo(5); //1 2 4
        assertThat(queue.delete(0)).isEqualTo(1); //2 4
        assertThat(queue.delete(0)).isEqualTo(2); //4
        assertThat(queue.delete(0)).isEqualTo(4); //
        assertThat(queue.isEmpty()).isTrue();
    }

    @Test
    public void shouldAddAndRemoveSingleElement() throws Exception {
        queue.insert(1);
        assertThat(queue.delete(0)).isEqualTo(1);
    }


}