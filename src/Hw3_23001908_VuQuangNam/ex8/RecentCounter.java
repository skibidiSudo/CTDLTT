package Hw3_23001908_VuQuangNam.ex8;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        int min = t - 3000;
        while (!queue.isEmpty() && (queue.peek() < min)) {
            queue.poll();
        }
        return queue.size();
    }
}
