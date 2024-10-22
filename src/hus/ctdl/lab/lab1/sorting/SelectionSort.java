package hus.ctdl.lab.lab1.sorting;

public class SelectionSort implements Sort {
    public SelectionSort() {

    }

    @Override
    public void sort(int[] ar) {
        int n = ar.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ar[i] > ar[j]) {
                    int temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }
            }
        }
    }
}
