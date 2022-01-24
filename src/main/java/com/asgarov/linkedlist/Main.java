package com.asgarov.linkedlist;

public class Main {

    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList(1);
        myLinkedList.add(new LinkedListNode(2));
        myLinkedList.add(new LinkedListNode(3));
        myLinkedList.add(new LinkedListNode(4));
        myLinkedList.add(new LinkedListNode(5));

        myLinkedList.printAll();
        myLinkedList = myLinkedList.reverseList();
        myLinkedList.printAll();
    }
}
