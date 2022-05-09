{% include navigation.html %}
# Study Week 2
- [Study Plan](https://devamshri.github.io/Tri-3-Devam-Challenges/StudyPlan)
- This week, we were responsible for taking part in the 2015 AP Computer Science A Practice Exam.

## Multiple Choice (Score: 24/40, but didn't have time for last 11, so more like 24/29)
### Question 6:
![image](https://media.discordapp.net/attachments/750110972420685825/973226819891380334/unknown.png?width=558&height=529)
- Casting to double
- Why I got this wrong: In option I, the cast applies to the value 2, so floating-point division is performed and the expression evaluates to 0.5 + 3, or 3.5. In option II, the cast applies to the result of the integer division 2 / 4, so the expression evaluates to 0.0 + 3, or 3.0. In option III, the cast applies to the sum of 3 and the result of the integer division 2 / 4, so the expression evaluates to (double) (0 + 3), or 3.0

### Question 10
![image](https://media.discordapp.net/attachments/750110972420685825/973227279901683712/unknown.png?width=405&height=530)
- Topic: Iteration
- Why I got this wrong: The for loop iterates from i = 0 to i = 19. The expression i % num2 == 0 evaluates to true when i is divisible by 5 and the expression i % 2 == 0 evaluates to true when i is even. The only values in the range 0 to 19, inclusive, that are both divisible by 5 and even are 0 and 10, so the statement prints "0 10 ".

### Question 14
![image](https://media.discordapp.net/attachments/750110972420685825/973228128849788958/unknown.png?width=451&height=529)
- Topic: If-else statements
- Why I got it wrong: Code segment I uses multi-way selection to assign and return the correct category. Code segment II returns "rural" for all values of density because it uses a series of one-way selection statements instead of multi-way selection. Code segment III returns the correct category through the use of an immediate return within each of the one-way selection statements.

### Question 18
![image](https://media.discordapp.net/attachments/750110972420685825/973229291997392896/unknown.png?width=392&height=529)
- Topic: For loops and traversing arrays
- Why I got it wrong: The first candidate for a local maximum is the element at index 1 (the second element in the array), and the last candidate is the element at index data.length - 2 (the next to last element in the array).

### Question 22
![image](https://media.discordapp.net/attachments/750110972420685825/973230201863548998/unknown.png?width=393&height=530)
- Topic: String methods and arrays
- Why I got it wrong: Line 12 is executed each time the variable sm is updated because a new smallest value is found. When j has the value 0, sm is updated for "day" and "of". When j has the value 1, sm is updated for "of". When j has the value 4, sm is updated for "year". When j has any of the values 2, 3, or 5, sm is not updated. Line 12 is executed four times.

### Question 23
![image](https://media.discordapp.net/attachments/750110972420685825/973230201863548998/unknown.png?width=393&height=530)
- Topic: 2D Arrays
- Why I got it wrong: The outer for loop stores each row of the two-dimensional array in j, a one-dimensional array. The inner for loop stores each element of j in k and prints k.


### Didn't have time for questions 30-40 (I guessed one right in there)

## FRQ (I was missing in class for the peer grading of the frq's, so I will miss out on the points for this assignment. Final Score: 25/36)

