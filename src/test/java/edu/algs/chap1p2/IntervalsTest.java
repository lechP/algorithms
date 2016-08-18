package edu.algs.chap1p2;

import edu.princeton.cs.algs4.Interval1D;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class IntervalsTest {

    private Intervals sut = new Intervals();

    @Test
    public void shouldHandleEmptyCollectionOf1dIntervals() throws Exception {
        List<Set<Interval1D>> result = sut.compute1dIntersections(new ArrayList<>());
        assertThat(result).isEmpty();
    }

    @Test
    public void shouldNotFindAnyIntersectionForSingleInterval() throws Exception {
        //given
        Interval1D interval = new Interval1D(1, 2.2);
        List<Interval1D> input = Collections.singletonList(interval);
        //when
        List<Set<Interval1D>> result = sut.compute1dIntersections(input);
        //then
        assertThat(result).isEmpty();
    }

    @Test
    public void shouldFindIntersectionBetweenTwoIntervals() throws Exception {
        //given
        Interval1D intervalA = new Interval1D(1, 2.2);
        Interval1D intervalB = new Interval1D(2.1, 4);
        List<Interval1D> input = Arrays.asList(intervalA, intervalB);
        //when
        List<Set<Interval1D>> result = sut.compute1dIntersections(input);
        //then
        Set<Interval1D> intersection = new HashSet<>(2);
        intersection.add(intervalA);
        intersection.add(intervalB);

        assertThat(result).hasSize(1).contains(intersection);
    }

    @Test
    public void shouldFindTwoIntersectionWithinThreeIntervals() throws Exception {
        //given
        Interval1D intervalA = new Interval1D(1, 2.2);
        Interval1D intervalB = new Interval1D(2.1, 4);
        Interval1D intervalC = new Interval1D(3.1, 4.2);
        List<Interval1D> input = Arrays.asList(intervalA, intervalB, intervalC);
        //when
        List<Set<Interval1D>> result = sut.compute1dIntersections(input);
        //then
        Set<Interval1D> intersectionAB = new HashSet<>(2);
        intersectionAB.add(intervalA);
        intersectionAB.add(intervalB);
        Set<Interval1D> intersectionBC = new HashSet<>(2);
        intersectionBC.add(intervalB);
        intersectionBC.add(intervalC);
        assertThat(result).hasSize(2).contains(intersectionAB, intersectionBC);
    }

    @Test
    public void shouldFindThreeIntersectionWithinThreeMutuallyIntersectingIntervals() throws Exception {
        //given
        Interval1D intervalA = new Interval1D(1, 2.2);
        Interval1D intervalB = new Interval1D(2.1, 4);
        Interval1D intervalC = new Interval1D(1.9, 2.2);
        List<Interval1D> input = Arrays.asList(intervalA, intervalB, intervalC);
        //when
        List<Set<Interval1D>> result = sut.compute1dIntersections(input);
        //then
        assertThat(result).hasSize(3);
    }

}