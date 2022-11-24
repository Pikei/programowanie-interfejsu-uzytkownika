package com.company;

public class Main {

    public static void main(String[] args) {
//        Menu start = new Menu();
//        start.mainMenu();
        int size = 5;
        int [][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
