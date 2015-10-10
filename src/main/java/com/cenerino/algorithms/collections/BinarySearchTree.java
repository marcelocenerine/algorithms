package com.cenerino.algorithms.collections;

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
        if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;

        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public V get(K key) {
        Node x = root;

        while (x != null) {
            int cmp = key.compareTo(x.key);

            if (cmp < 0) x = x.left;
            if (cmp > 0) x = x.right;
            else return x.value;
        }

        return null;
    }

    public void delete(K key) {
        // ???
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
