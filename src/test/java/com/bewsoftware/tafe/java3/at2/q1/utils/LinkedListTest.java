/*
 *  File Name:    LinkedListTest.java
 *  Project Name: Java3AT2Q1
 *
 *  Copyright (c) 2021 Bradley Willcott
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * ****************************************************************
 * Name: Bradley Willcott
 * ID:   M198449
 * Date: 22 July 2021
 * ****************************************************************
 */
package com.bewsoftware.tafe.java3.at2.q1.utils;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the {@linkplain LinkedList } class.
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
 *
 * @since 1.0
 * @version 1.0
 */
public class LinkedListTest {

    /**
     * Source data for testing.
     */
    private static final String[] NAMES =
    {
        "Fred Smith", "Peter Rand", "Anne Davidson", "Howard Hughes",
        "River Stone", "Margaret Thatcher", "Neville Young", "Jenny Rose"
    };

    /**
     * Globally accessible linked list.
     * <p>
     * Duplicates allowed.
     */
    private static LinkedList<String> linkedList;

    /**
     * Globally accessible linked list.
     * <p>
     * Duplicates NOT allowed.
     */
    private static LinkedList<String> linkedList2;

    @BeforeAll
    public static void setUpClass() {
        // Instantiate linked lists
        linkedList = new LinkedList<>();
        linkedList2 = new LinkedList<>(false);
    }

    @AfterAll
    public static void tearDownClass() {
        // just something to do
        linkedList.clear();
        linkedList2.clear();
    }

    public LinkedListTest() {
    }

    @BeforeEach
    public void setUp() {
        for (int i = 0; i < 4; i++)
        {
            linkedList.append(NAMES[i]);
        }

        for (int i = 0; i < 4; i++)
        {
            linkedList2.append(NAMES[i]);
        }
    }

    @AfterEach
    public void tearDown() {
        linkedList.clear();
        linkedList2.clear();
    }

    /**
     * Test of append method, of class LinkedList.
     */
    @Test
    public void testAppend() {
        int count = linkedList.size();

        linkedList.append(NAMES[5]);
        assertEquals(count + 1, linkedList.size(),
                     "linkedList - Internal count is wrong: " + count + 1 + " ~ " + linkedList.size());

        count = linkedList2.size();

        linkedList2.append(NAMES[5]);
        assertEquals(count + 1, linkedList2.size(),
                     "linkedList2 - Internal count is wrong: " + count + 1 + " ~ " + linkedList2.size());
    }

    /**
     * Test of append method, of class LinkedList.
     */
    @Test
    public void testAppendDuplicate() {
        int count = linkedList.size();

        linkedList.append(NAMES[1]);
        assertEquals(count + 1, linkedList.size(),
                     "linkedList - Internal count is wrong: " + count + 1 + " ~ " + linkedList.size());

        count = linkedList2.size();

        linkedList2.append(NAMES[1]);
        assertEquals(count, linkedList2.size(),
                     "linkedList2 - Internal count is wrong: " + count + " ~ " + linkedList2.size());
    }

    /**
     * Test of clear method, of class LinkedList.
     */
    @Test
    public void testClear() {
        linkedList.clear();
        assertEquals(0, linkedList.size(),
                     "linkedList - Internal count is wrong: 0 ~ " + linkedList.size());

        linkedList.clear();
        assertEquals(0, linkedList.size(),
                     "linkedList2 - Internal count is wrong: 0 ~ " + linkedList.size());
    }

    /**
     * Test of contains method, of class LinkedList.
     */
    @Test
    public void testContains() {
        assertTrue(linkedList.contains(NAMES[2]), "linkedList - Can't find NAMES[2]");
        assertTrue(linkedList2.contains(NAMES[2]), "linkedList2 - Can't find NAMES[2]");
    }

    /**
     * Test of size method, of class LinkedList.
     */
    @Test
    public void testDuplicateSize() {
        int count = linkedList.size();
        linkedList.append(NAMES[1]);
        assertEquals(count + 1, linkedList.size(),
                     "linkedList - Internal count is wrong: " + (count + 1) + " ~ " + linkedList.size());

        count = linkedList2.size();
        linkedList2.append(NAMES[1]);
        assertEquals(count, linkedList2.size(),
                     "linkedList2 - Internal count is wrong: " + count + " ~ " + linkedList2.size());
    }

    /**
     * Test of first method, of class LinkedList.
     */
    @Test
    public void testFirst() {
        assertNotNull(linkedList.first(), "linkedList - No first item returned");
        assertNotNull(linkedList2.first(), "linkedList2 - No first item returned");
    }

    /**
     * Test of hasNext method, of class LinkedList.
     */
    @Test
    public void testHasNext() {
        linkedList.first();
        assertTrue(linkedList.hasNext(), "linkedList - hasNext() failed");

        linkedList2.first();
        assertTrue(linkedList2.hasNext(), "linkedList2 - hasNext() failed");
    }

    /**
     * Test of insert method, of class LinkedList.
     */
    @Test
    public void testInsert() {
        int count = linkedList.size();
        linkedList.contains(NAMES[3]);
        linkedList.insert(NAMES[6]);
        assertEquals(count + 1, linkedList.size(),
                     "linkedList - Internal count is wrong: " + count + 1 + " ~ " + linkedList.size());

        count = linkedList2.size();
        linkedList2.contains(NAMES[3]);
        linkedList2.insert(NAMES[6]);
        assertEquals(count + 1, linkedList2.size(),
                     "linkedList2 - Internal count is wrong: " + count + 1 + " ~ " + linkedList2.size());
    }

    /**
     * Test of insertAfter method, of class LinkedList.
     */
    @Test
    public void testInsertAfter() {
        int count = linkedList.size();
        linkedList.contains(NAMES[2]);
        linkedList.insertAfter(NAMES[4]);
        assertEquals(count + 1, linkedList.size(),
                     "linkedList - Internal count is wrong: " + count + 1 + " ~ " + linkedList.size());

        count = linkedList2.size();
        linkedList2.contains(NAMES[2]);
        linkedList2.insertAfter(NAMES[4]);
        assertEquals(count + 1, linkedList2.size(),
                     "linkedList2 - Internal count is wrong: " + count + 1 + " ~ " + linkedList2.size());
    }

    /**
     * Test of insert method, of class LinkedList.
     */
    @Test
    public void testInsertDuplicate() {
        int count = linkedList.size();
        linkedList.contains(NAMES[3]);
        linkedList.insert(NAMES[2]);
        assertEquals(count + 1, linkedList.size(),
                     "linkedList - Internal count is wrong: " + count + 1 + " ~ " + linkedList.size());

        count = linkedList2.size();
        linkedList2.contains(NAMES[3]);
        linkedList2.insert(NAMES[2]);
        assertEquals(count, linkedList2.size(),
                     "linkedList2 - Internal count is wrong: " + count + " ~ " + linkedList2.size());
    }

    /**
     * Test of insertAfter method, of class LinkedList.
     */
    @Test
    public void testInsertDuplicateAfter() {
        int count = linkedList.size();
        linkedList.contains(NAMES[2]);
        linkedList.insertAfter(NAMES[1]);
        assertEquals(count + 1, linkedList.size(),
                     "linkedList - Internal count is wrong: " + count + 1 + " ~ " + linkedList.size());

        count = linkedList2.size();
        linkedList2.contains(NAMES[2]);
        linkedList2.insertAfter(NAMES[1]);
        assertEquals(count, linkedList2.size(),
                     "linkedList2 - Internal count is wrong: " + count + " ~ " + linkedList2.size());
    }

    /**
     * Test of last method, of class LinkedList.
     */
    @Test
    public void testLast() {
        assertNotNull(linkedList.last(), "linkedList - last should not be null");
        assertNotNull(linkedList2.last(), "linkedList2 - last should not be null");
    }

    /**
     * Test of next method, of class LinkedList.
     */
    @Test
    public void testNext_0args() {
        linkedList.first();
        assertNotNull(linkedList.next(), "linkedList - No String returned");

        linkedList2.first();
        assertNotNull(linkedList2.next(), "linkedList2 - No String returned");
    }

    /**
     * Test of next method, of class LinkedList.
     */
    @Test
    public void testNext_GenericType() {
        linkedList.append(NAMES[1]);
        linkedList.contains(NAMES[1]);
        assertTrue(linkedList.next(NAMES[1]), "linkedList - Couldn't find second record");

        linkedList2.append(NAMES[1]);
        linkedList2.contains(NAMES[1]);
        assertTrue(linkedList2.next(NAMES[1]), "linkedList2 - Couldn't find second record");
    }

    /**
     * Test of pop method, of class LinkedList.
     */
    @Test
    public void testPop() {
        String value = linkedList.pop();
        assertNotNull(value, "pop() return null");
        assertTrue(value.compareTo(NAMES[0]) == 0, "linkedList - Returned wrong string");

        value = linkedList2.pop();
        assertNotNull(value, "pop() return null");
        assertTrue(value.compareTo(NAMES[0]) == 0, "linkedList2 - Returned wrong string");
    }

    /**
     * Test of prev method, of class LinkedList.
     */
    @Test
    public void testPrev() {
        linkedList.last();
        assertNotNull(linkedList.prev(), "linkedList - prev() returned null");

        linkedList2.last();
        assertNotNull(linkedList2.prev(), "linkedList2 - prev() returned null");
    }

    /**
     * Test of pull method, of class LinkedList.
     */
    @Test
    public void testPull() {
        assertNotNull(linkedList.pull(), "linkedList - pull() returned null");
        assertNotNull(linkedList2.pull(), "linkedList2 - pull() returned null");
    }

    /**
     * Test of push method, of class LinkedList.
     */
    @Test
    public void testPush() {
        int count = linkedList.size();
        linkedList.push(NAMES[4]);
        assertEquals(count + 1, linkedList.size(),
                     "linkedList - Internal count is wrong: " + (count + 1) + " ~ " + linkedList.size());

        count = linkedList2.size();
        linkedList2.push(NAMES[4]);
        assertEquals(count + 1, linkedList2.size(),
                     "linkedList2 - Internal count is wrong: " + (count + 1) + " ~ " + linkedList2.size());
    }

    /**
     * Test of push method, of class LinkedList.
     */
    @Test
    public void testPushDuplicate() {
        int count = linkedList.size();
        linkedList.push(NAMES[0]);
        assertEquals(count + 1, linkedList.size(),
                     "linkedList - Internal count is wrong: " + (count + 1) + " ~ " + linkedList.size());

        count = linkedList2.size();
        linkedList2.push(NAMES[0]);
        assertEquals(count, linkedList2.size(),
                     "linkedList2 - Internal count is wrong: " + count + " ~ " + linkedList2.size());
    }

    /**
     * Test of remove method, of class LinkedList.
     */
    @Test
    public void testRemove() {
        int count = linkedList.size();
        linkedList.contains(NAMES[2]);
        String item = linkedList.remove();
        assertNotNull(item, "linkedList - remove returned null");
        assertEquals(count - 1, linkedList.size(),
                     "linkedList - Internal count is wrong: " + (count - 1) + " ~ " + linkedList.size());

        count = linkedList2.size();
        linkedList2.contains(NAMES[2]);
        item = linkedList2.remove();
        assertNotNull(item, "linkedList2 - remove returned null");
        assertEquals(count - 1, linkedList2.size(),
                     "linkedList2 - Internal count is wrong: " + (count - 1) + " ~ " + linkedList2.size());
    }

    /**
     * Test of remove method, of class LinkedList.
     */
    @Test
    public void testRemoveWithDuplicate() {
        int count = linkedList.size();
        linkedList.append(NAMES[2]);
        linkedList.contains(NAMES[2]);
        String item = linkedList.remove();
        assertNotNull(item, "linkedList - remove returned null");
        assertEquals(count, linkedList.size(),
                     "linkedList - Internal count is wrong: " + count + " ~ " + linkedList.size());

        count = linkedList2.size();
        linkedList2.append(NAMES[2]);
        linkedList2.contains(NAMES[2]);
        item = linkedList2.remove();
        assertNotNull(item, "linkedList2 - remove returned null");
        assertEquals(count - 1, linkedList2.size(),
                     "linkedList2 - Internal count is wrong: " + (count - 1) + " ~ " + linkedList2.size());
    }

    /**
     * Test of size method, of class LinkedList.
     */
    @Test
    public void testSize() {
        int count = linkedList.size();
        linkedList.append(NAMES[7]);
        assertEquals(count + 1, linkedList.size(),
                     "linkedList - Internal count is wrong: " + (count + 1) + " ~ " + linkedList.size());

        count = linkedList2.size();
        linkedList2.append(NAMES[7]);
        assertEquals(count + 1, linkedList2.size(),
                     "linkedList2 - Internal count is wrong: " + (count + 1) + " ~ " + linkedList2.size());
    }

    /**
     * Test of toString method, of class LinkedList.
     */
    @Test
    public void testToString() {
        assertTrue(linkedList.toString().length() > 0, "linkedList - toString failed");
        assertTrue(linkedList2.toString().length() > 0, "linkedList2 - toString failed");
    }
}
