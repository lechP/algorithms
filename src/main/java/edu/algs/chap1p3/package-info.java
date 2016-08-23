/**
 * Package containing solutions to following tasks:
 *
 * 1.3.4
 * Write a stack client Parentheses that reads in a text stream from standard input and uses a stack
 * to determine whether its parentheses are properly balanced.
 * For example, your program should print true for [()]{}{[()()]()} and false for [(]).
 * <p>
 * 1.3.10 Write a filter InfixToPostfix that converts an arithmetic expression from infix to postfix.
 * 1.3.11 Write a program EvaluatePostfix that takes a postfix expression from standard input, evaluates it,
 * and prints the value. (Piping the output of your program from the previous exercise
 * to this program gives equivalent behavior to Evaluate.)
 * <p>
 * 1.3.34  Random bag. A random bag stores a collection of items and supports the following API:
 * public class RandomBag<Item> implements Iterable<Item>
 * RandomBag() create an empty random bag
 * boolean isEmpty() is the bag empty?
 * int size() number of items in the bag
 * void add(Item item) add an item
 * Write a class RandomBag that implements this API. Note that this API is the same as for Bag,
 * except for the adjective random, which indicates that the iteration should provide the items in random order
 * (all N ! permutations equally likely, for each iterator).
 * Hint : Put the items in an array and randomize their order in the iterator’s constructor.
 * <p>
 * 1.3.37  Josephus problem. In the Josephus problem from antiquity, N people are in dire straits and agree
 * to the following strategy to reduce the population. They arrange themselves in a circle
 * (at positions numbered from 0 to N–1) and proceed around the circle, eliminating every Mth person until
 * only one person is left. Legend has it that Josephus figured out where to sit to avoid being eliminated.
 * Write a Queue client Josephus that takes M and N from the command line and prints out the order in which
 * people are eliminated (and thus would show Josephus where to sit in the circle).
 * % java Josephus 2 7
 * 1 3 5 0 4 2 6
 * <p>
 * 1.3.38  Delete kth element. Implement a class that supports the following API:
 * public class GeneralizedQueue<Item>
 * GeneralizedQueue() create an empty queue
 * boolean isEmpty() is the queue empty?
 * void insert(Item x) add an item
 * Item delete(int k) delete and return the kth least recently inserted item
 * First, develop an implementation that uses an array implementation, and then develop one that uses
 * a linked-list implementation.
 * <p>
 * 1.3.43  Listing files. A folder is a list of files and folders. Write a program that takes the name
 * of a folder as a command-line argument and prints out all of the files contained in that folder,
 * with the contents of each folder recursively listed (indented) under that folder’s name. Hint : Use a queue, and see java.io.File.
 * <p>
 */
package edu.algs.chap1p3;

