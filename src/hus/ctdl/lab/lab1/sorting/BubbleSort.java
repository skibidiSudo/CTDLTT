package hus.ctdl.lab.lab1.sorting;

public class BubbleSort implements Sort {
    public BubbleSort() {

    }

    @Override
    public void sort(int[] ar) {
        for (int i = 0; i < ar.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < ar.length - i - 1; j++) {
                if (ar[j] > ar[j + 1]) {
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }
}
