package com.devamchallenges.tt3.sorttesting;


public class LinkedList<T> {
    private T data;
    private com.devamchallenges.tt3.sorttesting.LinkedList<T> prevNode, nextNode;
    private com.devamchallenges.tt3.sorttesting.LinkedList lifo;

    public LinkedList(Object data, LinkedList<T> node) {
        this.setData((T) data);
        this.setPrevNode(node);
        this.prevNode.setNextNode(this);
        this.setNextNode(null);
    }
    public LinkedList(Object data) {
        this.setData((T) data);
        this.setPrevNode(null);
        this.setNextNode(null);
    }
    public LinkedList(com.devamchallenges.tt3.sorttesting.LinkedList<T> node) {
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

    public void setPrevNode(com.devamchallenges.tt3.sorttesting.LinkedList<T> node) {
        this.prevNode = node;
    }

    public void setNextNode(com.devamchallenges.tt3.sorttesting.LinkedList<T> node) {
        this.nextNode = node;
    }

    public com.devamchallenges.tt3.sorttesting.LinkedList<T> getPrevious() {
        return this.prevNode;
    }

    public com.devamchallenges.tt3.sorttesting.LinkedList<T> getNext() {
        return this.nextNode;
    }

    public static void insertsort(LinkedList arr){
//        int n = arr.length;
        while (arr.getNext() != null){
            int key = (int) arr.getData();
            LinkedList j = arr.getPrevious();
            while (j != null && (int) j.getData() > key) {
                LinkedList tempNext = null;
                if (j.nextNode != null) {
                    tempNext = j.nextNode.nextNode;
                }
                LinkedList tempPrev = j.prevNode;

                j.nextNode.setNextNode(j);
                j.getNext().setPrevNode(tempPrev);
                j.setPrevNode(j.getNext());

                if (tempNext != null) {
                    tempNext.setPrevNode(j);
                }
                j.setNextNode(tempNext);
                j = tempPrev;


            }
            LinkedList temp1= arr.getNext();
            if (j != null) {
                LinkedList temp2 = null;
                if (j.getNext() != null) {
                     temp2 = j.getNext().getNext();
                }

                j.getNext().setNextNode(arr);
                arr.setPrevNode(j.getNext());

                arr.setNextNode(temp2);
                if (temp2 != null) {
                    temp2.setPrevNode(arr);
                }

            }
            arr = temp1;
        }
//        for (int i = 1; i < n; ++i) {
//            LinkedList key = arr[i];
//            int j = i - 1;
//
//            /* Move elements around like a good old sorting algorithm */
//            while (j >= 0 && arr[j] > key) {
//                arr[j + 1] = arr[j];
//                j = j - 1;
//            }
//            arr[j + 1] = key;
//        }
    }
    public static void printArray(LinkedList arr)
    {
        LinkedList a = arr;
        while (a != null){

            System.out.print(a.getData() + " ");
            a = a.getNext();
        }
        System.out.println();
    }

    public static void getFirst(LinkedList arr) {
        while (arr.getPrevious() != null) {
            arr = arr.getPrevious();
        }
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