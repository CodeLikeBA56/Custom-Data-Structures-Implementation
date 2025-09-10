public interface StackInterface<T> {
	void push(T item);
	T pop();
	T peek();
	int size();
	void clear();
	boolean isEmpty();
	String toString();
	void print();
	boolean contains(T item);
}