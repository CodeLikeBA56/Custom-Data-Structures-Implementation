import java.util.Stack;
public class StackBasedQueue<T> implements QueueInterface<T>{
	private Stack<T> input;
	private Stack<T> output;
	
	public StackBasedQueue(){
		this.input = new Stack<>();
		this.output = new Stack<>();
	}

	@Override
	public void enqueue(T item){
		this.input.push(item);
	}
	
	@Override
	public T dequeue(){
		try {
			T value = this.getFront();
			this.output.pop();
			return value;
		}catch(Exception e) {
			return null;
		}
	}
	
	public T getFront(){
		if(this.input.isEmpty() && this.output.isEmpty()) {
			System.out.println("Queue is empty.");
			return null;
		}else if(this.output.isEmpty() && (!this.input.isEmpty())) {
			while(!this.input.isEmpty())
				this.output.push(this.input.pop());
		}
		
		return this.output.peek();
	}

	public boolean isEmpty(){
		return this.input.isEmpty() && this.output.isEmpty();
	}

	public void clear(){
		this.input.clear();
		this.output.clear();
	}
	
	public int size() {
		return this.input.size() + this.output.size();
	}

}
