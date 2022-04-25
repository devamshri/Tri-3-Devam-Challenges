package com.devamchallenges.frq2015;

import java.util.Arrays;

public class DiverseArray {
    // Score: 2/2
    public static int arraySum(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
        }
        return count;
    }
    // Score: 4/4
    public static int[] rowSums(int[][] arr2D) {
        int[] arr = new int[arr2D.length];
        int rowCount=0;
        for (int[] i : arr2D) {
            arr[rowCount] = arraySum(i);
            rowCount++;
        }
        return arr;
    }
    // Score: 3/3
    public static boolean isDiverse(int[][] arr2D) {
        int[] arr = rowSums(arr2D);
        for (int i = 0; i < arr.length; i++) {
            for (int j=i+1; j < arr.length; j++) {
                if (arr[i]==arr[j]) {
                    return false;
                }
            }

        }
        return true;
    }
}
