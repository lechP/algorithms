package edu.algs.chap1.p5.uf.compare;

import edu.algs.chap1.p5.uf.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 1.5.11
 * Implement weighted quick-find, where you always change
 * the id[] entries of the smaller component to the identifier of the larger component.
 * How does this change affect performance?
 * <p>
 * This class is intended to compare the performance of all UF implementations.
 * Result:
 * 1. For tiny set WQU needs more time (probably because of additional data it must store), but all goes << 1ms
 * 2. For medium set WQU and QU are comparable (<1ms) and QF is ten times slower (~6ms)
 * 3. For large set (2M pairs) WQU needs 0.25sec, QU... it starts nice but after about 600k pairs dramatically slows down
 *      and I'm not as much curious to wait for it till the finish
 * 4. WQUPC and WQU need similar amount of time for large set (WQUPC is slightly faster). Some super large set could help.
 */
public class UnionFindComparator {

    private static final String BASE_DIR = "src/main/resources/algs4-data/";

    public static void main(String[] args) {
        String fileSmall = "tinyUF.txt";
        String fileMid = "mediumUF.txt";
        String fileLarge = "largeUF.txt";

        UnionFindComparator comparator = new UnionFindComparator();
        comparator.analyzePerformanceForFile(fileSmall);
        comparator.analyzePerformanceForFile(fileMid);
        comparator.analyzePerformanceForFile(fileLarge);
    }

    private void analyzePerformanceForFile(String filename) {
        UFInput input = readInput(BASE_DIR + filename);
        System.out.println("Perform analysis for file: " + filename + ". N=" + input.n + " pairs count: " + input.pairs.size());

        analyze(input.pairs, new PathCompressingWeightedQuickUnionUF(input.n));
        analyze(input.pairs, new WeightedQuickUnionUF(input.n));
        analyze(input.pairs, new QuickUnionUF(input.n));
        analyze(input.pairs, new QuickFindUF(input.n));
    }

    private void analyze(List<Pair> pairs, UnionFind algorithm) {
        long time = performConnection(pairs, algorithm);
        System.out.println(time + " nanosecs | " + time * 1.0 / 1_000_000_000 + " secs for algorithm: " + algorithm.getClass().getSimpleName());
    }

    private long performConnection(List<Pair> input, UnionFind algorithm) {
        long startTime = System.nanoTime();
        int count = 0;
        for (Pair pair : input) {
            algorithm.union(pair.p, pair.q);
            count++;
            if (count % 100_000 == 0) System.out.println("Progress: " + count + "/" + input.size());
        }
        return System.nanoTime() - startTime;
    }

    private UFInput readInput(String filePath) {
        Scanner lineReader;
        try {
            lineReader = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String first = lineReader.nextLine();
        UFInput result = new UFInput(Integer.parseInt(first));
        while (lineReader.hasNext()) {
            String line = lineReader.nextLine();
            int[] pair = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            result.pairs.add(new Pair(pair[0], pair[1]));
        }
        lineReader.close();
        return result;
    }

    private class Pair {
        int p;
        int q;

        Pair(int p, int q) {
            this.p = p;
            this.q = q;
        }
    }

    private class UFInput {
        int n;
        List<Pair> pairs;

        UFInput(int n) {
            this.n = n;
            this.pairs = new ArrayList<>(n);
        }
    }


}
