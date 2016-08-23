package edu.algs.chap1p3.gq;

/**
 * 1.3.38  Delete kth element. Implement a class that supports the following API:
 * public class GeneralizedQueue<Item>
 * GeneralizedQueue() create an empty queue
 * boolean isEmpty() is the queue empty?
 * void insert(Item x) add an item
 * Item delete(int k) delete and return the kth least recently inserted item (starting from 0)
 * First, develop an implementation that uses an array implementation, and then develop one that uses
 * a linked-list implementation.
 */
interface GeneralizedQueue<Item> {

    boolean isEmpty();

    void insert(Item x);

    Item delete(int k);

}
