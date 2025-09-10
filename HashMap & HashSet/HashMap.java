import java.util.*;

public class HashMap<K, V> {
    private LinkedList<MapEntry<K, V>>[] buckets;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    public HashMap(int capacity) {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<MapEntry<K, V>>();
        }
        size = 0;
    }

    public V put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        for (MapEntry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                V oldValue = entry.getValue();
                entry.setValue(value);
                return oldValue;
            }
        }
        bucket.add(new MapEntry<K, V>(key, value));
        size++;
        if (size > LOAD_FACTOR * buckets.length) {
            resize();
        }
        return null;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        for (MapEntry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        Iterator<MapEntry<K, V>> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            MapEntry<K, V> entry = iterator.next();
            if (entry.getKey().equals(key)) {
                iterator.remove();
                size--;
                return entry.getValue();
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        int index = getBucketIndex(key);
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        for (MapEntry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            for (MapEntry<K, V> entry : bucket) {
                if (entry.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void clear() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<MapEntry<K, V>>();
        }
        size = 0;
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode % buckets.length);
    }

    private void resize() {
        int newCapacity = buckets.length * 2;
        LinkedList<MapEntry<K, V>>[] newBuckets = new LinkedList[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newBuckets[i] = new LinkedList<MapEntry<K, V>>();
        }
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            for (MapEntry<K, V> entry : bucket) {
                int index = Math.abs(entry.getKey().hashCode() % newCapacity);
                newBuckets[index].add(entry);
            }
        }
       this.buckets = newBuckets;
    }
}            
