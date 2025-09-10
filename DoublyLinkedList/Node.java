public class Node<T>{
	private T data;
	private Node<T> next;
	private Node<T> previous;

	public Node(T data){
		this.setData(data);
		this.setNext(null);
		this.setPrevious(null);
	}

	public Node(T data, Node<T> previous){
		this.setData(data);
		this.setNext(null);
		this.setPrevious(previous);
	}

	public void setData(T data){this.data = data;}
	public void setNext(Node<T> next){this.next = next;}
	public void setPrevious(Node<T> previous) {this.previous = previous;}

	public T getData(){return this.data;}
	public Node<T> getNext(){return this.next;}
	public Node<T> getPrevious() {return this.previous;}

}