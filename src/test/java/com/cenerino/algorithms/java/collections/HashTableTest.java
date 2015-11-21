package com.cenerino.algorithms.java.collections;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class HashTableTest {

    @Test
    public void shouldBeEmpty() {
        HashTable<String, Integer> table = new HashTable<>();

        assertThat(table.isEmpty(), is(true));
        assertThat(table.size(), is(0));
    }

    @Test
    public void shouldAddSingleEntry() {
        HashTable<String, Integer> table = new HashTable<>();
        table.put("one", 1);

        assertThat(table.isEmpty(), is(false));
        assertThat(table.size(), is(1));
    }

    @Test
    public void shouldAddMultipleEntries() {
        HashTable<String, Integer> table = new HashTable<>();

        for (int i = 0; i < 500; i++) {
            table.put(String.valueOf(i), i);
        }

        assertThat(table.size(), is(500));
    }

    @Test
    public void shouldContainKeys() {
        HashTable<String, Integer> table = new HashTable<>();
        table.put("one", 1);
        table.put("two", 2);
        table.put("three", 3);

        assertThat(table.containsKey("one"), is(true));
        assertThat(table.containsKey("two"), is(true));
        assertThat(table.containsKey("three"), is(true));
    }

    @Test
    public void shouldNotContainKeys() {
        HashTable<String, Integer> table = new HashTable<>();
        table.put("one", 1);
        table.put("two", 2);
        table.put("three", 3);

        assertThat(table.containsKey("four"), is(false));
        assertThat(table.containsKey("five"), is(false));
        assertThat(table.containsKey("six"), is(false));
    }

    @Test
    public void shouldReturnValue() {
        HashTable<String, Integer> table = new HashTable<>();
        table.put("one", 1);
        table.put("two", 2);

        assertThat(table.get("one"), is(1));
        assertThat(table.get("two"), is(2));
    }

    @Test
    public void shouldNotReturnValue() {
        HashTable<String, Integer> table = new HashTable<>();
        table.put("one", 1);

        assertThat(table.get("two"), is(nullValue()));
        assertThat(table.get("three"), is(nullValue()));
    }


    @Test
    public void shouldAddKeysThatCauseColision() {
        List<String> keys = asList("AaAaAa", "AaAaBB", "AaBBAa", "AaBBBB", "BBAaAa", "BBAaBB", "BBBBAa", "BBBBBB");
        int hashcode = 1952508096;
        HashTable<String, String> table = new HashTable<>();

        for (String key : keys) {
            assertThat(key.hashCode(), is(hashcode));
            table.put(key, key);
        }

        assertThat(table.size(), is(8));

        for (String key : keys) {
            assertThat(table.get(key), is(key));
        }
    }

    @Test
    public void shouldUpdateValueAssociatedWithKey() {
        HashTable<String, String> table = new HashTable<>();
        String oldVal = table.put("key", "val1");

        assertThat(oldVal, is(nullValue()));

        oldVal = table.put("key", "val2");

        assertThat(oldVal, is("val1"));
        assertThat(table.get("key"), is("val2"));
    }

    @Test
    public void shouldRemoveKey() {
        HashTable<String, String> table = new HashTable<>();
        table.put("a", "A");
        table.put("b", "B");
        table.put("c", "C");

        assertThat(table.remove("a"), is(true));
        assertThat(table.remove("b"), is(true));
        assertThat(table.get("c"), is("C"));
        assertThat(table.size(), is(1));
    }

    @Test
    public void shouldNotRemoveKey() {
        HashTable<String, String> table = new HashTable<>();
        table.put("a", "A");
        table.put("b", "B");
        table.put("c", "C");

        assertThat(table.remove("d"), is(false));
        assertThat(table.remove("e"), is(false));
        assertThat(table.remove("f"), is(false));
        assertThat(table.size(), is(3));
    }
}
