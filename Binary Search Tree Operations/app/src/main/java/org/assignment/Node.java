package org.assignment;

//Defining Node as a class
public class Node {
    public int key;
    Node left;
    Node right;
    Node parent;

    public Node(int key, Node parent) {
        this.key = key;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }

    // Constructor for creating a node with no parent
    public Node(int key) {
        this(key, null);
    }
    @Override // for overriding the inbuilt toString() method to be more human readable form
    public String toString() {
        return "<key: " + key +
                ", parent: " + (parent != null ? parent.key : "null") +
                ", left: " + (left != null ? left.key : "null") +
                ", right: " + (right != null ? right.key : "null") + ">";
    }
}