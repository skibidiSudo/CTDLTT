package Hw5_23001908_VuQuangNam.ex5;

import Hw5_23001908_VuQuangNam.ex1.Entry;

public class Event<K, E> implements Entry<K, E> {
    protected K timeStamp;
    protected E eventType;

    public Event(K timeStamp, E eventType) {
        this.timeStamp = timeStamp;
        this.eventType = eventType;
    }

    @Override
    public K getKey() {
        return timeStamp;
    }

    @Override
    public E getValue() {
        return eventType;
    }

    @Override
    public String toString() {
        return "[Scheduled to " + eventType + " on " + timeStamp + "]";
    }
}
