public class DoublyLinkedList<T> implements ListInterface<T> {
	private Node<T> first;
	private Node<T> last;
	private Node<T> currentNode;
	private int count;

	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
		this.count = 0;
	}

	public void add(T item) {
		Node<T> n = new Node<T>(item, this.last);
		if (isEmpty()) {
			this.first = n;
		} else {
			this.last.setNext(n);
		}
		this.last = n;
		this.last.setNext(first);
		first.setPrevious(last);
		this.count++;
	}

	public void add(int position, T item) {
		if (position >= 0 && position <= count) {
			if (position == 0) {
				this.addBeginning(item);
			}else{
				Node<T> n = new Node<T>(item);
				this.currentNode = this.first;
				for (int i = 1; i <= count; i++) {
					if (i == position) {
						n.setNext(currentNode.getNext());
						n.setPrevious(currentNode);
						currentNode.getNext().setPrevious(n);
						this.currentNode.setNext(n);
					}
					this.currentNode = this.currentNode.getNext();
				} // For-Loop
				this.last = this.currentNode;
				this.count++;
			}
		}
	} // Add with position

	public Node<T> getFirstNode() {
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

	public T removeBeginning() {
		T value;
		if (!this.isEmpty()) {
			value = this.first.getData();
			this.first = this.first.getNext();
			this.first.setPrevious(last);
			this.last.setNext(first);
			this.count--;
			return value;
		}else{
			System.out.println("Linked List is null.");
			return null;
		}
	}

	public T remove(int position) {
		T value = null;
		if(!isEmpty()) {
			if (position >= 0 && position < count) {
				if (position == 0) {
					return removeBeginning();
				}else if(position==this.size()-1) {
					value = this.last.getData();
					this.last = this.last.getPrevious();
					this.last.setNext(this.first);
					this.first.setPrevious(this.last);
					this.count--;
					return value;
				}else{
					currentNode = first;
					for (int i = 1; i < count; i++) {
						if (i == position) {
							last = currentNode;
						}
						if (i == position + 1) {
							value = currentNode.getData();
							last.setNext(currentNode.getNext());
							currentNode.getNext().setPrevious(last);
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
			return value;
		}else {
			System.out.println("Linked List is null.");
			return value;
		}
	}

	@Override
	public T removeLast() {
		return this.remove(this.size()-1);
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
						break;
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
				if (i == position){
					value = currentNode.getData();
					break;
				}
				currentNode = currentNode.getNext();
			}
		} // if
		return value;
	} // get-Method

	public boolean contains(T item) {
		if(!this.isEmpty()) {
			currentNode = first;
			for (int i = 0; i<this.count ;i++) {
				if (currentNode.getData().equals(item))
					return true;
				currentNode = currentNode.getNext();
			}
		}else
			System.out.println("List is empty.");
		return false;
	}

	public int search(T item) {
		if(!this.isEmpty()) {
			this.currentNode = this.first;
			for (int i = 0; i<this.count ;i++) {
				if (currentNode.getData().equals(item))
					return i;
				currentNode = currentNode.getNext();
			}
		}else
			System.out.println("List is empty.");
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
		this.currentNode = this.last;
		System.out.print("[");
		for(int i = this.count-1 ; i>=0 ;i--) {
			System.out.print(this.currentNode.getData());
			if(i>0) {
				System.out.print(",");
			}
			currentNode = currentNode.getPrevious();
		}
		System.out.println("]");
	}

	public void addBeginning(T item) {
		Node<T> n = new Node<T>(item);
		if (isEmpty()) {
			this.first = n;
			this.last = n;
		} else {
			n.setNext(first);
			this.first.setPrevious(n);
			this.first = n;
		}
		this.last.setNext(first);
		this.first.setPrevious(last);
		this.count++;
	}

	public void updateBeginning(T item) {
		this.first.setData(item);
	}
	
	public <Object> void sort(){
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
	} // Bubble Sort

}
