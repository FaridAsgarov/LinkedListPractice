package com.asgarov.linkedlist;

public class MyLinkedList {
    private LinkedListNode root;

    public MyLinkedList(int rootInt) {
        this.root = new LinkedListNode(rootInt);
    }

    public void add(LinkedListNode nextNode) {
        LinkedListNode temp = getLast();
        temp.setNextNode(nextNode);
    }

    public void addFirst(LinkedListNode firstToBe) {
        firstToBe.setNextNode(root);
        root = firstToBe;
    }

    protected LinkedListNode getFirst() {
        return root;
    }

    protected LinkedListNode getLast() {
        LinkedListNode temp = root;
        while (temp.getNextNode() != null) {
            temp = temp.getNextNode();
        }
        return temp;
    }

    public void printAll() {
        LinkedListNode temp = root;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNextNode();
        }
        System.out.println();
    }

    private LinkedListNode getBeforeLast() {
        LinkedListNode temp = root;
        while (temp.getNextNode().getNextNode() != null) {
            temp = temp.getNextNode();
        }
        return temp;
    }

    public void removeLast() {
        if (root == null || root.getNextNode() == null) {
            root = null;
        } else {
            LinkedListNode beforeLastNode = getBeforeLast();
            beforeLastNode.setNextNode(null);
        }
    }

    public void removeFirst() {
        if (root == null || root.getNextNode() == null) {
            root = null;
        }
        this.root = root.getNextNode();
    }

    public boolean exists(LinkedListNode node) {
        LinkedListNode temp = root;
        while (temp != null) {
            if (temp.equals(node)) {
                return true;
            }
            temp = temp.getNextNode();
        }
        return false;
    }

    public void remove(LinkedListNode node) {
        if (!exists(node)) {
            return;
        }

        if (root.equals(node)) {
            removeFirst();
            return;
        }

        LinkedListNode temp = root;
        while (!temp.getNextNode().equals(node)) {
            temp = temp.getNextNode();
        }
        LinkedListNode toBeDeleted = temp.getNextNode();
        temp.setNextNode(toBeDeleted.getNextNode());
    }

    public void insertAfter(LinkedListNode insertAfterThisPosition, LinkedListNode toBeInserted) {
        if (!exists(insertAfterThisPosition)) {
            return;
        }

        LinkedListNode temp = root;

        while (!temp.equals(insertAfterThisPosition)) {
            temp = temp.getNextNode();
        }

        LinkedListNode nodeBeforeWhichIsInserted = temp.getNextNode();

        temp.setNextNode(toBeInserted);

        toBeInserted.setNextNode(nodeBeforeWhichIsInserted);
    }
}
