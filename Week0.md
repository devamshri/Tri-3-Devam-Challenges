{% include navigation.html %}
### [TT0](https://github.com/devamshri/Tri_3_Devam_Challenges/issues/1):
#### Links to Review Ticket for this Week: [Review Ticket](https://github.com/devamshri/Tri_3_Devam_Challenges/issues/1)
Links to Github for Code: [Challenge 1: menu](https://https://github.com/devamshri/Tri_3_Devam_Challenges/blob/main/src/com/devamchallenges/TestMenu.java)
**KEY LEARNINGS**: using the HashMap to with a **Runnable action** so that the main file of each challenge can be run. This was probably the most important, key part to figuring out this challenge. This also helps keep all the challenges organized so that the menu can iterate through the HashMap.
```
// Based on the actual way Mort wanted us to do the Challenge 1
package com.devamchallenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.RunnableFuture;

public class TestMenu {
    String title;
    Runnable action;

    public TestMenu(String title, Runnable action) {
        this.title = title;
        this.action = action;
    }

    public String getTitle() {
        return this.title;
    }

    public Runnable getAction() {
        return this.action;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, TestMenu> menu = new HashMap<>();

        // This is for setting up the input based menu for
        menu.put(1, new TestMenu("Matrix", () -> Matrix.main(null) ) );
        menu.put(2, new TestMenu("Calculator", () -> IntByReference.main(null) ) );

        System.out.println("Menu:");
        for (Map.Entry<Integer, TestMenu> pair : menu.entrySet()) {
            System.out.println(pair.getKey() + " ==> " + pair.getValue().getTitle());
        }

        int input = sc.nextInt();
        TestMenu m = menu.get(input);
        m.getAction().run();
    }
}
```
Another interesting thing was the **try and catch** implementation. Essentially, the try & catch helps account for user error (if the user puts an int that is invalid)

        } catch (Exception e){
        
            System.out.println("Something went wrong. Please try again. \n");


Links to Github for Code: [Challenge 2: IntByReference (put lower number first)](https://https://github.com/devamshri/Tri_3_Devam_Challenges/blob/main/src/com/devamchallenges/IntByReference.java)
**Key Learnings**
implementing getters and setters so that in the swapToLowHighOrder function, we can actually use the getters and setters to swap the values
```
package com.devamchallenges;
import java.util.Scanner;

public class IntByReference {
    private int value;
// Different functions.
    public IntByReference(int v){
        value = v;
    }

    public int getvalue(){
        return value;
    }

    public void setvalue(int a){
        value = a;
    }

    public void swapToLowHighOrder(IntByReference num){
        if (num.getvalue() < value){
            int temp = num.getvalue();
            num.setvalue(value);
            value = temp;
        }
    }

    public String toString(){
        return Integer.toString(value);
    }

    // static method that enables me to see numbers swapped by reference (before, after)
    public static void swapper(int n0, int n1) {
        IntByReference a = new IntByReference(n0);
        IntByReference b = new IntByReference(n1);
        System.out.println("Before: " + a + " " + b);
        a.swapToLowHighOrder(b);  // conditionally build swap method to change values of a, b
        System.out.println("After: " + a + " " + b);
        System.out.println();
    }

    public static void main(String[] ags) {
// Tester methods
        IntByReference.swapper(21, 16);
        IntByReference.swapper(16, 21);
        IntByReference.swapper(16, -1);

//        This is for the input based method for IntByReference
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println("Enter 1st number:");
        int n1 = Integer.parseInt(scan.nextLine());
        System.out.println("Enter 2nd number:");
        int n2 = Integer.parseInt(scan.nextLine());
        IntByReference.swapper(n1, n2);

    }
}
```   
Also, another interesting thing to mention is that with this method, using a "temp" variable is necessary in order to be able to actually swap the values.

Links to Github for Code: [Challenge 3: Matrix (format Array output)](https://github.com/devamshri/Tri_3_Devam_Challenges/blob/main/src/com/devamchallenges/Matrix.java)

**KEY TAKEAWAYS** : the Matrix challenge was definitely a little harder, but the most **key** takeaways here is understanding the toString method and nested for loops to iterate through a 2D array.

First, for **toString method**, it's key to solving this challenge to understand that toString methods can be used to access data within an Array. So, for each value in the 2D array, I would assign it to a returnStatement variable which I then had to format (through \n statements and spaces, etc.).

        public String toString(){
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] < 0){output += "  ";}
                else{output += Integer.toHexString(matrix[i][j]) + " ";}
            }
            output += "\n";
        }
        output += "\n\n";

        for (int a = matrix.length-1; a >= 0; a--){
            for (int b = matrix[a].length-1; b >= 0; b--){
                if(matrix[a][b]<0){output += "  ";}
                else{output += Integer.toHexString(matrix[a][b]) + " ";}
            }
            output += "\n";
        }

        return output;
    }