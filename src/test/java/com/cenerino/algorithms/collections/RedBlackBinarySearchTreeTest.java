package com.cenerino.algorithms.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RedBlackBinarySearchTreeTest {

    private RedBlackBinarySearchTree<Integer, String> bst;

    @Before
    public void setUp() {
        bst = new RedBlackBinarySearchTree<>();
    }

    @Test
    public void shouldBeEmpty() {
        assertThat(bst.isEmpty(), is(true));
    }

    @Test
    public void shouldSizeOfEmptyTreeBeZero() {
        assertThat(bst.size(), is(0));
    }

    @Test
    public void shouldNotBeEmpty() {
        bst.put(1, "one");

        assertThat(bst.isEmpty(), is(false));
    }

    @Test
    public void shouldReturnSizeOfNonEmptyTree() {
        for (int x = 0; x < 255; x++) {
            bst.put(x, Integer.toString(x));
        }

        assertThat(bst.size(), is(255));
    }

    @Test
    public void shouldOverwriteValueAssociatedWithExistingKey() {
        bst.put(1, "old");
        bst.put(1, "new");

        assertThat(bst.get(1), is("new"));
    }

    @Test
    public void shouldNotChangeSizeWhenExistingKeyGetsOverwritten() {
        bst.put(1, "old");
        bst.put(1, "new");

        assertThat(bst.size(), is(1));
    }

    @Test
    public void shouldReturnKeysInNaturalOrder() {
        for (int x = 100; x > 0; x--) {
            bst.put(x, Integer.toString(x));
        }

        int n = 0;
        for (int key : bst.keys()) {
            assertThat(key, is(++n));
        }
    }

    @Test
    public void shouldBeBalancedAfterManyInsertions() {
        for (int x = (int) Math.pow(2, 10); x > 0; x--) {
            bst.put(x, Integer.toString(x));
        }

        assertThat(bst.isBalanced(), is(true));
    }

    @Test
    public void shouldDeleteKeyWithNoChildren() {
        bst.put(2, "two");
        bst.put(1, "one");
        bst.put(3, "three");

        bst.delete(3);

        assertThat(bst.size(), is(2));
        assertThat(bst.containsKey(3), is(false));
        assertThat(bst.containsKey(1), is(true));
        assertThat(bst.containsKey(2), is(true));
    }

    @Test
    public void shouldDeleteKeyWithOneChild() {
        bst.put(3, "three");
        bst.put(2, "two");
        bst.put(1, "one");

        bst.delete(2);

        assertThat(bst.size(), is(2));
        assertThat(bst.containsKey(2), is(false));
        assertThat(bst.containsKey(1), is(true));
        assertThat(bst.containsKey(3), is(true));
    }

    @Test
    public void shouldDeleteKeyWithTwoChildren() {
        bst.put(2, "two");
        bst.put(3, "three");
        bst.put(1, "one");

        bst.delete(2);

        assertThat(bst.size(), is(2));
        assertThat(bst.containsKey(2), is(false));
        assertThat(bst.containsKey(1), is(true));
        assertThat(bst.containsKey(3), is(true));
    }

    @Test
    public void shouldNotDoAnythingIfDeletedKeyDoesNotExist() {
        bst.put(10, "ten");

        bst.delete(1);

        assertThat(bst.size(), is(1));
    }
}
