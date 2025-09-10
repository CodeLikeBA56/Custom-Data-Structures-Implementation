public class Main{
	public static void main(String[] args) {
		DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
		DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();
		
		list1.add(10);
		list1.add(9);
		list1.add(8);
		list1.add(7);
		list1.add(6);
		list1.add(5);
		list1.printReverse();
		list1.removeLast();
		list1.print();
		list1.sort();
		list1.print();
		
		Node<Integer> first = list1.getFirstNode();
		System.out.println("Node first: "+first.getPrevious().getPrevious().getPrevious().getData());
		Node<Integer> last = list1.getLastNode();
		System.out.println("Node last: "+last.getNext().getNext().getData());

		list2.add(1100);
		list2.add(201);
		list2.add(3100);
		list2.add(400-200);
		list2.sort();
		list2.print();
		
		/*LinkedList<String> b = new LinkedList<>();
		b.add("a");
		b.add("b");
		b.add("c");
		//Object a = b.clone();
		System.out.println(b.clone().equals(b));
		System.out.println(b.toString());*/

	}

}