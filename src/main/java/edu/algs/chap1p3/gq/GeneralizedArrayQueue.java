package edu.algs.chap1p3.gq;

class GeneralizedArrayQueue<Item> implements GeneralizedQueue<Item> {

    private int size;
    @SuppressWarnings("unchecked")
    private Item[] items = (Item[]) new Object[8];

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(Item x) {
        if (size == items.length) resize(size * 2);
        items[size++] = x;
    }

    private void resize(int size) {
        @SuppressWarnings("unchecked") Item[] copy = (Item[]) new Object[size];
        System.arraycopy(items, 0, copy, 0, items.length);
        items = copy;
    }

    @Override
    public Item delete(int k) {
        if (size < k + 1) throw new IllegalArgumentException("Argument exceeds queue size: " + k + 1);
        Item result = items[k];
        System.arraycopy(items, k + 1, items, k, size - 1 - k);
        items[size-- - 1] = null;
        return result;
    }
}
