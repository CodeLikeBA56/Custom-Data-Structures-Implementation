public class CircularLinkedList<T extends Comparable<? super T>> implements ListInterface<T> {
	private Node<T> first;
	private Node<T> last;
	private Node<T> currentNode;
	private int count;

	public CircularLinkedList() {
		this.first = null;
		this.last = null;
		this.count = 0;
	}

	public void add(T item) {
		Node<T> n = new Node<T>(item);
		if (isEmpty()) {
			this.first = n;
		} else {
			this.last.setNext(n);
		}
		this.last = n;
		this.last.setNext(first);
		this.count++;
	}

	public void add(int position, T item) {
		if (position >= 0 && position <= count) {
			if (position == 0) {
				this.addBeginning(item);
			} else {
				Node<T> n = new Node<T>(item);
				this.currentNode = this.first;
				for (int i = 1; i <= count; i++) {
					if (i == position) {
						n.setNext(currentNode.getNext());
						this.currentNode.setNext(n);
					}
					this.currentNode = this.currentNode.getNext();
				} // For-Loop
				this.last = this.currentNode;
				this.last.setNext(first);
				this.count++;
			}
		}
	} // Add with position

	public Node<T> getLinkedList() {
		if(!this.isEmpty())
			return first;
		else
			System.out.println("List is empty.");
		return null;
	}
	
	public Node<T> getLastNode() {
		if(!this.isEmpty())
			return last;
		else
			System.out.println("List is empty.");
		return null;
	}

	public void removeBeginning() {
		if (!this.isEmpty()) {
			this.first = this.first.getNext();
			this.count--;
		}else{
			System.out.println("Linked List is null.");
		}
	}

	public void remove(int position) {
		if(!this.isEmpty()) {
			if (position >= 0 && position < count) {
				if (position == 0) {
					removeBeginning();
				}else{
					currentNode = first;

					for (int i = 1; i <= count; i++) {
						if (i == position) {
							last = currentNode;
						}
						if (i == position + 1) {
							last.setNext(currentNode.getNext());
						}
						currentNode = currentNode.getNext();
					} // For-Loop
					last = currentNode;
					count--;
				}
				if(this.count==0) {
					this.clear();
				}
			}
		}else {
			System.out.println("Linked List is null.");
		}
	}

	@Override
	public void removeLast() {
		remove(this.size() - 1);
	}

	public void replace(int position, T item) {
		if (position >= 0 && position < count) {
			if (position == 0) {
				updateBeginning(item);
			} else {
				currentNode = first;
				for (int i = 0; i < count; i++) {
					if (i == position) {
						currentNode.setData(item);
					}
					currentNode = currentNode.getNext();
				} // For-Loop
			}
		} // outer-if
	} // Replace-Method

	public void clear() {
		this.first = this.last = this.currentNode = null;
		this.count = 0;
	}

	public boolean isEmpty() {
		return this.count == 0 && this.first == null && this.last == null;
	}

	public T get(int position) {
		T value = null;
		if (position >= 0 && position < count) {
			currentNode = first;
			for (int i = 0; i < this.count; i++) {
				if (i == position)
					value = currentNode.getData();

				currentNode = currentNode.getNext();
			}
		} // if
		return value;
	} // get-Method

	public boolean contains(T item) {
		currentNode = first;
		for (int i = 0; i<this.count ;i++) {
			if (currentNode.getData().equals(item))
				return true;
			
			currentNode = currentNode.getNext();
		}
		return false;
	}

	public int search(T item) {
		currentNode = first;
		for (int i = 0; i<this.count ;i++) {
			if (currentNode.getData().equals(item))
				return i;
			
			currentNode = currentNode.getNext();
		}
		return -1;
	}

	public int size() {
		return this.count;
	}

	public T[] toArray() {
		T[] nodesArray = (T[]) new Object[count];
		currentNode = first;
		for (int i = 0; i<this.count ;i++) {
			nodesArray[i] = currentNode.getData();
			currentNode = currentNode.getNext();
		}
		return nodesArray;
	}

	public void print() {
		currentNode = first;
		System.out.print("[");
		for (int i = 0; i<this.count ;i++) {
			System.out.print(currentNode.getData());
			if (i<this.count-1) {
				System.out.print(",");
			}
			currentNode = currentNode.getNext();
		}
		System.out.println("]");
	}

	public void printReverse() {
		System.out.print("[");
		printRecursive(first, 0);
		System.out.println("]");
	}

	private void printRecursive(Node<T> temp, int i) {
		if (i<this.size()) {
			printRecursive(temp.getNext(), i+1);
			if (i<this.size()-1) {
				System.out.print(",");
			}
			System.out.print(temp.getData());
		}
	}

	public void addBeginning(T item) {
		Node<T> n = new Node<T>(item);
		if (isEmpty()) {
			this.first = n;
			this.last = n;
		} else {
			n.setNext(first);
			first = n;
		}
		this.last.setNext(first);
		this.count++;
	}

	public void updateBeginning(T item) {
		first.setData(item);
	}
	
	public <Object> void bubbleSort(){
        Node<T> index = null;
        this.currentNode = this.first;
        
        if (this.isEmpty()) {
            System.out.println("Cannot sort List because list is empty.");
        }else{
            for (int i = 1; i<=this.count ;i++) {
                index = (Node<T>) currentNode.getNext();
                for (int j = 0; j<this.count-i ;j++) {
                    if (((Comparable)currentNode.getData()).compareTo(index.getData())>0) {
                        T temp = (T) currentNode.getData();
                        currentNode.setData(index.getData());
                        index.setData(temp);
                    }
 
                    index = index.getNext();
                }
                currentNode = currentNode.getNext();
            }
        }
	}

	public static void main(String[] args) {
		CircularLinkedList<Integer> n = new CircularLinkedList<>();
		n.add(9);
		n.add(8);
		n.add(6);
		n.addBeginning(19);
		n.add(1,17);
		n.add(1,18);
		n.add(0);
		n.print();
		System.out.println(n.size());
		n.print();
		n.printReverse();
		System.out.println("Contains: "+n.contains(8));
		System.out.println("8 is at index: "+n.search(8));
		System.out.println("First: "+n.getFirstNode().getData());
		System.out.println("Last: "+n.getLastNode().getData());
	}

}
