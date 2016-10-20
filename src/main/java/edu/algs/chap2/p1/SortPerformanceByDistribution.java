package edu.algs.chap2.p1;

import edu.princeton.cs.algs4.StdRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static edu.algs.chap2.p1.SortAlg.SELECTION;
import static edu.algs.chap2.p1.SortTimer.timeRandomInput;

/**
 * 2.1.35  Nonuniform distributions.
 * Write a client that generates test data by randomly ordering objects using other
 * distributions than uniform, including the following:
 * 1. Gaussian
 * 2. Poisson
 * 3. Geometric
 * 4. Discrete
 * Develop and test hypotheses about the effect of such input on the performance of the algorithms in this section.
 * <p>
 * Times are different for different distributions. It could be interesting to merge it with plotting.
 */
public class SortPerformanceByDistribution {

    private final static Logger LOG = LoggerFactory.getLogger(SortPerformanceByDistribution.class);

    public static void main(String[] args) {
        SortAlg algorithm = SELECTION;
        int N = 10_000;
        int T = 10;
        Map<String, Double> timePerDistribution = new HashMap<>();
        timePerDistribution.put("uniform", timeRandomInput(algorithm, N, T));
        timePerDistribution.put("gaussian", timeRandomInput(algorithm, N, T, StdRandom::gaussian));
        timePerDistribution.put("poisson", timeRandomInput(algorithm, N, T, () -> StdRandom.poisson(2)));
        timePerDistribution.put("geometric", timeRandomInput(algorithm, N, T, () -> StdRandom.geometric(0.25)));
        timePerDistribution.put("discrete", timeRandomInput(algorithm, N, T, () -> StdRandom.discrete(new double[]{0.25, 0.35, 0.4})));

        for (Map.Entry<String, Double> entry : timePerDistribution.entrySet()) {
            double nanos = entry.getValue();
            double secs = nanos / Math.pow(10, 9);
            LOG.info(String.format("For distribution %s time of sorting equals avg: %.2f nanos (%.4f secs)", entry.getKey(), nanos, secs));
        }
    }

}
