public class LinkedBasedQueue<T> implements QueueInterface<T>{
	private Node<T> first;
	private Node<T> last;
	private int count;
	
	public LinkedBasedQueue(){
		this.first = null;
		this.last = null;
		this.count = 0;
	}

	@Override
	public void enqueue(T item){
		Node<T> n = new Node<T>(item, null);
		if(isEmpty()){
			this.first = n;
		}
		else{
			this.last.setNext(n);
		}
		this.last = n;	
		this.count++;
	}
	@Override
	public T dequeue(){
		try {
			T value = getFront();
			
			this.first = first.getNext();
			this.count--;
			if(this.first == null){
				this.clear();
			}
			return value;
		}
		catch(Exception ex) {
			return null;
		}		
	}
	
	public T getFront(){
		if(isEmpty()){
			System.out.println("Queue is empty!");
			return null;
		}else{
			return this.first.getData();
		}
	}

	public boolean isEmpty(){
		return this.first == null && this.last == null;
	}

	public void clear(){
		this.first = this.last = null;
		this.count = 0;
	}

	public int size(){
		return this.count;
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

} // Node Class for Queue

}
