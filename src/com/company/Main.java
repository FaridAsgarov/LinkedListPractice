package com.company;

public class Main {

    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList(1);
        myLinkedList.addNextNode(new LinkedListNode(2));
        myLinkedList.addNextNode(new LinkedListNode(3));
        myLinkedList.addNextNode(new LinkedListNode(4));
        myLinkedList.addNextNode(new LinkedListNode(5));


        myLinkedList.printNodeValues();
        myLinkedList.insertAfter(new LinkedListNode(1),new LinkedListNode(7)); //inserts node 7 after 1st position
        myLinkedList.printNodeValues();
        myLinkedList.insertAfter(new LinkedListNode(3),new LinkedListNode(8)); //inserts node 8 after 4th position
        myLinkedList.printNodeValues();
        myLinkedList.insertAfter(new LinkedListNode(5),new LinkedListNode(9)); //inserts node 9 after last position
        myLinkedList.printNodeValues();
    }
}
