import java.util.*;

public class HashSet<T> {
    private LinkedList<T>[] buckets;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    public HashSet() {
        this(DEFAULT_CAPACITY);
    }

    public HashSet(int capacity) {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<T>();
        }
        size = 0;
    }

    public boolean add(T element) {
        int index = getBucketIndex(element);
        LinkedList<T> bucket = buckets[index];
        if (bucket.contains(element)) {
            return false;
        }
        bucket.add(element);
        size++;
        if (size > LOAD_FACTOR * buckets.length) {
            resize();
        }
        return true;
    }

    public boolean remove(T element) {
        int index = getBucketIndex(element);
        LinkedList<T> bucket = buckets[index];
        if (bucket.contains(element)) {
            bucket.remove(element);
            size--;
            return true;
        }
        return false;
    }

    public boolean contains(T element) {
        int index = getBucketIndex(element);
        LinkedList<T> bucket = buckets[index];
        return bucket.contains(element);
    }

    

    private int getBucketIndex(T element) {
        int hashCode = element.hashCode();
        return Math.abs(hashCode % buckets.length);
    }

    private void resize() {
        int newCapacity = buckets.length * 2;
        LinkedList<T>[] newBuckets = new LinkedList[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newBuckets[i] = new LinkedList<T>();
        }
        for (LinkedList<T> bucket : buckets) {
            for (T element : bucket) {
                int index = Math.abs(element.hashCode() % newCapacity);
                newBuckets[index].add(element);
            }
        }
        buckets = newBuckets;
    }

    public int size() {
        System.out.println(buckets.length);
        return size;
    }

    public void clear(){
        this.buckets = null;
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public static void main(String[] args) {
        HashSet<Integer> a = new HashSet<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(9);
        a.add(10);
        a.add(11);
        a.add(12);
        a.add(13);
        //a.add(14);
        //a.add(15);
        System.out.println("Contains 16: "+a.contains(16));
        a.remove(5);
        System.out.println(a.size());
    }

}
