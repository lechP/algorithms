package edu.algs.chap1p1;

class Ch1Excercises {

    /**
     * 1.1.14
     * takes an int value N as argument and returns the largest int not larger than the base-2 logarithm of N.
     * Does not use Math.
     */
    int lg(int N) {
        checkIfPositive(N);

        int power = 1;
        int exponent = -1;

        while (power <= N && power > 0) {
            exponent++;
            power *= 2;
        }

        return exponent;
    }


    /**
     * 1.1.15
     * takes an array a[] of int values and an integer M as arguments and returns an array of length M whose i-th entry
     * is the number of times the integer i appeared in the argument array.
     * If the values in a[] are all between 0 and M–1, the sum of the values in the returned array should be equal to a.length.
     */
    int[] histogram(int A[], int M) {
        checkIfPositive(M);
        int[] result = new int[M];
        for (int i : A) {
            if (i >= 0 && i < M) result[i]++;
        }
        return result;
    }

    /**
     * 1.1.30
     * creates an N-by-N boolean array a[][] such that a[i][j] is true if i and j are relatively prime
     * (have no common factors), and false otherwise.
     * 0 and any i are assumed to be relatively prime
     */
    boolean[][] relativePrimes(int N) {
        boolean[][] result = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = areRelativelyPrime(i, j);
            }
        }
        return result;
    }

    private boolean areRelativelyPrime(int i, int j) {
        return i == 0 || j == 0 || gcd(i, j) == 1;
    }

    private int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    private void checkIfPositive(int M) {
        if (M <= 0) throw new IllegalArgumentException("input must be positive");
    }

}
