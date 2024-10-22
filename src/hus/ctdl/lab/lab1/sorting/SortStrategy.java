package hus.ctdl.lab.lab1.sorting;

public class SortStrategy {
    private static SortStrategy instance;
    private Sort sort;

    private SortStrategy() {

    }

    public static SortStrategy getInstance() {
        if (instance == null) {
            instance = new SortStrategy();
        }
        return instance;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Sort getSort() {
        return this.sort;
    }

    public void sort(int[] data) {
        sort.sort(data);
    }
}
