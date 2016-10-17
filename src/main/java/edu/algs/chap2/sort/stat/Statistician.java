package edu.algs.chap2.sort.stat;

public interface Statistician {

    void notifyCompare(Comparable left, Comparable right);

    void notifySwap(Comparable[] a, int i, int j);

    void printReport();

    SortStats getStats();

    void setN(int length);

    void setAlgName(String name);
}
