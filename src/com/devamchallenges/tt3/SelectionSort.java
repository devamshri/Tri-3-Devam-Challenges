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
