package edu.algs.chap1.p4;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 1.4.2 Modify ThreeSum (count number of triples in input which hold the condition a+b+c=0)
 * to work properly even when the int values are so large that adding two of them might cause overflow.
 * Assumption: integers in input are distinct
 */
class BigIntThreeSum {

    int countThreeSums(int[] input) {
        int cnt = 0;
        Arrays.sort(input);
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                BigInteger a = BigInteger.valueOf(input[i]);
                BigInteger b = BigInteger.valueOf(input[j]);
                if (binarySearch(a.add(b), j + 1, input) >= 0) cnt++;
            }
        }
        return cnt;
    }

    private int binarySearch(BigInteger key, int startIndex, int[] a) {
        //Array must be sorted.
        int lo = startIndex;
        int hi = a.length - 1;
        while (lo <= hi) {  // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            int comparison = BigInteger.valueOf(-a[mid]).compareTo(key);
            if (comparison < 0) hi = mid - 1;
            else if (comparison > 0) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

}
