public class Stack<T> implements StackInterface<T> {
	private Node<T> head;
	private Node<T> currentNode;
	private int count;

	public Stack() {
		this.head = null;
		this.count = 0; 
	}

	public void push(T item) {
		Node<T> n = new Node<>(item, head);
		this.head = n;
		this.count++;
	}

	public T pop() {
		try{
			T tmp = this.peek();
			this.head = this.head.getNext();
			count--;
			return tmp;
		}catch(Exception e){
			return null;
		}	
	}

	public T peek() {
		try{
			return this.head.getData();
		}catch(Exception e){
			System.out.println("Stack is empty.");
			return null;
		}	
	}

	public void clear() {
		this.head = null;
		this.count = 0;
	}

	public boolean isEmpty() {
		return this.head == null && count == 0;
	}

	public int size(){
		return this.count;
	}

	public void print() {
		System.out.print("[");
		currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.getData());
			if (currentNode.getNext() != null) {
				System.out.print(",");
			}
			currentNode = currentNode.getNext();
		}
		System.out.println("]");
	}

	public String toString(){
		String stackValues = "";
		if(!this.isEmpty()){
			this.currentNode = this.head;
			while(currentNode!=null){
				stackValues += currentNode.getData();
				if(currentNode.getNext()!=null)
					stackValues += ", ";
				currentNode = currentNode.getNext();
			}
			return stackValues;
		}else{
			stackValues = "Stack is empty.";
			return stackValues;
		}
		
	}

	public boolean contains(T item) {
		currentNode = head;
		while (currentNode != null) {
			if (currentNode.getData().equals(item)) {
				return true;
			}
			currentNode = currentNode.getNext();
		}
		return false;
	}

private class Node<T>{
	private T data;
	private Node<T> next;

	public Node(T data, Node<T> next){
		this.setData(data);
		this.setNext(next);
	}

	public void setData(T data){this.data = data;}
	public void setNext(Node<T> next){this.next = next;}
	public T getData(){return this.data;}
	public Node<T> getNext(){return this.next;}

} // Node Class for stack

}