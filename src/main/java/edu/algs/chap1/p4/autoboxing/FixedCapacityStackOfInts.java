package edu.algs.chap1.p4.autoboxing;

class FixedCapacityStackOfInts {

    private int[] items;
    private int size;

    FixedCapacityStackOfInts(int capacity) {
        //noinspection unchecked
        items = new int[capacity];
    }

    void push(int item) {
        if (size == items.length) throw new RuntimeException("stack is already full");
        items[size++] = item;
    }

    int pop() {
        if (size == 0) throw new RuntimeException("stack is empty");
        return items[size-- - 1];
    }

}
