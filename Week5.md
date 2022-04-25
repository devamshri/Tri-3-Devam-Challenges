{% include navigation.html %}
# 2015 FRQ Week
- [Study Plan](https://devamshri.github.io/Tri-3-Devam-Challenges/StudyPlan)
- This week, we were responsible for taking part in the 2015 AP Computer Science A Practice Exam.

## Multiple Choice (Score: 30/39, but didn't have time for last 5)
### Question 22:
![image](https://media.discordapp.net/attachments/750110972420685825/966380650401783868/unknown.png?width=719&height=351)
- 2D Arrays
- Why I got this wrong: My answer would 100% Error.

### Question 26
![image](https://media.discordapp.net/attachments/750110972420685825/968176663236063343/unknown.png?width=444&height=499)
- Topic: Writing Methods
- Why I got this wrong: This was some horrific code writen by CollegeBoard but I should have noticed that since the function is a static, the location of the value changes, but not the actual value

### Question 27
![image](https://media.discordapp.net/attachments/750110972420685825/968177006355312671/unknown.png?width=473&height=499)
- Topic: Arrays and Sorting
- Why I got it wrong: I noticed that this was a selection sort quite early, but forgot that the 1 and 6 would swap with each other, causing the mistake.

### Question 31
![image](https://media.discordapp.net/attachments/750110972420685825/968177198798368808/unknown.png?width=525&height=498)
- Topic: 2D Arrays
- Why I got it wrong: I actually was confused with the functionality of the code other than that of the front row

### Didn't have time for questions 35-39

## FRQ (I was out of town and could only do 2 of them)

### Question 1 (DiverseArray)

``` java
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
```

### Question 2 (HiddenWord):

``` java
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


```

### Question 4 (SparseArrayEntry):

``` java
public class SparseArrayEntry {

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

```
