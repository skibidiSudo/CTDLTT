package Hw5_23001908_VuQuangNam.ex1;

public class Test {
    public static void test(PriorityQueueInterface<String, Integer> pq) {
        pq.insert("Laptop", 300);
        pq.insert("Mouse", 100);
        pq.insert("Keyboard", 150);
        pq.insert("Monitor", 200);

        System.out.println("---------" + pq.getName() + "---------");
        Entry<String, Integer> minEntry = pq.min();
        System.out.println("Min: " + minEntry.getKey() + " - Price: " + minEntry.getValue());

        System.out.println("All products: ");
        while (!pq.isEmpty()) {
            Entry<String, Integer> entry = pq.removeMin();
            System.out.println("Name: " + entry.getKey() + " - Price: " + entry.getValue());
        }
    }


    public static void main(String[] args) {
        //test(new UnsortedArrayPriorityQueue<>());
        //test(new SortedArrayPriorityQueue<>());
        //test(new UnsortedLinkedPriorityQueue<>());
        test(new SortedLinkedPriorityQueue<>());
    }
}
