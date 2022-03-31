package com.devamchallenges.tt1;
import java.util.ArrayList;
import java.time.Duration;
import java.time.Instant;

public class MergeSort {
    private ArrayList<Integer> inputArray;
    private final Duration timeElapsed;

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
        Instant start = Instant.now();  // time capture -- start
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
        Instant end = Instant.now();    // time capture -- end
        this.timeElapsed = Duration.between(start, end);
    }
    public int getTimeElapsed() {
        return timeElapsed.getNano();
    }
    public static void main(String[] args) {

        ArrayList<Integer> unsortedArray = new ArrayList<Integer>();

        unsortedArray.add(8);
        unsortedArray.add(7);
        unsortedArray.add(6);
        unsortedArray.add(5);
        unsortedArray.add(4);
        unsortedArray.add(0);
        unsortedArray.add(2);
        MergeSort ms = new MergeSort(unsortedArray);

        System.out.println("---------Initial Unsorted Array---------");
        for(int i:ms.getSortedArray()){
            System.out.print(i+" ");
        }


        ms.sortGivenArray();

        System.out.println("\n------------Sorted Array------------");
        for(int i:ms.getSortedArray()){
            System.out.print(i+" ");
        }
    }
}