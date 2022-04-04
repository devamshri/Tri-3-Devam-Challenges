package com.devamchallenges.tt3.sorttesting;

import com.devamchallenges.tt3.sorttesting.LinkedList;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    com.devamchallenges.tt3.sorttesting.LinkedList<T> head, tail;

    /**
     *  Add a new object at the end of the Queue,
     *
     * @param  data,  is the data to be inserted in the Queue.
     */
    public void add(T data) {
        // add new object to end of Queue
        com.devamchallenges.tt3.sorttesting.LinkedList<T> tail = new com.devamchallenges.tt3.sorttesting.LinkedList<>(data, null);

        if (head == null)  // initial condition
            this.head = this.tail = tail;
        else {  // nodes in queue
            this.tail.setNextNode(tail); // current tail points to new tail
            this.tail = tail;  // update tail
        }
    }
    public void delete(T data){
        com.devamchallenges.tt3.sorttesting.LinkedList<T> tail = new com.devamchallenges.tt3.sorttesting.LinkedList<>(data, null);
        if(head == null){
            throw new RuntimeException();
        }
        if(head.getNext() == null){
            tail = null;
        }
        else{
            head.getNext().setPrevNode(tail);
        }
        head = head.getNext();
    }

    /**
     *  Returns the head object.
     *
     * @return  this.head, the head object in Queue.
     */
    public com.devamchallenges.tt3.sorttesting.LinkedList<T> getHead() {
        return this.head;
    }

    /**
     *  Returns the tail object.
     *
     * @return  this.tail, the last object in Queue
     */
    public com.devamchallenges.tt3.sorttesting.LinkedList<T> getTail() {
        return this.tail;
    }

    /**
     *  Returns the iterator object.
     *
     * @return  this, instance of object
     */
    public Iterator<T> iterator() {
        return new com.devamchallenges.tt3.sorttesting.QueueIterator<>(this);
    }

}

/**
 * Queue Iterator
 *
 * 1. "has a" current reference in Queue
 * 2. supports iterable required methods for next that returns a data object
 */
class QueueIterator<T> implements Iterator<T> {
    LinkedList<T> current;  // current element in iteration

    // QueueIterator is intended to the head of the list for iteration
    public QueueIterator(com.devamchallenges.tt3.sorttesting.Queue<T> q) {
        current = q.getHead();
    }

    // hasNext informs if next element exists
    public boolean hasNext() {
        return current != null;
    }

    // next returns data object and advances to next position in queue
    public T next() {
        T data = current.getData();
        current = current.getNext();
        return data;
    }
}

/**
 * Queue Manager
 * 1. "has a" Queue
 * 2. support management of Queue tasks (aka: titling, adding a list, printing)
 */
class QueueManager<T> {
    // queue data
    private final String name; // name of queue
    private int count = 0; // number of objects in queue
    public final com.devamchallenges.tt3.sorttesting.Queue<T> queue = new com.devamchallenges.tt3.sorttesting.Queue<>(); // queue object

    /**
     *  Queue constructor
     *  Title with empty queue
     */
    public QueueManager(String name) {
        this.name = name;
    }

    /**
     *  Queue constructor
     *  Title with series of Arrays of Objects
     */
    public QueueManager(String name, T[]... seriesOfObjects) {
        this.name = name;
        this.addList(seriesOfObjects);
        this.deleteList(seriesOfObjects);
    }

    /**
     * Add a list of objects to queue
     */
    public void addList(T[]... seriesOfObjects) {
        for (T[] objects: seriesOfObjects)
            for (T data : objects) {
                this.queue.add(data);
                this.count++;
                System.out.println("Enqueued data: " + data);
                printQueue();
            }
    }

    public void deleteList(T[]...seriesOfObjects){
        for (T[] objects: seriesOfObjects)
            for (T data : objects){
                this.queue.delete(data);
                this.count--;
                System.out.println("Dequeued data: "+ data);
                deQueue();
            }
    }

    /**
     * Print any array objects from queue
     */
    public void printQueue() {
        System.out.print(this.name + " count: " + count + ", data: ");
        //System.out.print(this.name + " data: ");
        for (T data : queue)
            System.out.print(data + " ");
        System.out.println();
    }

    public void deQueue(){
        System.out.print(this.name + " count: " + count + ", data: ");

        for (T data : queue)
            System.out.print(data + " ");
        System.out.println();

    }

}

/**
 * Driver Class
 * Tests queue with string, integers, and mixes of Classes and types
 */

class QueueTest {
    public static void main(String[] args) {
        Object[] words = new String[]{"seven", "slimy", "snakes", "sallying", "slowly", "slithered", "southward"};
        com.devamchallenges.tt3.sorttesting.QueueManager qWords = new com.devamchallenges.tt3.sorttesting.QueueManager("Words", words);
        Object[] numbers1 = new Integer[]{1, 4, 5, 8};
        com.devamchallenges.tt3.sorttesting.QueueManager qNums1 = new com.devamchallenges.tt3.sorttesting.QueueManager("num1", numbers1);

        Object[] numbers2 = new Integer[]{2, 3, 6, 7};
        com.devamchallenges.tt3.sorttesting.QueueManager qNums2 = new com.devamchallenges.tt3.sorttesting.QueueManager("num2", numbers2);

    }
}
