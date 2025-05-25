package org.assignment;

import java.util.ArrayList;
import java.util.List;

public class binarySearchTree {

    public class Node {
        int key;
        Node left, right, parent;

        Node(int key) {
            this.key = key;
            left = right = parent = null;
        }
    }

    private Node root;

    public binarySearchTree() {
        root = null;
    }

    // Checking if tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    // Inserting a key into Binary Search Tree; also no duplicates are allowed
    public Node insert(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return root;
        }
        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;
            if (key == current.key) {
                // No duplicates
                return null;
            } else if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        newNode.parent = parent;
        if (key < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        return newNode;
    }

    // Searching node by key
    public Node search(int key) {
        Node current = root;
        while (current != null) {
            if (key == current.key) return current;
            else if (key < current.key) current = current.left;
            else current = current.right;
        }
        return null;
    }

    // Minimum node starting from root
    public Node min() {
        if (root == null) return null;
        return min(root);
    }

    private Node min(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // Maximum node starting from root
    public Node max() {
        if (root == null) return null;
        return max(root);
    }

    private Node max(Node node) {
        while (node.right != null) node = node.right;
        return node;
    }

    // --- In-order predecessor: largest node smaller than given key ---
    public Node inOrderPredecessor(int key) {
        Node node = search(key);
        if (node == null) return null;

        // Case 1: If left subtree exists, predecessor is max in left subtree
        if (node.left != null) return max(node.left);

        // Case 2: Otherwise, go up until node is right child of parent
        Node parent = node.parent;
        while (parent != null && node == parent.left) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    // --- In-order successor: smallest node larger than given key ---
    public Node inOrderSuccessor(int key) {
        Node node = search(key);
        if (node == null) return null;

        // Case 1: If right subtree exists, successor is min in right subtree
        if (node.right != null) return min(node.right);

        // Case 2: Otherwise, go up until node is left child of parent
        Node parent = node.parent;
        while (parent != null && node == parent.right) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    // --- Pre-order traversal list ---
    private void preOrderTraversal(Node node, List<Node> list) {
        if (node == null) return;
        list.add(node);
        preOrderTraversal(node.left, list);
        preOrderTraversal(node.right, list);
    }

    // Pre-order predecessor of a key
    public Node preOrderPredecessor(int key) {
        List<Node> preOrderList = new ArrayList<>();
        preOrderTraversal(root, preOrderList);
        for (int i = 0; i < preOrderList.size(); i++) {
            if (preOrderList.get(i).key == key) {
                return i == 0 ? null : preOrderList.get(i - 1);
            }
        }
        return null;
    }

    // Pre-order successor of a key
    public Node preOrderSuccessor(int key) {
        List<Node> preOrderList = new ArrayList<>();
        preOrderTraversal(root, preOrderList);
        for (int i = 0; i < preOrderList.size(); i++) {
            if (preOrderList.get(i).key == key) {
                return i == preOrderList.size() - 1 ? null : preOrderList.get(i + 1);
            }
        }
        return null;
    }

    // --- Post-order traversal list ---
    private void postOrderTraversal(Node node, List<Node> list) {
        if (node == null) return;
        postOrderTraversal(node.left, list);
        postOrderTraversal(node.right, list);
        list.add(node);
    }

    // Post-order predecessor of a key
    public Node postOrderPredecessor(int key) {
        List<Node> postOrderList = new ArrayList<>();
        postOrderTraversal(root, postOrderList);
        for (int i = 0; i < postOrderList.size(); i++) {
            if (postOrderList.get(i).key == key) {
                return i == 0 ? null : postOrderList.get(i - 1);
            }
        }
        return null;
    }

    // Post-order successor of a key
    public Node postOrderSuccessor(int key) {
        List<Node> postOrderList = new ArrayList<>();
        postOrderTraversal(root, postOrderList);
        for (int i = 0; i < postOrderList.size(); i++) {
            if (postOrderList.get(i).key == key) {
                return i == postOrderList.size() - 1 ? null : postOrderList.get(i + 1);
            }
        }
        return null;
    }

    // Printing In-order Traversal
    private void printInOrderRec(Node node) {
        if (node != null) {
            printInOrderRec(node.left);
            System.out.print(node.key + " ");
            printInOrderRec(node.right);
        }
    }

    public void printInOrder() {
        System.out.print("InOrder: ");
        printInOrderRec(root);
        System.out.println();
    }


    // Printing Pre-order Traversal
    public void printPreOrder() {
        System.out.print("PreOrder: ");
        printPreOrderRec(root);
        System.out.println();
    }

    private void printPreOrderRec(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            printPreOrderRec(node.left);
            printPreOrderRec(node.right);
        }
    }

    // Printing Post-order Traversal
    private void printPostOrderRec(Node node) {
        if (node != null) {
            printPostOrderRec(node.left);
            printPostOrderRec(node.right);
            System.out.print(node.key + " ");
        }
    }
    public void printPostOrder() {
        System.out.print("PostOrder: ");
        printPostOrderRec(root);
        System.out.println();
    }


}