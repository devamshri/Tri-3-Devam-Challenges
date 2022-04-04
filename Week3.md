{% include navigation.html %}
# Sorts
- This week I learned how to use a variety of sort algorithms
- I also implemented sorting in my custom implementation of a queue

## Bubble Sort
- simplest sorting algorithm
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
