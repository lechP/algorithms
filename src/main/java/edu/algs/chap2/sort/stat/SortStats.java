package edu.algs.chap2.sort.stat;

public class SortStats {

    private long swaps;
    private long compares;
    private int N;

    public SortStats(int N, long swaps, long compares){
        this.N = N;
        this.swaps = swaps;
        this.compares = compares;
    }

    public int getN() {
        return N;
    }

    public long getCompares() {
        return compares;
    }

    public long getSwaps() {
        return swaps;
    }
}

