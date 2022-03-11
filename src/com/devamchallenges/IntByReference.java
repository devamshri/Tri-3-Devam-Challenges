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