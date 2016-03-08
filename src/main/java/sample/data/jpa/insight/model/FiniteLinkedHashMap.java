package sample.data.jpa.insight.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class FiniteLinkedHashMap<K,V> extends LinkedHashMap<K,V> {

    private int capacity;

    public FiniteLinkedHashMap(int capacity) {
        super(capacity);
        this.capacity = capacity;
    }

    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > this.capacity;
    }

}
