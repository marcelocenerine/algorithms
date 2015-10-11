package com.cenerino.algorithms.collections;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
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
}
