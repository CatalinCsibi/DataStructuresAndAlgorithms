package binarytrees;

public class MyBinaryTree {

    private Node root;

    private class Node {

        private int value;

        private Node leftChild;

        private Node rightChild;

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
            if(value == current.value)
                throw new IllegalStateException();

            if(value < current.value) {
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
            if(current.value == value) {
                return true;
            }
            if(value < current.value) {
                current = current.leftChild;
            } else  {
                current = current.rightChild;
            }
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    public int height(){
        return height(root);
    }

    public int min(){
        return min(root);
    }

    public void swapRoot() {
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }


    private boolean isBinarySearchTree(Node root, int min, int max) {
       if(root == null)
           return true;

       if(root.value < min || root.value > max)
           return false;

       return isBinarySearchTree(root.leftChild, min, root.value - 1)
               && isBinarySearchTree(root.rightChild, root.value +1, max);
    }

    private int height(Node root) {
        if(root == null)
            return -1;

        if(isLeaf(root))
            return 0;

        return 1 + Math.max(
                height(root.leftChild),
                height(root.rightChild));
    }

    private boolean isLeaf(Node root) {
        return root.leftChild == null && root.rightChild == null;
    }

    //Solution for binary trees, not binary search trees
    private int min(Node root) {
        if(isLeaf(root))
            return root.value;

       var left =  min(root.leftChild);
       var right = min(root.rightChild);

       return Math.min(Math.min(left, right), root.value);
    }

    public boolean equals(MyBinaryTree other) {
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if(first == null && second == null)
            return true;

        if(first != null && second != null)
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);

        return false;
    }

    private void traversePreOrder(Node root) {
        if(root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    private void traversePostOrder(Node root) {
        if(root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    private void traverseInOrder(Node root) {
        if(root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }


}
