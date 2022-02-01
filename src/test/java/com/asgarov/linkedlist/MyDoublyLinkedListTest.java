package com.asgarov.linkedlist;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyDoublyLinkedListTest {
    @Test
    public void testAdd() {
        MyDoublyLinkedList myDoublyLinkedList = getMyDoublyLinkedList(List.of(1, 2));

        assertEquals(2, myDoublyLinkedList.getLast().getValue());
    }

    @Test
    public void testRemoveLast() {
        MyDoublyLinkedList myDoublyLinkedList = getMyDoublyLinkedList(List.of(1, 2, 3));

        myDoublyLinkedList.removeLast();

        assertEquals(2, myDoublyLinkedList.getLast().getValue());
    }

    @Test
    public void testAddFirst() {
        MyDoublyLinkedList myDoublyLinkedList = getMyDoublyLinkedList(List.of(1, 2, 3));

        DoublyLinkedListNode newFirstNode = new DoublyLinkedListNode(7);
        myDoublyLinkedList.addFirst(newFirstNode);

        assertNotEquals(newFirstNode, myDoublyLinkedList.getLast());
        assertEquals(newFirstNode, myDoublyLinkedList.getFirst());
    }

    @Test
    public void testRemoveFirst() {
        MyDoublyLinkedList myDoublyLinkedList = getMyDoublyLinkedList(List.of(1, 2, 3));
        myDoublyLinkedList.removeFirst();

        assertEquals(2, myDoublyLinkedList.getFirst().getValue());
    }

    @Test
    public void testRemove() {
        MyDoublyLinkedList myDoublyLinkedList = getMyDoublyLinkedList(List.of(1, 2, 3, 4));

        myDoublyLinkedList.remove(new DoublyLinkedListNode(3));

        assertFalse(myDoublyLinkedList.exists(new DoublyLinkedListNode(3)));
    }

    @Test
    public void testExists() {
        MyDoublyLinkedList myDoublyLinkedList = getMyDoublyLinkedList(List.of(1, 2, 3));

        assertFalse(myDoublyLinkedList.exists(new DoublyLinkedListNode(99)));
        assertTrue(myDoublyLinkedList.exists(new DoublyLinkedListNode(1)));
    }

    //NewTest for Recursive Exists method
    @Test
    public void testExistsRecursive() {
        MyDoublyLinkedList myDoublyLinkedList = getMyDoublyLinkedList(List.of(1, 2, 3));

        assertFalse(myDoublyLinkedList.existsRecursive(new DoublyLinkedListNode(99)));
        assertTrue(myDoublyLinkedList.existsRecursive(new DoublyLinkedListNode(1)));
    }

    @Test
    public void testInsertAfter() {
        MyDoublyLinkedList myDoublyLinkedList = getMyDoublyLinkedList(List.of(1, 2, 3));

        DoublyLinkedListNode nodeToBeInserted = new DoublyLinkedListNode(7);

        DoublyLinkedListNode nodeToBeInsertedAfter = myDoublyLinkedList.getFirst().getNextNode();
        myDoublyLinkedList.insertAfter(nodeToBeInsertedAfter, nodeToBeInserted);

        assertEquals(nodeToBeInsertedAfter.getNextNode(), nodeToBeInserted);

    }

    @Test
    public void testPrintAll() {
        MyDoublyLinkedList myDoublyLinkedList = getMyDoublyLinkedList(List.of(1, 2, 3));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        myDoublyLinkedList.printAll();

        assertEquals("1\r\n" +
                "2\r\n" +
                "3\r\n" +
                "\r\n", outContent.toString());
    }

    @Test
    public void reverseList() {
        MyDoublyLinkedList myDoublyLinkedList = getMyDoublyLinkedList(List.of(1, 2, 3, 4, 5));
        myDoublyLinkedList = myDoublyLinkedList.reverseList();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        myDoublyLinkedList.printAll();

        assertEquals("5\r\n" +
                "4\r\n" +
                "3\r\n" +
                "2\r\n" +
                "1\r\n" +
                "\r\n", outContent.toString());
    }

    @Test
    public void testReverseCyclic() {
        MyDoublyLinkedList myDoublyLinkedList = getMyDoublyLinkedList(List.of(1, 2, 3, 4, 5));
        myDoublyLinkedList.reverseCyclic();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        myDoublyLinkedList.printAll();

        assertEquals("5\r\n" +
                "4\r\n" +
                "3\r\n" +
                "2\r\n" +
                "1\r\n" +
                "\r\n", outContent.toString());


        assertEquals(myDoublyLinkedList.getLast().getPrevNode(),new DoublyLinkedListNode(2));
        assertEquals(myDoublyLinkedList.getLast().getPrevNode().getPrevNode(),new DoublyLinkedListNode(3));
        assertEquals(myDoublyLinkedList.getLast().getPrevNode().getPrevNode().getPrevNode(),new DoublyLinkedListNode(4));
        assertEquals(myDoublyLinkedList.getLast().getPrevNode().getPrevNode().getPrevNode().getPrevNode(),new DoublyLinkedListNode(5));
        assertNull(myDoublyLinkedList.getLast().getPrevNode().getPrevNode().getPrevNode().getPrevNode().getPrevNode());
    }

    @Test
    public void testReverse() {
        MyDoublyLinkedList myDoublyLinkedList = getMyDoublyLinkedList(List.of(1, 2, 3, 4, 5));
        myDoublyLinkedList.reverse(null, myDoublyLinkedList.getFirst());

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        myDoublyLinkedList.printAll();

        assertEquals("5\r\n" +
                "4\r\n" +
                "3\r\n" +
                "2\r\n" +
                "1\r\n" +
                "\r\n", outContent.toString());

        assertEquals(myDoublyLinkedList.getLast().getPrevNode(),new DoublyLinkedListNode(2));
        assertEquals(myDoublyLinkedList.getLast().getPrevNode().getPrevNode(),new DoublyLinkedListNode(3));
        assertEquals(myDoublyLinkedList.getLast().getPrevNode().getPrevNode().getPrevNode(),new DoublyLinkedListNode(4));
        assertEquals(myDoublyLinkedList.getLast().getPrevNode().getPrevNode().getPrevNode().getPrevNode(),new DoublyLinkedListNode(5));
        assertNull(myDoublyLinkedList.getLast().getPrevNode().getPrevNode().getPrevNode().getPrevNode().getPrevNode());

    }

    private MyDoublyLinkedList getMyDoublyLinkedList(List<Integer> values) {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(values.get(0));

        for (int i = 1; i < values.size(); i++) {
            myDoublyLinkedList.add(new DoublyLinkedListNode(values.get(i)));
        }

        return myDoublyLinkedList;
    }


}