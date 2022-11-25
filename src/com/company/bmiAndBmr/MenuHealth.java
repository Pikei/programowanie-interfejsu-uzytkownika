package com.company.bmiAndBmr;

import java.util.Scanner;

public class MenuHealth {
    private final Scanner input = new Scanner(System.in);
    private int age;
    private double height;
    private double weight;
    private double lifestyle;
    private String gender;

    public void menu() {
        System.out.println("Please type necessary data:");
        boolean exit;
        do {
            System.out.print("gender (F/M) - ");
            setGender(input.next());
            if (!(getGender().equalsIgnoreCase("F") || (getGender().equalsIgnoreCase("M")))) {
                System.out.println("Please choose correct option.");
                exit = false;
            } else {
                exit = true;
            }
        } while (!exit);
        System.out.print("age - ");
        setAge(input.nextInt());
        System.out.print("height (cm) - ");
        setHeight(input.nextDouble());
        System.out.print("weight (kg) - ");
        setWeight(input.nextDouble());
        do {
            System.out.println("Choose your lifestyle:");
            System.out.println("1. sedentary");
            System.out.println("2. slightly active");
            System.out.println("3. moderately active");
            System.out.println("4. extremely active");
            System.out.print("Your choice: ");
            setLifestyle(lifestylePoints(input.nextInt()));
        } while (getLifestyle() == 0);
        printResults();
    }

    private void printResults() {
        System.out.println("======BMI======");
        Bmi bmi = new Bmi(getWeight(), getHeight());
        bmi.summary();
        System.out.println("======BMR======");
        Bmr bmr = new Bmr(getWeight(), getHeight(), getLifestyle(), getGender(), getAge());
        bmr.result();
    }

    private double lifestylePoints(int choice) {
        switch (choice) {
            case 1 -> {
                return 1.2;
            }
            case 2 -> {
                return 1.375;
            }
            case 3 -> {
                return 1.55;
            }
            case 4 -> {
                return 1.725;
            }
            case 5 -> {
                return 1.9;
            }
            default -> System.out.println("Choose correct option.");
        }
        return 0;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(double lifestyle) {
        this.lifestyle = lifestyle;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}