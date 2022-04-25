package com.devamchallenges.frq2015;

public class HiddenWord {

    private String word;

    public HiddenWord(String guessedWord) {
        word = guessedWord;
    }

    public String getHint(String guess) {
        String preHint = "";

        for (int i = 0; i < guess.length(); i++) {
            if (guess.substring(i, i+1).equals(word.substring(i, i+1))) {
                preHint += guess.substring(i, i+1);
            }
            else if (word.indexOf(guess.substring(i, i+1)) != -1) {
                preHint += "+";
            }
            else {
                preHint += "*";
            }
        }
        return preHint;
    }
}
