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
