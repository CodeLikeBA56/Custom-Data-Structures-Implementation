public interface ListInterface<T>{
	public abstract void add(T item);
	void add(int position, T item);
	Node<T> getLinkedList();
	Node<T> getLastNode();
	void remove(int position);
	void removeLast();
	void replace(int position, T item);
	void clear();
	boolean isEmpty();
	T get(int position);
	boolean contains(T item);
	int search(T item);
	int size();
	T[] toArray();
	void print();
	void printReverse();
	void addBeginning(T item);
	void updateBeginning(T item);
	void removeBeginning();
	<Object> void bubbleSort();
}