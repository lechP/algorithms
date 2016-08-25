/**
 * 1.4.2 Modify ThreeSum to work properly even when the int values are so large that adding two of them might cause overflow.
 *
 * 1.4.12 Write a program that, given two sorted arrays of N int values,
 * prints all elements that appear in both arrays, in sorted order.
 * The running time of your program should be proportional to N in the worst case.
 *
 * 1.4.19  Local minimum of a matrix. Given an N-by-N array a[] of N^2 distinct integers,
 * design an algorithm that finds a local minimum: an entry a[i][j] that is strictly less than its neighbors.
 * Internal entries have 4 neighbors; entries on an edge have 3 neighbors; entries on a corner have 2 neighbors.
 * The running time of your program should be proportional to N in the worst case,
 * which means that you cannot afford to examine all N^2 entries.
 *
 * 1.4.37  Autoboxing performance penalty. Run experiments to determine the performance penalty on your machine
 * for using autoboxing and auto-unboxing. Develop an implementation FixedCapacityStackOfInts
 * and use a client such as DoublingRatio to compare its performance with the generic FixedCapacityStack<Integer>,
 * for a large number of push() and pop() operations.
 *
 * 1.4.44  Birthday problem. Write a program that takes an integer N from the command line
 * and uses StdRandom.uniform() to generate a random sequence of integers between 0 and N – 1.
 * Run experiments to validate the hypothesis that the number of integers generated before the first repeated value is found is ~sqrt(pi*N/2)
 *
 * 1.4.45  Coupon collector problem. Generating random integers as in the previous exercise,
 * run experiments to validate the hypothesis that the number of integers generated before all possible values are generated is ~N*H_N.
 */
package edu.algs.chap1.p4;