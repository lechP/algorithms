package edu.algs.chap1.p4;

/**
 * 1.4.19  Local minimum of a matrix. Given an N-by-N array a[] of N^2 distinct integers,
 * design an algorithm that finds a local minimum: an entry a[i][j] that is strictly less than its neighbors.
 * Internal entries have 4 neighbors; entries on an edge have 3 neighbors; entries on a corner have 2 neighbors.
 * The running time of your program should be proportional to N in the worst case,
 * which means that you cannot afford to examine all N^2 entries.
 */
class MatrixLocalMinimum {

    /**
     * @param matrix NxN matrix with distinct integers
     * @return any local min
     */
    int localMinimum(int[][] matrix) {
        int n = matrix.length;
        Entry edgeMin = new Entry(0, 0, matrix);
        int x0 = 0;
        int xn = n - 1;
        int y0 = 0;
        int yn = n - 1;
        while (x0 < xn || y0 < yn) {
            edgeMin = getMinimalEntryOnBoundaryAndTheMiddle(matrix, x0, xn, y0, yn);
            Entry neighbourhoodMin = getMinimalEntryInNeighbourhood(edgeMin, matrix);
            if (neighbourhoodMin.equals(edgeMin)) {
                return edgeMin.val;
            } else {
                int xmid = (xn - x0 + 1) / 2;
                if (neighbourhoodMin.x < xmid) {
                    xn = xmid;
                } else {
                    x0 = xmid;
                }
                int ymid = (yn - y0 + 1) / 2;
                if (neighbourhoodMin.y < ymid) {
                    yn = ymid;
                } else {
                    y0 = ymid;
                }
            }
        }
        return edgeMin.val;
    }

    private Entry getMinimalEntryOnBoundaryAndTheMiddle(int[][] matrix, int x0, int xn, int y0, int yn) {
        Entry min = new Entry(x0, y0, matrix);
        for (int i = y0; i <= yn; i++) {
            if (matrix[x0][i] < min.val) min = new Entry(x0, i, matrix); //left
            if (matrix[xn][i] < min.val) min = new Entry(xn, i, matrix); //right
            if (matrix[(xn - x0 + 1) / 2][i] < min.val) min = new Entry((xn - x0 + 1) / 2, i, matrix); //middle column
        }
        for (int i = x0; i <= xn; i++) {
            if (matrix[i][y0] < min.val) min = new Entry(i, y0, matrix); //down
            if (matrix[i][yn] < min.val) min = new Entry(i, yn, matrix); //up
            if (matrix[i][(yn - y0 + 1) / 2] < min.val) min = new Entry(i, (yn - y0 + 1) / 2, matrix); //middle row
        }
        return min;
    }

    private Entry getMinimalEntryInNeighbourhood(Entry middle, int[][] matrix) {
        Entry min = middle;
        int n = matrix.length;
        if (middle.x > 0 && matrix[middle.x - 1][middle.y] < min.val)
            min = new Entry(middle.x - 1, middle.y, matrix);
        if (middle.x < n - 1 && matrix[middle.x + 1][middle.y] < min.val)
            min = new Entry(middle.x + 1, middle.y, matrix);
        if (middle.y > 0 && matrix[middle.x][middle.y - 1] < min.val)
            min = new Entry(middle.x, middle.y - 1, matrix);
        if (middle.y < n - 1 && matrix[middle.x][middle.y + 1] < min.val)
            min = new Entry(middle.x, middle.y + 1, matrix);
        return min;
    }

    private class Entry {
        int x;
        int y;
        int val;

        Entry(int x, int y, int[][] matrix) {
            this.x = x;
            this.y = y;
            this.val = matrix[x][y];
        }
    }

}
