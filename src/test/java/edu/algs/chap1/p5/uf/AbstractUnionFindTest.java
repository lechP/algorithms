package edu.algs.chap1.p5.uf;

import org.junit.Test;
import org.mockito.internal.util.collections.Sets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractUnionFindTest {

    protected abstract UnionFind getSutInstance(int N);

    private Map<Integer, Set<Integer>> getComponents(UnionFind uf) {
        Map<Integer, Set<Integer>> result = new HashMap<>();
        int i = 0;
        boolean insideArray = true;
        while (insideArray) {
            try {
                int compId = uf.find(i);
                Set<Integer> component = result.get(compId);
                if (component == null) {
                    component = new HashSet<>();
                    result.put(compId, component);
                }
                component.add(i);
                i++;
            } catch (ArrayIndexOutOfBoundsException e) {
                insideArray = false;
            }
        }
        return result;
    }

    @Test
    public void shouldHaveAsMuchComponentsAsItems() throws Exception {
        //when
        UnionFind sut = getSutInstance(5);
        //then
        assertThat(sut.count()).isEqualTo(5);
    }

    @Test
    public void shouldConnectExactlyTwoItems() throws Exception {
        //when
        UnionFind sut = getSutInstance(5);
        sut.union(0, 1);
        //then
        assertThat(sut.count()).isEqualTo(4);
        assertThat(sut.find(0)).isEqualTo(sut.find(1));
    }

    @Test
    public void shouldConnectIntoThreeComponents() throws Exception {
        //given
        UnionFind sut = getSutInstance(6);
        //when
        sut.union(4, 5); //4 & 5
        sut.union(5, 3); //3 & 4 & 5
        sut.union(1, 2); //1 & 2
        //then
        assertThat(getComponents(sut)).containsValues(Sets.newSet(0), Sets.newSet(1, 2), Sets.newSet(3, 4, 5));
    }

    @Test
    public void shouldConnectIntoTwoComponents() throws Exception {
        //given
        UnionFind sut = getSutInstance(10);
        //when
        sut.union(4, 3);
        sut.union(3, 8);
        sut.union(6, 5);
        sut.union(9, 4);
        sut.union(2, 1);
        sut.union(5, 0);
        sut.union(7, 2);
        sut.union(6, 1);
        sut.union(1, 0);
        sut.union(6, 7);
        //then
        assertThat(getComponents(sut)).containsValues(Sets.newSet(0, 1, 2, 5, 6, 7), Sets.newSet(3, 4, 8, 9));
    }


}
