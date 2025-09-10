public class Node<T>{
	private T data;
	private Node<T> next;

	public Node(T data){
		this.setData(data);
		this.setNext(null);
	}

	public void setData(T data){
		this.data = data;
	}
	public void setNext(Node<T> next){
		this.next = next;
	}
	public T getData(){
		return this.data;
	}
	public Node<T> getNext(){
		return this.next;
	}
}