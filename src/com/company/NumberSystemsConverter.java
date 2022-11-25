package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NumberSystemsConverter {
    private int base;
    ArrayList<Integer> convertedNumberIntegralPart = new ArrayList<Integer>();
    ArrayList<Integer> convertedNumberFractionPart = new ArrayList<Integer>();
    private int integralPart;
    private double fractionPart, decimalNumber;
    private final Scanner input = new Scanner(System.in).useDelimiter("\n");
    public void convertMenu() {
        System.out.print("Enter the base of the number system you want to convert (e.g. 2-binary, 8-octal, 16-hexadecimal) : ");
        setBase(input.nextInt());
        System.out.print("Enter decimal number that you want to convert: ");
        decimalNumber = input.nextDouble();
        splitNumber();
        convertIntegralPart();
        convertFractionPart();
        System.out.print("Your number: " + decimalNumber + " after conversion to number system based of " + base + " is: ");
        showConvertedNumber();
    }

    private void splitNumber() {
        integralPart = (int) decimalNumber;
        fractionPart = decimalNumber - integralPart;
    }

    private void convertIntegralPart() {
        while (integralPart > 0) {
            convertedNumberIntegralPart.add(integralPart % base);
            integralPart = (int) integralPart / base;
        }
        Collections.reverse(convertedNumberIntegralPart);
    }

    private void convertFractionPart() {
        while(convertedNumberFractionPart.size() < 10) {
            if ((fractionPart * base) > 0) {
                int temp = (int) (fractionPart * base);
                fractionPart = (fractionPart * base) - temp;
                convertedNumberFractionPart.add(temp);
            }
        }
    }

    public void showConvertedNumber() {
        convertedNumberIntegralPart.forEach(System.out::print);
        System.out.print(',');
        convertedNumberFractionPart.forEach(System.out::print);
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public ArrayList<Integer> getConvertedNumberIntegralPart() {
        return convertedNumberIntegralPart;
    }

    public void setConvertedNumberIntegralPart(ArrayList<Integer> convertedNumberIntegralPart) {
        this.convertedNumberIntegralPart = convertedNumberIntegralPart;
    }

    public ArrayList<Integer> getConvertedNumberFractionPart() {
        return convertedNumberFractionPart;
    }

    public void setConvertedNumberFractionPart(ArrayList<Integer> convertedNumberFractionPart) {
        this.convertedNumberFractionPart = convertedNumberFractionPart;
    }

    public int getIntegralPart() {
        return integralPart;
    }

    public void setIntegralPart(int integralPart) {
        this.integralPart = integralPart;
    }

    public double getFractionPart() {
        return fractionPart;
    }

    public void setFractionPart(double fractionPart) {
        this.fractionPart = fractionPart;
    }
}
