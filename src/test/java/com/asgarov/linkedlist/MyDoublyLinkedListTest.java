package com.asgarov.linkedlist;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyDoublyLinkedListTest {
    @Test
    public void testAdd() {
        MyDoublyLinkedList MyDoublyLinkedList = getMyDoublyLinkedList(List.of(1,2));

        assertEquals(2, MyDoublyLinkedList.getLast().getValue());
    }

    @Test
    public void testRemoveLast() {
        MyDoublyLinkedList MyDoublyLinkedList = getMyDoublyLinkedList(List.of(1,2,3));

        MyDoublyLinkedList.removeLast();

        assertEquals(2, MyDoublyLinkedList.getLast().getValue());
    }

    @Test
    public void testAddFirst() {
        MyDoublyLinkedList MyDoublyLinkedList = getMyDoublyLinkedList(List.of(1,2,3));

        DoublyLinkedListNode newFirstNode = new DoublyLinkedListNode(7);
        MyDoublyLinkedList.addFirst(newFirstNode);

        assertNotEquals(newFirstNode, MyDoublyLinkedList.getLast());
        assertEquals(newFirstNode, MyDoublyLinkedList.getFirst());
    }

    @Test
    public void testRemoveFirst() {
        MyDoublyLinkedList MyDoublyLinkedList = getMyDoublyLinkedList(List.of(1,2,3));
        MyDoublyLinkedList.removeFirst();

        assertEquals(2, MyDoublyLinkedList.getFirst().getValue());
    }

    @Test
    public void testRemove() {
        MyDoublyLinkedList MyDoublyLinkedList = getMyDoublyLinkedList(List.of(1,2,3,4));

        MyDoublyLinkedList.remove(new DoublyLinkedListNode(3));

        assertFalse(MyDoublyLinkedList.exists(new DoublyLinkedListNode(3)));
    }

    @Test
    public void testExists() {
        MyDoublyLinkedList MyDoublyLinkedList = getMyDoublyLinkedList(List.of(1,2,3));

        assertFalse(MyDoublyLinkedList.exists(new DoublyLinkedListNode(99)));
        assertTrue(MyDoublyLinkedList.exists(new DoublyLinkedListNode(1)));
    }

    @Test
    public void testExistsRecursive() {
        MyDoublyLinkedList MyDoublyLinkedList = getMyDoublyLinkedList(List.of(1,2,3));

        assertFalse(MyDoublyLinkedList.existsRecursive(new DoublyLinkedListNode(1),new DoublyLinkedListNode(99)));
        assertTrue(MyDoublyLinkedList.existsRecursive(new DoublyLinkedListNode(1),new DoublyLinkedListNode(1)));
    }

    @Test
    public void testInsertAfter() {
        MyDoublyLinkedList MyDoublyLinkedList = getMyDoublyLinkedList(List.of(1,2,3));

        DoublyLinkedListNode nodeToBeInserted = new DoublyLinkedListNode(7);

        DoublyLinkedListNode nodeToBeInsertedAfter = MyDoublyLinkedList.getFirst().getNextNode();
        MyDoublyLinkedList.insertAfter(nodeToBeInsertedAfter, nodeToBeInserted);

        assertTrue(nodeToBeInsertedAfter.getNextNode().equals(nodeToBeInserted));

    }

    @Test
    public void testPrintAll() {
        MyDoublyLinkedList MyDoublyLinkedList = getMyDoublyLinkedList(List.of(1,2,3));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        MyDoublyLinkedList.printAll();

        assertEquals("1\r\n" +
                "2\r\n" +
                "3\r\n" +
                "\r\n", outContent.toString());
    }

    private MyDoublyLinkedList getMyDoublyLinkedList(List<Integer> values) {
        MyDoublyLinkedList MyDoublyLinkedList = new MyDoublyLinkedList(values.get(0));

        for (int i = 1; i < values.size(); i++) {
            MyDoublyLinkedList.add(new DoublyLinkedListNode(values.get(i)));
        }

        return MyDoublyLinkedList;
    }


}