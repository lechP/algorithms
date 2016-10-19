package edu.algs.chap2.p1;

import edu.algs.chap2.sort.AbstractSort;
import edu.algs.chap2.sort.Insertion;
import edu.algs.chap2.sort.Selection;
import edu.algs.chap2.sort.Shell;
import edu.algs.chap2.sort.stat.AnimatingStatistician;

import java.util.Arrays;
import java.util.Random;

/**
 * 2.1.17
 * Animation. Add code to Insertion, Selection and Shell to make them draw
 * the array contents as vertical bars like the visual traces in this section,
 * redrawing the bars after each pass, to produce an animated effect,
 * ending in a “sorted” picture where the bars appear in order of their height.
 * Hint : Use a client like the one in the text that generates random Double values,
 * insert calls to show() as appropriate in the sort code,
 * and implement a show() method that clears the canvas and draws the bars.
 */
public class SortingAnimated {

    public static void main(String[] args) throws InterruptedException {
        int n = 100;
        int waitMs = 50;
        Double[] a = generateDoubles(n);

        sortBy(new Selection(new AnimatingStatistician(waitMs)), a);
        sortBy(new Shell(new AnimatingStatistician(waitMs)), a);
        sortBy(new Insertion(new AnimatingStatistician(waitMs)), a); //longest because of N^2 swaps (each of which costs ~1*waitMs)

    }

    private static void sortBy(AbstractSort alg, Double[] a) {
        alg.sort(Arrays.copyOf(a, a.length));
    }

    private static Double[] generateDoubles(int n) {
        Double[] a = new Double[n];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextDouble();
        }
        return a;
    }

}
