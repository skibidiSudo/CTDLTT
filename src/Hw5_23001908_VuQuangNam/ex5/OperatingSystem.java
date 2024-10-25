package Hw5_23001908_VuQuangNam.ex5;

import Hw5_23001908_VuQuangNam.ex1.Entry;
import Hw5_23001908_VuQuangNam.ex1.SortedArrayPriorityQueue;
import java.util.Date;

public class OperatingSystem {
    private SortedArrayPriorityQueue<Date, String> events;

    public OperatingSystem() {
        events = new SortedArrayPriorityQueue<>();
    }

    public void addEvents(Event<Date, String> event) {
        events.insert(event.getKey(), event.getValue());
    }

    public Event<Date, String> upcomingEvent() {
        if (events.isEmpty()) {
            System.out.println("No event to handle.");
            return null;
        }
        Entry<Date, String> event = events.removeMin();
        return new Event<>(event.getKey(), event.getValue());
    }
}
