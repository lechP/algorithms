package edu.algs.chap2.sort.merge;

public class DefaultMerger implements Merger {

    private Comparable[] auxiliary;

    /**
     * lazy loaded helper array
     */
    private Comparable[] getAuxiliary(int length) {
        if (auxiliary == null) {
            auxiliary = new Comparable[length];
        }
        return auxiliary;
    }

    @Override
    public void merge(Comparable[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        Comparable[] temp = getAuxiliary(a.length);
        copyArrayRange(a, temp, low, high);

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = temp[j++];
            } else if (j > high) {
                a[k] = temp[i++];
            } else //noinspection unchecked
                if (temp[j].compareTo(temp[i]) < 0) {
                    a[k] = temp[j++];
                } else {
                    a[k] = temp[i++];
                }
        }
    }

    private void copyArrayRange(Comparable[] a, Comparable[] temp, int low, int high) {
        System.arraycopy(a, low, temp, low, high + 1 - low);
    }
}
