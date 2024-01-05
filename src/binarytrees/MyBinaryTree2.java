package binarytrees;


public class MyBinaryTree2 {

    private Node root;

    private static class Node {

        private Node leftChild;
        private Node rightChild;

        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        var node = new Node(value);
        if(root == null) {
            root = node;
            return;
        }

        var current = root;

        while (true) {
            if(current.value == value) {
                break;
            } else if (value < current.value) {
                if(current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if(current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        var current = root;

        while (current != null) {
            if(value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean equals(MyBinaryTree2 myBinaryTree2){
        return equals(root, myBinaryTree2.root);
    }

    public int height() {
        return height(root);
    }

    public int min() {
        var current = root;
        int min = Integer.MAX_VALUE;

        while (current != null) {
            if(min > current.value) {
                min = current.value;
            }
            current = current.leftChild;
        }
        return min;
    }

    private void traversePreOrder(Node root) {
        if(root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    private void traverseInOrder(Node root) {
        if(root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    private void traversePostOrder(Node root) {
        if(root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    private boolean isBinarySearchTree(Node root, int max, int min) {
        if(root == null)
            return true;

        if(root.value < min || root.value > max)
            return false;

        return isBinarySearchTree(root.leftChild, root.value - 1, min)
                && isBinarySearchTree(root.rightChild, max, root.value + 1);
    }

    private boolean equals(Node first, Node second) {
        if(first == null && second == null)
            return true;

        if(first != null && second != null) {
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        }
        return false;
    }

    private int height(Node root) {
        if(root == null)
            return - 1;

        if(isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }
}