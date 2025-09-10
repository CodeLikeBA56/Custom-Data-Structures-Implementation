import java.util.*;
public class MaxHeap<T> {
    private Node<T> root;
    private int count;
    private int size;

    public MaxHeap(int size) {
        this.size = size;
        this.count = 0;
    }

    public void insert(T data) {
        if (count >= size) {
            return;
        }
        Node<T> node = new Node<T>(data, count++);
        if (root == null) {
            root = node;
        }else{
            Node<T> parent = getParent(node);
            node.setParent(parent);
            if (parent.getLeft() == null) {
                parent.setLeft(node);
            }else
                parent.setRight(node);
            
            while (parent != null && ((Comparable)node.getData()).compareTo(parent.getData()) > 0) {
                swap(node, parent);
                node = parent;
                parent = getParent(node);
            }
        } // else
    } // insert method

    private Node<T> getParent(Node<T> node) {
        if (node == root) {
            return null;
        }
        int index = (node.getIndex() - 1) / 2;
        return getNodeAtIndex(index);
    }

    private void swap(Node<T> node1, Node<T> node2) {
        T tmp;
        tmp = node1.getData();
        node1.setData(node2.getData());
        node2.setData(tmp);
    }

    private Node<T> getLeftChild(Node<T> node) {
        int index = (node.getIndex() * 2) + 1;
        return getNodeAtIndex(index);
    }

    private Node<T> getRightChild(Node<T> node) {
        int index = (node.getIndex() * 2) + 2;
        return getNodeAtIndex(index);
    }

    private boolean isLeaf(Node<T> node) {
        return node.getIndex() > (count / 2) && node.getIndex() <= count;
    }

    private void minHeapify(Node<T> node) {
        if (!isLeaf(node)) {
            Node<T> smallest = node;
            Node<T> leftChild = getLeftChild(node);
            Node<T> rightChild = getRightChild(node);

            if (leftChild != null && ((Comparable)leftChild.getData()).compareTo(smallest.getData()) > 0) {
                smallest = leftChild;
            }
            if (rightChild != null && ((Comparable)rightChild.getData()).compareTo(smallest.getData()) > 0) {
                smallest = rightChild;
            }

            if (smallest != node) {
                swap(node, smallest);
                minHeapify(smallest);
            }
        }
    }

    private Node<T> getNodeAtIndex(int index) {
        if (index > count) {
            return null;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            if (node.getIndex() == index) {
                return node;
            }
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return null;
    }

    public T remove() {
        T popped = root.getData();
        if (count == 1) {
            root = null;
            count--;
            return popped;
        }
        Node<T> lastNode = getNodeAtIndex(count - 1);
        swap(root, lastNode);
        if (lastNode.getParent().getLeft() == lastNode) {
            lastNode.getParent().setLeft(null);
        } else
            lastNode.getParent().setRight(null);
        count--;
        minHeapify(root);
        return popped;
    }

    public void breadthFirstTraversal() {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            System.out.print(node.getData() + " ");
            Node<T> leftChild = node.getLeft();
            Node<T> rightChild = node.getRight();
            if (leftChild != null) {
                queue.add(leftChild);
            }
            if (rightChild != null) {
                queue.add(rightChild);
            }
        }
        System.out.println();
    }

    public void depthFirstTraversal() {
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<T> node = stack.pop();
            System.out.print(node.getData() + " ");
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
        }
        System.out.println();
    }

    public int getSize() {
        return this.size;
    }

    public int getCount(){
        return this.count;
    }

public class Node<T> {
    private T data;
    private Node<T> parent;
    private Node<T> left;
    private Node<T> right;
    private int index;

    public Node(T data, int index) {
        this.data = data;
        this.index = index;
    }

    public void setData(T data) {this.data = data;}
    public void setIndex(int index){this.index = index;}
    public void setLeft(Node<T> left) {this.left = left;}
    public void setRight(Node<T> right) {this.right = right;}
    public void setParent(Node<T> parent) {this.parent = parent;}

    public T getData() {return data;}
    public int getIndex() {return index;}
    public Node<T> getLeft() {return left;}
    public Node<T> getRight() {return right;}
    public Node<T> getParent() {return parent;}
    

} // Node Class

}