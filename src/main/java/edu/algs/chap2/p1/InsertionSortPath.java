package edu.algs.chap2.p1;

import edu.algs.chap2.sort.Insertion;
import edu.algs.chap2.sort.stat.DefaultConsoleStatistician;

/**
 * 2.1.4 Show, in the style of the example trace with Algorithm 2.2,
 * how insertion sort sorts the array E A S Y Q U E S T I O N.
 */
public class InsertionSortPath {

    public static void main(String[] args) {
        String[] input = "E A S Y Q U E S T I O N".split(" ");
        Insertion sorter = new Insertion(new DefaultConsoleStatistician());
        sorter.analyzeSort(input);
        sorter.getStat().printReport();
    }

}
