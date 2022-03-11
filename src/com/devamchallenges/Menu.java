// My original way of solving the challenges
package com.devamchallenges;
import java.util.Scanner;

public class Menu {

    public static void menu() {


        String[] menu_items = new String[] {"Option 1: IntByReference", "Option 2: Matrix", "Option 3"};

        for(int i = 0; i < menu_items.length; i++){
            System.out.println(menu_items[i]);
            System.out.println("-------------------------\n");
        }

        System.out.println("Enter your choice:");

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();




        try {
            System.out.println(menu_items[Integer.parseInt(input)-1]);
        } catch (NumberFormatException e) {
            System.out.println("Make sure to enter a number as your choice!");
        } catch (ArrayIndexOutOfBoundsException a){
            System.out.println("Please enter a choice between 1 and " + menu_items.length);
        }

        if(input.equals("1")){
            System.out.println("Enter 1st number:");
            int n1 = Integer.parseInt(scan.nextLine());
            System.out.println("Enter 2nd number:");
            int n2 = Integer.parseInt(scan.nextLine());
            IntByReference.swapper(n1, n2);
        }

        if(input.equals("2")){
            Matrix m0 = new Matrix(Matrix.keypad());
            System.out.println("Keypad:");
            System.out.println(m0);

            Matrix m1 = new Matrix(Matrix.numbers());
            System.out.println("Numbers Systems:");
            System.out.println(m1);
        }

        menu();


    }

    public static void main(String[] args){
        Menu.menu();
    }

}