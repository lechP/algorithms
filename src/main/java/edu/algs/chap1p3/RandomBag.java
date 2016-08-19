package edu.algs.chap1p3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 1.3.34
 * Random bag. A random bag stores a collection of items and supports the following API:
 * public class RandomBag<Item> implements Iterable<Item>
 * RandomBag() create an empty random bag
 * boolean isEmpty() is the bag empty?
 * int size() number of items in the bag
 * void add(Item item) add an item
 * Write a class RandomBag that implements this API. Note that this API is the same as for Bag,
 * except for the adjective random, which indicates that the iteration should provide the items in random order
 * (all N ! permutations equally likely, for each iterator).
 * Hint : Put the items in an array and randomize their order in the iterator’s constructor.
 */
class RandomBag<Item> implements Iterable<Item> {

    @SuppressWarnings("unchecked")
    private Item[] items = (Item[]) new Object[8];
    private int size;

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    void add(Item item) {
        items[size++] = item;
        if (size == items.length) {
            @SuppressWarnings("unchecked") Item[] resizedCopy = (Item[]) new Object[2 * size];
            System.arraycopy(items, 0, resizedCopy, 0, items.length);
            items = resizedCopy;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {

        private int current;

        RandomIterator() {
            shuffleItems();
        }

        private void shuffleItems() {
            @SuppressWarnings("unchecked") Item[] temp = (Item[]) new Object[items.length];
            List<Integer> indexes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                indexes.add(i);
            }
            for (int i = 0; i < size; i++) {
                int random = StdRandom.uniform(indexes.size());
                int randomIndex = indexes.remove(random);
                temp[i] = items[randomIndex];
            }
            System.arraycopy(temp, 0, items, 0, items.length);
        }

        @Override
        public boolean hasNext() {
            return current != size;
        }

        @Override
        public Item next() {
            if (hasNext()) {
                return items[current++];
            } else {
                return null;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void forEachRemaining(Consumer<? super Item> action) {
            throw new UnsupportedOperationException();
        }
    }
}
