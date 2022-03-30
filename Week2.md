{% include navigation.html %}
### [TT2](https://github.com/devamshri/Tri_3_Devam_Challenges/issues/3):
#### Links to Review Ticket for this Week: [Review Ticket](https://github.com/devamshri/Tri-3-Devam-Challenges/issues/3)

[Run Time](https://replit.com/@D3vIs4G0d/Tri3DevamChallenges#src/com/devamchallenges/tt2)

## GitHub Links
1. [challenge 1 and 2 and SQRT thing](https://github.com/devamshri/Tri-3-Devam-Challenges/blob/main/src/com/devamchallenges/tt2/DevamCalculator.java)


## Notes for TT2
[3/22 Calculator Notes](https://github.com/nighthawkcoders/nighthawk_csa/wiki/Tri-3:-Tech-Talk-2:-Calculator)
Essentially how the calculator works is, after the expression is in RPN format, I iterate through the String Arraylist reverse_polish which is the reverse polish notation.

Then, if the token is not an operator (essentially, it is a number) I push it to the stack. 

Otherwise, if the token is an operator than I pop the top two values off the stack and perform an operation on these values.
I had to create individual (if) statements to check the operator. If it is a %, ^, +, -, *, /, etc. Then, I store the value obtained from the operation in "result" and push result back into the Stack
This is essentially how we calculate from RPN notation.

One thing that is notable is that when you pop the value off of the stack, it is initially an object. You need to convert that object into a Double.
**Tech Talk 2 Notes**
- compute rmath: strings converted to Reverse Polish Notation using Shunting-yard algorithm to deal with order of operations

``` java
Calculator allMath3 = new Calculator("200 % (300 + 5 + 300) / 200 + 1 * 100 + 5 ^ 2");
        System.out.println("All Math3\n" + allMath3);
        Calculator sqrt = new Calculator("200 % (300 + 5 + 300) / 200 + 1 * 100 + 5 ^ 2 + sqrt (2*12.5) + 2");
        System.out.println("All Math3\n" + sqrt);
 ```
        
- driver for testing- constructor with different stringss, operators with varying precedence

``` java
for (int i = 0; i < this.expression.length(); i++) {
            Character c = this.expression.charAt(i);
            if ( isOperator(c.toString() ) || isSeperator(c.toString())  ) {
                // 1st check for working term and add if it exists
                if (multiCharTerm.length() > 0) {
                    tokens.add(this.expression.substring(start, i));
                }
                // Add operator or parenthesis term to list
                if (c != ' ') {
                    tokens.add(c.toString())
   ```
- tokenization: string parsed and separated into tokens. these include numbers, operators, and separators
``` java
for(int i = 0; i < this.reverse_polish.size(); i++)
        {
            // If the token is a number
            if (isNumeric(this.reverse_polish.get(i))){
                calculation.push(this.reverse_polish.get(i));
                // Push number to stack
            }
            // else
            else{
                if(this.reverse_polish.get(i).equals("sqrt")){
                    calculation.push(Math.pow(Double.parseDouble(calculation.pop().toString()),0.5));
                }
                else{
                    Double first = Double.parseDouble(calculation.pop().toString());
                    Double second = Double.parseDouble(calculation.pop().toString());
                    switch(this.reverse_polish.get(i)){
                        case "+":
                            calculation.push(second + first);
                            break;
                        case "-":
                            calculation.push(second - first);
                            break;
                        case "*":
                            calculation.push(second * first);
                            break;
                        case "/":
                            calculation.push(second / first);
                            break;
                        case "%":
                            calculation.push(second % first);
                            break;
                        case "^" :
                            calculation.push(Math.pow(second, first));
                    }
                }
   ```
   
- going from rpn to final answer:
  - if element is a number, push to the stack
  - if element is an operator, pop the first two numbers off the stack, perform the computation, and push back onto the stack
  - I also learned how to use switch-case statements to check from multiple conditions (operators in this case)
- I learned how to add operators and set their precedence
``` java
OPERATORS.put("^", 2);
        OPERATORS.put("sqrt", 2);
 ```
