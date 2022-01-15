package com.company;

public class Main {

    public static void main(String[] args) {

//        LinkedListNode rootNode = new LinkedListNode(1, null);
//        LinkedListNode nextNode = new LinkedListNode(2, null);
//        LinkedListNode nextNextNode = new LinkedListNode(3, null);
//
//        rootNode.setNextNode(nextNode);
//        nextNode.setNextNode(nextNextNode);

        MyLinkedList myLinkedList = new MyLinkedList(1);
        myLinkedList.addNextNode(new LinkedListNode(2));
        myLinkedList.addNextNode(new LinkedListNode(3));
        myLinkedList.addNextNode(new LinkedListNode(4));


        myLinkedList.printNodeValues();
        myLinkedList.deleteNode(new LinkedListNode(3));
        myLinkedList.printNodeValues();
        myLinkedList.deleteNode(new LinkedListNode(7));
        myLinkedList.printNodeValues();
        myLinkedList.deleteNode(new LinkedListNode(1));
        myLinkedList.printNodeValues();
        myLinkedList.deleteNode(new LinkedListNode(4));
        myLinkedList.printNodeValues();
    }
}
