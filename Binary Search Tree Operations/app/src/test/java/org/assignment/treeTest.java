package org.assignment;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class treeTest {
    @Test
    public void testInsert() {
        binarySearchTree tree = new binarySearchTree();

        assertEquals(tree.search(10), null);

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);

        // Checking if the keys are inserted correctly
        assertEquals(tree.search(10).key, 10);
        assertEquals(tree.search(5).key, 5);
        assertEquals(tree.search(15).key, 15);
        assertEquals(tree.search(3).key, 3);
        assertEquals(tree.search(7).key, 7);
        assertEquals(tree.search(12).key, 12);
        assertEquals(tree.search(17).key, 17);
        assertEquals(tree.search(-4), null);
    }

    //test conditions
    @Test
    public void testMin() {
        binarySearchTree tree = new binarySearchTree();

        assertEquals(tree.min(), null);

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);

        assertEquals(tree.min().key, 3);
    }

    @Test
    public void testMax() {
        binarySearchTree tree = new binarySearchTree();

        assertEquals(tree.max(), null);

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);

        assertEquals(tree.max().key, 17);
    }

    @Test
    public void testInOrderPredecessor() {
        binarySearchTree tree = new binarySearchTree();

        assertEquals(tree.inOrderPredecessor(10), null);

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);

        assertEquals(tree.inOrderPredecessor(5).key, 3);
        assertEquals(tree.inOrderPredecessor(10).key, 7);
        assertEquals(tree.inOrderPredecessor(17).key, 15);
        assertEquals(tree.inOrderPredecessor(3), null);
    }

    @Test
    public void testInOrderSuccessor() {
        binarySearchTree tree = new binarySearchTree();

        assertEquals(tree.inOrderSuccessor(10), null);

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);

        assertEquals(tree.inOrderSuccessor(5).key, 7);
        assertEquals(tree.inOrderSuccessor(10).key, 12);
        assertEquals(tree.inOrderSuccessor(17), null);
        assertEquals(tree.inOrderSuccessor(12).key, 15);
    }

    @Test
    public void testPreOrderPredecessor() {
        binarySearchTree tree = new binarySearchTree();

        assertEquals(tree.preOrderPredecessor(10), null);

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);

        assertEquals(tree.preOrderPredecessor(5).key, 10);
        assertEquals(tree.preOrderPredecessor(10), null);
        assertEquals(tree.preOrderPredecessor(17).key, 12);
        assertEquals(tree.preOrderPredecessor(3).key, 5);
    }

    @Test
    public void testPreOrderSuccessor() {
        binarySearchTree tree = new binarySearchTree();

        assertEquals(tree.preOrderSuccessor(10), null);

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);

        assertEquals(tree.preOrderSuccessor(5).key, 3);
        assertEquals(tree.preOrderSuccessor(10).key, 5);
        assertEquals(tree.preOrderSuccessor(17), null);
        assertEquals(tree.preOrderSuccessor(12).key, 17);
    }

    @Test
    public void testPostOrderPredecessor() {
        binarySearchTree tree = new binarySearchTree();

        assertEquals(tree.postOrderPredecessor(10), null);

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);

        assertEquals(tree.postOrderPredecessor(5).key, 7);
        assertEquals(tree.postOrderPredecessor(10).key, 15);
        assertEquals(tree.postOrderPredecessor(17).key, 12);
        assertEquals(tree.postOrderPredecessor(3), null);
    }

    @Test
    public void testPostOrderSuccessor() {
        binarySearchTree tree = new binarySearchTree();

        assertEquals(tree.postOrderSuccessor(10), null);

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);

        assertEquals(tree.postOrderSuccessor(5).key, 12);
        assertEquals(tree.postOrderSuccessor(10), null);
        assertEquals(tree.postOrderSuccessor(17).key, 15);
        assertEquals(tree.postOrderSuccessor(12).key, 17);
    }
}