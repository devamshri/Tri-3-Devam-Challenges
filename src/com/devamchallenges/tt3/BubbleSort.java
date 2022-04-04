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
