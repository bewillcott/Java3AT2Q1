/*
 *  File Name:    LinkedList.java
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

import java.util.Objects;

/**
 * This is an implementation of a Doubly Linked List.
 * <p>
 * <b>Note:</b> <i>This implementation does not allow {@code null } items to be added.</i>
 *
 * @param <E> the type of elements held in this list
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
 *
 * @since 1.0
 * @version 1.0
 */
public class LinkedList<E extends Comparable<E>> {

    /**
     * Error message to go with {@link NullPointerException}
     */
    private static final String NO_NULL = "This implementation does not allow {@code null} items to be added.";

    /**
     * The node that was last retrieved by one of the traversal methods.
     */
    private Node<E> current;

    /**
     * The first node in the chain.
     */
    private Node<E> first;

    /**
     * The last node in the chain.
     */
    private Node<E> last;

    /**
     * The number of nodes/items in the chain.
     */
    private int size = 0;

    /**
     * Instantiate an empty default list object.
     */
    public LinkedList() {
        // Intensionally empty.
    }

    /**
     * Add a new item to the bottom of the list.
     * <p>
     * This item becomes the current reference point in the list.
     * <p>
     * <b>Note:</b> This implementation does not allow {@code null } items to be added.
     *
     * @param item to add
     *
     * @throws NullPointerException if item is {@code null}
     */
    public void append(E item) {
        Node<E> node = new Node<>(Objects.requireNonNull(item, NO_NULL));

        // Is the list empty?
        if (last == null)
        {
            // Yes - add first node
            first = node;
            last = node;
            current = node;
        } else
        {
            // No - add node to tail of chain
            node.previous = last;
            last.next = node;
            last = node;
        }

        current = node;
        size++;
    }

    /**
     * Reset this list to an empty list.
     */
    public void clear() {
        current = null;
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Searches for the first occurrence of the item in the list.
     * <p>
     * If found, this becomes the current reference point in the list.
     *
     * @param item to search for
     *
     * @return {@code true } if found, {@code false } otherwise
     *
     * @throws NullPointerException if item is {@code null}
     */
    public boolean contains(E item) {
        Objects.requireNonNull(item, NO_NULL);

        boolean rtn = false;
        current = first;

        // While we have something to work with
        while (current != null)
        {
            // Have we found one?
            if (current.item.compareTo(item) == 0)
            { // Yes - return true
                rtn = true;
                break;
            } else
            { // No - pointer to the next node
                current = current.next;
            }
        }

        return rtn;
    }

    /**
     * Retrieves the first item in the list.
     * <p>
     * If found, this becomes the current reference point in the list.
     *
     * @return the item at the top of the list, or {@code null } if the list is empty
     */
    public E first() {
        current = first;
        return (first != null) ? first.item : null;
    }

    /**
     * Returns {@code true } if there is other item following the current one,
     * {@code false } otherwise.
     *
     * @return {@code true } if there is other item following the current one,
     *         {@code false } otherwise
     */
    public boolean hasNext() {
        return (current != null && current.next != null);
    }

    /**
     * Inserts the item before the current reference point.
     * <p>
     * If the current reference is not within the list, then the item
     * will be pushed onto the top of the list.
     *
     * @param item to be inserted
     *
     * @throws NullPointerException if item is {@code null}
     */
    public void insert(E item) {

        // Are we out of bounds or pointing at the top?
        if (current == null || current.previous == null)
        { // Yes
            push(item);

        } else
        { // No - so we insert it before the current node
            Node<E> node = new Node<>(Objects.requireNonNull(item, NO_NULL));

            // point node to previous node
            node.previous = current.previous;
            // point current node to node
            current.previous = node;

            // point previous node to node
            node.previous.next = node;
            // point node to next node
            node.next = current;

            // point current reference pointer to node
            current = node;
            size++;
        }
    }

    /**
     * Inserts the item after the current reference point.
     * <p>
     * If the current reference is not within the list, then the item
     * will be appended onto the bottom of the list.
     *
     * @param item to be inserted
     *
     * @throws NullPointerException if item is {@code null}
     */
    public void insertAfter(E item) {

        // Are we out of bounds or pointing at the top?
        if (current == null || current.next == null)
        { // Yes
            append(item);

        } else
        { // No - so we insert it before the current node
            Node<E> node = new Node<>(Objects.requireNonNull(item, NO_NULL));

            // point node to next node
            node.next = current.next;
            // point current node to node
            current.next = node;

            // point next node to node
            node.next.previous = node;
            // point node to previous node
            node.previous = current;

            // point current reference pointer to node
            current = node;
            size++;
        }
    }

    /**
     * Retrieves the last item in the list.
     * <p>
     * If found, this becomes the current reference point in the list.
     *
     * @return the item at the top of the list, or {@code null } if the list is empty
     */
    public E last() {
        current = last;
        return (last != null) ? last.item : null;
    }

    /**
     * Searches for the next occurrence of the item in the list.
     * <p>
     * The search starts at the current reference point, plus one.
     * <p>
     * If found, this becomes the current reference point in the list.
     *
     * @param item to search for.
     *
     * @return {@code true } if found, {@code false } otherwise
     *
     * @throws NullPointerException if item is {@code null}
     */
    public boolean next(E item) {
        Objects.requireNonNull(item, NO_NULL);

        boolean rtn = false;

        // While we have something to work with
        while (current != null)
        {
            // Have we found one?
            if (current.item.compareTo(item) == 0)
            { // Yes - return true
                rtn = true;
                break;
            } else
            { // No - pointer to the next node
                current = current.next;
            }
        }

        return rtn;
    }

    /**
     * Retrieves the next item from the list.
     * <p>
     * The item retrieved is the one following the last item retrieved
     * or located by this or other traversal methods.
     * <p>
     * If found, this becomes the current reference point in the list.
     *
     * @return the item found, or {@code null } if either past the end of the
     *         list, or the list is empty.
     */
    public E next() {
        E rtn = null;

        // Are we pointing to something?
        if (current != null)
        { // Yes - shift the pointer
            current = current.next;

            // Are we pointing to something now?
            if (current != null)
            { // Yes - get item to return
                rtn = current.item;
            }
        }

        return rtn;
    }

    /**
     * Removes and returns the first item of this list.
     * <p>
     * If successful, the new first item becomes the current reference point in the list.
     *
     * @return the item at the top of the list, or {@code null } if the list is empty
     */
    public E pop() {
        E item = null;

        // Is the list empty?
        if (first != null)
        {
            // No - get item and remove node
            item = first.item;
            first = first.next;

            if (first != null)
            {
                first.previous = null;
            } else
            {
                last = null;
            }

            current = first;
            size--;
        } // Yes - nothing to do

        return item;
    }

    /**
     * Retrieves the previous item from the list.
     * <p>
     * The item retrieved is the one following the last item retrieved
     * or located by this or other traversal methods.
     * <p>
     * If found, this becomes the current reference point in the list.
     *
     * @return the item found, or {@code null } if either past the end of the
     *         list, or the list is empty.
     */
    public E prev() {
        E rtn = null;

        // Are we pointing to something?
        if (current != null)
        { // Yes - shift the pointer
            current = current.previous;

            // Are we pointing to something now?
            if (current != null)
            { // Yes - get item to return
                rtn = current.item;
            }
        }

        return rtn;
    }

    /**
     * Removes and returns the last item of this list.
     * <p>
     * If successful, the new last item becomes the current reference point in the list.
     *
     * @return the item at the bottom of the list, or {@code null } if the list is empty
     */
    public E pull() {
        E item = null;

        // Is the list empty?
        if (last != null)
        {
            // No - get item and remove node
            item = last.item;
            last = last.next;

            if (last != null)
            {
                last.next = null;
            } else
            {
                first = null;
            }

            current = last;
            size--;
        } // Yes - nothing to do

        return item;
    }

    /**
     * Add a new item to the top of the list.
     * <p>
     * If successful, this item becomes the current reference point in the list.
     * <p>
     * <b>Note:</b> This implementation does not allow {@code null } items to be added.
     *
     * @param item to add.
     *
     * @throws NullPointerException if item is {@code null}
     */
    public void push(E item) {
        Node<E> node = new Node<>(Objects.requireNonNull(item, NO_NULL));

        // Is the list empty?
        if (first == null)
        {
            // Yes - add first node
            first = node;
            last = node;
            current = node;
        } else
        {
            // No - add node to top of chain
            node.next = first;
            first.previous = node;
            first = node;
        }

        current = node;
        size++;
    }

    /**
     * Removes the item at the current reference point in the list.
     *
     * @return {@code true } if successful, {@code false } otherwise
     */
    public E remove() {
        E rtn = null;

        if (current != null)
        {
            // Are we at the top of the list?
            if (current.previous == null)
            { // Yes
                rtn = pop();
                // Are we at the bottom of the list?
            } else if (current.next == null)
            { // Yes
                rtn = pull();

            } else
            {
                // We are in the midst of the list
                current.previous.next = current.next;
                current.next.previous = current.previous;
                rtn = current.item;
                current = current.next;
                size--;
            }
        }

        return rtn;
    }

    /**
     * Returns the number of items in this list.
     *
     * @return the number of items in this list
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "LinkedList{" + "size=" + size + '}';
    }

    /**
     * This class is used by the {@linkplain LinkedList&lt;E&gt;} class to store the items,
     * and then be linked together into a chain.
     *
     * @param <E> the type of element held in this node
     *
     * @since 1.0
     * @version 1.0
     */
    private class Node<E> {

        /**
         * The item being stored.
         */
        public final E item;

        /**
         * Link to the next node.
         */
        public Node<E> next;
        /**
         * Link to the previous node.
         */
        public Node<E> previous;

        /**
         * Instantiate a new Node object.
         *
         * @param item the object being stored
         */
        public Node(E item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return "Node{" + "item=" + item + '}';
        }

    }
}
