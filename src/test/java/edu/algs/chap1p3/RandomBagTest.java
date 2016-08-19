package edu.algs.chap1p3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomBagTest {

    @Test
    public void shouldAddAnItem() throws Exception {
        RandomBag<String> bag = new RandomBag<>();
        assertThat(bag.isEmpty()).isTrue();
        assertThat(bag.size()).isEqualTo(0);
        bag.add("Some item");
        assertThat(bag.isEmpty()).isFalse();
        assertThat(bag.size()).isEqualTo(1);
        assertThat(bag.iterator().next()).isEqualTo("Some item");
    }

    @Test
    public void shouldShuffleItemsInRandomOrder() throws Exception {
        RandomBag<String> bag = new RandomBag<>();
        String s1 = "some item";
        String s2 = "other item";
        String s3 = "third item";
        String s4 = "and just another item";
        bag.add(s1);
        bag.add(s2);
        bag.add(s3);
        bag.add(s4);
        assertThat(bag).containsExactlyInAnyOrder(s1, s2, s3, s4).doesNotContain("some new item");
    }

    @Test
    public void shouldHandleResizing() throws Exception {
        RandomBag<String> bag = new RandomBag<>();
        String s1 = "some item";
        for (int i = 0; i < 10; i++) {
            bag.add(s1);
        }
    }

}