package Homework5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/**
 * Class: CourseHashMap
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 4/21/2021
 * <p>
 * This class:
 * <p>
 * Purpose:
 */

public class CourseHashMap<Integer, Course> implements MyMap<Integer, Course> {
    // Define the default hash table size. Must be a power of 2
    private static int DEFAULT_INITIAL_CAPACITY = 4;

    // Define the maximum hash table size. 1 << 30 is same as 2^30
    private static int MAXIMUM_CAPACITY = 1 << 30;
    // Define default load factor
    private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;
    // Hash table is an array with each cell that is a linked list
    LinkedList<Entry<Integer, Course>>[] table;
    // Current hash table capacity. Capacity is a power of 2
    private int capacity;
    // Specify a load factor used in the hash table
    private float loadFactorThreshold;
    // The number of entries in the map
    private int size = 0;

    /**
     * Construct a map with the default capacity and load factor
     */
    public CourseHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }

    /**
     * Construct a map with the specified initial capacity and
     * default load factor
     */
    public CourseHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
    }

    /**
     * Construct a map with the specified initial capacity
     * and load factor
     */
    public CourseHashMap(int initialCapacity, float loadFactorThreshold) {
        if (initialCapacity > MAXIMUM_CAPACITY)
            this.capacity = MAXIMUM_CAPACITY;
        else
            this.capacity = trimToPowerOf2(initialCapacity);

        this.loadFactorThreshold = loadFactorThreshold;
        table = new LinkedList[capacity];
    }

    /**
     * Ensure the hashing is evenly distributed
     */
    private static int supplementalHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int trimToPowerOf2(int initialCapacity) {
        int capacity = 1;
        while (capacity < initialCapacity) {
            capacity <<= 1;
        }

        return capacity;
    }

    /**
     * Remove all of the entries from this map
     */
    public void clear() {
        size = 0;
        removeEntries();
    }

    private void removeEntries() {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                table[i].clear();
            }
        }
    }

    /**
     * Return true if the specified key is in the map
     */
    public boolean containsKey(Integer key) {
        return get(key) != null;
    }

    /**
     * Return true if this map contains the value
     */
    public boolean containsValue(Course value) {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                LinkedList<Entry<Integer, Course>> bucket = table[i];
                for (MyMap.Entry<Integer, Course> entry : bucket)
                    if (entry.getValue().equals(value))
                        return true;
            }
        }

        return false;
    }

    /**
     * Return a set of entries in the map
     *
     * @return
     */
    public Set<Entry<Integer, Course>> entrySet() {
        Set<Entry<Integer, Course>> set =
                new HashSet<Entry<Integer, Course>>();

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                LinkedList<Entry<Integer, Course>> bucket = table[i];
                for (Entry<Integer, Course> entry : bucket)
                    set.add(entry);
            }
        }
        return set;
    }

    /**
     * Return the value that matches the specified key
     */
    public Course get(Integer key) {
        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] != null) {
            LinkedList<Entry<Integer, Course>> bucket = table[bucketIndex];
            for (Entry<Integer, Course> entry : bucket)
                if (entry.getKey().equals(key))
                    return entry.getValue();
        }
        return null;
    }

    /**
     * Hash function
     */
    private int hash(int hashCode) {
        return supplementalHash(hashCode) & (capacity - 1);
    }

    /**
     * Return true if this map contains no entries
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return a set consisting of the keys in this map
     */
    public Set<Integer> keySet() {
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                LinkedList<Entry<Integer, Course>> bucket = table[i];
                for (Entry<Integer, Course> entry : bucket)
                    set.add(entry.getKey());
            }
        }
        return set;
    }

    /**
     * Add an entry (key, value) into the map
     */
    public Course put(Integer key, Course value) {
        if (get(key) != null) { // The key is already in the map
            int bucketIndex = hash(key.hashCode());
            LinkedList<Entry<Integer, Course>> bucket = table[bucketIndex];
            for (Entry<Integer, Course> entry : bucket)
                if (entry.getKey().equals(key)) {
                    Course oldValue = entry.getValue();
                    // Replace old value with new value
                    entry.value = value;
                    // Return the old value for the key
                    return oldValue;
                }
        }

        // Check load factor
        if (size >= capacity * loadFactorThreshold) {
            if (capacity == MAXIMUM_CAPACITY)
                throw new RuntimeException("Exceeding maximum capacity");

            rehash();
        }

        int bucketIndex = hash(key.hashCode());

        // Create a linked list for the bucket if it is not created
        if (table[bucketIndex] == null) {
            table[bucketIndex] = new LinkedList<Entry<Integer, Course>>();
        }

        // Add a new entry (key, value) to hashTable[index]
        table[bucketIndex].add(new Entry<Integer, Course>(key, value));

        size++; // Increase size

        return value;
    }

    /**
     * Rehash the map
     */
    private void rehash() {
        Set<Entry<Integer, Course>> set = entrySet(); // Get entries
        capacity <<= 1; // Double capacity
        table = new LinkedList[capacity]; // Create a new hash table
        size = 0; // Reset size to 0

        for (Entry<Integer, Course> entry : set) {
            put(entry.getKey(), entry.getValue()); // Store to new table
        }
    }

    /**
     * Remove the entries for the specified key
     */
    public void remove(Integer key) {
        int bucketIndex = hash(key.hashCode());

        // Remove the first entry that matches the key from a bucket
        if (table[bucketIndex] != null) {
            LinkedList<Entry<Integer, Course>> bucket = table[bucketIndex];
            for (Entry<Integer, Course> entry : bucket)
                if (entry.getKey().equals(key)) {
                    bucket.remove(entry);
                    size--; // Decrease size
                    break; // Remove just one entry that matches the key
                }
        }
    }

    /**
     * Return the number of entries in this map
     */
    public int size() {
        return size;
    }

    /**
     * Return a set consisting of the values in this map
     */
    public Set<Course> values() {
        Set<Course> set = new HashSet<>();

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                LinkedList<Entry<Integer, Course>> bucket = table[i];
                for (Entry<Integer, Course> entry : bucket)
                    set.add(entry.getValue());
            }
        }
        return set;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null && table[i].size() > 0)
                for (Entry<Integer, Course> entry : table[i])
                    builder.append(entry);
        }

        builder.append("]");
        return builder.toString();
    }
}
