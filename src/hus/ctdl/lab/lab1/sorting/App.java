package hus.ctdl.lab.lab1.sorting;

public class App {
    public static void main(String[] args) {
        int[] data = {0, 1, 0, 1, 3, 0, 1, 5, 3, 1, 4, 7, 4, 2, 5, 7};
        SortStrategy sortStrategy = SortStrategy.getInstance();
        sortStrategy.setSort(new BubbleSort());

        sortStrategy.sort(data);
        printAr(data);
    }

    public static void printAr(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
