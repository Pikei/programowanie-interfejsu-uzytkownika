package com.company;

import com.company.bmiAndBmr.MenuHealth;
import java.util.Scanner;

public class Menu {
    private final Scanner input = new Scanner(System.in).useDelimiter("\n");
    private final RectangleArea rectangle = new RectangleArea();
    private final NumberSystemsConverter number = new NumberSystemsConverter();
    private final DiagonalOfTheMatrix matrix = new DiagonalOfTheMatrix();
    private final PerfectNumber perfectNumber = new PerfectNumber();
    private final MenuHealth menuHealth = new MenuHealth();
    private final Bridge bridge = new Bridge();

    public void mainMenu() {
        System.out.println("Welcome!");
        System.out.println("Choose what program would you like to start:");
        System.out.println("1. Calculator of biggest rectangle area.");
        System.out.println("2. Number systems converter.");
        System.out.println("3. Calculator of Variables above and below the diagonal of the matrix.");
        System.out.println("4. Perfect number.");
        System.out.println("5. BMI & BMR calculator.");
        System.out.println("6. Bridge points calculator.");
        System.out.println("7. Celsius to Fahrenheit degrees converter");
        System.out.print("Your choice: ");
        switch (input.next()) {
            case "1" -> rectangle.enterDataOfRectangle();
            case "2" -> number.convertMenu();
            case "3" -> matrix.menu();
            case "4" -> perfectNumber.perfectNumber();
            case "5" -> menuHealth.menu();
            case "6" -> bridge.start();
            case "7" -> new TemperatureConverter();
        }
    }
}
