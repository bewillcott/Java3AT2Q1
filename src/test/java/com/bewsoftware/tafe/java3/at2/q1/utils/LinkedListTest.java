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
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
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
     */
    private static LinkedList<String> linkedList;

    @BeforeAll
    public static void setUpClass() {
        // Instantiate linked list
        linkedList = new LinkedList<>();
    }

    @AfterAll
    public static void tearDownClass() {
        // just something to do
        linkedList.clear();
    }

    public LinkedListTest() {
    }

    @BeforeEach
    public void setUp() {
        for (int i = 0; i < 4; i++)
        {
            linkedList.append(NAMES[i]);
        }
    }

    @AfterEach
    public void tearDown() {
        linkedList.clear();
    }

    /**
     * Test of append method, of class LinkedList.
     */
    @Test
    public void testAppend() {
        int count = linkedList.size();

        linkedList.append(NAMES[5]);
        assertEquals(count + 1, linkedList.size(),
                     "Internal count is wrong: " + count + 1 + " ~ " + linkedList.size());
    }

    /**
     * Test of clear method, of class LinkedList.
     */
    @Test
    public void testClear() {
        linkedList.clear();
        assertEquals(0, linkedList.size(),
                     "Internal count is wrong: 0 ~ " + linkedList.size());
    }

    /**
     * Test of contains method, of class LinkedList.
     */
    @Test
    public void testContains() {
        assertTrue(linkedList.contains(NAMES[2]), "Can't find NAMES[2]");
    }

    /**
     * Test of first method, of class LinkedList.
     */
    @Test
    public void testFirst() {
        assertNotNull(linkedList.first(), "No first item returned");
    }

    /**
     * Test of hasNext method, of class LinkedList.
     */
    @Test
    public void testHasNext() {
        linkedList.first();
        assertTrue(linkedList.hasNext(), "hasNext() failed");
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
                     "Internal count is wrong: " + count + 1 + " ~ " + linkedList.size());
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
                     "Internal count is wrong: " + count + 1 + " ~ " + linkedList.size());
    }

    /**
     * Test of last method, of class LinkedList.
     */
    @Test
    public void testLast() {
        assertNotNull(linkedList.last(), "last should not be null");
    }

    /**
     * Test of next method, of class LinkedList.
     */
    @Test
    public void testNext_0args() {
        linkedList.first();
        assertNotNull(linkedList.next(), "No String returned");
    }

    /**
     * Test of next method, of class LinkedList.
     */
    @Test
    public void testNext_GenericType() {
        linkedList.append(NAMES[1]);
        linkedList.contains(NAMES[1]);
        assertTrue(linkedList.next(NAMES[1]), "Couldn't find second record");
    }

    /**
     * Test of pop method, of class LinkedList.
     */
    @Test
    public void testPop() {
        String value = linkedList.pop();

        assertNotNull(value, "pop() return null");
        assertTrue(value.compareTo(NAMES[0]) == 0, "Returned wrong string");
    }

    /**
     * Test of prev method, of class LinkedList.
     */
    @Test
    public void testPrev() {
        linkedList.last();
        assertNotNull(linkedList.prev(), "prev() returned null");
    }

    /**
     * Test of pull method, of class LinkedList.
     */
    @Test
    public void testPull() {
        assertNotNull(linkedList.pull(), "pull() returned null");
    }

    /**
     * Test of push method, of class LinkedList.
     */
    @Test
    public void testPush() {
        int count = linkedList.size();
        linkedList.push(NAMES[4]);
        assertEquals(count + 1, linkedList.size(),
                     "Internal count is wrong: " + count + 1 + " ~ " + linkedList.size());
    }

    /**
     * Test of remove method, of class LinkedList.
     */
    @Test
    public void testRemove() {
        int count = linkedList.size();
        linkedList.contains(NAMES[2]);
        String item = linkedList.remove();
        assertNotNull(item, "remove returned null");
        assertEquals(count - 1, linkedList.size(),
                     "Internal count is wrong: " + count + 1 + " ~ " + linkedList.size());
    }

    /**
     * Test of size method, of class LinkedList.
     */
    @Test
    public void testSize() {
        int count = linkedList.size();
        linkedList.append(NAMES[7]);
        assertEquals(count + 1, linkedList.size());
    }

    /**
     * Test of toString method, of class LinkedList.
     */
    @Test
    public void testToString() {
        assertTrue(linkedList.toString().length() > 0, "toString failed");
    }
}
