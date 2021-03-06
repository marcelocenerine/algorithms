package com.cenerino.algorithms.java.collections;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<K extends Comparable<K>, V> {

    private Node root;

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    public Node put(Node x, K key, V value) {
        if (x == null) return new Node(key,value);

        int cmp = key.compareTo(x.key);

        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;

        x.count = 1 + size(x.left) + size(x.right);
        return x;
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
        root = delete(root, key);
    }

    // Hibbard deletion
    private Node delete(Node x, K key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);

        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left; // no right child
            if (x.left == null) return x.right; // no left child

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
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
        return size() == 0;
    }

    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;
        private int count = 1;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
