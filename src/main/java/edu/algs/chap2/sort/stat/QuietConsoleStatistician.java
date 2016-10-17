package edu.algs.chap2.sort.stat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuietConsoleStatistician extends AbstractConsoleStatistician {

    private final static Logger LOG = LoggerFactory.getLogger(QuietConsoleStatistician.class);

    @Override
    public void notifyCompare(Comparable left, Comparable right) {
        compares++;
    }

    @Override
    public void notifySwap(Comparable[] a, int i, int j) {
        swaps++;
    }

    @Override
    public void printReport() {
        LOG.info(buildReport());
    }

}
