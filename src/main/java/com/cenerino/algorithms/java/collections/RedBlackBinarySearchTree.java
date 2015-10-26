package com.cenerino.algorithms.java.collections;

import java.util.LinkedList;
import java.util.Queue;

public class RedBlackBinarySearchTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    public void put(K key, V value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    public Node put(Node h, K key, V value) {
        if (h == null) return new Node(key,value, RED);

        int cmp = key.compareTo(h.key);

        if (cmp < 0) h.left = put(h.left, key, value);
        else if (cmp > 0) h.right = put(h.right, key, value);
        else h.value = value;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h); // lean left
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h); // balance 4-node
        if (isRed(h.left) && isRed(h.right)) flipColors(h); // split 4-node

        h.count = 1 + size(h.left) + size(h.right);
        return h;
    }

    private Node rotateLeft(Node h) {
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.count = h.count;
        h.count = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateRight(Node h) {
        assert isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.count = h.count;
        h.count = size(h.left) + size(h.right) + 1;
        return x;
    }

    private void flipColors(Node h) {
        // h must have opposite color of its two children
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public V get(K key) {
        Node x = root;

        while (x != null) {
            int cmp = key.compareTo(x.key);

            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.value;
        }

        return null;
    }

    public void delete(K key) {
        if (!containsKey(key)) return;

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node delete(Node h, K key) {
        if (key.compareTo(h.key) < 0)  {
            if (!isRed(h.left) && !isRed(h.left.left))
                h = moveRedLeft(h);

            h.left = delete(h.left, key);
        } else {
            if (isRed(h.left))
                h = rotateRight(h);

            if (key.compareTo(h.key) == 0 && (h.right == null))
                return null;

            if (!isRed(h.right) && !isRed(h.right.left))
                h = moveRedRight(h);

            if (key.compareTo(h.key) == 0) {
                Node x = min(h.right);
                h.key = x.key;
                h.value = x.value;
                h.right = deleteMin(h.right);
            } else {
                h.right = delete(h.right, key);
            }
        }

        return balance(h);
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    private Node deleteMin(Node h) {
        if (h.left == null) return null;

        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);

        h.left = deleteMin(h.left);
        return balance(h);
    }

    private Node moveRedLeft(Node h) {
        flipColors(h);

        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }

        return h;
    }

    private Node moveRedRight(Node h) {
        flipColors(h);

        if (isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);
        }

        return h;
    }

    private Node balance(Node h) {
        if (isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.count = 1 + size(h.left) + size(h.right);
        return h;
    }

    public Iterable<K> keys() {
        Queue<K> q = new LinkedList<>();
        inOrder(root, q);
        return q;
    }

    private void inOrder(Node x, Queue<K> q) {
        if (x == null) return;
        inOrder(x.left, q);
        q.add(x.key);
        inOrder(x.right, q);
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.count;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean isBalanced() {
        int black = 0; // number of black links on path from root to min
        Node x = root;

        while (x != null) {
            if (!isRed(x)) black++;
            x = x.left;
        }

        return isBalanced(root, black);
    }

    // does every path from the root to a leaf have the given number of black links?
    private boolean isBalanced(Node x, int black) {
        if (x == null) return black == 0;

        if (!isRed(x)) black--;

        return isBalanced(x.left, black) && isBalanced(x.right, black);
    }

    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;
        private int count = 1;
        private boolean color;

        public Node(K key, V value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }
}
