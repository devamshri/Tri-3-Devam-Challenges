package com.devamchallenges.tt3;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

public class SortMenu {
    public static void sortmenu() {


        String[] menu_items = new String[] {"Welcome to my sort algorithm!\nOption 1: Merge", "Option 2: Bubble", "Option 3: Insertion", "Option 4: Selection"};

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
        else if(input.equals("2")){
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
        else if(input.equals("3")){
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
        else if(input.equals("4")){
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
        sortmenu();
    }
    public static void main(String[] args){
        SortMenu.sortmenu();
    }
}
