import java.util.*;
public class PriorityQueue<T extends Comparable<T>> {
    private MinHeap<T> heap;

    public PriorityQueue() {
        heap = new MinHeap<T>(); // By Default Size of Priority Queue/Min Heap will be 25.
    }

    public PriorityQueue(int size) {
        heap = new MinHeap<T>(size);
    }

    public void enqueue(T data) {
        heap.insert(data);
    }

    public T dequeue() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.getCount() == 0;
    }

    public boolean isFull() {
        return heap.getCount() == heap.getSize();
    }

    public void print() {
        System.out.println("\tBreadthFist Traversal");
        heap.print1();
        System.out.println("\tDepththFist Traversal");
        heap.print2();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10);
        pq.enqueue(9);
        pq.enqueue(8);
        pq.enqueue(7);
        pq.enqueue(6);
        pq.enqueue(5);
        pq.enqueue(4);
        pq.enqueue(3);
        pq.print();
        System.out.println("Dequeued: " + pq.dequeue());
        pq.print();
    } // Main Method
}
