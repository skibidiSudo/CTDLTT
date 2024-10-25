package Hw5_23001908_VuQuangNam.ex3;

import Hw5_23001908_VuQuangNam.ex1.Entry;
import Hw5_23001908_VuQuangNam.ex1.PriorityQueueInterface;
import Hw5_23001908_VuQuangNam.ex1.SortedArrayPriorityQueue;
import Hw5_23001908_VuQuangNam.ex2.MinHeapPriorityQueue;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        testHeap();
        //run();
    }

    public static void testHeap() {
        final int size = 10;
        Entry<String, Integer>[] arr = init(size);
        Test test = new Test();
        System.out.println("----Before sort----");
        for (Entry<String, Integer> product : arr) {
            System.out.println(product);
        }
        test.heapSort(arr);
        System.out.println("\n----Before sort----");
        for (Entry<String, Integer> product : arr) {
            System.out.println(product);
        }
    }

    public static void run() {
        final int size = 10000;
        Entry<String, Integer>[] arr = init(size);
        Test test = new Test();

        Entry<Long, String>[] time = new SortedArrayPriorityQueue.ArrayEntry[6];
        Entry<String, Integer>[] bubbleArray = arr.clone();
        long startTime = System.nanoTime();
        test.bubbleSort(bubbleArray);
        long endTime = System.nanoTime();
        time[0] = new SortedArrayPriorityQueue.ArrayEntry<>(endTime - startTime, "Bubble Sort");

        Entry<String, Integer>[] insertionArray = arr.clone();
        startTime = System.nanoTime();
        test.insertionSort(insertionArray);
        endTime = System.nanoTime();
        time[1] = new SortedArrayPriorityQueue.ArrayEntry<>(endTime - startTime, "Insertion Sort");

        Entry<String, Integer>[] selectionArray = arr.clone();
        startTime = System.nanoTime();
        test.selectionSort(selectionArray);
        endTime = System.nanoTime();
        time[2] = new SortedArrayPriorityQueue.ArrayEntry<>(endTime - startTime, "Selection Sort");

        Entry<String, Integer>[] quickArray = arr.clone();
        startTime = System.nanoTime();
        test.quickSort(quickArray, 0, quickArray.length - 1);
        endTime = System.nanoTime();
        time[3] = new SortedArrayPriorityQueue.ArrayEntry<>(endTime - startTime, "Quick Sort");

        Entry<String, Integer>[] mergeArray = arr.clone();
        startTime = System.nanoTime();
        test.mergeSort(mergeArray, 0, mergeArray.length - 1);
        endTime = System.nanoTime();
        time[4] = new SortedArrayPriorityQueue.ArrayEntry<>(endTime - startTime, "Merge Sort");

        Entry<String, Integer>[] heapArray = arr.clone();
        startTime = System.nanoTime();
        test.heapSort(heapArray);
        endTime = System.nanoTime();
        time[5] = new SortedArrayPriorityQueue.ArrayEntry<>(endTime - startTime, "Heap Sort");

        print(time);
    }

    public static void print(Entry<Long, String>[] entries) {
        Arrays.sort(entries, (e1, e2) -> Long.compare(e1.getKey(), e2.getKey()));
        System.out.println("Sorted Times:");
        for (Entry<Long, String> entry : entries) {
            System.out.println("[" + entry.getKey() + " ns, " + entry.getValue() + "]");
        }
    }

    public static Entry<String, Integer>[] init(int size) {
        Random random = new Random();
        Entry<String, Integer>[] entries = new Entry[size];
        for (int i = 0; i < size; i++) {
            String productName = "Product " + random.nextInt(100);
            Integer price = random.nextInt(10000);
            entries[i] = new SortedArrayPriorityQueue.ArrayEntry<>(productName, price);
        }
        return entries;
    }

    public void bubbleSort(Entry<String, Integer>[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].getValue() > arr[j + 1].getValue()) {
                    swap(j, j + 1, arr);
                }
            }
        }
    }

    public void insertionSort(Entry<String, Integer>[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Entry<String, Integer> key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getValue() > key.getValue()) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public void selectionSort(Entry<String, Integer>[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].getValue() < arr[minIdx].getValue()) {
                    minIdx = j;
                }
            }
            swap(minIdx, i, arr);
        }
    }

    public void quickSort(Entry<String, Integer>[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(Entry<String, Integer>[] arr, int low, int high) {
        Entry<String, Integer> pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].getValue() <= pivot.getValue()) {
                i++;
                swap(i, j, arr);
            }
        }
        swap(i + 1, high, arr);
        return i + 1;
    }

    public void mergeSort(Entry<String, Integer>[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            Entry<String, Integer>[] leftArr = new SortedArrayPriorityQueue.ArrayEntry[mid - left + 1];
            Entry<String, Integer>[] rightArr = new SortedArrayPriorityQueue.ArrayEntry[right - mid];

            System.arraycopy(arr, left, leftArr, 0, leftArr.length);
            System.arraycopy(arr, mid + 1, rightArr, 0, rightArr.length);

            mergeSort(leftArr, 0, leftArr.length - 1);
            mergeSort(rightArr, 0, rightArr.length - 1);

            merge(arr, leftArr, rightArr);
        }
    }

    private void merge(Entry<String, Integer>[] arr, Entry<String, Integer>[] left, Entry<String, Integer>[] right) {
        int index = 0, rightIndex = 0, leftIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex].getValue() < right[rightIndex].getValue()) {
                arr[index++] = left[leftIndex++];
            } else {
                arr[index++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            arr[index++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            arr[index++] = right[rightIndex++];
        }
    }

    public void swap(int i, int j, Entry<String, Integer>[] arr) {
        Entry<String, Integer> temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void heapSort(Entry<String, Integer>[] arr) {
        int n = arr.length;
        PriorityQueueInterface<String, Integer> minHeap = new MinHeapPriorityQueue<>();
        for (Entry<String, Integer> entry : arr) {
            minHeap.insert(entry.getKey(), entry.getValue());
        }
        for (int i = 0; i < n; i++) {
            Entry<String, Integer> entry = minHeap.removeMin();
            arr[i] = entry;
        }
    }
}
