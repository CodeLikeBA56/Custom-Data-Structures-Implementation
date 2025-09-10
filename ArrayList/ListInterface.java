public interface ListInterface<T>{
	public abstract void add(T item);
	void add(int position, T item);
	T remove(int position);
	T removeLast();
	void replace(int position, T item);
	void clear();
	boolean isEmpty();
	T get(int position);
	boolean contains(T item);
	<T> int search(T item);
	int size();
	T[] toArray();
	void print();
	<Object> void sort();
	void addBeginning(T item);
	void updateBeginning(T item);
	T removeBeginning();
}