package com.asgarov.linkedlist;

import java.util.Objects;

public class DoublyLinkedListNode {
    private int value;
    private DoublyLinkedListNode nextNode;
    private DoublyLinkedListNode prevNode;

    public DoublyLinkedListNode(int value, DoublyLinkedListNode nextNode, DoublyLinkedListNode prevNode) {
        this.value = value;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
    }

    public DoublyLinkedListNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DoublyLinkedListNode getNextNode() {
        return nextNode;
    }

    public DoublyLinkedListNode getPrevNode() {
        return prevNode;
    }

    public void setNextNode(DoublyLinkedListNode nextNode) {
        this.nextNode = nextNode;
    }

    public void setPrevNode(DoublyLinkedListNode prevNode) {
        this.prevNode = prevNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoublyLinkedListNode that = (DoublyLinkedListNode) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
