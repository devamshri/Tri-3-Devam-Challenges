{% include navigation.html %}
# Sorts
- I also implemented sorting in my custom implementation of a Linked List

## Bubble Sort
- simplest sorting algorithm
- Takes the most time to run
- repeatedly swaps adjacent elements if in wrong order
- Time complexity of O(n^2) because two for loops go through entire array

``` java

package com.devamchallenges.tt3;

import java.time.Duration;
import java.time.Instant;

public class BubbleSort {
        public void bubbleSort(int arr[])
        {
            int n = arr.length;
            for (int i = 0; i < n-1; i++)
                for (int j = 0; j < n-i-1; j++)
                    if (arr[j] > arr[j+1])
                    {
                        // swap arr[j+1] and arr[j]
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
        }

        /* Prints the array */
        void printArray(int arr[])
        {
            int n = arr.length;
            for (int i=0; i<n; ++i)
                System.out.print(arr[i] + " ");
            System.out.println();
        }

        // Test test test! Make sure to always test your work!
        public static void main(String args[]) {
            for (int i = 0; i < 12; i++) {
                int time = 0;
                final Duration timeElapsed;
                BubbleSort ob = new BubbleSort();
                int arr[] = new int[5000];
                for (int j = 0; j < 5000; j++) {
                    arr[j] = ((int)(Math.random() *(5000)));
                }
                System.out.println("---------Initial Unsorted Array---------");
                ob.printArray(arr);
                Instant start = Instant.now();  // time capture -- start
                ob.bubbleSort(arr);
                Instant end = Instant.now();    // time capture -- end
                timeElapsed = Duration.between(start, end);
                System.out.println("\n------------Sorted Array------------");
                ob.printArray(arr);
                System.out.println();
                System.out.println("Nanoseconds: " + timeElapsed.getNano());
                time += timeElapsed.getNano();
                System.out.println("Total Nanoseconds: " + time );
                System.out.println("Total Seconds: " + time /1000000000.0);
            }

        }
}
```

## Selection Sort
  - in the unsorted section, the minimum element is found and put at the beginning
  - two subarrays: one which is already sorted, remaning array which is unsorted
  - Time complexity; O(n^2) because there are two nested for loops
  
``` java
package com.devamchallenges.tt3;

import java.time.Duration;
import java.time.Instant;

public class SelectionSort
{
    public static void selectionsort(int arr[])
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Prints the array
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver code to test above
    public static void main(String args[])
    {
        for (int i = 0; i < 12; i++) {
            int time = 0;
            final Duration timeElapsed;
            SelectionSort ob = new SelectionSort();
            int arr[] = new int[5000];
            for (int j = 0; j < 5000; j++) {
                arr[j] = ((int)(Math.random() *(5000)));
            }
            System.out.println("---------Initial Unsorted Array---------");
            ob.printArray(arr);
            Instant start = Instant.now();  // time capture -- start
            ob.selectionsort(arr);
            Instant end = Instant.now();    // time capture -- end
            timeElapsed = Duration.between(start, end);
            System.out.println("\n------------Sorted Array------------");
            ob.printArray(arr);
            System.out.println();
            System.out.println("Nanoseconds: " + timeElapsed.getNano());
            time += timeElapsed.getNano();
            System.out.println("Total Nanoseconds: " + time );
            System.out.println("Total Seconds: " + time /1000000000.0);
        }

    }
}
```

## Insertion Sort 
  - array is split into sorted and unsorted part
  - one at a time, values form unsorted part are put in the correct location of the sorted array
  - Time complexity is O(n^2) because there is 1 for loop and 1 while loop 
  - The second most efficient

``` java
package com.devamchallenges.tt3;

import java.time.Duration;
import java.time.Instant;

public class InsertionSort {
    public static void insertsort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements around like a good old sorting algorithm */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /* print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Testing method
    public static void main(String args[])
    {
        for (int i = 0; i < 12; i++) {
            int time = 0;
            final Duration timeElapsed;
            InsertionSort ob = new InsertionSort();
            int arr[] = new int[5000];
            for (int j = 0; j < 5000; j++) {
                arr[j] = ((int)(Math.random() *(5000)));
            }
            System.out.println("---------Initial Unsorted Array---------");
            ob.printArray(arr);
            Instant start = Instant.now();  // time capture -- start
            ob.insertsort(arr);
            Instant end = Instant.now();    // time capture -- end
            timeElapsed = Duration.between(start, end);
            System.out.println("\n------------Sorted Array------------");
            ob.printArray(arr);
            System.out.println();
            System.out.println("Nanoseconds: " + timeElapsed.getNano());
            time += timeElapsed.getNano();
            System.out.println("Total Nanoseconds: " + time );
            System.out.println("Total Seconds: " + time /1000000000.0);
        }

    }
}

```

## Merge Sort
  - a Divide and Conquer Algorithm
  - array is repeatedly divided, sorted, and then later merged
  - useful 
  - Most efficient of all the algorithms

``` java
package com.devamchallenges.tt3;
import java.util.ArrayList;
import java.time.Duration;
import java.time.Instant;

public class MergeSort {
    private ArrayList<Integer> inputArray;
    private Duration timeElapsed;

    public ArrayList<Integer> getSortedArray() {
        return inputArray;
    }

    public MergeSort(ArrayList<Integer> inputArray){

        this.inputArray = inputArray;

    }

    public void sortGivenArray(){
        divide(0, this.inputArray.size()-1);
    }

    public void divide(int startIndex,int endIndex){

        //Divide till you breakdown your list to single element
        if(startIndex<endIndex && (endIndex-startIndex)>=1){
            int mid = (endIndex + startIndex)/2;
            divide(startIndex, mid);
            divide(mid+1, endIndex);

            //merging Sorted array produce above into one sorted array
            merger(startIndex,mid,endIndex);
        }
    }

    public void merger(int startIndex,int midIndex,int endIndex){

        //Below is the mergedarray that will be sorted array Array[i-midIndex] , Array[(midIndex+1)-endIndex]
        ArrayList<Integer> mergedSortedArray = new ArrayList<Integer>();

        int leftIndex = startIndex;
        int rightIndex = midIndex+1;

        while(leftIndex<=midIndex && rightIndex<=endIndex){
            if(inputArray.get(leftIndex)<=inputArray.get(rightIndex)){
                mergedSortedArray.add(inputArray.get(leftIndex));
                leftIndex++;
            }else{
                mergedSortedArray.add(inputArray.get(rightIndex));
                rightIndex++;
            }
        }

        //Either of below while loop will execute
        while(leftIndex<=midIndex){
            mergedSortedArray.add(inputArray.get(leftIndex));
            leftIndex++;
        }

        while(rightIndex<=endIndex){
            mergedSortedArray.add(inputArray.get(rightIndex));
            rightIndex++;
        }

        int i = 0;
        int j = startIndex;
        //Setting sorted array to original one
        while(i<mergedSortedArray.size()){
            inputArray.set(j, mergedSortedArray.get(i++));
            j++;
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 12; i++) {
            int time = 0;
            ArrayList<Integer> unsortedArray = new ArrayList<Integer>();
            final Duration timeElapsed;
            for (int j = 0; j < 5000; j++) {
                unsortedArray.add((int)(Math.random() * (5000)));
            }


            MergeSort ms = new MergeSort(unsortedArray);

            System.out.println("---------Initial Unsorted Array---------");
            for(int j:ms.getSortedArray()){
                System.out.print(j+" ");
            }

            Instant start = Instant.now();  // time capture -- start
            ms.sortGivenArray();
            Instant end = Instant.now();    // time capture -- end
            timeElapsed = Duration.between(start, end);
//        nanoTime timeElapsed.getNano();

            System.out.println("\n------------Sorted Array------------");
            for(int j:ms.getSortedArray()){
                System.out.print(j+" ");
            }
            System.out.println();
            System.out.println("Nanoseconds: " + timeElapsed.getNano());
            time += timeElapsed.getNano();
            System.out.println("Total Nanoseconds: " + time );
            System.out.println("Total Seconds: " + time /1000000000.0);
        }

    }
}
    
```

# Extra Credit Assignment:
- For the extra credit assignment, I decided to apply my sorting algorithms towards a Linked List I created much earlier in the trimester.
- The three sorting algorithms I utilized were: Insertion Sort, Bubble Sort, Selection Sort
- I will be describing how I utilized all of the three below
- From the original [Linked List](https://github.com/devamshri/Tri-3-Devam-Challenges/blob/main/src/com/devamchallenges/tt1/LinkedList.java), I have had to make many adjustments to get the sorting algorithms to work
     - The new code is located [here](https://github.com/devamshri/Tri-3-Devam-Challenges/blob/main/src/com/devamchallenges/tt3/sorttesting/LinkedList.java)

## Full Code Snippet

``` java
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
```
## How I implemented the insertion sort
### Code Snippet:

``` java
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
            // Continue until null value. This basically just controlls the swaps being done
            while (j != null && (int) j.getData() > key) {
                temp = j;
                j = j.getPrevious();
            }
            // Controlls how the swaps function
            if (j != null) {
                j.setNextNode(arr);
            }
            else if (temp != null) {
                temp.setPrevNode(arr);
            }
            arr = next;
        }
    }
```
- From the original array, I have had to make many adjustments to go from an array to a linked List to fit an insert sort
- Remove each value and put it back to a point where all the values in front of it are less than it
     - Repeat for all points until a 'null' value appears (cue while loop and the various if statements)
- Also utilized temporary variables and linked lists to keep track of the doubly-linked lists and to ensure no elements are randomly dropped

## How I implemented the bubble sort
### Code Snippet:

``` java
public static void bubbleSort(LinkedList arr) {
        int i = arr.len();
        int b = 0;
        while (b < i) {
            // Constantly looked towards getting the next element of the linked list
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
```
- Takes the first element and compares to the second element and sees which one is smaller then swaps
     - This process continues until all the elements are put in order (super tedious)
- j starts at the beginning of the linked list and compares to the elements next to it (j_1)
     - If j>j_1, then they swap, otherwise they stay put and j_1 moves to the next element
     - This is repeated for all elements in the linked list

## How I implemented the selection sort
### Code snippet:

``` java
public static void selectionsort(LinkedList arr){

        while (arr != null){
            // get the minimum
            LinkedList min = minvalue(arr);
            if (min == arr) {
                arr = arr.getNext();
            }
            // Controlls the swap and ensures the minimum value moved to the front
            if (arr != null) {
                min.remove();
                arr.setPrevNode(min);
            }

        }
    }
```
- To be honest, this was the easiest of the three sorting algorithms to come up with
- Selection sort is basically just trying to shift the smallest values to the front of the linked list
     - This process continues until all the elements are in order or a 'null' value is reached
- For the selection sort, I also had to come up with a separate function named 'minvalue' where I try to get the  minimum value in the array list and move it to the front
- Code for 'minvalue' below:
``` java
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
```
