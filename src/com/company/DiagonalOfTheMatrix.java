package com.company;

import java.util.Scanner;

public class DiagonalOfTheMatrix {
    private Integer[][] matrix;
    private int size, up, down;
    private Scanner input = new Scanner(System.in).useDelimiter("\n");

    public void menu() {
        System.out.print("Enter matrix size: ");
        setSize(input.nextInt());
        setMatrix(new Integer[size][size]);
        System.out.println("Enter matrix values: ");
        enterMatrixValues();
        System.out.println("Your matrix is: ");
        showMatrix();
        calculate();
        result();
    }

    private void enterMatrixValues() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("enter value matrix value of [" + i + "]" + "[" + j + "] = ");
                matrix[i][j] = input.nextInt();
            }
        }
    }

    private void showMatrix() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    private void calculate() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j > i) {
                    setUp(getUp() + matrix[i][j]);
                } else if (i > j) {
                    setDown(getDown() + matrix[i][j]);
                }
            }
        }
    }

    private void result() {
        if (getUp() > getDown()) {
            System.out.println("The sum of the numbers above the diagonal of the matrix is greater.");
        } else if (getUp() < getDown()) {
            System.out.println("The sum of the numbers under the diagonal of the matrix is greater.");
        } else {
            System.out.println("The sum of the numbers above and under the diagonal of the matrix are the same.");
        }
    }

    public Integer[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Integer[][] matrix) {
        this.matrix = matrix;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }
}
