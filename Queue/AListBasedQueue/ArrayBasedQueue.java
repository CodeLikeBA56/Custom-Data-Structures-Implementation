public class ArrayBasedQueue<T> implements QueueInterface<T>{
	private T[] list;
	private int count;
	
	public ArrayBasedQueue(){
		this.count = 0;
		this.list = (T[]) new Object[25];
	}

	@Override
	public void enqueue(T item){
		this.list[count++] = item;
		checkCapacity();	
	}
	
	private void checkCapacity(){
		if(count == this.list.length){
			T[] newList = (T[]) new Object[this.list.length * 2];
			for (int i = 0; i < this.list.length; i++) {
				newList[i] = list[i];
			}
			list = newList;
		}
	}
	
	@Override
	public T dequeue(){
		T value = this.getFront();
		if(!this.isEmpty()){
			for(int i = 0; i<this.count ;i++)
				this.list[i] = this.list[i+1];
			this.count--;
			if(this.isEmpty())
				this.clear();
			return value;
		}else{
			return null;
		}
			
	}
	
	public T getFront(){
		if(this.isEmpty()){
			System.out.println("Queue is empty!");
			return null;
		}else{
			return this.list[0];
		}
	}

	public boolean isEmpty(){
		return this.count == 0;
	}

	public void clear(){
		this.count = 0;
		this.list = null;
	}

	public int size(){
		return this.count;
	}

}
