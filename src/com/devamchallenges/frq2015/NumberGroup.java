package com.devamchallenges.frq2015;

public class NumberGroup {

    public interface NumberGroup {
        boolean contains(int num);
    }

    public class Range implements NumberGroup {
        private int minValue;
        private int maxValue;

        public Range(int minValue, int maxValue) {
            this.minValue=minValue;
            this.maxValue=maxValue;
        }
        public boolean contains(int num) {
            return num >= minValue && num <= maxValue;
        }
    }

    public boolean contains(int num) {
         for (NumberGroup group : groupList) {
             if (group.contains(num)) {
                 return true;
             }
         }
         return false;
    }
}
