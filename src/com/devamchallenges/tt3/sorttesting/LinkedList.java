package com.devamchallenges.tt3.sorttesting;


public class LinkedList<T> {
    private T data;
    private com.devamchallenges.tt3.sorttesting.LinkedList<T> prevNode, nextNode;
    private com.devamchallenges.tt3.sorttesting.LinkedList lifo;

    public LinkedList(Object data, LinkedList<T> node) {
        this.setData((T) data);
        this.prevNode = node;
        node.nextNode = this;
        this.nextNode = null;
    }
    public LinkedList(Object data) {
        this.setData((T) data);
        this.prevNode = null;
        this.nextNode = null;
    }
    public LinkedList(com.devamchallenges.tt3.sorttesting.LinkedList<T> node) {
        this.setData(node.data);
        this.prevNode = node.prevNode;
        this.nextNode = node.nextNode;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setPrevNode(com.devamchallenges.tt3.sorttesting.LinkedList<T> node) {
        LinkedList temp = this.prevNode;
        if (temp != null) {
            this.prevNode = node;
            node.nextNode = this;
            node.prevNode = temp;
            temp.nextNode = node;
        }
        else {
            this.prevNode = node;
            node.nextNode = this;
            node.prevNode = temp;
        }

    }

    public void setNextNode(com.devamchallenges.tt3.sorttesting.LinkedList<T> node) {
        LinkedList temp = this.nextNode;
        if (temp != null) {
            this.nextNode = node;
            node.prevNode = this;
            node.nextNode = temp;
            temp.prevNode = node;
        }
        else {
            this.nextNode = node;
            node.prevNode = this;
            node.nextNode = temp;
        }

    }

    public com.devamchallenges.tt3.sorttesting.LinkedList<T> getPrevious() {
        return this.prevNode;
    }

    public com.devamchallenges.tt3.sorttesting.LinkedList<T> getNext() {
        return this.nextNode;
    }
    public void remove() {
        if (this.prevNode != null) {
            this.prevNode.nextNode = this.nextNode;
        }
        if (this.nextNode != null) {
            this.nextNode.prevNode = this.prevNode;
        }

        this.prevNode = null;
        this.nextNode = null;
    }
    public static void insertsort(LinkedList arr){

        while (arr != null){
            int key = (int) arr.getData();
            LinkedList next = arr.getNext();
            LinkedList j = arr.getPrevious();
//            Remove the value of arr and put it back to where it is actually less than the values before it
            if (j != null) {
                arr.remove();
            }
            LinkedList temp = null;
            while (j != null && (int) j.getData() > key) {
                temp = j;
                j = j.getPrevious();




            }
            if (j != null) {
                j.setNextNode(arr);

            }
            else if (temp != null) {
                temp.setPrevNode(arr);
            }


            arr = next;
        }

    }
    public static void printArray(LinkedList arr)
    {
        LinkedList a = arr;
        while (a.getPrevious() != null) {
            a = a.getPrevious();
        }
        while (a != null){
            System.out.print(a.getData() + " ");
            a = a.getNext();
        }
        System.out.println();
    }

    public static void getFirst(LinkedList arr) {

    }

    public static void main(String[] args) {
//        Object[] words = new String[]{"seven", "slimy", "snakes", "sallying", "slowly", "slithered", "southward"};
        int[] numbers = new int[]{64,25,12,22,11};

        LinkedList qWords = new LinkedList(numbers[0]);
        LinkedList start = qWords;
        for (int i = 1; i < numbers.length; i++) {
            qWords = new LinkedList(numbers[i], qWords);
        }
//        LinkedList.printArray(start);
//        LinkedList start2 = start;
        LinkedList.insertsort(start);
        //LinkedList.getFirst(start);
        LinkedList.printArray(start);
    }
}