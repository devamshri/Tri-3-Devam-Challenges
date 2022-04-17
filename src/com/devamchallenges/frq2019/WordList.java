package com.devamchallenges.frq2019;

import java.util.*;

public class WordList {
    private ArrayList myList;

    public int numWordsofLength(int len) {
        int count = 0;
        for (int i = 0; i < myList.size(); i++) {
            if (((String) myList.get(i)).length() == len) {
                count++;
            }
        }
        return count;
    }

    public void removeWordsOfLength(int len) {
        for (int i = 0; i < myList.size(); i++) {
            if (((String) myList.get(i)).length() == len) {
                myList.remove(i);
            }
        }
    }
}
