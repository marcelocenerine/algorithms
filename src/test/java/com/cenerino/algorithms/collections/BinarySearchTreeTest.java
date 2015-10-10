package com.cenerino.algorithms.collections;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer, String> bst;

    @Before
    public void setUp() {
        bst = new BinarySearchTree<>();
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
        bst.put(1, "one");
        bst.put(2, "two");
        bst.put(3, "three");

        assertThat(bst.size(), is(3));
    }

    @Test
    public void shouldAddNewKey() {
        bst.put(1, "one");
        bst.put(2, "two");

        assertThat(bst.get(1), is("one"));
        assertThat(bst.get(2), is("two"));
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
        bst.put(5, "e");
        bst.put(3, "c");
        bst.put(2, "b");
        bst.put(6, "f");
        bst.put(1, "a");
        bst.put(4, "d");

        int n = 0;
        for (int key : bst.keys()) {
            assertThat(key, is(++n));
        }
    }
}
