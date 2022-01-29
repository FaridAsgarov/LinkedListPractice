package com.asgarov.linkedlist;

public class Main {

    public static void main(String[] args) {

        MyDoublyLinkedList myLinkedList = new MyDoublyLinkedList(1);
        DoublyLinkedListNode node2 = new DoublyLinkedListNode(2);
        DoublyLinkedListNode node3 = new DoublyLinkedListNode(3);
        DoublyLinkedListNode node4 = new DoublyLinkedListNode(4);
        DoublyLinkedListNode node5 = new DoublyLinkedListNode(5);

        myLinkedList.add(node2);
        myLinkedList.add(node3);
        myLinkedList.add(node4);
        myLinkedList.add(node5);

        System.out.println(node2.getPrevNode().getValue());
        System.out.println(node3.getPrevNode().getValue());
        System.out.println(node4.getPrevNode().getValue());
        System.out.println(node5.getPrevNode().getValue());
        System.out.println();
        System.out.println(node2.getNextNode().getValue());
        System.out.println(node3.getNextNode().getValue());
        System.out.println(node4.getNextNode().getValue());
        System.out.println(node5.getNextNode());

//        myLinkedList.printAll();
//        myLinkedList.reverseCyclic();
//        myLinkedList.printAll();

    }
}
