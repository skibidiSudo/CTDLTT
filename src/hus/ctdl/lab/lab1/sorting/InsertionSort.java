package hus.ctdl.lab.lab1.sorting;

public class InsertionSort implements Sort {
    public InsertionSort() {

    }

    @Override
    public void sort(int[] ar) {
        int n = ar.length;
        for (int i = 1; i < n; i++) {
            int temp = ar[i];
            int j = i - 1;
            while ((j >= 0) && ar[j] > temp) {
                ar[j + 1] = ar[j];
                j--;
            }
            ar[j + 1] = temp;
        }
    }
}
