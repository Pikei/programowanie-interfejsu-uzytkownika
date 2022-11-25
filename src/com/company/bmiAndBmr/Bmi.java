package com.company.bmiAndBmr;

public class Bmi{
    private double bmi;
    private double weight;
    private double height;

    public Bmi(double weight, double height) {
        this.weight = weight;
        this.height = height/100;
    }

    private void converter() {
        setBmi(getWeight() / (getHeight() * getHeight()));
    }

    private String result() {
        if (bmi < 16)
            return "starvation";
        else if (bmi >= 16 && bmi <= 16.99)
            return "emaciation";
        else if (bmi >= 17 && bmi <= 18.49)
            return "underweight";
        else if (bmi >= 18.5 && bmi <= 24.99)
            return "optimal weight";
        else if (bmi >= 25 && bmi <= 29.99)
            return "overweight";
        else if (bmi >= 30 && bmi <= 34.99)
            return "first degree obesity";
        else if (bmi >= 35 && bmi <= 39.99)
            return "second degree obesity";
        else if (bmi >= 40)
            return "third degree obesity";
        return null;
    }

    public void summary() {
        converter();
        System.out.println("Your BMI is: " + String.format("%.2f", getBmi()) + " which means " + result() + ".");
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}