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