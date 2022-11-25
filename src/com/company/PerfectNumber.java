package com.company;

import javax.swing.*;
import java.util.Scanner;

public class PerfectNumber {
    private int number;

    public void perfectNumber() {
        String info = "Perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself.";
        JOptionPane.showMessageDialog(null, info);
        number = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter number to check if it is perfect: "));
        if (check()) {
            JOptionPane.showMessageDialog(null,"Number " + number + " is perfect.");
        } else {
            JOptionPane.showMessageDialog(null, "Number " + number + " isn't perfect.");
        }
        System.exit(0);
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
