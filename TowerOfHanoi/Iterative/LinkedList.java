public class LinkedList{
    private Node head;
    
    public LinkedList() {
        this.head = null;
    }
    
    // Method to add a node to the end of the linked list
    public void add(int data) {
        Node newNode = new Node(data);
        
        // If the linked list is empty, make the new node as head
        if (head == null) {
            head = newNode;
        } else {
            // Traverse till the end of the linked list and add the new node
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    // Method to remove a node from the linked list
    public void remove(int data) {
        // If the node to be removed is the head node, update the head
        if (head.data == data) {
            head = head.next;
        } else {
            // Traverse till the node to be removed is found and remove it
            Node current = head;
            while (current.next != null && current.next.data != data) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            }
        }
    }
    
    // Method to print the linked list
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
public class LinkedList {
    private Node head;
    
    public LinkedList() {
        this.head = null;
    }
    
    // Method to add a node to the end of the linked list
    public void add(int data) {
        Node newNode = new Node(data);
        
        // If the linked list is empty, make the new node as head
        if (head == null) {
            head = newNode;
        } else {
            // Traverse till the end of the linked list and add the new node
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    // Method to remove a node from the linked list
    public void remove(int data) {
        // If the node to be removed is the head node, update the head
        if (head.data == data) {
            head = head.next;
        } else {
            // Traverse till the node to be removed is found and remove it
            Node current = head;
            while (current.next != null && current.next.data != data) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            }
        }
    }
    
    // Method to print the linked list
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
