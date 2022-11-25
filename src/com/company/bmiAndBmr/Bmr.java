package com.company.bmiAndBmr;

public class Bmr {
    private double bmr, dcr, weight, height, lifestyle;
    private String gender;
    private int age;

    public Bmr(double weight, double height, double lifestyle, String gender, int age) {
        this.weight = weight;
        this.height = height;
        this.lifestyle = lifestyle;
        this.gender = gender;
        this.age = age;
    }

    private void calculator() {
        if (getGender().equalsIgnoreCase("F")) {
            setBmr(655 + (9.6 * getWeight()) + (1.8 * getHeight()) - (4.7 * getAge()));
        } else if (getGender().equalsIgnoreCase("M")) {
            setBmr(66 + (13.7 * getWeight()) + (5 * getHeight()) - (6.8 * getAge()));
        }
        setDcr(getBmr() * getLifestyle());
    }

    public void result() {
        calculator();
        System.out.println("Your daily caloric requirement is: " + String.format("%.2f", getDcr()) + " kcal.");
    }

    public double getBmr() {
        return bmr;
    }

    public void setBmr(double bmr) {
        this.bmr = bmr;
    }

    public double getDcr() {
        return dcr;
    }

    public void setDcr(double dcr) {
        this.dcr = dcr;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
