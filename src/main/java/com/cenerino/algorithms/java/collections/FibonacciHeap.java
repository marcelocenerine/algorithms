package com.cenerino.algorithms.java.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Imported from the JGraphT library: https://github.com/jgrapht/jgrapht/blob/master/jgrapht-core/src/main/java/org/jgrapht/util/FibonacciHeap.java
 * to be used in the DijkstraShortestPath algorithm
 */
public class FibonacciHeap<T> {

    private static final double oneOverLogPhi = 1.0 / Math.log((1.0 + Math.sqrt(5.0)) / 2.0);
    private FibonacciHeapNode<T> minNode;
    private int nNodes;

    public boolean isEmpty() {
        return minNode == null;
    }

    public void clear() {
        minNode = null;
        nNodes = 0;
    }

    public void decreaseKey(FibonacciHeapNode<T> x, double k) {
        if (k > x.key) throw new IllegalArgumentException("decreaseKey() got larger key value. Current key: " + x.key + " new key: " + k);

        x.key = k;

        FibonacciHeapNode<T> y = x.parent;

        if ((y != null) && (x.key < y.key)) {
            cut(x, y);
            cascadingCut(y);
        }

        if (x.key < minNode.key) {
            minNode = x;
        }
    }

    public void delete(FibonacciHeapNode<T> x) {
        decreaseKey(x, Double.NEGATIVE_INFINITY);
        removeMin();
    }

    public void insert(FibonacciHeapNode<T> node, double key) {
        node.key = key;

        // concatenate node into min list
        if (minNode != null) {
            node.left = minNode;
            node.right = minNode.right;
            minNode.right = node;
            node.right.left = node;

            if (key < minNode.key) {
                minNode = node;
            }
        } else {
            minNode = node;
        }

        nNodes++;
    }

    public FibonacciHeapNode<T> min() {
        return minNode;
    }

    public FibonacciHeapNode<T> removeMin() {
        FibonacciHeapNode<T> z = minNode;

        if (z != null) {
            int numKids = z.degree;
            FibonacciHeapNode<T> x = z.child;
            FibonacciHeapNode<T> tempRight;

            while (numKids > 0) {
                tempRight = x.right;

                // remove x from child list
                x.left.right = x.right;
                x.right.left = x.left;

                // add x to root list of heap
                x.left = minNode;
                x.right = minNode.right;
                minNode.right = x;
                x.right.left = x;

                // set parent[x] to null
                x.parent = null;
                x = tempRight;
                numKids--;
            }

            // remove z from root list of heap
            z.left.right = z.right;
            z.right.left = z.left;

            if (z == z.right) {
                minNode = null;
            } else {
                minNode = z.right;
                consolidate();
            }

            // decrement size of heap
            nNodes--;
        }

        return z;
    }

    public int size() {
        return nNodes;
    }

    private void cascadingCut(FibonacciHeapNode<T> y) {
        FibonacciHeapNode<T> z = y.parent;

        // if there's a parent...
        if (z != null) {
            // if y is unmarked, set it marked
            if (!y.mark) {
                y.mark = true;
            } else {
                // it's marked, cut it from parent
                cut(y, z);

                // cut its parent as well
                cascadingCut(z);
            }
        }
    }

    private void consolidate() {
        int arraySize = ((int) Math.floor(Math.log(nNodes) * oneOverLogPhi)) + 1;

        List<FibonacciHeapNode<T>> array = new ArrayList<>(arraySize);

        // Initialize degree array
        for (int i = 0; i < arraySize; i++) {
            array.add(null);
        }

        // Find the number of root nodes.
        int numRoots = 0;
        FibonacciHeapNode<T> x = minNode;

        if (x != null) {
            numRoots++;
            x = x.right;

            while (x != minNode) {
                numRoots++;
                x = x.right;
            }
        }

        while (numRoots > 0) {
            // Access this node's degree..
            int d = x.degree;
            FibonacciHeapNode<T> next = x.right;

            // ..and see if there's another of the same degree.
            for (; ; ) {
                FibonacciHeapNode<T> y = array.get(d);
                if (y == null) {
                    // Nope.
                    break;
                }

                // There is, make one of the nodes a child of the other. Do this based on the key value.
                if (x.key > y.key) {
                    FibonacciHeapNode<T> temp = y;
                    y = x;
                    x = temp;
                }

                // FibonacciHeapNode<T> y disappears from root list.
                link(y, x);

                // We've handled this degree, go to next one.
                array.set(d, null);
                d++;
            }

            // Save this node for later when we might encounter another
            // of the same degree.
            array.set(d, x);

            // Move forward through list.
            x = next;
            numRoots--;
        }

        // Set min to null (effectively losing the root list) and reconstruct the root list from the array entries in array[].
        minNode = null;

        for (int i = 0; i < arraySize; i++) {
            FibonacciHeapNode<T> y = array.get(i);
            if (y == null) continue;

            // We've got a live one, add it to root list.
            if (minNode != null) {
                // First remove node from root list.
                y.left.right = y.right;
                y.right.left = y.left;

                // Now add to root list, again.
                y.left = minNode;
                y.right = minNode.right;
                minNode.right = y;
                y.right.left = y;

                // Check if this is a new min.
                if (y.key < minNode.key) {
                    minNode = y;
                }
            } else {
                minNode = y;
            }
        }
    }

    private void cut(FibonacciHeapNode<T> x, FibonacciHeapNode<T> y) {
        // remove x from childlist of y and decrement degree[y]
        x.left.right = x.right;
        x.right.left = x.left;
        y.degree--;

        // reset y.child if necessary
        if (y.child == x) y.child = x.right;
        if (y.degree == 0) y.child = null;

        // add x to root list of heap
        x.left = minNode;
        x.right = minNode.right;
        minNode.right = x;
        x.right.left = x;

        // set parent[x] to nil
        x.parent = null;

        // set mark[x] to false
        x.mark = false;
    }

    private void link(FibonacciHeapNode<T> y, FibonacciHeapNode<T> x) {
        // remove y from root list of heap
        y.left.right = y.right;
        y.right.left = y.left;

        // make y a child of x
        y.parent = x;

        if (x.child == null) {
            x.child = y;
            y.right = y;
            y.left = y;
        } else {
            y.left = x.child;
            y.right = x.child.right;
            x.child.right = y;
            y.right.left = y;
        }

        // increase degree[x]
        x.degree++;

        // set mark[y] false
        y.mark = false;
    }

    public static class FibonacciHeapNode<T> {

        private boolean mark;
        private T data;
        private FibonacciHeapNode<T> child;
        private FibonacciHeapNode<T> left;
        private FibonacciHeapNode<T> parent;
        private FibonacciHeapNode<T> right;
        private double key;
        private int degree;

        public FibonacciHeapNode(T data) {
            right = this;
            left = this;
            this.data = data;
        }

        public final double getKey() {
            return key;
        }

        public final T getData() {
            return data;
        }
    }
}
