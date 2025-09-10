public class BalancedBST<T> {
    private Node<T> root;

    public BalancedBST() {
        this.root = null;
    }

    public void insert(T item) {
        this.root = insert(root, item);
    }

    private Node<T> insert(Node<T> root, T item) {
        if (root == null) {
            root = new Node<T>(item);
        } else if (((Comparable) item).compareTo(root.getData()) < 0) {
            root.setLeft(insert(root.getLeft(), item));
        } else {
            root.setRight(insert(root.getRight(), item));
        }

        // Update height and balance factor
        root.setHeight(Math.max(this.height(root.getLeft()), this.height(root.getRight())) + 1);
        int balance = getBalance(root);

        // Perform rotation if needed to balance the tree
        if (balance > 1) {
            if (((Comparable) item).compareTo(root.getLeft().getData()) < 0) {
                // Left-Left case
                root = rotateRight(root);
            } else {
                // Left-Right case
                root.setLeft(rotateLeft(root.getLeft()));
                root = rotateRight(root);
            }
        } else if (balance < -1) {
            if (((Comparable) item).compareTo(root.getRight().getData()) > 0) {
                // Right-Right case
                root = rotateLeft(root);
            } else {
                // Right-Left case
                root.setRight(rotateRight(root.getRight()));
                root = rotateLeft(root);
            }
        }

        return root;
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public T search(T item) {
        return searchRecursive(this.root, item);
    }

    private T searchRecursive(Node<T> current, T value) {
        if (current == null) {
            return null;
        } else if (((Comparable) value).compareTo(current.getData()) == 0) {
            return current.getData();
        } else if (((Comparable) value).compareTo(current.getData()) < 0) {
            return searchRecursive(current.getLeft(), value);
        } else {
            return searchRecursive(current.getRight(), value);
        }
    }

    public void remove(T item) {
        this.root = deleteRecursive(this.root, item);
    }

    private Node<T> deleteRecursive(Node<T> current, T value) {
        if (current == null) {
            return null;
        } else if (((Comparable) value).compareTo(current.getData()) == 0) {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;    // leaf root
            }
            if (current.getRight() == null) {
                return current.getLeft();    // root with one child (left)
            }
            if (current.getLeft() == null) {
                return current.getRight();    // root with one child (right)
            }

            T smallestValue = findSmallestValue(current.getRight()); // root with two children
            current.setData(smallestValue);
            current.setRight(deleteRecursive(current.getRight(), smallestValue));

            // Update height and balance factor
            current.setHeight(Math.max(height(current.getLeft()), height(current.getRight())) + 1);
            int balance = getBalance(current);

            // Perform rotation if needed to balance the tree
            if (balance > 1) {
                if (getBalance(current.getLeft()) >= 0) {
                    // Left-Left case
                    current = rotateRight(current);
                } else {
                    // Left-Right case
                    current.setLeft(rotateLeft(current.getLeft()));
                    current = rotateRight(current);
                }
            } else if (balance < -1) {
                // Right-Right case
                current = rotateLeft(current);
            } else {
                // Right-Left case
                current.setRight(rotateRight(current.getRight()));
                current = rotateLeft(current);
            }
        }

        return current;
    }

    private T findSmallestValue(Node<T> root) {
        return root.getLeft() == null ? root.getData() : findSmallestValue(root.getLeft());
    }

    private int max(int a, int b) {
        return a > b ? a : b;
        /*
        if(a>b){
            return a;
        }else{
            return b;
        }
        */
    }

    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    private int getBalance(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    private Node<T> rotateLeft(Node<T> z) {
        Node<T> y = z.getRight();
        Node<T> T2 = y.getLeft();

        y.setLeft(z);
        z.setRight(T2);

        z.setHeight(Math.max(height(z.getLeft()), height(z.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }

    private Node<T> rotateRight(Node<T> z) {
        Node<T> y = z.getLeft();
        Node<T> T2 = y.getRight();

        y.setRight(z);
        z.setLeft(T2);

        z.setHeight(Math.max(height(z.getLeft()), height(z.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }

private static class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;
    private int height;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }

    public void setData(T data) {this.data = data;}
    public void setLeft(Node<T> left) {this.left = left;}
    public void setRight(Node<T> right) {this.right = right;}
    public void setHeight(int height) {this.height = height;}

    public T getData() {return data;}
    public Node<T> getLeft() {return left;}
    public Node<T> getRight() {return right;}
    public int getHeight() {return height;}
    
    } // Node class for BalancedBST

} // Balanced BST
