package com.company;

public class MyLinkedList {
    private LinkedListNode root;

    public MyLinkedList(int rootInt) {
        this.root = new LinkedListNode(rootInt);
    }

    public void addNextNode(LinkedListNode nextNode) {
        LinkedListNode temp = getLastNode();
        temp.setNextNode(nextNode);
    }

    public void insertNodeFromStart(LinkedListNode firstToBe) {
        firstToBe.setNextNode(root);
        root = firstToBe;
    }

    private LinkedListNode getLastNode() {
        LinkedListNode temp = root;
        while (temp.getNextNode() != null) {
            temp = temp.getNextNode();
        }
        return temp;
    }

    public void printNodeValues() {
        LinkedListNode temp = root;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNextNode();
        }
        System.out.println();
    }

    private LinkedListNode getBeforeLastNode() {
        LinkedListNode temp = root;
        while (temp.getNextNode().getNextNode() != null) {
            temp = temp.getNextNode();
        }
        return temp;
    }

    public void removeLastNode() {
        if (root == null || root.getNextNode() == null) {
            root = null;
        } else {
            LinkedListNode beforeLastNode = getBeforeLastNode();
            beforeLastNode.setNextNode(null);
        }
    }

    public void removeFirst(){
        if(root == null || root.getNextNode()==null){
            root=null;
        }
        this.root=root.getNextNode();
    }

    public boolean exists(LinkedListNode node){
        LinkedListNode temp = root;
        while (temp != null) {
            if(temp.equals(node)){
                return true;
            }
            temp = temp.getNextNode();
        }
        return false;
    }

    public void deleteNode(LinkedListNode node){
        if(!exists(node)){
            return;
        }

        if(root.equals(node)){
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
    
    public void insertAfter(LinkedListNode nodeAfterWhichIsInserted, LinkedListNode toBeInserted){
        if(!exists(nodeAfterWhichIsInserted)){
            return;
        }

        LinkedListNode temp = root;
        LinkedListNode nodeBeforeWhichIsInserted = null;

        while (!temp.equals(nodeAfterWhichIsInserted)) {
            temp = temp.getNextNode();
        }

        if(temp.getNextNode()!=null){
               nodeBeforeWhichIsInserted = temp.getNextNode();
            }

            temp.setNextNode(toBeInserted);

        if(nodeBeforeWhichIsInserted != null){
                toBeInserted.setNextNode(nodeBeforeWhichIsInserted);
            }
    }
}
