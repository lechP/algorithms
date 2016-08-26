package edu.algs.chap1.p4.autoboxing;

class FixedCapacityStack<Item> {

    private Item[] items;
    private int size;

    FixedCapacityStack(int capacity) {
        //noinspection unchecked
        items = (Item[]) new Object[capacity];
    }

    void push(Item item) {
        if (size == items.length) throw new RuntimeException("stack is already full");
        items[size++] = item;
    }

    Item pop() {
        if (size == 0) throw new RuntimeException("stack is empty");
        return items[size-- - 1];
    }

}
