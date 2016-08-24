package edu.algs.chap1.p3.gq;

class GeneralizedLinkedQueue<Item> implements GeneralizedQueue<Item> {

    private Node<Item> first;
    private int size;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void insert(Item x) {
        Node<Item> newNode = new Node<>();
        newNode.item = x;
        if (first != null) {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        } else {
            first = newNode;
        }
        size++;
    }

    @Override
    public Item delete(int k) {
        if (size < k + 1) throw new IllegalArgumentException("Argument exceeds queue size: " + k + 1);
        size--;
        if (k == 0) {
            Item result = first.item;
            first = first.next;
            return result;
        } else {
            Node<Item> current = first;
            for (int i = 0; i < k - 1; i++) {
                current = current.next;
            }
            Node<Item> removed = current.next;
            current.next = removed.next;
            return removed.item;
        }
    }

}
