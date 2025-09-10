public class Main{
	public static void main(String[] args) {	
		CircularLinkedList<Integer> list1 = new CircularLinkedList<>();
		CircularLinkedList<Integer> list2 = new CircularLinkedList<>();
		
		list1.add(10);
		list1.add(9);
		list1.add(8);
		list1.add(7);
		list1.add(6);
		list1.add(5);
		list1.add(4);
		list1.add(3);
		list1.add(2);
		list1.add(1);
		list1.add(0);
		list1.printReverse();
		list1.bubbleSort();
		list1.print();
		
		Node temp = list1.getLastNode();
		System.out.println("Node 5: "+temp.getNext().getNext().getData());

		list2.add(1100);
		list2.add(201);
		list2.add(3100);
		list2.add(400-200);
		list2.bubbleSort();
		list2.print();

	}

	public static Node<Integer> mergeTwoLinkedList(Node<Integer> obj1, Node<Integer> obj2){

		CircularLinkedList<Integer> list = new CircularLinkedList<>();

		while(obj1 != null) {	
			int temp1 = obj1.getData() , temp2 = obj2.getData();
				if(((temp1*temp2)%2==0)){
					list.add(temp2*temp1);
				}
			obj1 = obj1.getNext();
			obj2 = obj2.getNext();
		}

		return list.getLinkedList();

	}

}