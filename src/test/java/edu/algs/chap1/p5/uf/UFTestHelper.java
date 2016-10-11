package edu.algs.chap1.p5.uf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class UFTestHelper {

    static Map<Integer, Set<Integer>> getComponents(UnionFind uf) {
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
}
