package binarytrees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyBinaryTree2 {

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
                return;
            else if (value < current.value) {
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
            } else if (value > current.value){
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean remove(int value) {
        if (root == null) return false;

        Node currentNode = root;
        Node parentNode = null;

        while (currentNode != null) {
            if (value < currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.leftChild;
            } else if (value > currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.rightChild;
            } else {
                // Node found: perform removal

                // Option 1: No right child
                if (currentNode.rightChild == null) {
                    if (parentNode == null) {
                        root = currentNode.leftChild;
                    } else {
                        if (currentNode.value < parentNode.value) {
                            parentNode.leftChild = currentNode.leftChild;
                        } else {
                            parentNode.rightChild = currentNode.leftChild;
                        }
                    }

                    // Option 2: Right child with no left child
                } else if (currentNode.rightChild.leftChild == null) {
                    currentNode.rightChild.leftChild = currentNode.leftChild;
                    if (parentNode == null) {
                        root = currentNode.rightChild;
                    } else {
                        if (currentNode.value < parentNode.value) {
                            parentNode.leftChild = currentNode.rightChild;
                        } else {
                            parentNode.rightChild = currentNode.rightChild;
                        }
                    }

                    // Option 3: Right child with a left child
                } else {
                    // Find the leftmost child in the right subtree
                    Node leftmost = currentNode.rightChild.leftChild;
                    Node leftmostParent = currentNode.rightChild;

                    while (leftmost.leftChild != null) {
                        leftmostParent = leftmost;
                        leftmost = leftmost.leftChild;
                    }

                    // Parent's left subtree becomes leftmost's right subtree
                    leftmostParent.leftChild = leftmost.rightChild;

                    // Replace currentNode with leftmost
                    leftmost.leftChild = currentNode.leftChild;
                    leftmost.rightChild = currentNode.rightChild;

                    if (parentNode == null) {
                        root = leftmost;
                    } else {
                        if (currentNode.value < parentNode.value) {
                            parentNode.leftChild = leftmost;
                        } else {
                            parentNode.rightChild = leftmost;
                        }
                    }
                }
                return true;
            }
        }

        return false; // Node not found
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

    public List<Integer> breadthFirstSearch() {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.println(currentNode.value);
            list.add(currentNode.value);

            if (currentNode.leftChild != null) queue.add(currentNode.leftChild);
            if (currentNode.rightChild != null) queue.add(currentNode.rightChild);
        }

        return list;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int height() {
        return height(root);
    }

    public int min() {
        var current = root;

        while (current != null) {
            if(current.leftChild == null) {
                return current.value;
            }
            current = current.leftChild;
        }
        return -1;
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if(root == null) {
            return true;
        }

        if(root.value < min || root.value > max)
            return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max);

    }

    private int height(Node root) {
        if(root == null)
            return -1;

        if(isLeaf(root))
            return 0;

        return 1+ Math.max(height(root.leftChild), height(root.rightChild));
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public static void main(String[] args) {
        MyBinaryTree2 myBinaryTree2 = new MyBinaryTree2();

        myBinaryTree2.insert(8);
        myBinaryTree2.insert(5);
        myBinaryTree2.insert(11);
        myBinaryTree2.insert(9);
        myBinaryTree2.insert(14);
        myBinaryTree2.insert(4);
        myBinaryTree2.insert(7);
        myBinaryTree2.insert(6);
        myBinaryTree2.insert(3);
        myBinaryTree2.insert(1);

        System.out.println(myBinaryTree2.find(6));
        System.out.println(myBinaryTree2.find(7));
        System.out.println(myBinaryTree2.find(33));

        System.out.println();

        myBinaryTree2.traversePreOrder();

        System.out.println();

        myBinaryTree2.traverseInOrder();


        System.out.println();

        myBinaryTree2.traversePostOrder();

        System.out.println();

        System.out.println(myBinaryTree2.isBinarySearchTree());
        System.out.println();

        System.out.println(myBinaryTree2.height());
        System.out.println(myBinaryTree2.min());
    }

}