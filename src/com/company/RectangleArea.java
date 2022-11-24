package com.company;

import java.util.Scanner;

public class RectangleArea {
    private Scanner input = new Scanner(System.in);
    private Integer sideA1;
    private Integer sideA2;
    private Integer sideB1;
    private Integer sideB2;
    private Integer sideC1;
    private Integer sideC2;
    private Integer areaA;
    private Integer areaB;
    private Integer areaC;

    void enterDataOfRectangle() {
        System.out.println("Enter first side for first rectangle:");
        setSideA1(input.nextInt());
        System.out.println("Enter second side for first rectangle:");
        setSideA2(input.nextInt());
        setAreaA(sideA1*sideA2);
        System.out.println("Enter first side for second rectangle:");
        setSideB1(input.nextInt());
        System.out.println("Enter second side for second rectangle:");
        setSideB2(input.nextInt());
        setAreaB(sideB1*sideB2);
        System.out.println("Enter first side for third rectangle:");
        setSideC1(input.nextInt());
        System.out.println("Enter second side for third rectangle:");
        setSideC2(input.nextInt());
        setAreaC(sideC1*sideC2);
        biggestArea(getAreaA(), getAreaB(), getAreaC());
    }

    private void biggestArea(Integer areaA, Integer areaB, Integer areaC) {
        if (areaA>areaB) {
            if (areaB>areaC) {
                System.out.println("Rectangle A is the biggest.");
            } else if (!(areaA>areaC)) {
                System.out.println("Rectangle C is the biggest.");
            } else System.out.println("Rectangle A is the biggest.");
        } else if (areaB>areaC) {
            System.out.println("Rectangle B is the biggest.");
        } else System.out.println("Rectangle C is the biggest.");
    }

    public Integer getSideA1() {
        return sideA1;
    }

    public void setSideA1(Integer sideA1) {
        this.sideA1 = sideA1;
    }

    public Integer getSideA2() {
        return sideA2;
    }

    public void setSideA2(Integer sideA2) {
        this.sideA2 = sideA2;
    }

    public Integer getSideB1() {
        return sideB1;
    }

    public void setSideB1(Integer sideB1) {
        this.sideB1 = sideB1;
    }

    public Integer getSideB2() {
        return sideB2;
    }

    public void setSideB2(Integer sideB2) {
        this.sideB2 = sideB2;
    }

    public Integer getSideC1() {
        return sideC1;
    }

    public void setSideC1(Integer sideC1) {
        this.sideC1 = sideC1;
    }

    public Integer getSideC2() {
        return sideC2;
    }

    public void setSideC2(Integer sideC2) {
        this.sideC2 = sideC2;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public Integer getAreaA() {
        return areaA;
    }

    public void setAreaA(Integer areaA) {
        this.areaA = areaA;
    }

    public Integer getAreaB() {
        return areaB;
    }

    public void setAreaB(Integer areaB) {
        this.areaB = areaB;
    }

    public Integer getAreaC() {
        return areaC;
    }

    public void setAreaC(Integer areaC) {
        this.areaC = areaC;
    }
}