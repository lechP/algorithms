package edu.algs.chap2.sort.stat;

public abstract class AbstractConsoleStatistician implements Statistician {

    protected long compares;
    protected long swaps;
    protected int N;
    protected String algorithmName;

    protected String buildReport() {
        return "Report for algorithm: " + algorithmName + "\n"
                + "N = " + N + "\n"
                + "Number of compares = " + compares + "\n"
                + "Number of swaps = " + swaps + "\n";
    }

    @Override
    public void setN(int N) {
        this.N = N;
    }

    @Override
    public void setAlgName(String algName) {
        this.algorithmName = algName;
    }

    @Override
    public SortStats getStats() {
        return new SortStats(N, swaps, compares);
    }
}
