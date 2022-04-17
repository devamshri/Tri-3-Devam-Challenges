package com.devamchallenges.frq2019;

public class PondStocker {
    private Environment theEnv;
    private double minDensity;

    private int numUnder() {
        // Stuff I didn't get
        double numSpaces = theEnv.numRows() * theEnv.numCols();
        double numFilled = theEnv.numObjects;
        double numNeeded = numFilled;
        if (numNeeded < minDensity) {
            return (int) (minDensity - numNeeded);
        }
        else {
            return 0;
        }
    }


    private Location randomLocation() {
        int randomRow = (int)(Math.random() * (theEnv.Rows));
        int randomCol = (int)(Math.random() * (theEnv.Cols));

        return "Here is your Random Location: " + randomRow + ", " randomCol;
    }

    public void addFish(int numToAdd) {

    }
}
