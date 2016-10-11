/**
 * 1.5.7 Develop classes QuickUnionUF and QuickFindUF that implement quick-union and quick-find, respectively.
 *
 * 1.5.11 Implement weighted quick-find, where you always change
 * the id[] entries of the smaller component to the identifier of the larger component.
 * How does this change affect performance?
 *
 * 1.5.13  Weighted quick-union with path compression.
 * Modify weighted quick-union (Algorithm 1.5) to implement path compression, as described in Exercise 1.5.12.
 * Give a sequence of input pairs that causes this method to produce a tree of height 4.
 * Note : The amortized cost per operation for this algorithm is known to be bounded
 * by a function known as the inverse Ackermann function and is less than 5 for any conceivable practical value of N.
 *
 * 1.5.17  Random connections.
 * Develop a UF client ErdosRenyi that takes an integer value N from the command line,
 * generates random pairs of integers between 0 and N-1, calling connected() to determine
 * if they are connected and then union() if not (as in our development client),
 * looping until all sites are connected, and printing the number of connections generated.
 * Package your program as a static method count() that takes N as argument and returns the number of connections
 * and a main() that takes N from the command line, calls count(), and prints the returned value.
 *
 * 1.5.21  Erdös-Renyi model.
 * Use your client from Exercise 1.5.17 to test the hypothesis
 * that the number of pairs generated to get one component is ~ 1/2*N ln N.
 *
 */
package edu.algs.chap1.p5;