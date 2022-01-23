package com.asgarov.linkedlist;

public class Main {

    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList(1);
        myLinkedList.add(new LinkedListNode(2));
        myLinkedList.add(new LinkedListNode(3));
        myLinkedList.add(new LinkedListNode(4));
        myLinkedList.add(new LinkedListNode(5));


        myLinkedList.printAll();
        myLinkedList.insertAfter(new LinkedListNode(1),new LinkedListNode(7)); //inserts node 7 after 1st position
        myLinkedList.printAll();
        myLinkedList.insertAfter(new LinkedListNode(3),new LinkedListNode(8)); //inserts node 8 after 4th position
        myLinkedList.printAll();
        myLinkedList.insertAfter(new LinkedListNode(5),new LinkedListNode(9)); //inserts node 9 after last position
        myLinkedList.printAll();
    }
}
