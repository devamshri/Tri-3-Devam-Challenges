package com.devamchallenges.frq2019;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.io.*;
import java.lang.*;
import java.util.*;

// I sort of messed up with this as I very much overcomplicated this FRQ.

public class StepTracker {
//    This was the part I messed up: I needed to start off by implementing some private values that will carry out throughout the FRQ
    private int minSteps;
    private int totalSteps;
    private int numDays;
    private int numActiveDays;

    public StepTracker(int i) {
        minSteps = i;
        totalSteps = 0;
        numDays = 0;
        numActiveDays = 0;
    }
    public void addDailySteps(int steps) {
        totalSteps += steps;
        numDays++;
        if (steps > minSteps) {
            numActiveDays++;
        }
    }
    public int activeDays() {
        return numActiveDays;
    }
    public double averageSteps() {
// I screwed this part up
        if (numDays == 0) {
            return 0.0;
        }
        else {
            return (double) totalSteps / numDays;
        }
    }

    public static void main(String[] args) {
        StepTracker tr = new StepTracker(10000);
        tr.activeDays();
        tr.averageSteps();
        tr.addDailySteps(9000);
        tr.addDailySteps(5000);
        tr.activeDays();
        tr.averageSteps();
        tr.addDailySteps(13000);
        tr.activeDays();
        tr.averageSteps();
        tr.addDailySteps(23000);
        tr.addDailySteps(1111);
        tr.activeDays();
        tr.averageSteps();
    }


}