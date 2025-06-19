package binarytrees;

import java.util.*;

public class MyBinaryTree3{
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public MyBinaryTree3() {
        this.root = null;
    }

    // Insert method
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

    // Lookup method
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

    // Remove method
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
                // Node found

                // Option 1: No right child
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
                }
                // Option 2: Right child has no left child
                else if (currentNode.right.left == null) {
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
                }
                // Option 3: Right child has left child
                else {
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

    // Breadth First Search (Iterative)
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

    // Breadth First Search (Recursive)
    public List<Integer> breadthFirstSearchRecursive(Queue<Node> queue, List<Integer> list) {
        if (queue.isEmpty()) return list;

        Node currentNode = queue.poll();
        list.add(currentNode.value);

        if (currentNode.left != null) queue.add(currentNode.left);
        if (currentNode.right != null) queue.add(currentNode.right);

        return breadthFirstSearchRecursive(queue, list);
    }

    // Helper method to traverse (pre-order)
    public Map<String, Object> traverse(Node node) {
        if (node == null) return null;

        Map<String, Object> tree = new HashMap<>();
        tree.put("value", node.value);
        tree.put("left", traverse(node.left));
        tree.put("right", traverse(node.right));

        return tree;
    }

    // Main method to test
    public static void main(String[] args) {
        MyBinaryTree3 tree = new MyBinaryTree3();
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);

        System.out.println("BFS (Iterative): " + tree.breadthFirstSearch());
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree.root);
        System.out.println("BFS (Recursive): " + tree.breadthFirstSearchRecursive(queue, new ArrayList<>()));

        // Example for traverse
        System.out.println("Tree structure: " + tree.traverse(tree.root));
    }
}
