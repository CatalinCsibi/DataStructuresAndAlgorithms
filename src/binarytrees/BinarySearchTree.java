package binarytrees;

import java.util.*;


public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }
        Node currentNode = root;
        while (true) {
            if (value < currentNode.value) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    return;
                }
                currentNode = currentNode.left;
            } else {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    return;
                }
                currentNode = currentNode.right;
            }
        }
    }

    public Node lookup(int value) {
        if (root == null) return null;
        Node currentNode = root;
        while (currentNode != null) {
            if (value < currentNode.value) {
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                return currentNode;
            }
        }
        return null;
    }

    public boolean remove(int value) {
        if (root == null) return false;
        Node currentNode = root;
        Node parentNode = null;

        while (currentNode != null) {
            if (value < currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.right;
            } else {
                if (currentNode.right == null) {
                    if (parentNode == null) {
                        root = currentNode.left;
                    } else {
                        if (currentNode.value < parentNode.value) {
                            parentNode.left = currentNode.left;
                        } else {
                            parentNode.right = currentNode.left;
                        }
                    }
                } else if (currentNode.right.left == null) {
                    currentNode.right.left = currentNode.left;
                    if (parentNode == null) {
                        root = currentNode.right;
                    } else {
                        if (currentNode.value < parentNode.value) {
                            parentNode.left = currentNode.right;
                        } else {
                            parentNode.right = currentNode.right;
                        }
                    }
                } else {
                    Node leftmost = currentNode.right.left;
                    Node leftmostParent = currentNode.right;
                    while (leftmost.left != null) {
                        leftmostParent = leftmost;
                        leftmost = leftmost.left;
                    }
                    leftmostParent.left = leftmost.right;
                    leftmost.left = currentNode.left;
                    leftmost.right = currentNode.right;

                    if (parentNode == null) {
                        root = leftmost;
                    } else {
                        if (currentNode.value < parentNode.value) {
                            parentNode.left = leftmost;
                        } else {
                            parentNode.right = leftmost;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public List<Integer> breadthFirstSearch() {
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return list;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            list.add(currentNode.value);
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }
        return list;
    }

    public List<Integer> breadthFirstSearchRecursive(Queue<Node> queue, List<Integer> list) {
        if (queue.isEmpty()) return list;
        Node currentNode = queue.poll();
        list.add(currentNode.value);
        if (currentNode.left != null) queue.add(currentNode.left);
        if (currentNode.right != null) queue.add(currentNode.right);
        return breadthFirstSearchRecursive(queue, list);
    }

    public List<Integer> DFSInOrder(Node node, List<Integer> list) {
        if (node != null) {
            DFSInOrder(node.left, list);
            list.add(node.value);
            DFSInOrder(node.right, list);
        }
        return list;
    }

    public List<Integer> DFSPreOrder(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.value);
            DFSPreOrder(node.left, list);
            DFSPreOrder(node.right, list);
        }
        return list;
    }

    public List<Integer> DFSPostOrder(Node node, List<Integer> list) {
        if (node != null) {
            DFSPostOrder(node.left, list);
            DFSPostOrder(node.right, list);
            list.add(node.value);
        }
        return list;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);

        System.out.println("BFS: " + tree.breadthFirstSearch());
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree.root);
        System.out.println("BFS Recursive: " + tree.breadthFirstSearchRecursive(queue, new ArrayList<>()));
        System.out.println("DFS InOrder: " + tree.DFSInOrder(tree.root, new ArrayList<>()));
        System.out.println("DFS PreOrder: " + tree.DFSPreOrder(tree.root, new ArrayList<>()));
        System.out.println("DFS PostOrder: " + tree.DFSPostOrder(tree.root, new ArrayList<>()));
    }
}

