package com.devamchallenges.frq2019;

public class FrogSimulation {
    private int goalDistance;
    private int maxHops;

    public FrogSimulation(int dist, int numHops) {
        goalDistance = dist;
        maxHops = numHops;
    }

    private int hopDistance() {

    }

    public boolean simulate() {
        int pos = 0;
        for (int i = 0; i <= maxHops; i++) {
            pos +=;
            if (pos >= goalDistance) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public double runSimulations(int num) {
        int count = 0;
        for (int i = 0; i < num; i++) {
            if (simulate()){
                count++;
            }

        }
        return (double) count / num;
    }
}
