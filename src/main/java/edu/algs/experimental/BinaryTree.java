package edu.algs.experimental;

/**
 * Own implementation of binary tree
 */
public class BinaryTree<T extends Comparable<T>> {

    private class Node {
        T value;
        Node left;
        Node right;

        Node(T value) {
            this.value = value;
        }
    }

    private Node root;

    public BinaryTree(T rootValue) {
        root = new Node(rootValue);
    }

    private BinaryTree(Node root) {
        this.root = root;
    }

    /**
     * add element to tree
     */
    public void add(T element) {
        addElementToNode(element, root);
    }

    private void addElementToNode(T element, Node node) {
        if (node.value.compareTo(element) < 0) {
            if (node.right == null) {
                node.right = new Node(element);
            } else {
                addElementToNode(element, node.right);
            }
        } else {
            if (node.left == null) {
                node.left = new Node(element);
            } else {
                addElementToNode(element, node.left);
            }
        }
    }

    /**
     * retrieve left branch
     */
    public BinaryTree<T> left() {
        return new BinaryTree<>(root.left);
    }

    /**
     * retrieve right branch
     */
    public BinaryTree<T> right() {
        return new BinaryTree<>(root.right);
    }

    /**
     * return value stored at value
     */
    public T value() {
        return root.value;
    }

    public boolean isLeaf() {
        return root.left == null && root.right == null;
    }

}
