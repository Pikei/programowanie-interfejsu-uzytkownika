package com.company;

import com.company.bmiAndBmr.MenuHealth;
import java.util.Scanner;

public class Menu {
    private final Scanner input = new Scanner(System.in).useDelimiter("\n");
    private final RectangleArea rectangle = new RectangleArea();
    private final NumberSystemsConverter number = new NumberSystemsConverter();
    private final DiagonalOfTheMatrix matrix = new DiagonalOfTheMatrix();
    private final MenuHealth menuHealth = new MenuHealth();
//    private final Bridge bridge = new Bridge();

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
            case "4" -> new PerfectNumber();
            case "5" -> menuHealth.menu();
            case "6" -> {
                Bridge brydz = new Bridge();
                brydz.randomCardsGenerator(13);
            }
            case "7" -> new TemperatureConverter();
        }
    }
}
