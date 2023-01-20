package com.company.bmiAndBmr;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class MenuHealth extends JFrame {
    private final Scanner input = new Scanner(System.in);
    private int age;
    private double howTall;
    private double weight;
    private double lifestyle;
    private String gender;

    private JLabel weightLabel, heightLabel, ageLabel,genderLabel,lifestyleLabel;
    private JButton bmi,bmr;


    public MenuHealth() {
        JFrame frame = new JFrame("BMI and BMR calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        weightLabel = new JLabel("Weight: ");
//        frame.add(weightLabel);

        SpinnerModel value =
                new SpinnerNumberModel(0, //initial value
                        0, //minimum value
                        300, //maximum value
                        0.1); //step

        JSpinner spinner = new JSpinner(value);
        spinner.setBounds(100,100,50,30);
        frame.add(spinner);
        frame.setSize(300,300);
        frame.setLayout(null);
        frame.setVisible(true);

//        JPanel p1 = new JPanel();
//
//        p1.add(weightLabel, value);
//        frame.add(p1);
//
//        BorderLayout l1 = new BorderLayout();
//        setLayout(l1);

        frame.setBackground(Color.lightGray);
        frame.setSize(500,175);
        frame.setVisible(true);
    }

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
        setHowTall(input.nextDouble());
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

    public double getHowTall() {
        return howTall;
    }

    public void setHowTall(double howTall) {
        this.howTall = howTall;
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

    public JLabel getWeightLabel() {
        return weightLabel;
    }

    public void setWeightLabel(JLabel weightLabel) {
        this.weightLabel = weightLabel;
    }

    public JLabel getHeightLabel() {
        return heightLabel;
    }

    public void setHeightLabel(JLabel heightLabel) {
        this.heightLabel = heightLabel;
    }

    public JLabel getAgeLabel() {
        return ageLabel;
    }

    public void setAgeLabel(JLabel ageLabel) {
        this.ageLabel = ageLabel;
    }

    public JLabel getGenderLabel() {
        return genderLabel;
    }

    public void setGenderLabel(JLabel genderLabel) {
        this.genderLabel = genderLabel;
    }

    public JLabel getLifestyleLabel() {
        return lifestyleLabel;
    }

    public void setLifestyleLabel(JLabel lifestyleLabel) {
        this.lifestyleLabel = lifestyleLabel;
    }
}