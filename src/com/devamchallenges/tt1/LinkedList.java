package com.devamchallenges.tt1;

public class LinkedList<T> {
    private T data;
    private LinkedList<T> prevNode, nextNode;
    private LinkedList lifo;

    public LinkedList(T data, LinkedList<T> node) {
        this.setData(data);
        this.setPrevNode(node);
        this.setNextNode(null);
    }

    public LinkedList(LinkedList<T> node) {
        this.setData(node.data);
        this.setPrevNode(node.prevNode);
        this.setNextNode(node.nextNode);
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setPrevNode(LinkedList<T> node) {
        this.prevNode = node;
    }

    public void setNextNode(LinkedList<T> node) {
        this.nextNode = node;
    }

    public LinkedList<T> getPrevious() {
        return this.prevNode;
    }

    public LinkedList<T> getNext() {
        return this.nextNode;
    }

    public static void main(String[] args) {
        Object[] words = new String[]{"seven", "slimy", "snakes", "sallying", "slowly", "slithered", "southward"};
        QueueManager qWords = new QueueManager("Words", words);

    }
}