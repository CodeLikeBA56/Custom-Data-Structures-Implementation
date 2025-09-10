import java.util.*;

public class HashMap<K, V> {
    private ArrayList<Entry<K, V>>[] buckets;
    private int size;

    public HashMap() {
        this.buckets = new ArrayList[4];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
		this.size = 0;
        }
        
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % buckets.length); //-
    }

    public void insert(K key, V value) {
        int bucketIndex = hash(key);
        ArrayList<Entry<K, V>> bucket = buckets[bucketIndex];
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
        size++;
    }

    public void remove(K key) {
        int bucketIndex = hash(key);
        ArrayList<Entry<K, V>> bucket = buckets[bucketIndex];
        for (int i = 0; i < bucket.size(); i++) {
            Entry<K, V> entry = bucket.get(i);
            if (entry.getKey().equals(key)) {
                bucket.remove(i);
                size--;
                return;
            }
        }
    }

    public boolean containsKey(K key) {
        int bucketIndex = hash(key);
        ArrayList<Entry<K, V>> bucket = buckets[bucketIndex];
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (ArrayList<Entry<K, V>> bucket : buckets) {
            System.out.print("Bucket: ");
            for (Entry<K, V> entry : bucket) {
                System.out.print("(" + entry.getKey() + ", " + entry.getValue() + ") ");
            }
            System.out.println();
        }
    }

    private static class Entry<K, V> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
