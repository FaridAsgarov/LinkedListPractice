package com.asgarov.linkedlist;

public class MyDoublyLinkedList {
    private DoublyLinkedListNode root;

    /**
     * constructor has a time-complexity of O(1) because it only makes a single operation
     **/
    public MyDoublyLinkedList(int rootInt) {
        this.root = new DoublyLinkedListNode(rootInt);
    }

    /**
     * 1) total time complexity of the add() is O(n)
     * 2) because add() includes a protected getLast() method which has time complexity of O(n) as explained in the accompanying comment
     * 3) it also has a setNextNode() and setPrevNode() which are 2 constant time operations of O(1)
     **/
    public void add(DoublyLinkedListNode nextNode) {
        DoublyLinkedListNode temp = getLast();
        temp.setNextNode(nextNode);
        nextNode.setPrevNode(temp);
    }

    /**
     * Time complexity is O(1) because addFirst() includes 3 constant time operations
     **/
    public void addFirst(DoublyLinkedListNode firstToBe) {
        firstToBe.setNextNode(root);
        root.setPrevNode(firstToBe);
        root = firstToBe;
    }

    /**
     * Time complexity is O(1) - 1 constant time operation
     **/
    protected DoublyLinkedListNode getFirst() {
        return root;
    }

    /**
     * time complexity of O(n) because getLast() has to iterate through N sized linkedList to find the last
     **/
    protected DoublyLinkedListNode getLast() {
        DoublyLinkedListNode temp = root;
        while (temp.getNextNode() != null) {
            temp = temp.getNextNode();
        }
        return temp;
    }

    /**
     * Total time-complexity of O(n)
     * because it has to call System.out.println() * by N quantity of linked nodes
     **/
    public void printAll() {
        DoublyLinkedListNode temp = root;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNextNode();
        }
        System.out.println();
    }

    private DoublyLinkedListNode getBeforeLast() {
        DoublyLinkedListNode temp = root;
        while (temp.getNextNode().getNextNode() != null) {
            temp = temp.getNextNode();
        }
        return temp;
    }

    /**
     * time complexity of O(n) because removeLast() has to iterate through N sized linkedList to find the last and then null it
     **/
    public void removeLast() {
        if (root == null || root.getNextNode() == null) {
            root = null;
        } else {
            DoublyLinkedListNode beforeLastNode = getBeforeLast();
            beforeLastNode.setNextNode(null);
        }
    }

    /**
     * Time complexity is O(1) because removeFirst() includes 2 constant time operations
     **/
    public void removeFirst() {
        if (root == null || root.getNextNode() == null) {
            root = null;
        }
        this.root = root.getNextNode();
    }

    /**
     * time complexity of O(n) because exists() has to potentially iterate through N sized linkedList to find the required node
     **/
    public boolean exists(DoublyLinkedListNode node) {
        DoublyLinkedListNode temp = root;
        while (temp != null) {
            if (temp.equals(node)) {
                return true;
            }
            temp = temp.getNextNode();
        }
        return false;
    }

    /**
     * time complexity of remove() is O(n)
     * because it has to first run exists() which potentially iterates through N sized linkedList. - O(n)
     * Additionally, it performs another run through the linked list - which is another O(n)
     * Plus multiple constant time O(1) operations are required afterwards to remove the node
     **/
    public void remove(DoublyLinkedListNode node) {
        if (!exists(node)) {
            return;
        }

        if (root.equals(node)) {
            removeFirst();
            return;
        }

        DoublyLinkedListNode temp = root;
        while (!temp.getNextNode().equals(node)) {
            temp = temp.getNextNode();
        }
        DoublyLinkedListNode toBeDeleted = temp.getNextNode();
        temp.setNextNode(toBeDeleted.getNextNode());
        toBeDeleted.getNextNode().setPrevNode(temp);
    }

    /**
     * time complexity of insertAfter() is O(n)
     * because it has to first run exists() which potentially iterates through N sized linkedList
     * Additionally, it performs another run through the linked list - which is another O(n)
     * then it performs constant time operations O(1) to set the node after the right position
     **/
    public void insertAfter(DoublyLinkedListNode insertAfterThisPosition, DoublyLinkedListNode toBeInserted) {
        if (!exists(insertAfterThisPosition)) {
            return;
        }

        DoublyLinkedListNode temp = root;

        while (!temp.equals(insertAfterThisPosition)) {
            temp = temp.getNextNode();
        }

        DoublyLinkedListNode nodeBeforeWhichIsInserted = temp.getNextNode();

        temp.setNextNode(toBeInserted);
        toBeInserted.setPrevNode(temp);

        toBeInserted.setNextNode(nodeBeforeWhichIsInserted);
        nodeBeforeWhichIsInserted.setPrevNode(toBeInserted);
    }

    /**
     * Time Complexity is O(n)
     * because the reverseList() goes through N quantity of nodes in the original Linked list
     * and then performs addFirst() method which is a constant time operation on each element
     * and runs through the linked list again to remove the unnecessary last node
     **/
    public MyDoublyLinkedList reverseList() {
        DoublyLinkedListNode newRoot = getLast();
        MyDoublyLinkedList reversedList = new MyDoublyLinkedList(0);

        DoublyLinkedListNode temp = root;

        while (temp.getNextNode() != null) {
            reversedList.addFirst(new DoublyLinkedListNode(temp.getValue()));
            temp = temp.getNextNode();
        }

        reversedList.addFirst(new DoublyLinkedListNode(newRoot.getValue()));
        reversedList.removeLast();

        return reversedList;
    }

    /**
     * Time Complexity is O(n)
     * because the reverseCyclic() goes through N quantity of nodes in the original Linked list
     * and then performs setNextNode() method which is a constant time operation on each element
     * and runs through the linked list again to remove the unnecessary last node
     **/
    public void reverseCyclic() {
        DoublyLinkedListNode temp = root;
        DoublyLinkedListNode toBeSetAsNext = null;
        while (temp != null) {
            DoublyLinkedListNode nextForIteration = temp.getNextNode();

            temp.setNextNode(toBeSetAsNext);
            toBeSetAsNext = temp;

            temp = nextForIteration;
        }

        root = toBeSetAsNext;
    }

    /**
     * Has to be called with as reverse(null, root)
     * @param node
     * @param next
     */
    private void reverse(DoublyLinkedListNode node, DoublyLinkedListNode next) {
        if (next == null) {
            this.root = node;
            return;
        }

        reverse(next, next.getNextNode());
        next.setNextNode(node);
    }
}


