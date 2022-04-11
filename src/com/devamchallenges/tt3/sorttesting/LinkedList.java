package com.devamchallenges.tt3.sorttesting;


import com.devamchallenges.tt3.BubbleSort;
import com.devamchallenges.tt3.InsertionSort;
import com.devamchallenges.tt3.MergeSort;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

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

    public int len()
    {
        LinkedList a =this;
        while (a.getPrevious() != null) {
            a = a.getPrevious();
        }
         int i = 0;
        while (a != null){
            i+= 1;
            a = a.getNext();
        }
        return i;
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

    public static void bubbleSort(LinkedList arr) {
        int i = arr.len();
        int b = 0;
        while (b < i) {
            LinkedList next = arr.getNext();
            LinkedList j = arr;
            while (j.getPrevious() != null) {
                j = j.getPrevious();
            }

            LinkedList j_1 = j.getNext(); //j+1
            while (j_1 != null ) {
                if ((int) j.getData() > (int) j_1.getData()) {
                    j.remove();
                    j_1.setNextNode(j);
                    j_1 = j.getNext();
                } else {
                    j_1 = j_1.getNext();
                }

            }

            arr = next;
            b+= 1;
        }
    }
    public static void selectionsort(LinkedList arr){

        while (arr != null){
            // get the minimum
            LinkedList min = minvalue(arr);
            if (min == arr) {
                arr = arr.getNext();
            }

            if (arr != null) {
                min.remove();
                arr.setPrevNode(min);
            }

        }
    }

    // make a function that finds the minimum from that point onwards
    public static LinkedList minvalue(LinkedList arr) {
        int min_key = 99999;
        LinkedList min = null;
        while (arr != null){
            int key = (int) arr.getData();
            LinkedList next = arr.getNext();
            if (key < min_key) {
                min_key = key;
                min = arr;
            }
            arr = next;
        }
        return min;
    }
    public static void sortlinkedlistmenu() {
        int[] numbers = new int[]{64,25,12,22,11};

        LinkedList qWords = new LinkedList(numbers[0]);
        LinkedList start = qWords;
        for (int i = 1; i < numbers.length; i++) {
            qWords = new LinkedList(numbers[i], qWords);
        }

        // Make sure to include an if-statement to choose which sorting algorithm is to be used
        String[] menu_items = new String[] {"Welcome to my sort algorithm!\nOption 1: Insertion", "Option 2: Bubble", "Option 3: Selection"};

        for(int i = 0; i < menu_items.length; i++){
            System.out.println(menu_items[i]);
            System.out.println("-------------------------\n");
        }
        System.out.println("Enter your choice:");

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        try {
            System.out.println(menu_items[Integer.parseInt(input)-1]);
        } catch (NumberFormatException e) {
            System.out.println("Make sure to enter a number as your choice!");
        } catch (ArrayIndexOutOfBoundsException a){
            System.out.println("Please enter a choice between 1 and " + menu_items.length);
        }

        if(input.equals("1")){
            System.out.println("List before sorting");
            LinkedList.printArray(start);
            System.out.println("Let the insertion sort commence");
            LinkedList.insertsort(start);
            LinkedList.printArray(start);

        }
        else if(input.equals("2")){
            System.out.println("List before sorting");
            LinkedList.printArray(start);
            System.out.println("Let the bubble sort commence");
            LinkedList.bubbleSort(start);
            LinkedList.printArray(start);
        }
        else if(input.equals("3")) {
            System.out.println("List before sorting");
            LinkedList.printArray(start);
            System.out.println("Let the selection sort commence");
            LinkedList.selectionsort(start);
            LinkedList.printArray(start);
        }
        sortlinkedlistmenu();
    }
    public static void main(String[] args) {
//        Object[] words = new String[]{"seven", "slimy", "snakes", "sallying", "slowly", "slithered", "southward"};
        LinkedList.sortlinkedlistmenu();
    }
}