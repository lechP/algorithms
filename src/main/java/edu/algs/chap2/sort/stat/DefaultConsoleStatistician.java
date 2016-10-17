package edu.algs.chap2.sort.stat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultConsoleStatistician extends AbstractConsoleStatistician {

    private final static Logger LOG = LoggerFactory.getLogger(DefaultConsoleStatistician.class);

    @Override
    public void notifyCompare(Comparable left, Comparable right) {
        compares++;
        LOG.debug("Compare no. " + compares + " between elements: [" + left + "; " + right + "]");
    }

    @Override
    public void notifySwap(Comparable[] a, int i, int j) {
        swaps++;
        LOG.debug("Swap no. " + swaps + " between elements: [" + i + "; " + j + "]");
        LOG.info("Swap no. " + swaps + ". Current array state: " + showArray(a));
    }

    @Override
    public void printReport() {
        LOG.info(buildReport());
    }

    private String showArray(Comparable[] array) {
        String result = "";
        for (Comparable a : array) {
            result += a + " ";
        }
        return result.trim();
    }
}
