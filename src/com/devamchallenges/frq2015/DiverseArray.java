package com.devamchallenges.frq2015;

import java.util.Arrays;

public class DiverseArray {
    public static int arraySum(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
        }
        return count;
    }

    public static int[] rowSums(int[][] arr2D) {
        int[] arr = new int[arr2D.length];
        int rowCount=0;
        for (int[] i : arr2D) {
            arr[rowCount] = arraySum(i);
            rowCount++;
        }
        return arr;
    }

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
