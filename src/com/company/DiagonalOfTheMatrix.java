package com.company;

import java.util.Scanner;

public class DiagonalOfTheMatrix {
    private int[][] matrix;
    private int size;

    public void menu() {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Enter matrix size: ");
        setSize(input.nextInt());
        setMatrix(new int[size][size]);
    }

    private void enterMatrixValues() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
