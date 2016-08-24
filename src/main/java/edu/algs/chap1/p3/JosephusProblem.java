package edu.algs.chap1.p3;


import edu.princeton.cs.algs4.StdOut;

/**
 * 1.3.37  Josephus problem. In the Josephus problem from antiquity, N people are in dire straits and agree
 * to the following strategy to reduce the population. They arrange themselves in a circle
 * (at positions numbered from 0 to N–1) and proceed around the circle, eliminating every Mth person until
 * only one person is left. Legend has it that Josephus figured out where to sit to avoid being eliminated.
 * Write a Queue client Josephus that takes M and N from the command line and prints out the order in which
 * people are eliminated (and thus would show Josephus where to sit in the circle).
 * % java Josephus 2 7
 * 1 3 5 0 4 2 6
 */
public class JosephusProblem {

    public static void main(String[] args) {
        new JosephusProblem().eliminate(10, 3);
    }

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    private int currentSize;

    private void eliminate(int queueSize, int index) {
        Node<Integer> current = initCircularQueue(queueSize);
        while (currentSize > 0) {
            currentSize--;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            StdOut.println(current.next.item);
            current.next = current.next.next;
        }
    }

    private Node<Integer> initCircularQueue(int size) {
        currentSize = size;
        Node<Integer> first = new Node<>();
        first.item = 0;
        Node<Integer> current = first;
        for (int i = 1; i < size; i++) {
            Node<Integer> next = new Node<>();
            next.item = i;
            current.next = next;
            current = next;
        }
        current.next = first;
        return current;
    }
}
