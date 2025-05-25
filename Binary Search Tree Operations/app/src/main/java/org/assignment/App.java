package org.assignment;

public class App {
    public static void main(String[] args) {
        // Creating a new Binary Search Tree instance
        binarySearchTree tree = new binarySearchTree();

        // Inserting elements into the Binary Search Tree (logics in binarySearchTree.java file)
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);

        // Display the minimum and maximum key in the tree (logics in binarySearchTree.java file)
        System.out.println("Minimum key: " + (tree.min() != null ? tree.min().key : "None"));
        System.out.println("Maximum key: " + (tree.max() != null ? tree.max().key : "None"));

        // Searching for a key
        int searchKey = 7;
        binarySearchTree.Node foundNode = tree.search(searchKey);
        System.out.println("Search for " + searchKey + ": " + (foundNode != null ? "Found" : "Not Found"));

        // Displaying in-order predecessor and successor
        System.out.println("In-order predecessor of 10: " + getKey(tree.inOrderPredecessor(10)));
        System.out.println("In-order successor of 10: " + getKey(tree.inOrderSuccessor(10)));

        // Displaying pre-order predecessor and successor
        System.out.println("Pre-order predecessor of 7: " + getKey(tree.preOrderPredecessor(7)));
        System.out.println("Pre-order successor of 7: " + getKey(tree.preOrderSuccessor(7)));

        // Displaying post-order predecessor and successor
        System.out.println("Post-order predecessor of 12: " + getKey(tree.postOrderPredecessor(12)));
        System.out.println("Post-order successor of 12: " + getKey(tree.postOrderSuccessor(12)));

        // Printing all traversals
        System.out.print("In-order Traversal: ");
        tree.printInOrder();

        System.out.print("Pre-order Traversal: ");
        tree.printPreOrder();

        System.out.print("Post-order Traversal: ");
        tree.printPostOrder();
    }

    // Helper function to print keys safely (to manage null pointer exceptions)
    public static int getKey(binarySearchTree.Node node) {
        return node != null ? node.key : -1;
    }
}