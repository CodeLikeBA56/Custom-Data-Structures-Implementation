import java.util.*;
public class MaxHeap {
    private Node root;
    private int count;
    private int size;

    public MaxHeap(int size) {
        this.size = size;
        this.count = 0;
    }

    public void insert(int data) {
        if (count >= size) {
            return;
        }
        Node node = new Node(data, count++);
        if (root == null) {
            root = node;
        }else{
            Node parent = getParent(node);
            node.setParent(parent);
            if (parent.getLeft() == null) {
                parent.setLeft(node);
            }else
                parent.setRight(node);
            
            while (parent != null && node.getData() > parent.getData()) {
                swap(node, parent);
                node = parent;
                parent = getParent(node);
            }
        } // else
    } // insert method

    private Node getParent(Node node) {
        if (node == root) {
            return null;
        }
        int index = (node.getIndex() - 1) / 2;
        return getNodeAtIndex(index);
    }

    private void swap(Node node1, Node node2) {
        int tmp = node1.getData();
        node1.setData(node2.getData());
        node2.setData(tmp);
    }

    private Node getLeftChild(Node node) {
        int index = (node.getIndex() * 2) + 1;
        return getNodeAtIndex(index);
    }

    private Node getRightChild(Node node) {
        int index = (node.getIndex() * 2) + 2;
        return getNodeAtIndex(index);
    }

    private boolean isLeaf(Node node) {
        return node.getIndex() > (count / 2) && node.getIndex() <= count;
    }

    private void minHeapify(Node node) {
        if (!isLeaf(node)) {
            Node smallest = node;
            Node leftChild = getLeftChild(node);
            Node rightChild = getRightChild(node);

            if (leftChild != null && leftChild.getData() > smallest.getData()) {
                smallest = leftChild;
            }
            if (rightChild != null && rightChild.getData() > smallest.getData()) {
                smallest = rightChild;
            }

            if (smallest != node) {
                swap(node, smallest);
                minHeapify(smallest);
            }
        }
    }

    private Node getNodeAtIndex(int index) {
        if (index > count) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.getIndex() == index) {
                return node;
            }
            Node leftChild = node.getLeft();
            Node rightChild = node.getRight();
            if (leftChild != null) {
                queue.add(leftChild);
            }
            if (rightChild != null) {
                queue.add(rightChild);
            }
        }
        return null;
    }

    public int remove() {
        int popped = root.getData();
        if (count == 1) {
            root = null;
            count--;
            return popped;
        }
        Node lastNode = getNodeAtIndex(count - 1);
        swap(root, lastNode);
        if (lastNode.getParent().getLeft() == lastNode) {
            lastNode.getParent().setLeft(null);
        } else
            lastNode.getParent().setRight(null);
        count--;
        minHeapify(root);
        return popped;
    }

    public void print() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.getData() + " ");
            Node leftChild = node.getLeft();
            Node rightChild = node.getRight();
            if (leftChild != null) {
                queue.add(leftChild);
            }
            if (rightChild != null) {
                queue.add(rightChild);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        heap.insert(9);
        heap.print();
        System.out.println("Removed: " + heap.remove());
        heap.print();
    }

public class Node {
    private int data;
    private Node parent;
    private Node left;
    private Node right;
    private int index;

    public Node(int data, int index) {
        this.data = data;
        this.index = index;
    }

    public void setData(int data) {this.data = data;}
    public void setIndex(int index){this.index = index;}
    public void setLeft(Node left) {this.left = left;}
    public void setRight(Node right) {this.right = right;}
    public void setParent(Node parent) {this.parent = parent;}

    public int getData() {return data;}
    public int getIndex() {return index;}
    public Node getLeft() {return left;}
    public Node getRight() {return right;}
    public Node getParent() {return parent;}
    

} // Node Class

}