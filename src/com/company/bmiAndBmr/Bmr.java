package com.company.bmiAndBmr;

public class Bmr extends MenuHealth {
    private double bmr;
    private double dcr;

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
}
