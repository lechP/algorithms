package edu.algs.chap1.p5.er;

import edu.algs.chap1.p5.uf.PathCompressingWeightedQuickUnionUF;
import edu.algs.chap1.util.Problem;

import java.util.Random;

/**
 * 1.5.17  Random connections.
 * Develop a UF client ErdosRenyi that takes an integer value N from the command line,
 * generates random pairs of integers between 0 and N-1, calling connected() to determine
 * if they are connected and then union() if not (as in our development client),
 * looping until all sites are connected, and printing the number of connections generated.
 * Package your program as a static method count() that takes N as argument and returns the number of connections
 * and a main() that takes N from the command line, calls count(), and prints the returned value.
 */
public class ErdosRenyi implements Problem {

    private int doConnect(int n) {
        int generatedPairs = 0;
        PathCompressingWeightedQuickUnionUF uf = new PathCompressingWeightedQuickUnionUF(n);
        Random r = new Random();
        while (uf.count() > 1) {
            int p = r.nextInt(n);
            int q = r.nextInt(n);
            generatedPairs++;
            if (!uf.connected(p, q)) {
                uf.union(p, q);
            }
        }
        return generatedPairs;
    }

    public static void main(String[] args) {
        ErdosRenyi er = new ErdosRenyi();
        int cons = er.doConnect(10);
        System.out.println(cons);
    }

    @Override
    public double getExpectedValue(int N) {
        return 0.5 * N * Math.log(N);
    }

    @Override
    public double estimateValue(int N, int repeats) {
        double sum = 0.0;
        for (int i = 0; i < repeats; i++) {
            sum += doConnect(N);
        }
        return sum / repeats;
    }
}
