package com.devamchallenges;

public class Matrix {
    private final int[][] matrix;
    private String output = "";

    // store matrix
    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    // for loop deals w/ arrays of variable length
//    one for loop in forward direction, and one in backwards direction
//    toString returns a "output" string with the correct formatting

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


    // declare and initialize a matrix for a keypad
    public static int[][] keypad() {
        return new int[][]{ { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, {-1, 0, -1} };
    }

    // declare and initialize a random length arrays
    public static int[][] numbers() {
        return new int[][]{ { 0, 1 },
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 } };
    }

    // tester method for matrix formatting
    public static void main(String[] args) {
        Matrix m0 = new Matrix(keypad());
        System.out.println("Keypad:");
        System.out.println(m0);

        Matrix m1 = new Matrix(numbers());
//        print m1 to test it
        System.out.println("Numbers Systems:");
        System.out.println(m1);
    }

}