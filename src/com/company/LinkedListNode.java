package com.company;

import java.util.Objects;

public class LinkedListNode {
    private int value;
    private LinkedListNode nextNode;

    public LinkedListNode(int value, LinkedListNode nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public LinkedListNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkedListNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedListNode that = (LinkedListNode) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
