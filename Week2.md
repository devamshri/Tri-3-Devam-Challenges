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
public class DevamCalculator {
    // Key instance variables
    private final String expression;
    private ArrayList<String> tokens;
    private ArrayList<String> reverse_polish;
    private Double result;

    private final Map<String, Integer> OPERATORS = new HashMap<>();
    {
        // Map<"token", precedence>
//        Set up Operaters for the specific functions
        OPERATORS.put("*", 3);
        OPERATORS.put("/", 3);
        OPERATORS.put("%", 3);
        OPERATORS.put("+", 4);
        OPERATORS.put("-", 4);
        OPERATORS.put("^", 2);
        OPERATORS.put("sqrt", 2);
    }

    private final Map<String, Integer> SEPARATORS = new HashMap<>();
    {
        // Map<"separator", not_used>
        SEPARATORS.put(" ", 0);
        SEPARATORS.put("(", 0);
        SEPARATORS.put(")", 0);
    }


    // Print the expression, terms, and result
//    The toString to help get the formatting for prints
    public String toString() {
        return ("Original expression: " + this.expression + "\n" +
                "Tokenized expression: " + this.tokens.toString() + "\n" +
                "Reverse Polish Notation: " +this.reverse_polish.toString() + "\n" +
                "Final result: " + String.format("%.2f", this.result));
    }

    public static boolean isNumeric(String n){
        try {
            double d = Double.parseDouble(n);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    // Takes RPN and produces a final result
    private void rpnToResult()
    {
        // Stack used to hold calculation while process RPN
        Stack calculation = new Stack();

        // for loop to process RPN
        for(int i = 0; i < this.reverse_polish.size(); i++)
        {
            // If the token is a number
            if (isNumeric(this.reverse_polish.get(i))){
                calculation.push(this.reverse_polish.get(i));

                // Push number to stack
            }
            // else
            else{
// Setting up sqrt function as an exponent to the 0.5 power.
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
                // Pop the two top entries


                // Based off of Token operator calculate result
                // Push result back onto the stack




            }
        }
        // Pop final result and set as final result for expression
        result = (Double) calculation.pop();
    }

    public DevamCalculator(String expression) {
        // original input
        this.expression = expression;

        // parse expression into terms
        this.Tokens();

        // place terms into reverse polish notation
        this.tokensToReversePolishNotation();

        // calculate reverse polish notation
        this.rpnToResult();
    }

    // Term Tokenizer takes original expression and converts it to ArrayList of tokens
    private void Tokens() {
        // contains final list of tokens
        this.tokens = new ArrayList<>();

        int start = 0;  // term split starting index
        StringBuilder multiCharTerm = new StringBuilder();    // term holder
        for (int i = 0; i < this.expression.length(); i++) {
            Character c = this.expression.charAt(i);
            if ( isOperator(c.toString() ) || isSeperator(c.toString())  ) {
                // 1st check for working term and add if it exists
                if (multiCharTerm.length() > 0) {
                    tokens.add(this.expression.substring(start, i));
                }
                // Add operator or parenthesis term to list
                if (c != ' ') {
                    tokens.add(c.toString());
                }
                // Get ready for next term
                start = i + 1;
                multiCharTerm = new StringBuilder();
            } else {
                // multi character terms: numbers, functions, perhaps non-supported elements
                // Add next character to working term
                multiCharTerm.append(c);
            }

        }
        // Add last term
        if (multiCharTerm.length() > 0) {
            tokens.add(this.expression.substring(start));
        }
    }

    // Takes tokens and converts to Reverse Polish Notation (RPN), this is one where the operator follows its operands.
    private void tokensToReversePolishNotation () {
        // contains final list of tokens in RPN
        this.reverse_polish = new ArrayList<>();

        // stack is used to reorder for appropriate grouping and precedence
        Stack tokenStack = new Stack();
        for (String token : tokens) {
            switch (token) {
                // If left bracket push token on to stack
                case "(":
                    tokenStack.push(token);
                    break;
                case ")":
                    while (tokenStack.peek() != null && !tokenStack.peek().equals("("))
                    {
                        reverse_polish.add( (String)tokenStack.pop() );
                    }
                    tokenStack.pop();
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                case "^":
                case "sqrt":
                    // While stack
                    // not empty AND stack top element
                    // and is an operator
                    while (!tokenStack.empty() && isOperator((String) tokenStack.peek()))
                    {
                        if ( isPrecedent(token, (String) tokenStack.peek() )) {
                            reverse_polish.add((String)tokenStack.pop());
                            continue;
                        }
                        break;
                    }
                    // Push the new operator on the stack
                    tokenStack.push(token);
                    break;
                default:    // Default should be a number, there could be test here
                    this.reverse_polish.add(token);
            }
        }
        // Empty remaining tokens
        while (!tokenStack.empty()) {
            reverse_polish.add((String)tokenStack.pop());
        }

    }
    // Helper definition for supported operators

    private boolean isOperator(String token) {
        // find the token in the hash map
        return OPERATORS.containsKey(token);
    }

    // Test if token is an separator
    private boolean isSeperator(String token) {
        // find the token in the hash map
        return SEPARATORS.containsKey(token);
    }

    // Compare precedence of operators.
    private Boolean isPrecedent(String token1, String token2) {
        // token 1 is precedent if it is greater than token 2
        return (OPERATORS.get(token1) - OPERATORS.get(token2) >= 0) ;
    }

    public static void main(String[] args){
        DevamCalculator simpleMath = new DevamCalculator("100 + 200  * 3");
        System.out.println("Simple Math\n" + simpleMath);

        DevamCalculator parenthesisMath = new DevamCalculator("(100 + 200)  * 3");
        System.out.println("Parenthesis Math\n" + parenthesisMath);

        DevamCalculator allMath = new DevamCalculator("200 % 300 + 5 + 300 / 200 + 1 * 100");
        System.out.println("All Math\n" + allMath);

        DevamCalculator allMath2 = new DevamCalculator("200 % (300 + 5 + 300) / 200 + 1 * 100");
        System.out.println("All Math2\n" + allMath2);

        DevamCalculator allMath3 = new DevamCalculator("200 % (300 + 5 + 300) / 200 + 1 * 100 + 5 ^ 2");
        System.out.println("All Math3\n" + allMath3);

// Basically just setting up the sqrt function stuffies bc why not try extra credit
        DevamCalculator sqrt = new DevamCalculator("200 % (300 + 5 + 300) / 200 + 1 * 100 + 5 ^ 2 + sqrt (2*12.5) + 2");
        System.out.println("All Math3\n" + sqrt);
    }
}
 ```
