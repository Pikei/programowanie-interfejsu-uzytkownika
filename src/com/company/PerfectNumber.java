package com.company;

import java.util.Scanner;

public class PerfectNumber {
    private int number;
    private final Scanner input = new Scanner(System.in);

    public void perfectNumber() {
        System.out.println("Perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself.");
        System.out.println("Enter number to check if it is perfect: ");
        number = input.nextInt();
        if (check()) {
            System.out.println("Number " + number + " is perfect.");
        } else {
            System.out.println("Number " + number + " isn't perfect.");
        }
    }

    private boolean check() {
        int temp = 0;
        for(int i = 1; i < number; i++) {
            if(number % i == 0) {
                temp = temp + i;
            }
        }
        return temp == getNumber();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
