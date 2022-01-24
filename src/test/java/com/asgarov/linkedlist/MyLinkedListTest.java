package com.asgarov.linkedlist;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    @Test
    public void testAdd() {
        MyLinkedList myLinkedList = getMyLinkedList(List.of(1,2));

        assertEquals(2, myLinkedList.getLast().getValue());
    }

    @Test
    public void testRemoveLast() {
        MyLinkedList myLinkedList = getMyLinkedList(List.of(1,2,3));

        myLinkedList.removeLast();

        assertEquals(2, myLinkedList.getLast().getValue());
    }

    @Test
    public void testAddFirst() {
        MyLinkedList myLinkedList = getMyLinkedList(List.of(1,2,3));

        LinkedListNode newFirstNode = new LinkedListNode(7);
        myLinkedList.addFirst(newFirstNode);

        assertNotEquals(newFirstNode, myLinkedList.getLast());
        assertEquals(newFirstNode, myLinkedList.getFirst());
    }

    @Test
    public void testRemoveFirst() {
        MyLinkedList myLinkedList = getMyLinkedList(List.of(1,2,3));
        myLinkedList.removeFirst();

        assertEquals(2, myLinkedList.getFirst().getValue());
    }

    @Test
    public void testRemove() {
        MyLinkedList myLinkedList = getMyLinkedList(List.of(1,2,3,4));

        myLinkedList.remove(new LinkedListNode(3));

        assertFalse(myLinkedList.exists(new LinkedListNode(3)));
    }

    @Test
    public void testExists() {
        MyLinkedList myLinkedList = getMyLinkedList(List.of(1,2,3));

        assertFalse(myLinkedList.exists(new LinkedListNode(99)));
        assertTrue(myLinkedList.exists(new LinkedListNode(1)));
    }

    @Test
    public void testInsertAfter() {
        MyLinkedList myLinkedList = getMyLinkedList(List.of(1,2,3));

        LinkedListNode nodeToBeInserted = new LinkedListNode(7);

        LinkedListNode nodeToBeInsertedAfter = myLinkedList.getFirst().getNextNode();
        myLinkedList.insertAfter(nodeToBeInsertedAfter, nodeToBeInserted);

        assertTrue(nodeToBeInsertedAfter.getNextNode().equals(nodeToBeInserted));

    }

    @Test
    public void testPrintAll() {
        MyLinkedList myLinkedList = getMyLinkedList(List.of(1,2,3));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        myLinkedList.printAll();

        assertEquals("1\r\n" +
                "2\r\n" +
                "3\r\n" +
                "\r\n", outContent.toString());
    }

    private MyLinkedList getMyLinkedList(List<Integer> values) {
        MyLinkedList myLinkedList = new MyLinkedList(values.get(0));

        for (int i = 1; i < values.size(); i++) {
            myLinkedList.add(new LinkedListNode(values.get(i)));
        }

        return myLinkedList;
    }


}