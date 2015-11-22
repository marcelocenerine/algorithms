package com.cenerino.algorithms.java.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DoublyLinkedListTest {

    private DoublyLinkedList<String> list;

    @Before
    public void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test
    public void shouldBeEmpty() {
        assertThat(list.size(), is(0));
        assertThat(list.isEmpty(), is(true));
    }

    @Test
    public void shouldAddFirst() {
        list.addFirst("a");
        assertThat(list.getFirst(), is("a"));
        assertThat(list.getLast(), is("a"));

        list.addFirst("b");
        assertThat(list.getFirst(), is("b"));
        assertThat(list.getLast(), is("a"));
    }

    @Test
    public void shouldAddLast() {
        list.addLast("a");
        assertThat(list.getFirst(), is("a"));
        assertThat(list.getLast(), is("a"));

        list.addLast("b");
        assertThat(list.getFirst(), is("a"));
        assertThat(list.getLast(), is("b"));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldFailToReturnFirstIfEmpty() {
        list.getFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldFailToReturnLastIfEmpty() {
        list.getLast();
    }

    @Test
    public void shouldReturnValueByIndex() {
        list.addLast("a");
        list.addLast("b");

        assertThat(list.get(0), is("a"));
        assertThat(list.get(1), is("b"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldFailToReturnValueByIndexIfEmpty() {
        list.get(0);
    }

    @Test
    public void shouldNotBeEmpty() {
        list.addFirst("a");
        list.addLast("a");

        assertThat(list.size(), is(2));
        assertThat(list.isEmpty(), is(false));
    }

    @Test
    public void shouldRemoveFirst() {
        list.addFirst("a");
        list.addFirst("b");

        assertThat(list.removeFirst(), is("b"));
        assertThat(list.size(), is(1));
        assertThat(list.getFirst(), is("a"));
        assertThat(list.getLast(), is("a"));
    }

    @Test
    public void shouldRemoveLast() {
        list.addFirst("a");
        list.addFirst("b");

        assertThat(list.removeLast(), is("a"));
        assertThat(list.size(), is(1));
        assertThat(list.getFirst(), is("b"));
        assertThat(list.getLast(), is("b"));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldFailToRemoveFirstIfEmpty() {
        list.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldFailToRemoveLastIfEmpty() {
        list.removeLast();
    }

    @Test
    public void shouldSizeBeConsistentAfterMultipleAdditionsAndRemovals() {
        int addCount = 0;
        int removalCount = 0;

        for (int i = 1; i <= 100; i++) {
            if (i % 5 == 0) {
                list.removeFirst();
                removalCount++;
                continue;
            }

            if (i % 4 == 0) {
                list.removeLast();
                removalCount++;
                continue;
            }

            if (i % 3 == 0) {
                list.addFirst(String.valueOf(i));
                addCount++;
                continue;
            }

            list.addLast(String.valueOf(i));
            addCount++;
        }

        assertThat(list.size(), is(addCount - removalCount));
    }

    @Test
    public void shouldRemoveByIndex() {
        list.addLast("a");

        assertThat(list.remove(0), is("a"));
        assertThat(list.isEmpty(), is(true));
    }

    @Test
    public void shouldRemoveByIndexFromTheBeginning() {
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");

        assertThat(list.remove(0), is("a"));
        assertThat(list.size(), is(2));
        assertThat(list.getFirst(), is("b"));
    }

    @Test
    public void shouldRemoveByIndexFromTheEnd() {
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");

        assertThat(list.remove(2), is("c"));
        assertThat(list.size(), is(2));
        assertThat(list.getLast(), is("b"));
    }

    @Test
    public void shouldRemoveByIndexFromTheMiddle() {
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");

        assertThat(list.remove(1), is("b"));
        assertThat(list.size(), is(2));
        assertThat(list.getFirst(), is("a"));
        assertThat(list.getLast(), is("c"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldFailToRemoveByIndexIfEmpty() {
        list.remove(0);
    }


    @Test
    public void shouldRemoveByValue() {
        list.addLast("a");

        assertThat(list.remove("a"), is(true));
        assertThat(list.isEmpty(), is(true));
    }

    @Test
    public void shouldRemoveByValueFromTheBeginning() {
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");

        assertThat(list.remove("a"), is(true));
        assertThat(list.size(), is(2));
        assertThat(list.getFirst(), is("b"));
    }

    @Test
    public void shouldRemoveByValueFromTheEnd() {
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");

        assertThat(list.remove("c"), is(true));
        assertThat(list.size(), is(2));
        assertThat(list.getLast(), is("b"));
    }

    @Test
    public void shouldRemoveByValueFromTheMiddle() {
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");

        assertThat(list.remove("b"), is(true));
        assertThat(list.size(), is(2));
        assertThat(list.getFirst(), is("a"));
        assertThat(list.getLast(), is("c"));
    }

    @Test
    public void shouldNotRemoveByValue() {
        list.addLast("a");
        list.addLast("b");

        assertThat(list.remove("c"), is(false));
        assertThat(list.size(), is(2));
    }

    @Test
    public void shouldIterateThroughItems() {
        for (int x = 0; x < 50; x++) {
            list.addLast(String.valueOf(x));
        }

        Iterator<String> it = list.iterator();
        int count = 0;

        while (it.hasNext()) {
            assertThat(it.next(), is(String.valueOf(count++)));
        }

        assertThat(count, is(50));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldFailIfNextIsCalledOnIteratorWithNoMoreElements() {
        list.iterator().next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldFailIfRemoveIsCalledOnIterator() {
        list.iterator().remove();
    }

    @Test
    public void shouldIterateThroughItemsInReverseOrder() {
        for (int x = 0; x < 50; x++) {
            list.addLast(String.valueOf(x));
        }

        Iterator<String> it = list.reverseIterator();
        int count = 50;

        while (it.hasNext()) {
            assertThat(it.next(), is(String.valueOf(--count)));
        }

        assertThat(count, is(0));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldFailIfNextIsCalledOnReverseIteratorWithNoMoreElements() {
        list.reverseIterator().next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldFailIfRemoveIsCalledOnReverseIterator() {
        list.reverseIterator().remove();
    }
}
